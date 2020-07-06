package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;

//5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
// Осуществить проверку корректности ввода чисел.


public class MonthOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the month number: ");
        String month = reader.readLine();

        try {
            int monthInt = Integer.parseInt(month);
            if (monthInt > 0 && monthInt < 13) {
                System.out.println(Month.of(monthInt));
            } else System.out.println("You can choose only number from 1 to 12");

        } catch (Exception e) {
            System.out.println("You can choose only number from 1 to 12");
        }
    }
}
