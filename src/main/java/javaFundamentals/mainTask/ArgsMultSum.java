package javaFundamentals.mainTask;

//4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

public class ArgsMultSum {
    public static void main(String[] args) {
        int sum = 0;
        int mult = 1;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
            mult *= Integer.parseInt(args[i]);
        }

        if(args.length == 0) {
            System.out.println("Please, enter arguments");
        } else {
            System.out.println("Sum : " + sum);
            System.out.println("Mult : " + mult);
        }

    }
}
