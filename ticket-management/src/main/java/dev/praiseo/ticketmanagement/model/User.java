package dev.praiseo.ticketmanagement.model;

public class User {
    private Integer userId;
    private String username;

    public User(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
