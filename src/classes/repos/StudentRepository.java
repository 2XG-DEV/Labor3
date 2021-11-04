package classes.repos;

import classes.Student;

public class StudentRepository extends InMemoryRepository<Student>{

    private static StudentRepository instance = null;

    private StudentRepository(){
        super();
    }

    public static StudentRepository getInstance(){
        if(instance == null)
            instance = new StudentRepository();
        return instance;
    }

    @Override
    public Student update(Student obj){
        Student studentToUpdate = this.repoList.stream().filter(student -> student.getStudentId()== obj.getStudentId()).findFirst().orElseThrow();
        studentToUpdate.setFirstName(obj.getFirstName());
        studentToUpdate.setLastName(obj.getLastName());
        studentToUpdate.setStudentId(obj.getStudentId());
        studentToUpdate.setTotalCredits(obj.getTotalCredits());
        studentToUpdate.setEnrolledCourses(obj.getEnrolledCourses());
        return studentToUpdate;
    }
}
