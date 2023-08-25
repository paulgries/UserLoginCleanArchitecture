package users;

// Use case layer

public interface UserSignupOutputBoundary {
    UserSignupOutputData prepareSuccessView(UserSignupOutputData user);

    UserSignupOutputData prepareFailView(String error);
}