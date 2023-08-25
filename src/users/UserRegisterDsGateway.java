package users;

// Use case layer

public interface UserRegisterDsGateway {
    boolean existsByName(String identifier);

    void save(UserRegisterDsRequestModel requestModel);
}
