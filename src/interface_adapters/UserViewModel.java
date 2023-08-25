package interface_adapters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserViewModel {

    public enum LoginState {
        WELCOME,
        SIGNING_UP,
        LOGGING_IN,
        LOGGED_IN,
    }

    /** The username of the user who is currently logged in. Null if not logged in. */
    String currentUser = null;

    private LoginState state = LoginState.WELCOME;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        String oldUser = this.currentUser;
        this.currentUser = currentUser;
        support.firePropertyChange("user", oldUser, this.currentUser);
    }

    public void setState(LoginState state) {
        LoginState oldState = this.state;
        this.state = state;
        support.firePropertyChange("state", oldState, this.state);
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
