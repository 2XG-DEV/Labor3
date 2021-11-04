package classes;

import classes.repos.CourseRepository;
import classes.repos.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {

    public static RegistrationSystem instance = null;

    private RegistrationSystem(){

    }

    public static RegistrationSystem getInstance(){
        if(instance == null)
            instance = new RegistrationSystem();
        return instance;
    }

    public boolean register(Course course,Student student){
        for(Student s : course.getStudentsEnrolled()) { // check if student already enrolled
            if (s == student) {
                return false;
            }
        }
        if(student.getTotalCredits() + course.getCredits() > 30){
            return false;
        }else if(course.getStudentsEnrolled().size() >= course.getMaxEnrollment()){
            return false;

        }
        course.getStudentsEnrolled().add(student);
        student.setTotalCredits(student.getTotalCredits()+course.getCredits());
        return true;
    }

    public List<Course> retrieveCoursesWithFreePlaces(){
        ArrayList<Course> coursesWithFreePlaces = new ArrayList<Course>();
        for(Course c : CourseRepository.getInstance().getAll()){
            if(c.getStudentsEnrolled().size() < c.getMaxEnrollment()){
                coursesWithFreePlaces.add(c);
            }
        }
        return coursesWithFreePlaces;
    }

    public List<Student> retrieveStudentsEnrolledForACourse(Course c){
        return c.getStudentsEnrolled();
    }

    public List<Course> getAllCourses(){
        return CourseRepository.getInstance().getAll();
    }

    public void changeCourseCredits(Course course , int newCredits){
        for(Course c : CourseRepository.getInstance().getAll()){
            if(course == c){
                course.setCredits(newCredits);
            }
        }
    }

    public  void removeCourse(Course c){
        CourseRepository.getInstance().delete(c);
    }

}
