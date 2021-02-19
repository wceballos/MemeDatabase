package MemeDatabase;

import java.util.Scanner;

public class MemeDatabase {

    

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Meme Database!");
        String input = "";
        while (!input.equals("y") || !input.equals("n")) {
            System.out.println("DO you have an account? [y/n] ");
            input = scan.nextLine();
        }
    }

}
