package classes.repos;

import classes.Course;
import classes.Student;

import java.util.ArrayList;

public class CourseRepository extends InMemoryRepository<Course>{

    private static CourseRepository instance = null;

    private CourseRepository(){
        super();
    }

    public static CourseRepository getInstance(){
        if(instance == null){
            instance = new CourseRepository();
        }
        return instance;
    }

    @Override
    public Course update(Course obj){
        Course courseToUpdate = this.repoList.stream().filter(course -> course.getName()== obj.getName()&&course.getTeacher() == obj.getTeacher()).findFirst().orElseThrow();
        courseToUpdate.setCredits(obj.getCredits());
        courseToUpdate.setMaxEnrollment(obj.getMaxEnrollment());
        courseToUpdate.setName(obj.getName());
        courseToUpdate.setTeacher(obj.getTeacher());
        courseToUpdate.setStudentsEnrolled(obj.getStudentsEnrolled());
        return courseToUpdate;
    }

    @Override
    public void delete(Course obj) {
        for(Student s : obj.getStudentsEnrolled()){
            s.getEnrolledCourses().remove(obj);
            s.setTotalCredits(s.getTotalCredits()-obj.getCredits());
        }
        obj.setStudentsEnrolled(new ArrayList<Student>());
        this.repoList.remove(obj);
    }
}
