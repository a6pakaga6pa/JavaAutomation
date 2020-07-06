package javaCollections.optionalTasks;

//6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.

import java.util.Collections;
import java.util.List;

public class SortArrayBySort {
    private static String textToReadPath = "src/main/resources/songRead.txt";

    public static void main(String[] args) {
        List<String> poem = ListReverseOrder.readFromFile(textToReadPath);
        Collections.sort(poem);
        poem.forEach(System.out::println);
    }
}
