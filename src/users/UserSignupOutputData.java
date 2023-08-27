package users;

// Use case layer

public class UserSignupOutputData {

    String user;
    String creationTime;

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
