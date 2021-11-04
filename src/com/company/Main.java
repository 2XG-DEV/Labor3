package com.company;

import classes.Course;
import classes.RegistrationSystem;
import classes.Student;
import classes.Teacher;
import classes.repos.CourseRepository;
import classes.repos.StudentRepository;
import classes.repos.TeachersRepository;

public class Main {

    public static void main(String[] args) {

        Student Radu = new Student("Tarean","Radu",3456);
        Student George = new Student("Popescu","George",3457);
        Student Marcel = new Student("Ionescu","Marcel",3458);
        Student Maria = new Student("Mihailescu","Maria",3459);
        Teacher Modoi = new Teacher("Gheorge","Modoi");
        Teacher Ion = new Teacher("Popescu","Ion");
        Teacher Mihai = new Teacher("Georgescu","Mihai");
        Course Algebra = new Course("Algebra fur informatiker",Modoi,2,6);
        Course OOP = new Course("Object Oriented Programming",Ion,3,6);
        Course DSA = new Course("DatenStrukturen und Algorithmen",Mihai,1,6);
        StudentRepository.getInstance().create(Radu);
        StudentRepository.getInstance().create(George);
        StudentRepository.getInstance().create(Marcel);
        StudentRepository.getInstance().create(Maria);
        TeachersRepository.getInstance().create(Modoi);
        TeachersRepository.getInstance().create(Ion);
        TeachersRepository.getInstance().create(Mihai);
        CourseRepository.getInstance().create(Algebra);
        CourseRepository.getInstance().create(OOP);
        CourseRepository.getInstance().create(DSA);
        RegistrationSystem.getInstance().register(Algebra,Radu);
        System.out.println("Radu credits " + Radu.getTotalCredits() );
        RegistrationSystem.getInstance().register(Algebra,Maria);
        for(Student s : RegistrationSystem.getInstance().retrieveStudentsEnrolledForACourse(Algebra)){
            System.out.println(s);
        }
        for(Course c : RegistrationSystem.getInstance().retrieveCoursesWithFreePlaces()){
            System.out.println(c);
        }
        for(Course c : RegistrationSystem.getInstance().getAllCourses()){
            System.out.println(c);
        }
        CourseRepository.getInstance().delete(Algebra);
        System.out.println("Radu credits " + Radu.getTotalCredits() );



    }
}
