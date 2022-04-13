package com.myStudent.StudentMainController.StudentMessageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WellcomeMessage {

    private final FindingEmailStudent FindingEmailStudent;

    @Autowired
    public WellcomeMessage(FindingEmailStudent FindingEmailStudent) {
        this.FindingEmailStudent = FindingEmailStudent;
    }

     public String Greetings() {
       return "Welcome to School Management System ...";
    }

    public void addNewStudent(Student student) {

        // filter student by email
        Optional<Student> std = FindingEmailStudent.findByEmail(student.getEmail());

        // if student exist then return error message
        if (std.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }

        FindingEmailStudent.save(student);
    }
}

