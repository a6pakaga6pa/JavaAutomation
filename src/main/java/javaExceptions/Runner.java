package javaExceptions;


import com.google.gson.Gson;
import javaExceptions.exceptions.MarkOutOfBoundsException;
import javaExceptions.exceptions.StudentHasNoSubjectException;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws MarkOutOfBoundsException, StudentHasNoSubjectException {
        //Creating University data

        University kpi = new University();
        kpi.setName("KPI");
        Faculty electronics = new Faculty(Faculty.FacultyName.ELECTRONICS, "Physics", "Acoustics", "Radiotechnics", "Microelectronics");
        Faculty informatics = new Faculty(Faculty.FacultyName.INFORMATICS, "Java", "Assembler", "JavaScript", "HTML");
        Faculty chemistry = new Faculty(Faculty.FacultyName.CHEMISTRY, "Organics", "Not organics", "Biochemistry", "Reactions");
        Faculty economics = new Faculty(Faculty.FacultyName.ECONOMICS, "Microeconomics", "Macroeconomics", "Public relations", "Money theory");
        List<Faculty> faculties = Arrays.asList(electronics,informatics,chemistry,economics);
        kpi.setFaculties(faculties);

        Student student1 = new Student("Charlton Peck");
        student1.chooseSubjectsAndMarks("Physics", 9);
        student1.chooseSubjectsAndMarks("Acoustics", 8);
        Student student2 = new Student("Codie Marks");
        student2.chooseSubjectsAndMarks("Radiotechnics", 10);
        student2.chooseSubjectsAndMarks("Microelectronics", 10);
        Student student3 = new Student("Emilis Leonard");
        student3.chooseSubjectsAndMarks("Physics", 7);
        student3.chooseSubjectsAndMarks("Microelectronics", 9);
        Student student4 = new Student("Natasha Naylor");
        student4.chooseSubjectsAndMarks("Acoustics", 9);
        student4.chooseSubjectsAndMarks("Radiotechnics", 5);
        Student student5 = new Student("Sheena Goulding");
        student5.chooseSubjectsAndMarks("Java", 10);
        student5.chooseSubjectsAndMarks("Assembler", 6);
        Student student6 = new Student("Aniqa Serrano");
        student6.chooseSubjectsAndMarks("JavaScript", 8);
        student6.chooseSubjectsAndMarks("HTML", 7);
        Student student7 = new Student("Nikki Bannister");
        student7.chooseSubjectsAndMarks("Java", 5);
        student7.chooseSubjectsAndMarks("HTML", 10);
        Student student8 = new Student("Mercedes Robin");
        student8.chooseSubjectsAndMarks("Assembler", 9);
        student8.chooseSubjectsAndMarks("Java", 8);
        Student student9 = new Student("Nabeel Robinson");
        student9.chooseSubjectsAndMarks("Organics", 10);
        student9.chooseSubjectsAndMarks("Not organics", 9);
        Student student10 = new Student("Archie Iles");
        student10.chooseSubjectsAndMarks("Biochemistry", 8);
        student10.chooseSubjectsAndMarks("Reactions", 9);
        Student student11 = new Student("Catrin Mcleod");
        student11.chooseSubjectsAndMarks("Organics", 7);
        student11.chooseSubjectsAndMarks("Biochemistry", 8);
        Student student12 = new Student("Subhan Mosley");
        student12.chooseSubjectsAndMarks("Not organics", 6);
        student12.chooseSubjectsAndMarks("Reactions", 10);
        Student student13 = new Student("Kohen Morris");
        student13.chooseSubjectsAndMarks("Microeconomics", 8);
        student13.chooseSubjectsAndMarks("Macroeconomics", 8);
        Student student14 = new Student("Steve Thorne");
        student14.chooseSubjectsAndMarks("Public relations", 10);
        student14.chooseSubjectsAndMarks("Money theory", 9);
        Student student15 = new Student("Makenzie Barrett");
        student15.chooseSubjectsAndMarks("Money theory", 6);
        student15.chooseSubjectsAndMarks("Microeconomics", 4);
        Student student16 = new Student("Dulcie Powers");
        student16.chooseSubjectsAndMarks("Public relations", 8);
        student16.chooseSubjectsAndMarks("Macroeconomics", 6);

        Group el11 = new Group("EL-11");
        el11.setStudentList(Arrays.asList(student1,student2));
        Group el12 = new Group("EL-12");
        el12.setStudentList(Arrays.asList(student3,student4));
        Group in31 = new Group("IN-31");
        in31.setStudentList(Arrays.asList(student5,student6));
        Group in32 = new Group("IN-32");
        in32.setStudentList(Arrays.asList(student7,student8));
        Group ch61 = new Group("CH-61");
        ch61.setStudentList(Arrays.asList(student9,student10));
        Group ch62 = new Group("CH-62");
        ch62.setStudentList(Arrays.asList(student11,student12));
        Group ec01 = new Group("EC-01");
        ec01.setStudentList(Arrays.asList(student13,student14));
        Group ec02 = new Group("EC-02");
        ec02.setStudentList(Arrays.asList(student15,student16));

        electronics.setGroups(Arrays.asList(el11,el12));
        informatics.setGroups(Arrays.asList(in31,in32));
        chemistry.setGroups(Arrays.asList(ch61,ch62));
        economics.setGroups(Arrays.asList(ec01,ec02));

        System.out.println("Average mark for student " + student1.getFullName() + " is " + student1.calculateAverageMark(student1));
        double mark = electronics.calculateAverageSubjectGroupFaculty(informatics, in32, "Java");
        System.out.println("Average mark for \"Java\" subject at " + informatics.getName() + " faculty for group "
                + in32.getName() + " is " + mark);
        System.out.println("Average mark for " + kpi.getName() + " university at \"Acoustics\" is "
                + kpi.averageMarkForUniversity("Acoustics"));


       /* Gson gson = new Gson();
        System.out.println(gson.toJson(kpi));
        University jsonUniversity = University.loadListFromJson();
        System.out.println(jsonUniversity);*/

    }
}
