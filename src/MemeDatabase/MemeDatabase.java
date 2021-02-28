package MemeDatabase;

import java.util.Scanner;

public class MemeDatabase {

    private Account account;
    private MySQLServer server;
    private Scanner scan;

    public MemeDatabase (MySQLServer server, Account acc) {
        this.server = server;
        this.account = acc;
        scan = new Scanner(System.in);
    }

    public static void main (String[] args) {

        Account acc = null;
        MySQLServer ms = new MySQLServer(args[0], args[1], args[2], args[3]);

        String username = "";
        String password = "";
        String email = "";
        System.out.println("Welcome to Meme Database!");
        if (getInput("Do you have an account? [y/n] ").equals("y")) { // if the user has an account
            while (acc == null) {
                acc = logIn(ms);
            }
            System.out.println("We have located your account, welcome!");
        } else { // if the user does not have an account and needs to register an account
            while (acc == null) {
                //createAccount(username, password, email);
                //System.out.println("Account: " + username + email + password);
                acc = doCreateAccount(ms);
                if (acc == null) {
                    System.out.println("username is already taken, try again");
                }
            }
        }
        MemeDatabase prog = new MemeDatabase (ms, acc);
        prog.run();
    }

    public static Account logIn (MySQLServer ms) { // verify that the log in is correct using a query against the databse
        String username = getInput("Username");
        String password = getInput("Password");
        return QueryMaker.logIn(ms, username, password);
    }

    // actuall creates the account
    public static Account doCreateAccount (MySQLServer ms) { // make a query to DB to insert a new account
        String username = "";
        String email = "";
        String password = "";

        String confirm = "";
        while (!confirm.equals("y")) {
            username = getInput("Enter a username you want ");
            password = getInput("Enter a password you want ");
            email = getInput("Enter your email addres: ");
            System.out.println("\n============================\n");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
            confirm = getInput("Does this information look correct? [y/n]: ");
        }
        //System.out.println("Account: " + username + email + password);
        return QueryMaker.createAccount(ms, username, email, password);
        //return temp;
    }

    public static String getInput (String question) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println(question + ": ");
        input = scan.nextLine();

        return input;
    }

    public void run () {
        while (true) {
            String option = menu();
            switch (option) {
                case "1" :
                    searchMemeByTitle();
                    break;
                case "2" :
                    searchMemeByCategory();
                    break;
                case "3" :
                    makeFavorite();
                    break;
                case "4" :
                    viewMeme();
                    break;
                case "5" :
                    // do something
                    break;
                case "6" :
                    deleteMeme();
                    break;
                default :
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    public String menu () {
        System.out.println("Menu:");
        System.out.println("\t1. Search for meme by title");
        System.out.println("\t1. Search for meme by category");
        System.out.println("\t3. Add a meme to favorite");
        System.out.println("\t4. View a meme");
        System.out.println("\t5. Add a new meme");
        System.out.println("\t6. Delete a meme");
        System.out.print(">> ");
        return scan.nextLine();
    }

    public void searchMemeByTitle () {
        System.out.print("Enter a title to search by: ");
        String title = scan.nextLine();
        QueryMaker.searchByTitle(server, title);
    }

    public void searchMemeByCategory () {
        System.out.print("Enter a title to search by: ");
        String category = scan.nextLine();
        QueryMaker.searchByCategory(server, category);
    }

    public void makeFavorite() {
        System.out.println("Enter the meme id:");
        int temp = scan.nextInt();
        QueryMaker.favoriteMeme(server, account, temp);
    }

    public void viewMeme () {
        System.out.println("Enter a meme id to viewed: ");
        System.out.print(">> ");
        int i = scan.nextInt();
        QueryMaker.viewMeme(server, account, i);
        String location = "meme/" + i + ".jpg";
        try {
            RenderMeme.render(location);
        } catch (Exception e) {
            location = "meme/" + i + ".png";
            try {
                RenderMeme.render(location);
            } catch (Exception a) {
                location = "meme/Duckroll.jpg";
                RenderMeme.render(location);
            }
        }
    }

    public void deleteMeme () {
        System.out.println("Enter a meme id: ");
        System.out.print(">> ");
        int id = scan.nextInt();
        QueryMaker.deleteMeme(server, id);
    }

}
