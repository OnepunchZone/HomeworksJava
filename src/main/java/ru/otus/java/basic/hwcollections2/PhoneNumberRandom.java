package ru.otus.java.basic.hwcollections2;

public class PhoneNumberRandom {
    public static String randomNum() {
        int maxOfRandom = 10;
        String[] phoneNumber = new String[11];
        phoneNumber[0] = " +7";
        phoneNumber[1] = "(9";

        for (int i = 2; i < phoneNumber.length; i++) {
            phoneNumber[i] = String.valueOf((int) (Math.random() * maxOfRandom));
        }

        return addSymbols(phoneNumber);
    }

    private static String addSymbols(String[] symbol) {
        symbol[3] += ")";
        symbol[6] += "-";
        symbol[8] += "-";

        return String.join("", symbol);
    }

    public static String convertNumber(String number) {
        StringBuilder numberBuild = new StringBuilder(number);
        numberBuild.insert(0, " ");

        if (number.length() == 12) {
            numberBuild.insert(3, "(");
            numberBuild.insert(7, ")");
            numberBuild.insert(11, "-");
            numberBuild.insert(14, "-");
            return  numberBuild.toString();
        }

        if (number.length() == 11) {
            numberBuild.insert(2, "(");
            numberBuild.insert(6, ")");
            numberBuild.insert(10, "-");
            numberBuild.insert(13, "-");
            return  numberBuild.toString();
        }

        return numberBuild.toString();
    }

}

