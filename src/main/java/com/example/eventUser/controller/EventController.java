package com.example.eventUser.controller;

import com.example.eventUser.model.Event;
import com.example.eventUser.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;
    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/getEvent")
    public Event getById(@RequestParam int id){
        return eventService.getById(id);
    }

    @PostMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody Event event){
        eventService.addEvent(event);
        return new ResponseEntity<>("Successfully added event", HttpStatus.CREATED);
    }

    @PutMapping("/updateEvent")
    public ResponseEntity<String> updateEvent(@RequestBody Event event){
        eventService.updateEvent(event);
        return new ResponseEntity<>("Successfully updated event", HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent")
    public ResponseEntity<String> deleteEvent(@RequestParam int id){
        eventService.deleteEvent(id);
        return new ResponseEntity<>("Successfully deleted event", HttpStatus.OK);
    }
}
