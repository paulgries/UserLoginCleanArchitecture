package screens;

import users.UserInputBoundary;
import users.UserRequestModel;
import users.UserResponseModel;

// Interface adapters layer

public class UserRegisterController {

    final UserInputBoundary userInput;

    public UserRegisterController(UserInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserResponseModel create(UserRequestModel requestModel) {
        return userInput.create(requestModel);
    }
}
