package org.hw27.dao;

import org.hibernate.Session;
import org.hw27.HibernateSession;
import org.hw27.entity.Student;

import java.util.List;

public class StudentDao {
    public void addStudent(Student student){
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteStudent(Student student){
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

    public void updateStudent(Student student){
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    public Student getStudentById(int id){
        Session session = HibernateSession.getSessionFactory().openSession();
        Student student = (Student) session.get(Student.class, id);
        session.close();
        return student;
    }

    public List<Student> findAll(){
        Session session = HibernateSession.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student").list();
        session.close();
        return students;
    }
}
