package com.mycompany.studentmanagementsystem;

import java.util.Scanner;

public class StudentManagementSystem {

    final private static Student[] students = new Student[100];
    private static int studentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int subjectCount = 3;
        final int termCount = 2;

        System.out.println("Student Management System - 2025");

        boolean keepLooping = true;

        while (keepLooping) {
            System.out.print("Enter an option:\n1) Capture new student grades\n2) Update student grades\n3) Retrieve student grades\n4) Print students report\n5) Exit program\n");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
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

                    if (studentIndex < students.length) {
                        students[studentIndex++] = student;
                        System.out.println("Student grades captured.");
                    } else {
                        System.out.println("Student limit reached.");
                    }
                }

                case 2 -> {
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    for (int i = 0; i < studentIndex; i++) {
                        if (students[i] != null && students[i].getName().equals(name)) {
                            while (true) {
                                System.out.println("Enter the subject: ");
                                int subject = Integer.parseInt(scanner.nextLine());
                                System.out.println("Enter the term: ");
                                int term = Integer.parseInt(scanner.nextLine());
                                
                                if (term < 1 || term >  termCount || subject > subjectCount || subjectCount < 1) {
                                    System.out.println("Invalid subject/term count.");
                                } else {
                                    System.out.println("Enter grade: ");
                                    int grade = Integer.parseInt(scanner.nextLine());
                                    students[i].updateGrade(subject, term, grade);
                                    break;
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    for (int i = 0; i < studentIndex; i++) {
                        if (students[i] != null && students[i].getName().equals(name)) {
                            students[i].displayGrades();
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Student Reports: ");
                    for (Student student : students) {
                        if (student != null) {
                            student.displayGrades();
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Exiting application...");
                    keepLooping = false;
                }
                default -> {
                    System.out.println("Invalid option. Choose 1, 2, 3, 4, 5.");
                }
            }
        }
    }
}
