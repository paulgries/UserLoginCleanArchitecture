package users;

// Use case layer

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel requestModel);
}
