package isp.lab6.exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentGradeManagementTest {
    private StudentGradeManagement management;

    @Before
    public void setUp() {
        management = new StudentGradeManagement();
    }

    @Test
    public void testAddStudent() {
        Student student1 = new Student("Alice", 1);
        student1.addGrade("Math", 90);
        student1.addGrade("Science", 80);

        boolean added = management.addStudent(student1);

        assertTrue(added);
        assertEquals(student1, management.getStudent(1));
    }

    @Test
    public void testUpdateStudent() {
        Student student1 = new Student("Alice", 1);
        student1.addGrade("Math", 90);
        student1.addGrade("Science", 80);
        management.addStudent(student1);

        Student studentToUpdate = management.getStudent(1);
        studentToUpdate.setName("Alicia");
        studentToUpdate.addGrade("History", 75);

        assertEquals("Alicia", studentToUpdate.getName());
        assertEquals(75, studentToUpdate.getGrade("History"));

        management.displayStudents();
    }

    @Test
    public void testRemoveStudent() {
        Student student1 = new Student("Alice", 1);
        student1.addGrade("Math", 90);
        student1.addGrade("Science", 80);
        management.addStudent(student1);

        boolean removed = management.removeStudent(1);
        assertTrue(removed);

        assertNull(management.getStudent(1));
    }

    @Test
    public void testCalculateAverageGrade() {
        Student student2 = new Student("Bob", 2);
        student2.addGrade("Math", 85);
        student2.addGrade("Science", 95);
        student2.addGrade("History", 80);
        management.addStudent(student2);

        double avgGrade = student2.calculateAverageGrade();

        assertEquals(86.67, avgGrade, 0.01);
    }
}
