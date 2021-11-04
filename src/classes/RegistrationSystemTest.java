package classes;

import classes.repos.CourseRepository;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {

    @Test
    void register() {
        Teacher Modoi = new Teacher("Gheorghe","Modoi");
        Course Algebra = new Course("Algebra",Modoi,5,6);
        Student Radu = new Student("Radu","Tarean",234);
        RegistrationSystem.getInstance().register(Algebra,Radu);

        assertEquals(Radu.enrolledCourses.size(),1);
        assertEquals(Algebra.getStudentsEnrolled().size(),1);
    }

    @org.junit.jupiter.api.Test
    void retrieveCoursesWithFreePlaces() {
        Teacher Modoi = new Teacher("Gheorghe","Modoi");
        Course Algebra = new Course("Algebra",Modoi,2,6);
        Student Radu = new Student("Radu","Tarean",234);
        Student Maria = new Student("Maria","Popescu",235);

        Teacher Ion = new Teacher("ion","popescu");
        Course OOP = new Course("OOP",Ion,2,6);

        RegistrationSystem.getInstance().register(Algebra,Radu);
        RegistrationSystem.getInstance().register(Algebra,Maria);

        RegistrationSystem.getInstance().register(OOP,Radu);
        assertEquals(RegistrationSystem.getInstance().retrieveCoursesWithFreePlaces().size(),1);
    }

    @org.junit.jupiter.api.Test
    void retrieveStudentsEnrolledForACourse() {
        Teacher Modoi = new Teacher("Gheorghe","Modoi");
        Course Algebra = new Course("Algebra",Modoi,2,6);
        Student Radu = new Student("Radu","Tarean",234);
        Student Maria = new Student("Maria","Popescu",235);

        Teacher Ion = new Teacher("ion","popescu");
        Course OOP = new Course("OOP",Ion,2,6);

        RegistrationSystem.getInstance().register(Algebra,Radu);
        RegistrationSystem.getInstance().register(Algebra,Maria);

        RegistrationSystem.getInstance().register(OOP,Radu);
        assertEquals(RegistrationSystem.getInstance().retrieveStudentsEnrolledForACourse(Algebra).size(),2);
    }

    @org.junit.jupiter.api.Test
    void getAllCourses() {
        Teacher Modoi = new Teacher("Gheorghe","Modoi");
        Course Algebra = new Course("Algebra",Modoi,2,6);
        Student Radu = new Student("Radu","Tarean",234);
        Student Maria = new Student("Maria","Popescu",235);

        Teacher Ion = new Teacher("ion","popescu");
        Course OOP = new Course("OOP",Ion,2,6);

        RegistrationSystem.getInstance().register(Algebra,Radu);
        RegistrationSystem.getInstance().register(Algebra,Maria);

        RegistrationSystem.getInstance().register(OOP,Radu);
        assertEquals(RegistrationSystem.getInstance().getAllCourses().size(),2);
    }

    @org.junit.jupiter.api.Test
    void changeCourseCredits() {
        Teacher Modoi = new Teacher("Gheorghe","Modoi");
        Course Algebra = new Course("Algebra",Modoi,2,6);
        Student Radu = new Student("Radu","Tarean",234);
        Student Maria = new Student("Maria","Popescu",235);

        Teacher Ion = new Teacher("ion","popescu");
        Course OOP = new Course("OOP",Ion,2,6);

        RegistrationSystem.getInstance().register(Algebra,Radu);
        RegistrationSystem.getInstance().register(Algebra,Maria);

        RegistrationSystem.getInstance().register(OOP,Radu);
        assertEquals(Radu.getTotalCredits(),12);
        Algebra.setCredits(8);
        assertEquals(Radu.getTotalCredits(),14);
    }

    @org.junit.jupiter.api.Test
    void removeCourse() {
        Teacher Modoi = new Teacher("Gheorghe","Modoi");
        Course Algebra = new Course("Algebra",Modoi,2,6);
        Student Radu = new Student("Radu","Tarean",234);
        Student Maria = new Student("Maria","Popescu",235);

        Teacher Ion = new Teacher("ion","popescu");
        Course OOP = new Course("OOP",Ion,2,6);

        RegistrationSystem.getInstance().register(Algebra,Radu);
        RegistrationSystem.getInstance().register(Algebra,Maria);
        CourseRepository.getInstance().create(Algebra);
        CourseRepository.getInstance().create(OOP);

        RegistrationSystem.getInstance().register(OOP,Radu);
       RegistrationSystem.getInstance().removeCourse(Algebra);
        assertEquals(Radu.getTotalCredits(),6);
    }
}