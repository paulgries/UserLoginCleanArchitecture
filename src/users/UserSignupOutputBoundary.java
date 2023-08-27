package users;

// Use case layer

public interface UserSignupOutputBoundary {
    void prepareSuccessView(UserSignupOutputData user);

    UserSignupOutputData prepareFailView(String error);
}