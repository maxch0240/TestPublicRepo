package com.example.java_ifortex_test_task.repository;

import com.example.java_ifortex_test_task.entity.DeviceType;
import com.example.java_ifortex_test_task.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query(value = """
    SELECT * FROM sessions
    WHERE device_type = :#{#deviceType.getCode()}
    ORDER BY started_at_utc ASC
    LIMIT 1
    """, nativeQuery = true)
    Session getFirstDesktopSession(@Param("deviceType") DeviceType deviceType);

//    @Query(value = "", nativeQuery = true)
//    List<Session> getSessionsFromActiveUsersEndedBefore2025(LocalDateTime endDate);
}