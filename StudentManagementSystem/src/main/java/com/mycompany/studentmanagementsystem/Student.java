package com.mycompany.studentmanagementsystem;
public class Student extends Person {
    private String studentId;
    private int[][] grades;
    
    public Student(String name, int age, String studentId, int subjectCount, int termCount) {
        super(name, age);
        this.studentId = studentId;
        this.grades = new int[subjectCount][termCount];
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public void setGrade(int subjectIndex, int termIndex, int grade) {
        if (isValidIndex(subjectIndex, termIndex)) {
            grades[subjectIndex][termIndex] = grade;
        }
    }
    
    public int getGrade(int subjectIndex, int termIndex) {
        if (isValidIndex(subjectIndex, termIndex)) {
            return grades[subjectIndex][termIndex];
        }
        
        return -1;
    }
    
    public boolean isValidIndex(int subjectIndex, int termIndex) {
        return subjectIndex >= 0 && subjectIndex < grades.length && termIndex >=0 && termIndex < grades[0].length;
    }
    
    public String updateGrade(int subjectIndex, int termIndex, int grade) {
        if(getGrade(subjectIndex, termIndex) != -1) {
            setGrade(subjectIndex, termIndex, grade);
            return "Grade updated.";
        } else {
            return "Grade not found.";
        }
    }
    
    public void displayGrades() {
        System.out.println("Grades for: " + getName());
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Subject (" + (i+1) + "): ");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print(grades[i][j] + " ");
            }
            System.out.println();
        }
    }
}
