package users;

// Use case layer

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);

    void save(UserSignupDsData requestModel);
}
