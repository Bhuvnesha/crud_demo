<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.model.Student" %>

<%
  Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>

<html>

<head>
  <title>Edit Student</title>
</head>

<body>

<h2>Edit Student</h2>

<form action="edit" method="post">

  <input type="hidden"
         name="id"
         value="<%= student.getId() %>">

  Name<br>

  <input type="text"
         name="name"
         value="<%= student.getName() %>">

  <br><br>

  Email<br>

  <input type="email"
         name="email"
         value="<%= student.getEmail() %>">

  <br><br>

  Course<br>

  <input type="text"
         name="course"
         value="<%= student.getCourse() %>">

  <br><br>

  <input type="submit" value="Update Student">

</form>

</body>

</html>