package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class StudentGradeManagement {
    private final List<Student> students;

    public StudentGradeManagement() {
        this.students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public boolean removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        return true;
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    //update student all info

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Average Grade: " + student.calculateAverageGrade());
        }
    }
}
