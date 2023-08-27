package data_access;

// Use case layer

import users.UserSignupDsData;

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);

    void save(UserSignupDsData requestModel);
}
