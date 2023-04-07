package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    private String name;
    private int id;
    private final HashMap<String, Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade(String subject) {
        return grades.get(subject);
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public void addGrade(String subject, int grade) {
        this.grades.put(subject, grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
