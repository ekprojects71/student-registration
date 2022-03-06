package com.student.registration.studentregistration.Request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Used for request validation in student controller

public class StudentRequestModel {

    @NotBlank(message = "First Name cannot be empty")
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @NotBlank(message = "Street Address cannot be empty")
    @NotNull(message = "Street Address cannot be null")
    private String streetAddress;

    @NotBlank(message = "City cannot be empty")
    @NotNull(message = "City cannot be null")
    private String city;

    @NotBlank(message = "State cannot be empty")
    @NotNull(message = "State cannot be null")
    private String state;

    @NotBlank(message = "Zipcode cannot be empty")
    @NotNull(message = "Zipcode cannot be null")
    @Size(min = 4, message = "Zipcode has to be at least 4 characters") //for accommodating non-us postal codes
    private String zipcode;


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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
