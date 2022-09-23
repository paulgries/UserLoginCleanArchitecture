package user_register_use_case;

// Use case layer

public interface UserRegisterDsGateway {
    boolean existsByName(String identifier);

    void save(UserDsRequestModel requestModel);
}
