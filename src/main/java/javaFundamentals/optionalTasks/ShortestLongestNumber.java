package javaFundamentals.optionalTasks;

//1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

public class ShortestLongestNumber {
    public static void main(String[] args) {
        int amount = 10;
        int[] numbers = new int[amount];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }

        System.out.println("Max number is: " + maxNumber(numbers) + ". It has " + numberLength(maxNumber(numbers)) + " digits");
        System.out.println("Min number is: " + minNumber(numbers) + ". It has " + numberLength(minNumber(numbers)) + " digits");
    }

    public static int maxNumber(int[] numbers) {
        int max = 0;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int minNumber(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int numberLength(int number) {
        int length = 0;
        if (number == 0) {
            length ++;
            return length;
        } else {
            while(number % 10 != 0) {
                length++;
                number = number / 10;
            }
        }
        return length;
    }
}
