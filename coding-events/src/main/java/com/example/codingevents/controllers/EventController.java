package com.example.codingevents.controllers;

import com.example.codingevents.data.EventRepository;
import com.example.codingevents.models.Event;
import com.example.codingevents.models.EventType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired // spring boot o sa dea valori automate, pt ca nu am constructori; = dependency injection
    private EventRepository eventRepository; // ii ciudat ca ii interfata but oh well... ii ceva ce spring poate face pt ca am pus @Repository si creeaza o clasa in memorie ca sa o implementeze si dupa pe care sa o bage aici, autowired

    // findAll, save, findById - is metode pe care le putem folosi pt ca is implementate in CrudRepository interface, care ii extinsa de EventRepository

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        // model.addAttribute("events", EventData.getAllEvents()); // inainte de crearea repository ului
         model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }


    // Model binding; when spring tries to call this method when the post req is made to this route,
    // it'll look in the req data and look for fields that'll match up w the fields of the event class
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        //EventData.add(newEvent);
        eventRepository.save(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        //model.addAttribute("events", EventData.getAllEvents());
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {

        if(eventIds != null) {
            for (int id : eventIds) {
                //EventData.remove(id);
                eventRepository.deleteById(id);
            }
        }
        return "redirect:/events";
    }

}
