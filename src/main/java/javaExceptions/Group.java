package javaExceptions;

import javaExceptions.exceptions.GroupHasNoStudentsException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public Group(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = studentList;
    }

    public Group(String name){
        this.name = name;
    }

    public void addStudentsToGroup(Student students){
        studentList = new ArrayList<>();
         studentList.add(students);
    }

    public String getName() {
        return name;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() throws GroupHasNoStudentsException{
        if(studentList.isEmpty()) {
            throw new GroupHasNoStudentsException();
        }
        return studentList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
