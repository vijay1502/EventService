package com.digibusy.EventEverEventService.Service;

import com.digibusy.EventEverEventService.Model.NotificationEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventServiceNotification {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void notifyUser(String email, String message){
        NotificationEvent event = new NotificationEvent();
                event.setRecipientEmail(email);
                event.setMessage(message);
                event.setType("EMAIL");
                event.setEventType("EVENT_CREATED");

        ObjectMapper mapper = new ObjectMapper();
        try {
            kafkaTemplate.send("notification-topic", event.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
