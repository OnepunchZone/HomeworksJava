package ru.otus.java.basic.javaio2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(compareQuery(readFile()));
    }

    public static String readFile() {
        String fileName = sc.nextLine();
        String data = null;

        try(BufferedInputStream bif = new BufferedInputStream(new FileInputStream("files/" + fileName + ".txt"))) {
            byte[] bytes = bif.readAllBytes();
            data = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static int compareQuery(String data) {
        String query = sc.nextLine();
        String str = "";
        int count = 0;

        for(int i = 0; i < data.length(); i++){
            str += String.valueOf(data.charAt(i));

            if(str.length() > query.length()) {
                str = String.valueOf(data.charAt(i));
            }

            if(query.equals(str)) {
                count++;
                str = "";
            }
        }
        return count;
    }
}
