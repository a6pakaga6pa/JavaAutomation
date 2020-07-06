package javaFundamentals.mainTask;

//2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class ArgsReverseOrder {
    public static void main(String[] args) {
        String[] array = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = args[args.length - i - 1];
        }

        for (String s : array) {
            System.out.println(s);
        }
    }
}

