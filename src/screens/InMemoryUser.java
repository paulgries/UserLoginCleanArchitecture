package screens;

import users.UserDsRequestModel;
import users.UserRegisterDsGateway;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUser implements UserRegisterDsGateway {

    private Map<String, UserDsRequestModel> users = new HashMap<>();

    /**
     * @param identifier
     * @return
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param requestModel
     */
    @Override
    public void save(UserDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getName());
        users.put(requestModel.getName(), requestModel);
    }
}
