package com.mycompany.studentmanagementsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student[] testStudents = {
        new Student("Jimmy", 12, "001", 3, 2),
        new Student("Johnny", 12, "002", 3, 2),
        new Student("Teegan", 12, "003", 3, 2)
    };
    @Test
    public void TestGetStudentId() {
        String expected = "001";
        String output = testStudents[0].getStudentId();

        assertEquals(expected, output);
    }
    
    @Test
    public void TestSetAndGetStudentGrade() {
        int expected = 12;
        testStudents[0].setGrade(0, 0, 12);
        int output = testStudents[0].getGrade(0, 0);
        
        assertEquals(expected, output);
    }
    
    @Test
    public void TestUpdateStudentGradeSuccess() {
        testStudents[0].setGrade(0, 0, 100);
        String expected = "Grade updated.";
        String output = testStudents[0].updateGrade(0, 0, 86);
        
        assertEquals(expected, output);
    }
    
    @Test
    public void TestUpdateStudentGradeFailure() {
        testStudents[0].setGrade(0, 0, 100);
        String expected = "Grade updated.";
        String output = testStudents[0].updateGrade(0, 1, 86);
        
        assertEquals(expected, output);
    }
}
