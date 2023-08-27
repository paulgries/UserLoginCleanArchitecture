package users;

public class UserSignupOutputData {

    private final String user;
    private String creationTime;

    public UserSignupOutputData(String user, String creationTime) {
        this.user = user;
        this.creationTime = creationTime;
    }

    public String getUser() {
        return user;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
