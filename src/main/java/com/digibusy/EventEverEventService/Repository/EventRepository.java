package com.digibusy.EventEverEventService.Repository;

import com.digibusy.EventEverEventService.Model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity,Long> {
List<EventEntity> findByOrganizerId(String organizerId);
List<EventEntity> findByCategory(String category);
@Query("SELECT e FROM EventEntity e WHERE DATE(e.startTime) >= :date")
List<EventEntity> findByStartTimeAfter(@Param("date") LocalDate date);
@Query("SELECT e FROM EventEntity e WHERE DATE(e.startTime) >= :date AND e.location = :location")

List<EventEntity> findByStartTimeAfterAndLocation(@Param("date") LocalDate date,@Param("location") String location);
@Query("SELECT e FROM EventEntity e WHERE DATE(e.startTime) >= :date AND e.location = :location and e.status = :status")

List<EventEntity> findByStartTimeAfterAndLocationAndStatus(@Param("date") LocalDate date,@Param("location") String location,@Param("status") String status);
@Query("SELECT e FROM EventEntity e WHERE DATE(e.startTime) = :date")
List<EventEntity> findByExactDate(@Param("date") LocalDate date);
@Query("SELECT e FROM EventEntity e WHERE DATE(e.startTime) = :date AND e.location = :location")

List<EventEntity> findByDateAndLocation(@Param("date") LocalDate date,@Param("location") String location);
@Query("SELECT e FROM EventEntity e WHERE DATE(e.startTime) = :date AND e.location = :location and e.status = :status")

List<EventEntity> findByDateAndLocationAndStatus(@Param("date") LocalDate date,@Param("location") String location,@Param("status") String status);
@Query("SELECT e FROM EventEntity e WHERE e.status = :status")
List<EventEntity> findAllEventsByStatus(@Param("status") String status);

@Query("SELECT e FROM EventEntity e WHERE e.status = :status AND e.location = :location")
List<EventEntity> findAllEventsByStatusAndLocation(@Param("status") String status,@Param("location") String location);

}
