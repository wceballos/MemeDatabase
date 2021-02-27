package MemeDatabase;

public class Account {

    private String accountName;
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

    public String getEmail () {
        return this.email;
    }

    public String getPassword () {
        return this.password;
    }

    

}
