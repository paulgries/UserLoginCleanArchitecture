package users;

import data_access.UserSignupDataAccessInterface;
import entities.CommonUserFactory;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import data_access.InMemoryUserDataAccessObject;

import static org.junit.jupiter.api.Assertions.*;

class UserRegisterInteractorTest {

    @Test
    void create() {
        // To test the use case:
        // 1) Create a UserSignupInteractor and prerequisite objects
        //    (arguments for the UserSignupInteractor constructor parameters)
        // 2) create the Input Data
        // 3) Call the use case User Input Boundary method to run the use case
        // 4) Check that the Output Data passed to the Presenter is correct
        // 5) Check that the expected changes to the data layer are there.

        // 1) UserSignupInteractor and prerequisite objects
        // We're going to need a place to save and look up information. We could
        // use FileUserDataAccessObject, but because unit tests are supposed to be independent
        // that would make us also reset the file when we are done.
        // Instead, we're going to "mock" that info using a short-lived solution
        // that just keeps the info in a dictionary, and it won't be persistent.
        // (Separately, elsewhere, we will need to test the FileUserDataAccessObject works
        // properly.)

//        UserSignupDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        UserSignupDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // This creates an anonymous implementing class for the Output Boundary.
        UserSignupOutputBoundary presenter = new UserSignupOutputBoundary() {
            @Override
            public void prepareSuccessView(UserSignupOutputData user) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("paul", user.getUser());
                assertNotNull(user.getCreationTime()); // any creation time is fine.
                assertTrue(userRepository.existsByName("paul"));
                return null;
            }

            @Override
            public UserSignupOutputData prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        UserFactory userFactory = new CommonUserFactory();
        UserSignupInputBoundary interactor = new UserSignupInteractor(
                userRepository, presenter, userFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        UserSignupInputData inputData = new UserSignupInputData(
                "paul", "pwd1234", "pwd1234");

        // 3) Run the use case
        interactor.createUser(inputData);
    }
}