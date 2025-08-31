package com.mycompany.studentmanagementsystem;
public class Student extends Person {
    private String studentId;
    private int[][] grades;
    
    public Student(String name, int age, String studentId, int subjectCount, int termCount) {
        super(name, age);
        this.studentId = studentId;
        this.grades = new int[subjectCount][termCount];
    }
    
    // Get student Id
    public String getStudentId() {
        return studentId;
    }
    // Set student grade
    public void setGrade(int subjectIndex, int termIndex, int grade) {
        if (isValidIndex(subjectIndex, termIndex)) {
            grades[subjectIndex - 1][termIndex - 1] = grade; 
        }
    }
    // Get student grade
    public int getGrade(int subjectIndex, int termIndex) {
        if (isValidIndex(subjectIndex, termIndex)) {
            return grades[subjectIndex - 1][termIndex - 1]; 
        }
        return -1;
    }
    // Helper function for checking valid indexes
    public boolean isValidIndex(int subjectIndex, int termIndex) {
        return subjectIndex >= 1 && subjectIndex <= grades.length && termIndex >= 1 && termIndex <= grades[0].length;
    }
    // Update student grade
    public String updateGrade(int subjectIndex, int termIndex, int grade) {
        if (getGrade(subjectIndex, termIndex) != -1) {
            setGrade(subjectIndex, termIndex, grade);
            return "Grade updated.";
        } else {
            return "Invalid subject or term number.";
        }
    }
    // Display student grades
    public void displayGrades() {
        int overallMark = 0;
        
        System.out.println("Grades for: " + getName());
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Subject (" + (i+1) + "): ");
            for (int j = 0; j < grades[i].length; j++) {
                overallMark += grades[i][j];
                System.out.print(grades[i][j] + " ");
            }
            System.out.println();
        }
        
        overallMark = overallMark / 6;
        if (overallMark > 60) {
            System.out.println("Your overall aggregate was " + overallMark + " (Good)");
        } else {
            System.out.println("Your overall aggregate was " + overallMark + " (Bad)");
        }
    }
}
