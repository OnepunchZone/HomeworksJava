package ru.otus.java.basic.javaio1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        chooseFile();
    }

    public static void chooseFile() throws IOException {

        File file1 = new File("files/fileRus.txt");
        File file2 = new File("files/fileEng.txt");
        File file3 = new File("files/fileNumbs.txt");

        System.out.println("Выберите файл для работы:");
        System.out.println("1 - " + file1.getName() + ";");
        System.out.println("2 - " + file2.getName() + ";");
        System.out.println("3 - " + file3.getName() + ";");
        System.out.println("0 - выйти.\n");

        Scanner sc = new Scanner(System.in);
        int chooseNum = sc.nextInt();

        if (chooseNum == 1) {
            printAndReturn(file1);
        } else if (chooseNum == 2) {
            printAndReturn(file2);
        } else if (chooseNum == 3) {
            printAndReturn(file3);
        } else {
            if(chooseNum == 0) {
                return;
            }
            System.out.println("Такого файла не существует.");
            chooseFile();
        }
    }

    private static void readFile(File file) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
        } catch (IOException e) {
            System.out.println("Ошибка файла.");
        }
    }

    private static void writeFile(File file, String str) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write("\n");
        out.write(str);
        out.close();
    }

    private static void printAndReturn(File file) throws IOException {
        readFile(file);
        System.out.println("\nВведите что нужно добавить в файл: ");

        Scanner sc = new Scanner(System.in);
        writeFile(file, sc.nextLine());

        readFile(file);
        System.out.println();

        chooseFile();
    }
}
