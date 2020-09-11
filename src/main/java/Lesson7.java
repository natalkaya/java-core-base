import org.apache.commons.lang3.RandomStringUtils;
import plates.Cat;
import plates.Plate;

import java.util.ArrayList;
import java.util.List;

/**
 * Расширить задачу про котов и тарелки с едой.
 * Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
 * Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
 * Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
 * Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Lesson7 {
    public static void main(String[] args) {
        final int catsCount = 5;
        final int appetite = 5;
        List<Cat> cats = new ArrayList<>();
        Plate plate = new Plate(catsCount * appetite + 2);
        plate.info();

        for (int i = 0; i < catsCount; i++) {
            cats.add(new Cat(RandomStringUtils.randomAlphabetic(5), appetite));
        }
        System.out.println("Generated cats:");
        cats.forEach(System.out::println);

        cats.forEach(cat -> cat.eat(plate));
        System.out.println("1. Cats after eating:");
        cats.forEach(System.out::println);
        plate.info();

        System.out.println("Add eating to plate");
        plate.add(appetite);
        plate.info();

        cats.forEach(cat -> cat.eat(plate));
        System.out.println("2. Cats after eating:");
        cats.forEach(System.out::println);
        plate.info();
    }
}
