package javaExceptions;

public class Subject {
    private String subjectName;

    public Subject(){}

    public Subject(String name){
        this.subjectName = name;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                '}';
    }
}
