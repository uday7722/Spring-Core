package com.spring.studentcourse;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entity.Course;
import com.spring.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
    	Student student1 = applicationContext.getBean(Student.class);
    	student1.setStudentId(101);
    	student1.setStudentName("Uday");
    	student1.setStudentEmail("u@gmail.com");
    	student1.setStudentAge(12);
    	
    	Student student2 = applicationContext.getBean(Student.class);
    	student2.setStudentId(102);
    	student2.setStudentName("Sai");
    	student2.setStudentEmail("s@gmail.com");
    	student2.setStudentAge(16);
    	
    	Student student3 = applicationContext.getBean(Student.class);
    	student3.setStudentId(103);
    	student3.setStudentName("Vinod");
    	student3.setStudentEmail("v@gmail.com");
    	student3.setStudentAge(19);
    	
    	Student student4 = applicationContext.getBean(Student.class);
    	student4.setStudentId(104);
    	student4.setStudentName("Hippo");
    	student4.setStudentEmail("h@gmail.com");
    	student4.setStudentAge(10);
    	
    	
    	Course course1=applicationContext.getBean(Course.class);
    	course1.setCourseId(1);
    	course1.setCourseName("Java");
    	course1.setCourseDuration("7Months");
    	course1.setCoursePrice(39000);
    	
    	Course course2=applicationContext.getBean(Course.class);
    	course2.setCourseId(2);
    	course2.setCourseName("Mern");
    	course2.setCourseDuration("7Months");
    	course2.setCoursePrice(39000);
    	
    	
    	Course course3=applicationContext.getBean(Course.class);
    	course3.setCourseId(3);
    	course3.setCourseName("Sap");
    	course3.setCourseDuration("3Months");
    	course3.setCoursePrice(3000);
    	
    	
    	Course course4=applicationContext.getBean(Course.class);
    	course4.setCourseId(4);
    	course4.setCourseName("Python");
    	course4.setCourseDuration("5Months");
    	course4.setCoursePrice(9000);
    	
    	List<Student> students=new ArrayList<Student>();
    	students.add(student1);
    	students.add(student2);
    	students.add(student3);
    	students.add(student4);
    	
    	List<Course> courses=new ArrayList<Course>();
    	courses.add(course1);
    	courses.add(course2);
    	courses.add(course3);
    	courses.add(course4);
    	
    	course1.setStudents(students);
    	course2.setStudents(students);
    	course3.setStudents(students);
    	course4.setStudents(students);
    	
    	student1.setCourses(courses);
    	student2.setCourses(courses);
    	student3.setCourses(courses);
    	student4.setCourses(courses);

    	
//    	course1.getStudents().add(student1);
//    	course1.getStudents().add(student2);
////    	
//    	course2.getStudents().add(student4);
//    	course2.getStudents().add(student3);
////    	
//    	course3.getStudents().add(student1);
//    	course3.getStudents().add(student2);
////    	
//    	course4.getStudents().add(student3);
//    	course4.getStudents().add(student4);
////    
//    	
//    	
//    	student1.getCourses().add(course1);
//    	student1.getCourses().add(course2);
////    	
//    	student2.getCourses().add(course3);
//    	student2.getCourses().add(course4);
////    	
//    	student3.getCourses().add(course1);
//    	student3.getCourses().add(course2);
////    	
//    	student4.getCourses().add(course3);
//    	student4.getCourses().add(course4);

    	
    	
    	
    	Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
    	SessionFactory factory=configuration.buildSessionFactory();
    	Session session=factory.openSession();
    	Transaction transaction=session.beginTransaction();
    	
    	session.save(course1);
		session.save(course2);
		session.save(course3);
		session.save(course4);

		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);

	

    	
    	
    	transaction.commit();
    	session.close();
    	
    	
    	
    	
    }
}
