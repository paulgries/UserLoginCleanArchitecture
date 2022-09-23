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

    UserRegisterResponseModel create(String username, String password1, String password2) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                username, password1, password2);

        return userInput.create(requestModel);
    }
}
