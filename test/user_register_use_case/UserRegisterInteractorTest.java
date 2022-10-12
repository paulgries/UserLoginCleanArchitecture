package user_register_use_case;

import entities.CommonUserFactory;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screens.InMemoryUser;

import static org.junit.jupiter.api.Assertions.*;

class UserRegisterInteractorTest {

    @Test
    void create() {
        // To test the use case:
        // 1) Create a UserRegisterInteractor and prerequisite objects
        //    (arguments for the UserRegisterInteractor constructor parameters)
        // 2) create the Input Data
        // 3) Call the use case User Input Boundary method to run the use case
        // 4) Check that the Output Data passed to the Presenter is correct
        // 5) Check that the expected changes to the data layer are there.

        // 1) UserRegisterInteractor and prerequisite objects
        // We're going to need a place to save and look up information. We could
        // use FileUser, but because unit tests are supposed to be independent
        // that would make us also reset the file when we are done.
        // Instead, we're going to "mock" that info using a short-lived solution
        // that just keeps the info in a dictionary, and it won't be persistent.
        // (Separately, elsewhere, we will need to test the FileUser works
        // properly.)
        UserRegisterDsGateway userRepository = new InMemoryUser();

        // This creates an anonymous implementing class for the Output Boundary.
        UserRegisterPresenter presenter = new UserRegisterPresenter() {
            @Override
            public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("paul", user.getLogin());
                assertNotNull(user.getCreationTime()); // any creation time is fine.
                assertTrue(userRepository.existsByName("paul"));
                return null;
            }

            @Override
            public UserRegisterResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        UserFactory userFactory = new CommonUserFactory();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                userRepository, presenter, userFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        UserRegisterRequestModel inputData = new UserRegisterRequestModel(
                "paul", "pwd1234", "pwd1234");

        // 3) Run the use case
        interactor.create(inputData);
    }
}