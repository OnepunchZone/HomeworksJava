package ru.otus.java.basic.hwcollections2;

public class PhoneNumberRandom {
    public static String randomNum() {
        int maxOfRandom = 10;
        String[] phoneNumber = new String[11];
        phoneNumber[0] = " +7";
        phoneNumber[1] = "(9";

        for (int i = 2; i < phoneNumber.length; i++) {
            phoneNumber[i] = String.valueOf((int) (Math.random() * maxOfRandom));
            if (i == 3) {
                phoneNumber[i] += ")";
            } else if (i == 6 || i == 8) {
                phoneNumber[i] += "-";
            }
        }
        return String.join("", phoneNumber);
    }

    public static String convertNumber(String number) {
        String newNumber = " ";

        for (int i = 0; i < number.length(); i++) {
            newNumber += number.charAt(i);

            if (number.length() == 12) {
                if (i == 1) {
                    newNumber += "(";
                } else if (i == 4) {
                    newNumber += ")";
                } else if (i == 7 || i == 9) {
                    newNumber += "-";
                }
            } else if (number.length() == 11) {
                if (i == 0) {
                    newNumber += "(";
                } else if (i == 3) {
                    newNumber += ")";
                } else if (i == 6 || i == 8) {
                    newNumber += "-";
                }
            }
        }
        return newNumber;
    }

}

