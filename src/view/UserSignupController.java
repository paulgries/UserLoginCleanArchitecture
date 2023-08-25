package view;

import users.UserSignupInputBoundary;
import users.UserSignupInputData;
import users.UserSignupOutputData;

// Interface adapters layer

public class UserSignupController {

    final UserSignupInputBoundary userInput;

    public UserSignupController(UserSignupInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserSignupOutputData create(String username, String password1, String password2) {
        UserSignupInputData userSignupInputData = new UserSignupInputData(
                username, password1, password2);

        return userInput.createUser(userSignupInputData);
    }
}
