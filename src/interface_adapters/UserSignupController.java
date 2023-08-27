package interface_adapters;

import users.UserSignupInputBoundary;
import users.UserSignupInputData;
import users.UserSignupOutputData;

// Interface adapters layer

public class UserSignupController {

    final UserSignupInputBoundary userInput;

    public UserSignupController(UserSignupInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public void create(String username, String password1, String password2) {
        UserSignupInputData userSignupInputData = new UserSignupInputData(
                username, password1, password2);

        userInput.createUser(userSignupInputData);
    }
}
