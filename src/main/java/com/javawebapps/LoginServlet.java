package com.javawebapps;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        if (USERNAME.equals(userId) && PASSWORD.equals(password)) {
            // Create a list of departments and add students to each department
            List<Department> departmentList = getHardcodedDepartmentData();
            request.getSession().setAttribute("departmentList", departmentList);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            response.sendRedirect("LoginPage.jsp?error=1");
        }
    }

    private List<Department> getHardcodedDepartmentData() {
        // Create and return a list of hardcoded department data with students
        List<Department> departmentList = new ArrayList<>();

        Department department1 = new Department("Dep 1");
        Department department2 = new Department("Dep 2");
        Department department3 = new Department("Dep 3");

        // Add students to each department
        department1.addStudent(new Student("S1",  "Dep 1", 35));
        department1.addStudent(new Student("S2", "Dep 1", 70));
        department1.addStudent(new Student("S3",  "Dep 1", 60));
        department1.addStudent(new Student("S4",  "Dep 1", 90));

        department2.addStudent(new Student("S5", "Dep 2", 30));

        department3.addStudent(new Student("S6",  "Dep 3", 32));
        department3.addStudent(new Student("S7",  "Dep 3", 70));
        department3.addStudent(new Student("S8",  "Dep 3", 20));

        // Add departments to the list
        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);

        return departmentList;
    }
}
