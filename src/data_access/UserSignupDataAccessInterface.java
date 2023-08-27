package data_access;

import users.UserSignupDsData;

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);

    void save(UserSignupDsData requestModel);
}
