<%@ page import="com.javawebapps.Department" %>
<%@ page import="com.javawebapps.Student" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome Page</h1>

<table border="1">
    <tr>
        <th>Department</th>
        <th>Student ID</th>
        <th>Marks</th>
        <th>Pass %</th>
    </tr>
    <%
        List<Department> departmentList = (List<Department>) request.getSession().getAttribute("departmentList");
        for (Department department : departmentList) {
            List<Student> students = department.getStudents();
            for (Student student : students) {
                String passPercentage = String.format("%.2f%%", student.getPassPercentage(department.getStudents()));
    %>
    <tr>
        <td><%= department.getDepartmentName() %></td>
        <td><%= student.getStudentId() %></td>
        <td><%= student.getMarks() %></td>
        <td><%= passPercentage %></td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="login.jsp">Kembali ke Halaman Login</a>

</body>
</html>
