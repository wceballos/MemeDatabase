package MemeDatabase;

/**
   This class is just to store and recall information for the MySQL server being connected to. This will be initialized and set in the main method. Then it can be passed and used later in program execution to recall the server details.
 */

public class MySQLDatabase {

    private String url;
    private String username;
    private String password;

    public MySQLDatabase (String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getURL () {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

}
