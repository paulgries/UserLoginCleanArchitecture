package interface_adapters;

public class UserCreationFailed extends RuntimeException {
    public UserCreationFailed(String error) {
        super(error);
    }
}
