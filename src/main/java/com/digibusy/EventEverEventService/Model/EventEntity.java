package com.digibusy.EventEverEventService.Model;

import com.digibusy.EventEverEventService.Constant.EventType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Builder
public class EventEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false, length = 255)
    private String location;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String organizerId;
    @Column(nullable = false)
    private int availableSeats;

    @Column(nullable = false, length = 50)
    private String status;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    public EventEntity() {
    }

    public EventEntity(Long id, String title, String description, String category, String location, LocalDateTime startTime, LocalDateTime endTime, BigDecimal price, Integer capacity, String organizerId, int availableSeats, String status, EventType eventType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.capacity = capacity;
        this.organizerId = organizerId;
        this.availableSeats = availableSeats;
        this.status = status;
        this.eventType = eventType;
    }

    public EventEntity(LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, Long id, String title, String description, String category, String location, LocalDateTime startTime, LocalDateTime endTime, BigDecimal price, Integer capacity, String organizerId, int availableSeats, String status, EventType eventType) {
        super(createdAt, updatedAt, createdBy, updatedBy);
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.capacity = capacity;
        this.organizerId = organizerId;
        this.availableSeats = availableSeats;
        this.status = status;
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", capacity=" + capacity +
                ", organizerId='" + organizerId + '\'' +
                ", availableSeats=" + availableSeats +
                ", status='" + status + '\'' +
                '}';
    }
}
