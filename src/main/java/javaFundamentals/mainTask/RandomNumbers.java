package javaFundamentals.mainTask;

import java.util.Arrays;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

public class RandomNumbers {
    public static void main(String[] args) {
        int amount = 10;
        int[] array = new int[amount];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }

        System.out.println("Numbers in one line: " + Arrays.toString(array));

        System.out.println("Numbers from a new line:");
        for (int number: array) {
            System.out.println(number);
        }
    }
}
