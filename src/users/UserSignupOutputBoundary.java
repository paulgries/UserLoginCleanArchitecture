package users;

// Use case layer

public interface UserSignupOutputBoundary {
    void prepareSuccessView(UserSignupOutputData user);

    void prepareFailView(String error);
}