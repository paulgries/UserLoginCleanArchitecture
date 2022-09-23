package user_register_use_case;

// Use case layer

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel requestModel);
}
