package org.example;


import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.example.Entities.Courses;
import org.example.Entities.Department;
import org.example.Entities.Student;
import org.example.Entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Configuration configuration = new Configuration();
        configuration.configure("Hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try{

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
//            Root<Student> rootStudent = criteriaQuery.from(Student.class);
//            criteriaQuery.select(rootStudent);
//
//            Query query = session.createQuery(criteriaQuery);
//            Student student = (Student)query.getSingleResult();
            Department department = Department.builder().departmentName("HR").createdOn(new Date()).build();
            Integer departmentId = (Integer) session.save(department);
            department.setId(departmentId);

            Student student = Student.builder().department(department).name("Kamal").fatherName("Dileep Kumar").dateOfBirth("14-02-2000").build();
            Integer studentId = (Integer) session.save(student);
            student.setId(studentId);

            Teacher teacher = Teacher.builder().department(department).designation("Assistant Professor").name("Dr Fahad").build();
            Integer teacherId = (Integer) session.save(teacher);
            teacher.setId(teacherId);

            List<Courses> allCourses = new ArrayList<>();
            List<String> courseCodesNames = Arrays.asList(new String[]{"DataStructure","CS150","Algorithm","CS162","Data Science","CS170"});
            for(int i=0; i<courseCodesNames.size(); i+=2){
                Courses course = Courses.builder()
                        .courseName(courseCodesNames.get(i))
                        .courseCode(courseCodesNames.get(i+1))
                        .build();
                Integer courseId = (Integer) session.save(course);
                course.setId(courseId);
                allCourses.add(course);
            }

            student.setCourses(allCourses);
            session.save(student);
            teacher.setCourses(allCourses);
            session.save(teacher);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}