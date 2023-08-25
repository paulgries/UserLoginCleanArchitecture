package interface_adapters;

import users.UserSignupOutputBoundary;
import view.UserCreationFailed;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class UserSignupPresenter implements UserSignupOutputBoundary {

    @Override
    public users.UserSignupOutputData prepareSuccessView(users.UserSignupOutputData response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public users.UserSignupOutputData prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}
