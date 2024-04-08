package org.hw27;

import org.hibernate.Session;
import org.hw27.dao.StudentDao;
import org.hw27.entity.Student;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        StudentDao studentDAO = new StudentDao();

        Student student1 = new Student("Zack", "zack@example.com");
        Student student2 = new Student("John", "john@example.com");
        Student student3 = new Student("Jack", "jack@example.com");

        //add new students
        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);
        studentDAO.addStudent(student3);

        //get all students
        System.out.println("Students: ");
        List<Student> students = studentDAO.findAll();
        students.forEach(System.out::println);

        //delete student
        Student student = studentDAO.getStudentById(1);
        studentDAO.deleteStudent(student);

        System.out.println("Student after deleting student1:");
        students = studentDAO.findAll();
        students.forEach(System.out::println);

        //update student`s data/get student by id
        System.out.println("Updating email of student2");
        Student studentNewEmail = studentDAO.getStudentById(2);
        studentNewEmail.setStudentEmail("newemail@example.com");
        studentDAO.updateStudent(studentNewEmail);
        student = studentDAO.getStudentById(2);
        System.out.println(student);

    }
}
