import java.util.Random;
import java.util.Scanner;

/**
 * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

public class Lesson3 {

    public static int startGame(int isStart) {
        if (isStart == 1) {
            int maxTriesCount = 3;
            int triesCount = 0;
            Random random = new Random();
            int quizNumber = random.nextInt(10);
            System.out.println("Программа загадла случайное число от 0 до 9. Угадайте число.");
            while (triesCount < maxTriesCount) {
                System.out.println("Введите число: ");
                Scanner scanner = new Scanner(System.in);
                int userAnswer = scanner.nextInt();
                if (userAnswer == quizNumber) {
                    System.out.println("Угадали!");
                    break;
                } else if (userAnswer > quizNumber) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
                triesCount++;
            }
            if (triesCount == maxTriesCount) {
                System.out.println("Загаданное число: " + quizNumber);
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            return startGame(new Scanner(System.in).nextInt());
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        startGame(1);
    }
}
