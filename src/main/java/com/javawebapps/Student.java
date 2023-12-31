package com.javawebapps;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private int marks;

    public Student(String studentId, String studentName, int marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public double getPassPercentage(List<Student> students) {
        int passedStudents = 0;
        for (Student student : students) {
            if (student.getMarks() >= 40) {
                passedStudents++;
            }
        }
        // Hitung persentase kelulusan
        if (students.size() > 0) {
            return ((double) passedStudents / students.size()) * 100.00;
        } else {
            return 0.00;
        }
    }

    public boolean isPassed() {
        return marks >= 40;
    }
}
