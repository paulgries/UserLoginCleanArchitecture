package screens;

import user_register_use_case.UserPresenter;
import user_register_use_case.UserResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class UserResponseFormatter implements UserPresenter {

    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public UserResponseModel prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}
