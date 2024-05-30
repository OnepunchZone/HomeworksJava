package ru.otus.java.basic.hwcollections2;

import java.util.*;

public class PhoneBook {
    private String name;
    private String patronymic;
    private String surname;
    private String numberPhone;
    private Map<PhoneBook, String> phoneBookMap = new HashMap<>();

    public PhoneBook(String name, String patronymic, String surname) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        numberPhone = PhoneNumberRandom.randomNum();
    }

    public PhoneBook(String name, String number) {
        this.name = name;
        numberPhone = PhoneNumberRandom.convertNumber(number);
        patronymic = "-";
        surname = "-";
    }

    public PhoneBook() {
        phoneListCreate();
    }

    public Map<PhoneBook, String> getPhoneBookMap() {
        return phoneBookMap;
    }

    public void setPhoneBookMap(Map<PhoneBook, String> phoneBookMap) {
        this.phoneBookMap = phoneBookMap;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private void phoneListCreate() {
        PhoneBook[] phoneBook = {new PhoneBook("Рик", "Васильевич", "Санчес"),
        new PhoneBook("Эрик", "Петрович", "Картман"),
        new PhoneBook("Наруто", "Власович", "Узумаки"),
        new PhoneBook("Лара", "Андреевна", "Крофт"),
        new PhoneBook("Гус", "Иванович", "Хиддинг"),
        new PhoneBook("Лара", "Александровна", "Борщёва"),
        new PhoneBook("Геральд", "Антонович", "Ривийский"),
        new PhoneBook("Леголас", "Трандуилович", "Эльфов")};

        for (PhoneBook phoneBookClass : phoneBook) {
            phoneBookMap.put(phoneBookClass, phoneBookClass.getNumberPhone());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(name, phoneBook.name) && Objects.equals(patronymic, phoneBook.patronymic) &&
                Objects.equals(surname, phoneBook.surname) && Objects.equals(numberPhone, phoneBook.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patronymic, surname, numberPhone);
    }

    @Override
    public String toString() {
        return name + " " + patronymic + " " + surname + " ";
    }


}
