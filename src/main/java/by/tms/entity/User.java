package by.tms.entity;

public class User {

    private String name;
    private String userName;
    private String password;
    private String sessionID;

    public User(String name, String username, String password) {
        this.name = name;
        this.userName = username;
        this.password = password;
    }

    public User(String name, String userName, String password, String sessionId) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.sessionID = sessionId;
    }

    public User(String sessionId) {
        this.sessionID = sessionId;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sessionID='" + sessionID + '\'' +
                '}';
    }
}

