package com.example.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message = "Name field must not be blank")
    @Size(min = 3, max = 500, message = "Name size must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description size must be under 500 characters")
    private String description;

    @NotBlank(message = "Email field must not be blank")
    @Email(message = "Invalid email")
    private String contactEmail;

    private EventType type;

    public Event() { }

    public Event(String name, String description, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return //id +
                ". " + name + "(" + type +", contact: "+ contactEmail + "): " + description;
    }
}
