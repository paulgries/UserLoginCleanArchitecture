package screens;

import user_register_use_case.UserRegisterDsRequestModel;
import user_register_use_case.UserRegisterDsGateway;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUser implements UserRegisterDsGateway {

    final private Map<String, UserRegisterDsRequestModel> users = new HashMap<>();

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
    public void save(UserRegisterDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getName());
        users.put(requestModel.getName(), requestModel);
    }
}
