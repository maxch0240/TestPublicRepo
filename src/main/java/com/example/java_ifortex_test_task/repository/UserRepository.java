package com.example.java_ifortex_test_task.repository;

import com.example.java_ifortex_test_task.entity.DeviceType;
import com.example.java_ifortex_test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = """
    SELECT u.*, MAX(s.started_at_utc) AS last_session_time
    FROM sessions s
    JOIN users u ON s.user_id = u.id
    WHERE s.device_type = :#{#deviceType.getCode()}
    GROUP BY u.id
    ORDER BY last_session_time DESC
    """, nativeQuery = true)
    List<User> getUsersWithAtLeastOneMobileSession(@Param("deviceType")DeviceType deviceType);

    @Query(value = """
    SELECT u.*
    FROM users u
    WHERE u.id = (
        SELECT s.user_id
        FROM sessions s
        GROUP BY s.user_id
        ORDER BY COUNT(*) DESC
        LIMIT 1
    )
    """, nativeQuery = true)
    User getUserWithMostSessions();
}
