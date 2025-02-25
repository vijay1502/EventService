package com.digibusy.EventEverEventService.Exception;

public class EventException extends RuntimeException{
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EventException(String message) {
        this.message = message;
    }

}
