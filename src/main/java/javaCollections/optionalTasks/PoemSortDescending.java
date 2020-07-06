package javaCollections.optionalTasks;

//4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

import java.util.List;

public class PoemSortDescending {
    private static String textToReadPath = "src/main/resources/songRead.txt";

    public static void main(String[] args) {
        List<String> poem = ListReverseOrder.readFromFile(textToReadPath);
        poem.sort((x,y) -> x.length() - y.length());
        poem.forEach(System.out::println);
    }


}
