package com.digibusy.EventEverEventService.Service.impl;

import com.digibusy.EventEverEventService.DTO.EventDto;
import com.digibusy.EventEverEventService.Exception.EventException;
import com.digibusy.EventEverEventService.Model.EventEntity;
import com.digibusy.EventEverEventService.Repository.EventRepository;
import com.digibusy.EventEverEventService.Service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public EventEntity getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event Not Found!"));
    }

    @Override
    public List<EventEntity> getAllByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    @Override
    public List<EventEntity> getFilteredEvents(String status, String location, LocalDate date, String category) {
        List<EventEntity> events;

        if (status != null && location != null && date != null) {
            events = eventRepository.findByDateAndLocationAndStatus(date, location, status);
        } else if (status != null && location != null) {
            events = eventRepository.findAllEventsByStatusAndLocation(status, location);
        } else if (status != null) {
            events = eventRepository.findAllEventsByStatus(status);
        }else if(category != null){
            events = eventRepository.findByCategory(category);
        }
        else {
            events = eventRepository.findAll();
        }

        return events;
    }

    @Override
    public EventEntity createEvent(EventEntity eventEntity) {
        eventEntity.setAvailableSeats(eventEntity.getCapacity());
        return eventRepository.save(eventEntity);
    }

    @Override
    public String deleteEvent(Long id) {
        try {
            Optional<EventEntity> byId = eventRepository.findById(id);
            EventEntity eventEntity = byId.get();
            eventRepository.delete(eventEntity);
            return "Deleted Event";
        }catch (EventException e){
            throw new EventException("Cannot Delete event:"+e.getMessage());
        }
    }

    @Override
    public Object updateEvent(EventEntity eventEntity) {
        boolean present = eventRepository.findById(eventEntity.getId()).isPresent();
        if(present){
            EventEntity eventEntityUpdate = eventRepository.findById(eventEntity.getId()).get();
            eventEntityUpdate.setUpdatedAt(LocalDateTime.now());
            eventEntityUpdate.setUpdatedBy(eventEntity.getUpdatedBy());
            eventEntityUpdate.setCreatedBy(eventEntity.getCreatedBy());
            eventEntityUpdate.setCapacity(eventEntity.getCapacity());
            eventEntityUpdate.setId(eventEntity.getId());
            eventEntityUpdate.setLocation(eventEntity.getLocation());
            eventEntityUpdate.setCategory(eventEntity.getCategory());
            eventEntityUpdate.setPrice(eventEntity.getPrice());
            eventEntityUpdate.setDescription(eventEntity.getDescription());
            eventEntityUpdate.setStartTime(eventEntity.getStartTime());
            eventEntityUpdate.setCapacity(eventEntity.getCapacity());
            eventEntityUpdate.setEndTime(eventEntity.getEndTime());
            eventEntityUpdate.setOrganizerId(eventEntity.getOrganizerId());
            eventEntityUpdate.setTitle(eventEntity.getTitle());
            eventEntityUpdate.setEventType(eventEntity.getEventType());
            return eventRepository.save(eventEntityUpdate);
        }
        return "No Such Event found";
    }

    @Override
    public List<EventEntity> getAllEventsInOpenState(String status) {
        return eventRepository.findAllEventsByStatus(status);
    }

    @Override
    public List<EventEntity> getAllEventsInOpenStateAndLocation(String status, String location) {
        return eventRepository.findAllEventsByStatusAndLocation(status,location);
    }

    @Override
    public List<EventEntity> getAllEventsInOpenStateAndLocationAndDate(String status, String location, LocalDate date) {
        return eventRepository.findByDateAndLocationAndStatus(date,location,status);
    }

    @Override
    public void updateSeats(Long eventId, int seatChange) {
        EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event Not Found!"));
        if(eventEntity.getAvailableSeats() < seatChange){
            throw new EventException("Not enough seats available");
        }
        System.out.println("Event changes:"+ (eventEntity.getAvailableSeats()-seatChange));
        eventEntity.setAvailableSeats(eventEntity.getAvailableSeats()-seatChange);
        eventRepository.save(eventEntity);
    }
}
