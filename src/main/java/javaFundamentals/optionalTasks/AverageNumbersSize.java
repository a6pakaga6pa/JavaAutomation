package javaFundamentals.optionalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

public class AverageNumbersSize {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter any numbers with Enter. When finished, just press Enter: ");
        while(true) {
            try {
                String number = reader.readLine();
                if (number == null || number.isEmpty()) {
                    break;
                }
                list.add(Integer.parseInt(number));
            } catch (NumberFormatException | IOException e) {
                System.out.println("Only numbers are possible to enter!");
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if(numberSize(number) > averageSize(list)) {
                System.out.println("Number " + number + " has " + numberSize(number) + " digits, that is bigger, than" +
                        " average " + averageSize(list));
            }
        }
    }

    public static double averageSize(List<Integer> list) {
        List<Integer> averageSizes = new ArrayList<>();
        for (int numberInt : list) {
            averageSizes.add(numberSize(numberInt));
        }
        return averageSizes.stream().mapToDouble(v -> v).average().orElse(0.0);
    }

    public static int numberSize(int number){
        int absValue = Math.abs(number);
        return String.valueOf(absValue).length();
    }
}
