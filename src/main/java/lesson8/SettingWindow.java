package lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {

    private static final int W_X = GameWindow.W_X + 50;
    private static final int W_Y = GameWindow.W_Y + 50;
    private static final int W_WIDTH = 405;
    private static final int W_HEIGHT = 300;
    private final static int FIELD_SIZE_MIN = 3;
    private final static int FIELD_SIZE_MAX = 10;

    private final static int MODE_H_V_A = 0;
    private final static int MODE_H_V_H = 1;

    private GameWindow gameWindow;
    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup bgGameMode;
    private JSlider slFieldSize;
    private JSlider slWinLength;


    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(W_X, W_Y, W_WIDTH, W_HEIGHT);
        setTitle("Setting");

        setLayout(new GridLayout(8, 1));

        add(new JLabel("Choose game mode"));
        jrbHumVsAi = new JRadioButton("HumVsAi", true);
        jrbHumVsHum = new JRadioButton("HumVsHum");
        bgGameMode = new ButtonGroup();
        bgGameMode.add(jrbHumVsAi);
        bgGameMode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);

        add(new JLabel("Choose field size"));
        slFieldSize = new JSlider(FIELD_SIZE_MIN, FIELD_SIZE_MAX, FIELD_SIZE_MIN);
        slFieldSize.setMajorTickSpacing(2);
        slFieldSize.setMinorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);
        add(slFieldSize);

        add(new JLabel("Choose win's length"));
        slWinLength = new JSlider(FIELD_SIZE_MIN, FIELD_SIZE_MIN, FIELD_SIZE_MIN);
        slWinLength.setMajorTickSpacing(1);
        slWinLength.setPaintTicks(true);
        slWinLength.setPaintLabels(true);
        add(slWinLength);

        slFieldSize.addChangeListener(e -> {
            slWinLength.setMaximum(slFieldSize.getValue());
        });

        JButton buttonStartGame = new JButton("Start a game");
        add(buttonStartGame);

        buttonStartGame.addActionListener(e -> {
            int mode = jrbHumVsAi.isSelected() ? MODE_H_V_A : MODE_H_V_H;
            int filedSize = slFieldSize.getValue();
            int winLength = this.slWinLength.getValue();
            Logic.SIZE = filedSize;
            Logic.DOTS_TO_WIN = winLength;
            Logic.initMap();
            Logic.isGameFinished = false;
            gameWindow.startNewGame(mode, filedSize, winLength);
            setVisible(false);
        });

        setVisible(false);
    }
}
