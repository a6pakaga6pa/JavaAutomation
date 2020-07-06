package javaCollections.optionalTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class ListReverseOrder {

    private static String textToReadPath = "src/main/resources/songRead.txt";
    private static String textToWritePath = "src/main/resources/songWrite.txt";

    //1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

    public static void main(String[] args) throws IOException {
        List<String> lines = readFromFile(textToReadPath);
        writeInReverseOrder(lines, textToWritePath);
    }

    public static List<String> readFromFile(String filePath) {
        List<String> linesFromFile = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while(reader.ready()) {
                linesFromFile.add(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }

    public static void writeInReverseOrder(List<String> list, String filePath){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Collections.reverse(list);
            for (String line : list) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
