package users;

// Entity layer

interface User {
    boolean passwordIsValid();

    String getName();

    String getPassword();
}
