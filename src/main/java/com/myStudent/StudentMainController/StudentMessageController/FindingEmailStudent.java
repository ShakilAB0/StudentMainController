package com.myStudent.StudentMainController.StudentMessageController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FindingEmailStudent extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
