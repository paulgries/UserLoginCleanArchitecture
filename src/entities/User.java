package entities;

// Entity layer

public interface User {
    boolean passwordIsValid();

    String getName();

    String getPassword();
}
