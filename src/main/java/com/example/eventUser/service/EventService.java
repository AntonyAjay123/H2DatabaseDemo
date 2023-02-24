package com.example.eventUser.service;

import com.example.eventUser.model.Event;
import com.example.eventUser.repository.EventRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    
    @Autowired
    EventRepository eventRepository;
    
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    
    public Event getById(int id){
        return eventRepository.findById(id).get();
    }
    
    public void addEvent(Event newEvent){
        eventRepository.save(newEvent);
    }
    
    public void updateEvent(Event event){
        Event existingEvent = getById(event.getId());
        JSONObject json = new JSONObject(event);
        if(json.has("eventName"))
            existingEvent.setEventName(event.getEventName());
        if(json.has("location"))
            existingEvent.setLocation(event.getLocation());
        if(json.has("dateEvent"))
            existingEvent.setDateEvent(event.getDateEvent());
        if(json.has("startTime"))
            existingEvent.setStartTime(event.getStartTime());
        if(json.has("endTime"))
            existingEvent.setEndTime(event.getEndTime());
        if(json.has("imgUrl"))
            existingEvent.setImgUrl(event.getImgUrl());
        eventRepository.save(existingEvent);
    }

    public void deleteEvent(int id){
        eventRepository.deleteById(id);
    }
}
