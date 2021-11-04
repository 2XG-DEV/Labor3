package classes.repos;

import classes.Teacher;

public class TeachersRepository extends InMemoryRepository<Teacher>{

    private static TeachersRepository instance = null;

    private TeachersRepository(){
        super();
    }

    public static TeachersRepository getInstance(){
        if(instance == null)
            instance = new TeachersRepository();
        return instance;
    }

    @Override
    public Teacher update(Teacher obj){
        Teacher teacherToUpdate = this.repoList.stream().filter(teacher -> teacher.getFirstName().equals(obj.getFirstName())&&teacher.getLastName().equals(obj.getLastName())).findFirst().orElseThrow();
        teacherToUpdate.setFirstName(obj.getFirstName());
        teacherToUpdate.setLastName(obj.getLastName());
        teacherToUpdate.setCourses(obj.getCourses());
        return teacherToUpdate;
    }

}
