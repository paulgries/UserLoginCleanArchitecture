package users;

// Use case layer

public class UserSignupInputData {

    final private String name;
    final private String password;
    final private String repeatPassword;

    public UserSignupInputData(String name, String password, String repeatPassword) {
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getName() {
        return name;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
