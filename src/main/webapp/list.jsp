<%--
  Created by IntelliJ IDEA.
  User: bhuvanesh1990
  Date: 20/07/26
  Time: 8:54 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>

<!DOCTYPE html>

<html>

<head>

  <title>Student List</title>

  <style>

    table{

      border-collapse: collapse;

      width:100%;

    }

    th,td{

      border:1px solid #ddd;

      padding:10px;

    }

    th{

      background:#eeeeee;

    }

  </style>

</head>

<body>

<h2>Student List</h2>

<a href="add.jsp">

  Add Student

</a>

<br><br>

<table>

  <tr>

    <th>ID</th>

    <th>Name</th>

    <th>Email</th>

    <th>Course</th>

    <th>Action</th>

  </tr>

  <%

    List<Student> students =
            (List<Student>)request.getAttribute("students");

    if(students!=null){

      for(Student student : students){

  %>

  <tr>

    <td><%=student.getId()%></td>

    <td><%=student.getName()%></td>

    <td><%=student.getEmail()%></td>

    <td><%=student.getCourse()%></td>

    <td>

      <a href="edit?id=<%= student.getId() %>">Edit</a>

      |

      <a href="delete?id=<%= student.getId() %>"  onclick="return confirm('Are you sure?')">Delete</a>

    </td>

  </tr>

  <%

      }

    }

  %>

</table>

</body>

</html>
