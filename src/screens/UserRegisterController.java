package screens;

import user_register_use_case.UserInputBoundary;
import user_register_use_case.UserRequestModel;
import user_register_use_case.UserResponseModel;

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
