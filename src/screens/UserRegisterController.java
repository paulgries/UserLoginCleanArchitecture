package screens;

import user_register_use_case.UserRegisterInputBoundary;
import user_register_use_case.UserRegisterRequestModel;
import user_register_use_case.UserRegisterResponseModel;

// Interface adapters layer

public class UserRegisterController {

    final UserRegisterInputBoundary userInput;

    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
        return userInput.create(requestModel);
    }
}
