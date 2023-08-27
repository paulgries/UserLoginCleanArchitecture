package interface_adapters;

import users.UserSignupOutputBoundary;
import users.UserSignupOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserSignupPresenter implements UserSignupOutputBoundary {

    @Override
    public void prepareSuccessView(UserSignupOutputData response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }

    @Override
    public void prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}
