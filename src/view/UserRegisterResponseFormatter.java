package view;

import users.UserRegisterPresenter;
import users.UserRegisterResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class UserRegisterResponseFormatter implements UserRegisterPresenter {

    @Override
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public UserRegisterResponseModel prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}
