package javaExceptions;

import com.google.gson.Gson;
import javaExceptions.exceptions.FacultyHasNoGroupException;
import javaExceptions.exceptions.StudentHasNoSubjectException;
import javaExceptions.exceptions.UniversityHasNoFacultiesException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private List<Faculty> faculties = new ArrayList<>();
    private static String jsonFilePath = "src/main/resources/university.json";

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public University() {
    }

    public double averageMarkForUniversity(String subjectName) throws StudentHasNoSubjectException {
        int count = 0;
        double totalMark = 0.0;
        try {
            for(Faculty currentFaculty: getFaculties()){
                List<Group> groups = null;
                try {
                    groups = currentFaculty.getGroups();
                } catch (FacultyHasNoGroupException e) {
                    e.printStackTrace();
                }
                for(Group currentGroup: groups){
                    double currentMark = currentFaculty.calculateAverageSubjectGroupFaculty(currentFaculty,currentGroup,subjectName);
                    if(currentMark != 0) {
                        totalMark+=currentMark;
                        count++;
                    }
                }
            }
        } catch (UniversityHasNoFacultiesException e) {
            e.printStackTrace();
        }
        return totalMark / count;
    }

    public static University loadListFromJson() {
        String jsonString = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            while(bufferedReader.ready()) {
                jsonString += bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Json file is not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonString, University.class);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() throws UniversityHasNoFacultiesException {
        if(faculties.isEmpty()){
            throw new UniversityHasNoFacultiesException("University should have at least 1 faculty!");
        }
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
