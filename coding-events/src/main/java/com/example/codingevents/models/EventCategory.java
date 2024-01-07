package com.example.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity{

    @Size(min = 3, message = "Name size must be at least 3 characters")
    private String name;

    public EventCategory(@Size(min = 3, message = "Name size must be at least 3 characters") String name) {
        this.name = name;
    }

    public EventCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
