import java.util.Arrays;
import java.util.Random;

public class Lesson2 {

    public static int[] generateArr(int arrLength, int randBound) {
        Random random = new Random();
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = random.nextInt(randBound);
        }
        System.out.println("Generated array: " + Arrays.toString(arr));
        return arr;
    }

    public static void task1() {
        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1. " +
                "Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;");
        int arrLength = 10;
        int[] arr = generateArr(arrLength, 2);

        for (int i =0; i < arrLength; i++) {
            if (arr[i] == 0) arr[i] = 1; else arr[i] = 0;
        }
        System.out.println("Modified array: " + Arrays.toString(arr));
    }

    public static void task2() {
        System.out.println("\n2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его " +
                "значениями 0 3 6 9 12 15 18 21;");
        int arrLength = 8;
        int[] arr = new int[arrLength];
        for (int i =1; i < arrLength; i++) {
            arr[i] = arr[i-1] + 3;
        }
        System.out.println("Generated array: " + Arrays.toString(arr));
    }

    public static void task3() {
        System.out.println("\n3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, " +
                "и числа меньшие 6 умножить на 2;");
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Generated array: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println("Modified array: " + Arrays.toString(arr));
    }

    public static void task4() {
        System.out.println("\n4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов " +
                "одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;");
        Random random = new Random();
        int count = 5;
        int[][] arr = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = random.nextInt(count);
            }
        }
        print2DArray(arr, count);

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if ( i == j) {
                    arr[i][j] = 1;
                }
            }
        }
        print2DArray(arr, count);

    }

    public static void print2DArray(int[][] arr, int count) {
        System.out.println();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void task5() {
        System.out.println("\n5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы " +
                "(без помощи интернета);");
        int arrLength = 10;
        int[] arr = generateArr(arrLength, arrLength);
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arrLength; i++) {
            if (arr[i] <= min) min = arr[i];
            if (arr[i] >= max) max = arr[i];
        }
        System.out.println("min: " + min + "\nmax: " + max);
    }

    public static void task6() { //todo
        System.out.println("\n6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, " +
                "метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. " +
                "Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, " +
                "граница показана символами ||, эти символы в массив не входят.");
    }

//    public static boolean checkBalance(int[] arr) {
//        boolean res = false;
//        final int length = arr.length;
//        for (int i = 0; i < length; i++) {
//            for (int j = length; j > 0; j--) {
//
//            }
//
//        }
//        return res;
//    }

    public static void task7() { //todo
        System.out.println("7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть " +
                "положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. " +
                "Для усложнения задачи нельзя пользоваться вспомогательными массивами.");

    }

//    public static void moveElements(int[] arr, int n) {
//    }


    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

}
