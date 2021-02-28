package MemeDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class QueryMaker {

    private static Connection makeConnection (MySQLServer ms) throws SQLException, ClassNotFoundException {
        Class.forName(ms.getDriver());
        Connection conn = DriverManager.getConnection(ms.getURL(), ms.getUsername(), ms.getPassword());
        return conn;
    }

    private static void closeConnection (Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
            conn.close();
        } catch (Throwable t) {
            System.err.println("Database leak has occured as the program had issues properly closing database connection");
        }
    }

    public static Account logIn (MySQLServer ms, String username, String password) {
        Account temp = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select account.username, account.email, account.password from account where account.username = " + "'" + username + "'" + " and account.password = " + "'" + password + "'";
        try {
            Class.forName(ms.getDriver());
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (!rs.next()) {
                temp = null;
                throw new Exception();
            }
            temp = new Account(rs.getString(1), rs.getString(2), rs.getString(3));  
        } catch (SQLException e) {
            System.err.println("Error fulfilling the task");
            e.printStackTrace();
            System.exit(1);
            temp = null;
        } catch (ClassNotFoundException a) {
            System.err.println("There is an issue with the driver specified by client");
            temp = null;
        } catch (Exception l) {
            System.err.println("Account does not exist");
        } finally {
            closeConnection(conn, stmt, rs);
            return temp;
        }
    }

    public static void getFavoriteMeme (MySQLServer ms, Account a) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select viewed.meme_id from viewed left join account on viewed.username = account.username where favorite = TRUE and viewed.username = '" + a.getAccountName() + "'");
            while (rs.next()) {
                System.out.println("\t"+rs.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Issue fulfilling request with database, check connection");
        } catch (ClassNotFoundException c) {
            System.err.println("There is an issue with the driver specified by client");
        } finally {
            closeConnection(conn, stmt, rs);
        }
    }

    public static void searchByTitle (MySQLServer ms, String title) {
        String query = "select * from meme, (select contains.meme_id from contains where contains.picture_title = '"+ title + "') as B where meme.meme_id = B.meme_id";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.print("\t");
                System.out.print("Meme title: " + rs.getString(2) + "\n");
                System.out.print("\t\tMeme ID: " + rs.getInt(1) + "\n");
                System.out.print("\t\tCategory: " + rs.getString(3) + "\n");
            }
        } catch (SQLException e) {
            System.err.println("Error occured while searching, please check database connection");
        } catch (ClassNotFoundException a) {
            System.err.println("There is an issue with the driver specified by client");
        } finally {
            closeConnection(conn, stmt, rs);
        }
    }

    public static void favoriteMeme (MySQLServer ms, Account a, int id) {
        String query = "update viewed set viewed.favorite = true where viewed.username = '"+a.getAccountName()+"' and viewed.meme_id = "+id;
        System.out.println(query);
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Update complete");
        } catch (SQLException e) {
            System.out.println("Error trying to favorite a meme, check connection to database");
        } catch (ClassNotFoundException c) {
            System.err.println("There is an issue with the driver specified by client");
        } finally {
            closeConnection(conn, stmt, null);
        }
    }

    public static boolean viewMeme (MySQLServer ms, Account a, int id) {
        String query = "select meme_id from meme where meme.meme_id = " + id;
        boolean condition = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (!rs.next()) {
                throw new SQLException();
            }
            stmt = conn.createStatement();
            query = "insert into viewed value("+id+","+"'"+ a.getAccountName()+"'" +",false)";
            try {
                stmt.executeUpdate(query);
            } catch (Exception e) {
                // do nothing
            }
            condition = true;
        } catch (SQLException e) {
            System.out.println("An issue occured with the query, try specifying a valid id for a meme");
            condition = false;
        } catch (ClassNotFoundException c) {
            System.err.println("There is an issue with the driver specified by client");
            condition = false;
        } finally {
            closeConnection(conn, stmt, null);
            return condition;
        }
    }

    public static void deleteMeme (MySQLServer ms, int id) {
        String query = "delete from meme where meme_id = " + id;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error occured deleting meme, check connection");
        } catch (ClassNotFoundException a) {
            System.err.println("There is an issue with the driver specified by client");
        } finally {
            closeConnection(conn, stmt, null);
        }
    }

    public static void searchByCategory (MySQLServer ms, String cat) {
        String query = "select * from meme where meme.category = " +"'"+ cat+"'";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (!rs.isBeforeFirst()) {
                throw new Exception();
            }
            while (rs.next()) {
                System.out.println("\tMeme id: " + rs.getInt(1));
                System.out.println("\t\tMeme title: " + rs.getString(2));

            }
        } catch (SQLException e) {
            System.err.println("Issue searching by category, check connection");
        } catch (ClassNotFoundException a) {
            System.err.println("There is an issue with the driver specified by client");
        } catch (Exception e) {
            System.err.println("Category specified was invalid");
        } finally {
            closeConnection(conn, stmt, rs);
        }
    }

    public static Account createAccount (MySQLServer ms, String username, String email, String password) {
        String query;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String preQuery = "select * from account where username = '" + username + "'";
        Account temp = null;
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(preQuery);
            if (rs.next()) {
                temp = null;
            } else {
                query = "insert into account(username, email, password) values('" + username + "','" + email + "','" + password + "')";
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
                temp = new Account(username, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, rs);
            return temp;
        }
         
    }

    public static void addMeme (MySQLServer server, String memeTitle, String category, String username, String pictureTitle, String pictureURI) {
        String query = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        query = "insert into meme value('"+memeTitle + "','" + category +"'," +"TRUE" ")";
        query = query + " insert into creates value('" + username"',"+ "GETDATE(), GETDATE())";
        query = qeury + " insert into picture value('" + pictureURI + "','" + pictureURI + ")";
        query = query + " insert into contain value('"+pictureTitle "')";
        try {
            conn = QueryMaker.makeConnection(ms);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, rs);
        }
    }

}
