package users;

// Use case layer

public interface UserRegisterPresenter {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}