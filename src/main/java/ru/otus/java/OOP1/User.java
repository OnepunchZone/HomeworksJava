package ru.otus.java.OOP1;


import java.time.LocalDate;

public class User {
    public LocalDate currentDate = LocalDate.now();
    public final int maxYear = currentDate.getYear();
    private String lastName;
    private String firstName;
    private String patronymic;
    private int yearOfTheBirth;
    private String userEmail;

    public User (String lastName, String firstName, String patronymic,
                 int yearOfTheBirth, String userEmail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.yearOfTheBirth = validateYearOfBirth(yearOfTheBirth);
        this.userEmail = userEmail;
    }

    public User(String lastName, String firstName, String patronymic, int yearOfTheBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.yearOfTheBirth = validateYearOfBirth(yearOfTheBirth);
        userEmail = "Отсутствует";
    }

    @Override
    public String toString() {
        return "ФИО: " +
                 lastName + " " + firstName + " " + patronymic + "\n" +
                "Год рождения: " + yearOfTheBirth + "\n" +
                "E-mail: " + userEmail + "\n";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getYearOfTheBirth() {
        return yearOfTheBirth;
    }

    public void setYearOfTheBirth(int yearOfTheBirth) {

        if (validateYearOfBirth(yearOfTheBirth) == maxYear + 1) {
            System.out.println("Ты ещё не родился, либо очень древний организм!");
        } else {
            this.yearOfTheBirth = yearOfTheBirth;
        }

    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int validateYearOfBirth(int yearOfTheBirth) {

        if (yearOfTheBirth > 0 && yearOfTheBirth <= maxYear) {
            return yearOfTheBirth;
        } else {
            return  maxYear + 1;
        }
    }
}
