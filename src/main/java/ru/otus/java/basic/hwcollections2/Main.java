package ru.otus.java.basic.hwcollections2;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        print();
    }

    private static void print() {
        Map<PhoneBook, String> phoneBookList = new PhoneBook().getPhoneBookMap();
        System.out.println(phoneBookList);
        add(phoneBookList,"Олег", "89993332211");
        add(phoneBookList,"Бонд", "007");
        add(phoneBookList,"Бендер", "+11010101010");
        add(phoneBookList,"Бендер", "21111100000");
        System.out.println(phoneBookList);
        find(phoneBookList, "лара");
        find(phoneBookList, "апвпрап");
        find(phoneBookList, "леголас");
        find(phoneBookList, "бендер");
        containsPhoneNumber(phoneBookList, "89993332211");
        containsPhoneNumber(phoneBookList, "45747457");
    }

    public static void add(Map<PhoneBook, String> phoneBookList, String name, String number) {

        PhoneBook phoneBook = new PhoneBook(name, number);
        
        phoneBookList.put(phoneBook, phoneBook.getNumberPhone());
    }

    public static void find(Map<PhoneBook, String> phoneBookList, String name) {
        for (Map.Entry<PhoneBook, String> entry : phoneBookList.entrySet()) {
            String key = entry.getKey().getName().toUpperCase();
            if (key.equals(name.toUpperCase())) {
                System.out.println(entry);
            }
        }
    }

    public  static void containsPhoneNumber(Map<PhoneBook, String> phoneBookList, String number) {
        String convertNumber = PhoneNumberRandom.convertNumber(number);
        System.out.println(phoneBookList.containsValue(convertNumber));
    }

}
