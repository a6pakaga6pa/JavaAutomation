package javaFundamentals.optionalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//2.     Вывести числа в порядке возрастания (убывания) значений их длины.

public class SortNumberLength {
    public static void main(String[] args) throws IOException {
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
            } catch (NumberFormatException e) {
                System.out.println("Only numbers are possible to enter!");
            }
        }

        straightOrder(list);
        reverseOrder(list);

    }

    public static void straightOrder(List<Integer> list) {
        int count = 0;
        boolean allNumbersChecked = false;
        System.out.println("Straight order of numbers by size:");
        while(!allNumbersChecked) {
            for (int i = 1; i < String.valueOf(Integer.MAX_VALUE).length(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    int numberInt = list.get(j);
                    int absValue = Math.abs(numberInt);
                    int length = String.valueOf(absValue).length();
                    if (length == i) {
                        System.out.println(list.get(j));
                        count++;
                        if(count == list.size()) {
                            allNumbersChecked = true;
                        }
                    }
                }
            }
        }
    }

    public static void reverseOrder(List<Integer> list) {
        int count = 0;
        boolean allNumbersChecked = false;
        System.out.println("Reverse order of numbers by size:");
        while(!allNumbersChecked) {
            for (int i = String.valueOf(Integer.MAX_VALUE).length(); i > 0 ; i--) {
                for (int j = 0; j < list.size(); j++) {
                    int numberInt = list.get(j);
                    int absValue = Math.abs(numberInt);
                    int length = String.valueOf(absValue).length();
                    if (length == i) {
                        System.out.println(list.get(j));
                        count++;
                        if(count == list.size()) {
                            allNumbersChecked = true;
                        }
                    }
                }
            }
        }
    }

}
