package com.mycompany.studentmanagementsystem;

import java.util.Scanner;

public class StudentManagementSystem {
    // pre-defined values
    final private static Student[] students = new Student[100];
    private static int studentIndex = 0;

    public static void main(String[] args) {
        // system set up
        Scanner scanner = new Scanner(System.in);
        final int subjectCount = 3;
        final int termCount = 2;

        System.out.println("Student Management System - 2025");

        boolean keepLooping = true;

        while (keepLooping) {
            // Ask student to choose option
            System.out.print("Enter an option:\n1) Capture new student grades\n2) Update student grades\n3) Retrieve student grades\n4) Print students report\n5) Exit program\n");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    // Retrieve student credentials
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter student ID:");
                    String id = scanner.nextLine();

                    Student student = new Student(name, age, id, subjectCount, termCount);

                    System.out.println("Enter grades for " + subjectCount + " subjects over " + termCount + " terms:");
                    // Loop through to get grades for term and subjects
                    for (int subject = 1; subject <= subjectCount; subject++) {
                        for (int term = 1; term <= termCount; term++) {
                            System.out.print("Grade for Subject " + subject + ", Term " + term + ": ");
                            int grade = Integer.parseInt(scanner.nextLine());
                            student.setGrade(subject, term, grade);
                        }
                    }
                    // Check if student capacity has been reached
                    if (studentIndex < students.length) {
                        students[studentIndex++] = student;
                        System.out.println("Student grades captured successfully.");
                    } else {
                        System.out.println("Maximum student capacity reached.");
                    }
                }

                case 2 -> {
                    // Get student name
                    System.out.println("Enter the name of the student: ");
                    String name = scanner.nextLine();
                    boolean found = false;
                    // Search for student
                    for (int i = 0; i < studentIndex; i++) {
                        if (students[i] != null && students[i].getName().equals(name)) {
                            found = true;
                            // Get required subject and term
                            System.out.print("Enter subject number (1 to " + subjectCount + "): ");
                            int subject = Integer.parseInt(scanner.nextLine());
                            System.out.print("Enter term number (1 to " + termCount + "): ");
                            int term = Integer.parseInt(scanner.nextLine());
                            // Validate inputs, then get grade and set new values
                            if (subject >= 1 && subject <= subjectCount && term >= 1 && term <= termCount) {
                                System.out.print("Enter new grade: ");
                                int grade = Integer.parseInt(scanner.nextLine());
                                System.out.println(students[i].updateGrade(subject, term, grade));
                            } else {
                                System.out.println("Invalid subject or term number.");
                            }
                            break;
                        }
                    }
                    // Check if student was found
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }
                case 3 -> {
                    // Get student name
                    System.out.println("Enter the name of the student:");
                    String name = scanner.nextLine();
                    boolean found = false;
                    // Search for student and display grades
                    for (int i = 0; i < studentIndex; i++) {
                        if (students[i] != null && students[i].getName().equalsIgnoreCase(name)) {
                            students[i].displayGrades();
                            found = true;
                            break;
                        }
                    }
                    // Check if student was found
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                    // Provide report of all student grades
                    System.out.println("Student Report:");
                    for (int i = 0; i < studentIndex; i++) {
                        if (students[i] != null) {
                            students[i].displayGrades();
                        }
                    }
                }
                case 5 -> {
                    // Exit application
                    System.out.println("Exiting application...");
                    keepLooping = false;
                }
                default -> {
                    // Look for valid input
                    System.out.println("Invalid option. Choose 1, 2, 3, 4, 5.");
                }
            }
        }
    }
}
