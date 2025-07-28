package com.mycompany.studentmanagementsystem;

import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[2];
        final int subjectCount = 3;
        final int termCount = 2;

        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter student ID: ");
            String id = scanner.nextLine();

            Student student = new Student(name, age, id, subjectCount, termCount);
            System.out.println("Enter student grades for " + subjectCount + " subjects, " + termCount + " terms: ");
            for (int subject = 0; subject < subjectCount; subject++) {
                for (int term = 0; term < termCount; term++) {
                    System.out.println("Grade for subject " + (subject + 1) + ", term " + (term + 1) + ":");
                    int grade = Integer.parseInt(scanner.nextLine());
                    student.setGrade(subject, term, grade);
                }
            }
            students[i] = student;
        }

        System.out.println("Student Reports: ");
        for (Student student: students) {
            student.displayGrades();
        }
        
        scanner.close();
    }
}
