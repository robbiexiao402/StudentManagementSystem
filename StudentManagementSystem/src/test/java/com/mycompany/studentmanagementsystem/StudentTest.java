package com.mycompany.studentmanagementsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private final Student[] testStudents = {
        new Student("Jimmy", 12, "001", 3, 2),
        new Student("Johnny", 12, "002", 3, 2),
        new Student("Teegan", 12, "003", 3, 2)
    };

    @Test
    public void testGetStudentId() {
        // Testing get student method
        String expected = "001";
        String output = testStudents[0].getStudentId();
        assertEquals(expected, output);
    }

    @Test
    public void testSetAndGetStudentGrade() {
        // Testing the set and get grades method
        int expected = 12;
        testStudents[0].setGrade(1, 1, expected);
        int output = testStudents[0].getGrade(1, 1);
        assertEquals(expected, output);
    }

    @Test
    public void testUpdateStudentGradeSuccess() {
        // Testing valid term/subject
        testStudents[0].setGrade(1, 1, 100);
        String expected = "Grade updated.";
        String output = testStudents[0].updateGrade(1, 1, 86); 
        assertEquals(expected, output);
    }
    
    @Test
    public void testUpdateStudentGradeFailure() {
        // Testing out of bounds term/subject
        String expected = "Invalid subject or term number.";
        String output = testStudents[0].updateGrade(5, 5, 86); 
        assertEquals(expected, output);
    }
}
