package isp.lab6.exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        StudentGradeManagement management = new StudentGradeManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display Students");
            System.out.println("5. Calculate Average Grade");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    Student student = new Student(name, id);
                    management.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                }
                case 2: {
                    System.out.print("Enter student ID to update: ");
                    int id = scanner.nextInt();
                    Student student = management.getStudent(id);
                    if (student != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        student.setName(newName);
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter student ID to remove: ");
                    int id = scanner.nextInt();
                    management.removeStudent(id);
                    System.out.println("Student removed successfully.");
                    break;
                }
                case 4: {
                    System.out.println("Student List:");
                    management.displayStudents();
                    break;
                }
                case 5: {
                    System.out.print("Enter student ID to calculate average grade: ");
                    int id = scanner.nextInt();
                    Student student = management.getStudent(id);
                    if (student != null) {
                        System.out.println("Average Grade: " + student.calculateAverageGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        }
    }
}
