package javaCollections.optionalTasks;

//8. Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SameWords {
    private static String textToReadPath = "src/main/resources/songRead.txt";

    public static void main(String[] args) {
        List<String> poem = ListReverseOrder.readFromFile(textToReadPath);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < poem.size(); i++) {
            String[] wordsInLine = poem.get(i).toLowerCase().split(" ");
            set.addAll(Arrays.asList(wordsInLine));
        }
        set.forEach(System.out::println);
    }

}
