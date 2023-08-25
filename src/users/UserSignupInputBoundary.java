package users;

// Use case layer

public interface UserSignupInputBoundary {
    UserSignupOutputData createUser(UserSignupInputData userSignupInputData);
}
