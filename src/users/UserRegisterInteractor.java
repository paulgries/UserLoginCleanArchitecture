package users;

import entities.User;
import entities.UserFactory;

import java.time.LocalDateTime;

// Use case layer

public class UserRegisterInteractor implements UserRegisterInputBoundary {

    final UserRegisterDsGateway userDsGateway;
    final UserRegisterPresenter userPresenter;
    final UserFactory userFactory;

    public UserRegisterInteractor(UserRegisterDsGateway userRegisterDfGateway, UserRegisterPresenter userRegisterPresenter,
                                  UserFactory userFactory) {
        this.userDsGateway = userRegisterDfGateway;
        this.userPresenter = userRegisterPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
        if (userDsGateway.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("User already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
            return userPresenter.prepareFailView("Passwords don't match.");
        }

        User user = userFactory.create(requestModel.getName(), requestModel.getPassword());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        LocalDateTime now = LocalDateTime.now();
        UserRegisterDsRequestModel userDsModel = new UserRegisterDsRequestModel(user.getName(), user.getPassword(), now);
        userDsGateway.save(userDsModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}