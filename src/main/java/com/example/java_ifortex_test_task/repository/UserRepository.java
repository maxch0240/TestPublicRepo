package com.example.java_ifortex_test_task.repository;

import com.example.java_ifortex_test_task.entity.DeviceType;
import com.example.java_ifortex_test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query(value = "", nativeQuery = true)
//    List<User> getUsersWithAtLeastOneMobileSession(DeviceType deviceType);
//
//    @Query(value = "", nativeQuery = true)
//    User getUserWithMostSessions();
}
