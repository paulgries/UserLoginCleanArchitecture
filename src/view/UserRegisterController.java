package view;

import users.UserRegisterInputBoundary;
import users.UserRegisterRequestModel;
import users.UserRegisterResponseModel;

// Interface adapters layer

public class UserRegisterController {

    final UserRegisterInputBoundary userInput;

    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserRegisterResponseModel create(String username, String password1, String password2) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                username, password1, password2);

        return userInput.create(requestModel);
    }
}
