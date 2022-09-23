package user_register_use_case;

// Use case layer

public interface UserRegisterPresenter {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}