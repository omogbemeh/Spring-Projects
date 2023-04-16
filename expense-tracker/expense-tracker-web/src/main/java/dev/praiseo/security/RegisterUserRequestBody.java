package dev.praiseo.security;

import dev.praiseo.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

public class RegisterUserRequestBody {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User toUser(PasswordEncoder encoder) {
        return new User(firstName, lastName, username, encoder.encode(password));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterUserRequestBody that)) return false;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, password);
    }
}
