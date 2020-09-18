package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int W_X = 500;
    static final int W_Y = 500;
    static final int W_WIDTH = 505;
    static final int W_HEIGHT = 555;

    private BattleField battleField;
    private SettingWindow settingWindow;

    public GameWindow() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(W_X, W_Y, W_WIDTH, W_HEIGHT);
        setTitle("TicTacToe");

        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);

        settingWindow = new SettingWindow(this);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton buttonNewGame = new JButton("Start a new game");
        JButton buttonExit = new JButton("Exit");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonExit);
        add(jPanel, BorderLayout.SOUTH);

        buttonNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        buttonExit.addActionListener( e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }

    public void startNewGame(int mode, int fieldSize, int winLength) {
        battleField.startNewGame(mode, fieldSize, winLength);
    }
}
