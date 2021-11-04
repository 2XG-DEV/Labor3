package classes;

import classes.repos.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class Course {


    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;

    public Course(String name, Person teacher, int maxEnrollment, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.credits = credits;
        studentsEnrolled = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        int diff = credits - this.credits;
        for( Student s : getStudentsEnrolled()){
            s.setTotalCredits(s.getTotalCredits()+diff);
        }
        this.credits = credits;
    }

    @Override
    public String toString(){
        return this.getName()+ " anleitet bei: " + this.getTeacher().getFirstName() + " " + this.getTeacher().getLastName() + " mit " + this.getCredits() + " credite " + this.getStudentsEnrolled().size() + "/" + this.getMaxEnrollment();

    }
}
