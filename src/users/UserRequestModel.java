package users;

// Use case layer

public class UserRequestModel {

    String name;
    String password;

    public UserRequestModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
