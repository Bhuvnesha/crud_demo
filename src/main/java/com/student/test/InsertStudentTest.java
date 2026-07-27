package com.student.test;
import com.student.dao.StudentDAO;
import com.student.model.Student;

import java.util.Scanner;

public class InsertStudentTest
{
    public static void main(String[] args) {
        while(true) {

            Student student = new Student();

            System.out.println("Enter student name : ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            student.setName(name);
            System.out.println("Enter student email : ");
            String email = scanner.nextLine();
            student.setEmail(email);
            System.out.println("Enter student course : ");
            String course = scanner.nextLine();
            student.setCourse(course);
            //        student.setName("Bhuvanesh");
            //        student.setEmail("bhuvanesh@example.com");
            //        student.setCourse("Java Full Stack");
            StudentDAO dao = new StudentDAO();
            boolean inserted = dao.insertStudent(student);

            if (inserted) {
                System.out.println("Student inserted successfully.");
            } else {
                System.out.println("Student insertion failed.");
            }
        }
    }
}