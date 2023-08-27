package data_access;

import users.UserSignupDsData;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements UserSignupDataAccessInterface {

    final private Map<String, UserSignupDsData> users = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(UserSignupDsData requestModel) {
        System.out.println("Save " + requestModel.getName());
        users.put(requestModel.getName(), requestModel);
    }
}
