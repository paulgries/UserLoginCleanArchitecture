class Account {
    /**
     * Unique identifier of this account (cannot be changed).
     */
    private final int accountID;

    /**
     * Username of this account (cannot be changed).
     */
    private final String accountName;

    /**
     * Password of this account.
     */
    private final String password;

    /**
     * Creates a new account with the given username, password
     *
     * @param username    Username of this account
     * @param password    Password for this account
     * @param accountID   Unique identifier of this account
     */
    public Account(String username, String password, int accountID) {
        this.accountName = username;
        this.password = password;
        this.accountID = accountID;
    }
    /**
     * Get the accountID of this account.
     *
     * @return Unique identifier of the account
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * Gets the username of the account.
     *
     * @return Username of the account
     */
    String getAccountName() {
        return accountName;
    }

    /**
     * Returns the password of this account.
     *
     * @return Password of the account
     */
    String getPassword() {
        return password;
    }

    /**
     * Returns the password of this account.
     *
     * @return Password of the account
     */
    boolean passwordMatches(String pwd) {
        return pwd == this.password;
    }

    /**
     * Creates a string representation of this Account.
     *
     * @return A string representation of this Account object
     */
    @Override
    public String toString() {
        return this.accountName;
    }
}
