package com.digibusy.EventEverEventService.Model;

public class NotificationEvent {
    private String recipientEmail;
    private String recipientPhone;
    private String message;
    private String type; // EMAIL or SMS
    private String eventType;// BOOKING_CONFIRMED, PAYMENT_SUCCESS, etc.

    public NotificationEvent() {
    }

    public NotificationEvent(String recipientEmail, String recipientPhone, String message, String type, String eventType) {
        this.recipientEmail = recipientEmail;
        this.recipientPhone = recipientPhone;
        this.message = message;
        this.type = type;
        this.eventType = eventType;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "NotificationEvent{" +
                "recipientEmail='" + recipientEmail + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
