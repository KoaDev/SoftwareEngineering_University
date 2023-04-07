package isp.lab6.exercise1;

import junit.framework.TestCase;

//add test junit
public class StudentGradeManagementTest {
    public static void main(String[] args) {
        // Test: Add a student
        StudentGradeManagement management = new StudentGradeManagement();
        Student student1 = new Student("Alice", 1);
        student1.addGrade("Math", 90);
        student1.addGrade("Science", 80);
        management.addStudent(student1);
        management.displayStudents();

        // Test: Update student information
        Student studentToUpdate = management.getStudent(1);
        studentToUpdate.setName("Alicia");
        studentToUpdate.addGrade("History", 75);
        management.displayStudents();

        // Test: Remove a student
        management.removeStudent(1);
        management.displayStudents();

        // Test: Calculate the average grade of a student
        Student student2 = new Student("Bob", 2);
        student2.addGrade("Math", 85);
        student2.addGrade("Science", 95);
        student2.addGrade("History", 80);
        management.addStudent(student2);
        System.out.println("Average Grade of Student 2: " + student2.calculateAverageGrade());
    }
}
