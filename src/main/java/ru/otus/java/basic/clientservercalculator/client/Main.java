package ru.otus.java.basic.clientservercalculator.client;

import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double num1 = sc.nextDouble();

        try(Socket socket = new Socket("localhost", 2323)) {
            PingClient pingClient = new PingClient(socket);
            pingClient.sendNum(num1);
            System.out.println("Выберите операцию (+) - сумма, (-) - разность, " +
                    "(*) - умножение, (/) - деление : ");
            char symbol = sc.next().charAt(0);
            pingClient.sendSymbol(symbol);
            System.out.println("Введите второе число: ");
            double num2 = sc.nextDouble();
            pingClient.sendNum(num2);
            double result = pingClient.read();
            System.out.println(num1 + " " + symbol + " " + num2 + " = " + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
