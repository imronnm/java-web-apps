package com.javawebapps;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Student> students;
    private int totalPassedStudents;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.students = new ArrayList<>();
        this.totalPassedStudents = 0; // Inisialisasi jumlah siswa yang lulus
    }

    public void addStudent(Student student) {
        students.add(student);
        // Perbarui jumlah siswa yang lulus jika nilai siswa memenuhi syarat
        if (student.isPassed()) {
            totalPassedStudents++;
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getTotalPassedStudents() {
        return totalPassedStudents;
    }

    public void setTotalPassedStudents(int totalPassedStudents) {
        this.totalPassedStudents = totalPassedStudents;
    }

    public double getPassPercentage() {
        // Hitung persentase kelulusan berdasarkan jumlah siswa yang lulus
        if (students.size() > 0) {
            return ((double) totalPassedStudents / students.size()) * 100;
        } else {
            return 0.0;
        }
    }
}

