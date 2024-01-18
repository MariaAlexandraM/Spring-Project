package com.example.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // this is a table; class i wanna store in the db
public class EventDetails extends AbstractEntity{
    @Size(max = 500, message = "Description size must be under 500 characters")
    private String description;

    @NotBlank(message = "Email field must not be blank")
    @Email(message = "Invalid email")
    private String contactEmail;

    public EventDetails() { }

    public EventDetails(String description, String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
