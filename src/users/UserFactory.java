package users;

// Entity layer

public interface UserFactory {
    User create(String name, String password);
}
