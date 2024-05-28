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
        minAverageAge(createEmployeeList(), 20);
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
        System.out.println("Список имен всех сотрудников :");
        return namesList;
    }

    public static List<Employee> chooseMinAge(List<Employee> arrList, int minAge) {
        List<Employee> relevantList = new ArrayList<>();

        for (Employee employee : arrList) {
            if (employee.getAge() >= minAge) {
                relevantList.add(employee);
            }
        }
        System.out.println("Список подходящих сотрудников с возрастом не менее " +
                minAge + " лет :");
        return relevantList;
    }

    public static void minAverageAge(List<Employee> arrList, int minAverAge) {
        ListIterator<Employee> li = arrList.listIterator();
        int sumOfAge = 0;

        while (li.hasNext()) {
            sumOfAge += li.next().getAge();
        }

        int averAge = sumOfAge / arrList.size();
        System.out.println("Средний возраст сотрудников = " + averAge);
        System.out.println(averAge > minAverAge ?
                "Средний возраст сотрудников БОЛЬШЕ заданного значения " +
                minAverAge : "Средний возраст сотрудников МЕНЬШЕ заданного значения " + minAverAge);
    }

    public static Employee youngestEmployee(List<Employee> arrList) {
        ListIterator<Employee> li = arrList.listIterator();
        int elem;
        int minAge = Integer.MAX_VALUE;
        Employee youngest = null;

        while (li.hasNext()) {
            elem = li.next().getAge();
            if ( elem <= minAge) {
                minAge = elem;
                youngest = li.previous();
                li.next();
            }
        }
        System.out.println("Самый молодой сотрудник :");
        return youngest;
    }
}
