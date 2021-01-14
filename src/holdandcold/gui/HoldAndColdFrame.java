package holdandcold.gui;

import holdandcold.commons.types.LevelEnum;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class HoldAndColdFrame extends JFrame {
    private static final Dimension FRAME_DIMENSION = new Dimension(500, 150);
    private static final int MAX_NUMBER_TO_GUESS = 100;
    private static final int ATTEMPTS_TO_GUESS = 3;
    private final JLabel descriptionLabel;
    private final JLabel resultLabel;
    private final JTextField inputTextField;
    private final JPanel contentPanel;
    private final int number;
    private byte attemptsCount = 0;

    public HoldAndColdFrame() {
        super("Hot and cold.");
        descriptionLabel = new JLabel("There's a number between 0 and " + MAX_NUMBER_TO_GUESS + ". Please use maximum " + ATTEMPTS_TO_GUESS + " attempts to guess.");
        resultLabel = new JLabel();
        inputTextField = new JTextField(15);
        contentPanel = new JPanel();
        final Random random = new Random();
        number = random.nextInt(MAX_NUMBER_TO_GUESS + 1);
        System.out.println(number);

        setContentPane(contentPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME_DIMENSION);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setVisible(true);

        add(descriptionLabel);
        add(inputTextField);
        add(resultLabel);

        inputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String inputNumberString = inputTextField.getText();
                final int inputNumber = Integer.parseInt(inputNumberString);
                checkNumber(inputNumber);
            }
        });
    }

    private void checkNumber(int number) {
        final String result;
        if (this.number == number) {
            result = "Correct answer!";
        } else {
            result = LevelEnum.getResult(this.number - number);
        }

        JOptionPane.showMessageDialog(this, result);

        if (++attemptsCount == ATTEMPTS_TO_GUESS) {
            JOptionPane.showMessageDialog(this, "There's no more attempts to guess.");
            System.exit(0);
        }
    }
}