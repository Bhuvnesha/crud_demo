<%--
  Created by IntelliJ IDEA.
  User: bhuvanesh1990
  Date: 20/07/26
  Time: 7:42 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Add Student</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h2>Add Student</h2>

<form action="student" method="post">

    <label>Name</label><br>

    <input type="text"
           name="name"
           required>

    <br><br>

    <label>Email</label><br>

    <input type="email"
           name="email"
           required>

    <br><br>

    <label>Course</label><br>

    <input type="text"
           name="course"
           required>

    <br><br>

    <button type="submit">
        Save Student
    </button>

</form>

</body>

</html>

