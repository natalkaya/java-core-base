import oop.Animal;
import oop.Cat;
import oop.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Создать классы Собака и Кот с наследованием от класса Животное.
 * Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 * У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 * * Добавить подсчет созданных котов, собак и животных.
 */
public class Lesson6 {

    public static void main(String[] args) {
        Random random = new Random();
        AtomicReference<Integer> catsCount = new AtomicReference<>(0);
        AtomicReference<Integer> dogsCount = new AtomicReference<>(0);
        List<Animal> animals = new ArrayList<>();

        Animal gavCat = new Cat("Гав");
        Animal meowDog = new Dog("Мяу");

        animals.add(gavCat);
        animals.add(meowDog);
        animals.forEach(
                animal -> {
                    final int distanceBound = 500;
                    if (animal instanceof Cat) catsCount.getAndSet(catsCount.get() + 1);
                    if (animal instanceof Dog) dogsCount.getAndSet(dogsCount.get() + 1);
                    animal.run(random.nextInt(distanceBound));
                    animal.swim(random.nextInt(distanceBound));
                }
        );

        System.out.println(
                "\n\nCount of created animals: " + animals.size() +
                "\nCats: " + catsCount +
                "\nDogs: " + dogsCount
        );
    }


}
