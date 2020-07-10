package javaExceptions;

import javaExceptions.exceptions.MarkOutOfBoundsException;
import javaExceptions.exceptions.StudentHasNoSubjectException;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String fullName;
    private Map<Subject, Integer> studentSubjectsWithMarks = new HashMap<>();

    public Student(String fullName) {
        this.fullName = fullName;

    }

    public Student(){}

    public String getFullName() {
        return fullName;
    }

    public Map<Subject, Integer> getStudentSubjectsWithMarks() throws StudentHasNoSubjectException {
        if(studentSubjectsWithMarks.isEmpty()) {
            throw new StudentHasNoSubjectException();
        }
        return studentSubjectsWithMarks;
    }

    public void chooseSubjectsAndMarks(String subjectName, int mark) throws MarkOutOfBoundsException{
        if(mark < 0 || mark > 10) {
            throw new MarkOutOfBoundsException();
        }
        Subject subject = new Subject(subjectName);
        studentSubjectsWithMarks.put(subject, mark);
    }

    public double calculateAverageMark(Student student) throws StudentHasNoSubjectException {
        Map<Subject, Integer> map = student.getStudentSubjectsWithMarks();
        double markSum = 0;
        double count = 0.0;
        for(Map.Entry<Subject,Integer> pair : map.entrySet()){
            markSum += pair.getValue();
            count++;
        }
        return markSum / count;

    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", studentSubjectsWithMarks=" + studentSubjectsWithMarks +
                '}';
    }
}
