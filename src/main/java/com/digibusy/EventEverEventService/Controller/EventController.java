package com.digibusy.EventEverEventService.Controller;

import com.digibusy.EventEverEventService.DTO.EventDto;
import com.digibusy.EventEverEventService.Model.EventEntity;
import com.digibusy.EventEverEventService.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("event")
public class EventController {
@Autowired
    EventService eventService;

    public EventController() {
    }

    @GetMapping("/allEvents")
    public ResponseEntity<List<EventEntity>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.FOUND);
    }
    @GetMapping("/event/{id}")
    public ResponseEntity<EventEntity> getEventById(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getEventById(id),HttpStatus.FOUND);
    }
    @PostMapping("/postEvent")
    public ResponseEntity<EventEntity> createEvent(@RequestBody EventEntity eventEntity){
        return new ResponseEntity<>(eventService.createEvent(eventEntity),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteEvent")
    public ResponseEntity<String> deleteEvent(@RequestParam("id") Long id){
        return new ResponseEntity<>(eventService.deleteEvent(id),HttpStatus.OK);
    }

    @PutMapping("/updateEvent")
    public ResponseEntity<Object> updateEvent(@RequestBody EventEntity eventEntity){
        return new ResponseEntity<>(eventService.updateEvent(eventEntity),HttpStatus.ACCEPTED);
    }

    @GetMapping("/filterEvents")
    public ResponseEntity<List<EventEntity>> filterEvents(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String category
    ) {
        return ResponseEntity.ok(eventService.getFilteredEvents(status, location, date, category));
    }

    @PutMapping("/{id}/updateSeats")
    public ResponseEntity<Void> updateAvailableSeats(@PathVariable Long id,@RequestParam int seats){
        eventService.updateSeats(id,seats);
        return ResponseEntity.ok().build();
    }
}
