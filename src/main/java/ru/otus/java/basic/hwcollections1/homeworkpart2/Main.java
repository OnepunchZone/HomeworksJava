package ru.otus.java.basic.hwcollections1.homeworkpart2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        System.out.println(namesOfEmployees(createEmployeeList()));
        System.out.println();
        System.out.println(chooseMinAge(createEmployeeList(), 30));
        System.out.println();
        System.out.println(minAverageAge(createEmployeeList(), 20));
        System.out.println();
        System.out.println(youngestEmployee(createEmployeeList()));
        
    }

    public static List<Employee> createEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Рик", 52));
        employeeList.add(new Employee("Эрик", 12));
        employeeList.add(new Employee("Бэндэр", 6));
        employeeList.add(new Employee("Маша", 30));
        employeeList.add(new Employee("Итачи", 26));

        return employeeList;
    }

    public static List<String> namesOfEmployees(List<Employee> arrList) {
        List<String> namesList = new ArrayList<>();

        for (Employee name : arrList) {
            namesList.add(name.getName());
        }
        return namesList;
    }

    public static List<Employee> chooseMinAge(List<Employee> arrList, int minAge) {
        List<Employee> relevantList = new ArrayList<>();

        for (Employee employee : arrList) {
            if (employee.getAge() >= minAge) {
                relevantList.add(employee);
            }
        }
        return relevantList;
    }

    public static boolean minAverageAge(List<Employee> arrList, int minAverAge) {
        ListIterator<Employee> li = arrList.listIterator();
        int sumOfAge = 0;

        while (li.hasNext()) {
            sumOfAge += li.next().getAge();
        }

        int averAge = sumOfAge / arrList.size();

        return averAge > minAverAge;
    }

    public static List<Employee> youngestEmployee(List<Employee> arrList) {
        int minAge = arrList.get(0).getAge();

        for (int i = 1; i < arrList.size(); i++) {
            if (minAge > arrList.get(i).getAge()) {
                minAge = arrList.get(i).getAge();
                arrList.remove(0);

            } else {
                arrList.remove(i);
            }
            i--;
        }
        return arrList;
    }
}
