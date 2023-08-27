package entities;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String name, String password) {
        return new CommonUser(name, password);
    }
}
