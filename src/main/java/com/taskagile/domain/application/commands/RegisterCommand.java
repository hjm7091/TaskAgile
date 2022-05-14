package com.taskagile.domain.application.commands;

import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Objects;

@Getter
public class RegisterCommand extends AnonymousCommand {
    
    private final String username;
    private final String emailAddress;
    private final String firstName;
    private final String lastName;
    private final String password;
  
    public RegisterCommand(String username, String emailAddress, String firstName, String lastName, String password) {
        Assert.hasText(username, "Parameter `username` must not be empty");
        Assert.hasText(emailAddress, "Parameter `emailAddress` must not be empty");
        Assert.hasText(firstName, "Parameter `firstName` must not be empty");
        Assert.hasText(lastName, "Parameter `lastName` must not be empty");
        Assert.hasText(password, "Parameter `password` must not be empty");

        this.username = username;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterCommand)) return false;
        RegisterCommand that = (RegisterCommand) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(password, that.password);
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(username, emailAddress, firstName, lastName, password);
    }

    @Override
    public String toString() {
        return "RegisterCommand{" +
                "username='" + username + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
