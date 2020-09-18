package lesson8;

import java.util.Random;

public class Logic {

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;

    public static int SIZE;
    public static int DOTS_TO_WIN;
    public static Random rand = new Random();
    public static boolean isGameFinished = false;
    public static String GAME_RESULT;

    private static String WIN_HUM1 = "Win human";
    private static String WIN_AI = "Win AI";
//    private static String WIN_HUM2 = "Победил человек";
    private static String WIN_DRAW = "Draw";

    private static void go() {
        isGameFinished = true;
        printMap();
        if (checkWin(DOT_X)) {
            GAME_RESULT = WIN_HUM1;
            System.out.println(GAME_RESULT);
            return;
        }
        if (isMapFull()) {
            GAME_RESULT = WIN_DRAW;
            System.out.println(GAME_RESULT);
            return;
        }
        aiTurn();
        printMap();
        if (checkWin(DOT_O)) {
            GAME_RESULT = WIN_AI;
            System.out.println(GAME_RESULT);
            return;
        }
        if (isMapFull()) {
            GAME_RESULT = WIN_DRAW;
            System.out.println(GAME_RESULT);
            return;
        }
        isGameFinished = false;
    }

    public static boolean checkWin(char symb) {
        if (checkHoriz(symb)) return true;
        if (checkVert(symb)) return true;
        return checkDiagonal(symb);
    }

    public static boolean checkHoriz(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int dotsInLine = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) dotsInLine++;
                else if (dotsInLine > 0) dotsInLine--;
                if (dotsInLine == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    public static boolean checkVert(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int dotsInLine = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) dotsInLine++;
                else if (dotsInLine > 0) dotsInLine--;
                if (dotsInLine == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char symb) {
        int dotsInLine = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) dotsInLine++;
            else if (dotsInLine > 0) dotsInLine--;
            if (dotsInLine == DOTS_TO_WIN) return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn(int x, int y) {
        if (!isCellValid(x, y)) {
            return;
        }
        map[y][x] = DOT_X;
        go();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
