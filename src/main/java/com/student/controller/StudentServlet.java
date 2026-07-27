package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student();

        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        boolean inserted = dao.insertStudent(student);

        if (inserted) {

            response.sendRedirect("index.jsp");

        } else {

            response.getWriter().println("Student insertion failed.");

        }
    }
//
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("StudentServlet doGet() called");

        List<Student> students = dao.getAllStudents();

        System.out.println("Retrieved " + students.size() + " students from the database.");

        request.setAttribute("students", students);

        request.getRequestDispatcher("/list.jsp")
                .forward(request, response);

//        System.out.println("Step 1: Browser sent a GET request.");
//
//        response.setContentType("text/plain");
//
//        response.getWriter().println("Hello from StudentServlet");
    }

}