package javaFundamentals.optionalTasks;

// 4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MinimumDifferentFigures {
    public static void main(String[] args) {
        int number = minumumDifferentFigures(enterNumbers());
        System.out.println("Number with minimum different numbers is " + number);
    }

    public static List<Integer> enterNumbers() {
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
        return list;
    }

    public static int minumumDifferentFigures(List<Integer> list) {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String number = String.valueOf(list.get(i));
            List<Character> figures = number.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            Set<Character> set  = new HashSet<>(figures);
            if (set.size() == 1) {
                return Integer.parseInt(number);
            } else sizes.add(set.size());
        }
        int min = Collections.min(sizes);
        return list.get(sizes.indexOf(min));
    }
}
