package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1.     Приветствовать любого пользователя при вводе его имени через командную строку.

public class GreetUser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter username: ");
        String name = reader.readLine();
        System.out.println("Hello, " + name + "!");
    }
}
