package classes;


import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    List<Course> courses;

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        courses = new ArrayList<Course>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public  void setCourses(List<Course> newCourses){
        this.courses = newCourses;
    }

    @Override
    public String toString(){
        return "Prof. " + this.getFirstName() + " " + this.getLastName();
    }
}
