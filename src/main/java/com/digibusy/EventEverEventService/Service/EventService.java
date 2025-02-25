package com.digibusy.EventEverEventService.Service;

import com.digibusy.EventEverEventService.DTO.EventDto;
import com.digibusy.EventEverEventService.Model.EventEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {
    public List<EventEntity> getAllEvents();
    public EventEntity getEventById(Long id);
    public List<EventEntity> getAllByCategory(String category);
    public List<EventEntity> getFilteredEvents(String status, String location, LocalDate date, String category);
    public EventEntity createEvent(EventEntity eventEntity);
    public String deleteEvent(Long id);
    public Object updateEvent(EventEntity eventEntity);
    public List<EventEntity> getAllEventsInOpenState(String status);

    public List<EventEntity> getAllEventsInOpenStateAndLocation(String status,String location);
    public List<EventEntity> getAllEventsInOpenStateAndLocationAndDate(String status, String location, LocalDate date);

    public void updateSeats(Long eventId,int seatChange);
}
