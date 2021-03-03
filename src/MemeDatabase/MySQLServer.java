package MemeDatabase;

/**
   This class is just to store and recall information for the MySQL server being connected to. This will be initialized and set in the main method. Then it can be passed and used later in program execution to recall the server details.
 */

public class MySQLServer {

    private String url;
    private String username;
    private String password;
    private String driver;

    public MySQLServer (String url, String username, String password, String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
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

    public String getDriver () {
        return this.driver;
    }

}
