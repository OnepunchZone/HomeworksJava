package ru.otus.java.basic.clientservercalculator.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2323);

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("Клиент подключен");
            processRequest(client);
        }
    }

    public static void processRequest(Socket client) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        Calculator calc = new Calculator();
        String begin = in.readUTF();
        out.writeUTF("""
                        Доступные операции:
                        - сложение(+);
                        - вычитание(-);
                        - умножение(*);
                        - деление(/).""" + begin);
        out.flush();
        calc.setNum1(in.readDouble());
        System.out.println("Введите первое число: " + calc.getNum1());
        calc.setSymbol(in.readChar());
        System.out.println("Выберите операцию : " + calc.getSymbol());
        calc.setNum2(in.readDouble());
        System.out.println("Введите второе число: " + calc.getNum2());
        double result = calc.calculate();
        System.out.println(calc.getNum1() + " " + calc.getSymbol() + " " +
                calc.getNum2() + " = " + result);
        out.writeDouble(result);
        out.flush();
    }
}
