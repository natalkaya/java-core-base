package lesson8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ResultWindow extends JFrame {
    private static final int W_X = GameWindow.W_X + 50;
    private static final int W_Y = GameWindow.W_Y + 50;
    private static final int W_WIDTH = GameWindow.W_WIDTH / 3;
    private static final int W_HEIGHT = GameWindow.W_HEIGHT / 3;

    public ResultWindow() {

        setBounds(W_X, W_Y, W_WIDTH, W_HEIGHT);
        setTitle("Game over");

        JLabel resultLabel = new JLabel(Logic.GAME_RESULT, SwingConstants.CENTER);
        resultLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        resultLabel.setForeground(Color.darkGray);

        JButton exitToMainWindowButton = new JButton("Finish");
        add(resultLabel, BorderLayout.CENTER);
        add(exitToMainWindowButton, BorderLayout.SOUTH);

        exitToMainWindowButton.addActionListener(e -> {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        setVisible(false);
    }
}
