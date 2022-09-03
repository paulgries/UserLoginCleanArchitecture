package users;

import org.junit.jupiter.api.Test;
import users.CommonUser;
import users.User;

import static org.junit.jupiter.api.Assertions.assertFalse;

class UserUnitTest {

    @Test
    void given123Password_whenPasswordIsNotValid_thenIsFalse() {
        User user = new CommonUser("Baeldung", "123");

        assertFalse(user.passwordIsValid());
    }
}