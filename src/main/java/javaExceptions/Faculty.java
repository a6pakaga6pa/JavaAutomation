package javaExceptions;


import javaExceptions.exceptions.FacultyHasNoGroupException;
import javaExceptions.exceptions.GroupHasNoStudentsException;
import javaExceptions.exceptions.StudentHasNoSubjectException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Faculty {
    private FacultyName name;
    private List<Subject> subjects;
    private List<Group> groups = new ArrayList<>();

    public enum FacultyName{
        ELECTRONICS, ECONOMICS, INFORMATICS, CHEMISTRY;
    }

    public Faculty(){}

    public Faculty(FacultyName name, String ...subjects) {
        this.name = name;
        List<Subject> list = new ArrayList<>();
        for (int i = 0; i < subjects.length; i++) {
            Subject subject = new Subject(subjects[i]);
            list.add(subject);
        }
        this.subjects = list;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public FacultyName getName() {
        return name;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() throws FacultyHasNoGroupException{
        if(groups.isEmpty()) {
            throw new FacultyHasNoGroupException("Faculty should have at least 1 group!");
        }
        return groups;
    }

    public double calculateAverageSubjectGroupFaculty(Faculty faculty, Group group, String subjectName) throws StudentHasNoSubjectException {
        List<Group> groupsList = null;
        try {
            groupsList = faculty.getGroups();
        } catch (FacultyHasNoGroupException e) {
            e.printStackTrace();
        }
        List<Student> students = new ArrayList<>();
        int count = 0;
        double markSum = 0.0;
        for (Group currentGroup: groupsList) {
            if(currentGroup.getName().equals(group.getName())) {
                try {
                    students = currentGroup.getStudentList();
                } catch (GroupHasNoStudentsException e) {
                    e.printStackTrace();
                }
            }
        }
        for(Student student: students) {
            Map<Subject, Integer> map = student.getStudentSubjectsWithMarks();
            for(Map.Entry<Subject, Integer> pair : map.entrySet()){
                String name = pair.getKey().getSubjectName();
                if(name.equals(subjectName)){
                    count++;
                    markSum += pair.getValue();
                }
            }
        }
        return count != 0? markSum / count : 0;

    }

    public static List<Faculty> initializeFaculties(){
        Faculty electronics = new Faculty(Faculty.FacultyName.ELECTRONICS, "Physics", "Acoustics", "Radiotechnics", "Microelectronics");
        Faculty informatics = new Faculty(Faculty.FacultyName.INFORMATICS, "Java", "Assembler", "JavaScript", "HTML");
        Faculty chemistry = new Faculty(Faculty.FacultyName.CHEMISTRY, "Organics", "Not organics", "Biochemistry", "Reactions");
        Faculty economics = new Faculty(Faculty.FacultyName.ECONOMICS, "Microeconomics", "Macroeconomics", "Public relations", "Money theory");
        return Arrays.asList(electronics,informatics,chemistry,economics);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + name +
                ", subjects=" + subjects +
                ", groups=" + groups +
                '}';
    }
}
