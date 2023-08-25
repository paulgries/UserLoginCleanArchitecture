package users;

// Use case layer

public interface UserRegisterInputBoundary {
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
