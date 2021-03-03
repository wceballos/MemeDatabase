package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main (String[] args) {
        ResultSet rs = null;
        Statement st = null;
        Connection conn = null;

        String username = args[1];
        String password = args[2];

        String url = args[0];
        String driver = args[3];

        try {
            try {
                Class.forName(driver); 
            }  catch (Exception e) {
                    System.out.println("Issue getting driver");
                    System.exit(1);
            }

            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                System.out.println("Issue making connection");
                System.exit(1);
            }

            st = conn.createStatement();

            rs = st.executeQuery("select * from account");
            while (rs.next())
                System.out.println(rs.getString(1));

        } catch (SQLException sql) {
            System.out.println("Error");
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Throwable t) {
                
            }
            try {
                conn.close();
            } catch (Throwable t2) {
                System.err.println("Connection leak!");
            }
        }

    }

}
