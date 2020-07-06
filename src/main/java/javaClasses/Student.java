package javaClasses;

//1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
//
//Создать массив объектов. Вывести:
//
//a) список студентов заданного факультета;
//
//b) списки студентов для каждого факультета и курса;
//
//c) список студентов, родившихся после заданного года;
//
//d) список учебной группы.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String fathersName;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    public static void main(String[] args) {
        Student student1 = new Student(1, "Ivanov", "Oleg", "Ivanovich", LocalDate.of(1976,3,12),"address1", "0505444554","Electronics", 2, "DG11");
        Student student2 = new Student(2, "Petrov", "Ivan", "Ivanovich", LocalDate.of(1994,8,23),"address2", "0505444254","Electronics", 1, "DG21");
        Student student3 = new Student(3, "Sidorov", "Max", "Olegovich", LocalDate.of(1998,12,1),"address3", "0505447854","Informatics", 1, "DI21");
        Student student4 = new Student(4, "Semenov", "Niko", "Nokolaevich", LocalDate.of(1994,6,29),"address4", "0705447854","Informatics", 2, "DI21");
        Student student5 = new Student(5, "Certova", "Ivanna", "Nikolaevna", LocalDate.of(1995,2,5),"address5", "0705237854","Electronics", 2, "DG11");

        Student[] students = new Student[]{student1, student2, student3, student4, student5};

        student1.findFaculty(students, "Informatics");
        System.out.println();
        student1.listCourse(students);
        System.out.println();
        student1.listFaculty(students);
        System.out.println();
        student1.printBornAfterYear(students, 1994);

    }

    public void findFaculty(Student[] students, String faculty) {
        System.out.println("List of students for " + faculty + " :");
        for (int i = 0; i < students.length; i++) {
            if(students[i].getFaculty().equals(faculty)) {
                System.out.println(students[i]);
            }
        }
    }

    public void listFaculty(Student[] students) {
        Set<String> faculty = new TreeSet<>();
        for (Student student : students) {
            faculty.add(student.getFaculty());
        }
        List<String> list = new ArrayList<>(faculty);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List of students of " + list.get(i) + " faculty: ");
            for (int j = 0; j < students.length; j++) {
                String currentFaculty = students[j].getFaculty();
                if (currentFaculty.equals(list.get(i))) {
                    System.out.println("Faculty " + currentFaculty + ": " + students[j]);
                }
            }
        }
    }

    public void listCourse(Student[] students) {
        Set<Integer> course = new TreeSet<>();
        for (Student student : students) {
            course.add(student.getCourse());
        }
        List<Integer> list = new ArrayList<>(course);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List of students on " + list.get(i) + " course: ");
            for (int j = 0; j < students.length; j++) {
                int currentCourse = students[j].getCourse();
                if (currentCourse == list.get(i)) {
                    System.out.println(students[j]);
                }
            }
        }
    }

    public void printBornAfterYear(Student[] students, int year) {
        System.out.println("List of students, that were born after " + year + ": ");
        for (Student student : students) {
            LocalDate currentDOB = student.getBirthday();
            int studentYear = currentDOB.getYear();
            if (studentYear > year) {
                System.out.println(student);
            }
        }
    }

    public Student(int id, String surname, String name, String fathersName, LocalDate birthday,
                   String address, String phoneNumber, String faculty, int course, String group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fathersName = fathersName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course='" + course + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}

