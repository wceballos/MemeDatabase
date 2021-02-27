package MemeDatabase;

public class Account {

    private String accountName;
    private String userID; // may need to change
    private String email;
    private String password;

    public Account (String initAccountName, String initUserID, String initEmail, String initPassword) {
        this.accountName = initAccountName;
        this.email = initEmail;
        this.password = initPassword;
    }

    public String getAccountName () {
        return this.accountName;
    }

    public String getUserID () {
        return this.userID;
    }

    public String getEmail () {
        return this.email;
    }

    

}
