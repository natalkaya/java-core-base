import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * Конструктор класса должен заполнять эти поля при создании объекта.
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class Lesson5 {

    public static void main(String[] args) {
        final int employeesCount = 5;
        Random rand = new Random();
        Employee[] employees = new Employee[employeesCount];
        for (int i = 0; i < employeesCount; i++) {

            final int lettersCount = 5;
            final boolean isLetters = true;
            final boolean isNumbers = false;

            employees[i] = new Employee(
                    RandomStringUtils.random(lettersCount, isLetters, isNumbers),
                    RandomStringUtils.random(lettersCount, isLetters, isNumbers),
                    RandomStringUtils.randomAlphanumeric(lettersCount),
                    RandomStringUtils.randomNumeric(10),
                    rand.nextInt(30000),
                    rand.nextInt(60)
            );
        }

        System.out.println("Generated employees: ");
        for (Employee employee : employees) {
            employee.printToConsole();
        }

        System.out.println("\nEmployee with age > 40:");
        for (Employee employee : employees) {
            if (employee.getAge() > 40) employee.printToConsole();
        }
    }
}

