import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorfulCalculator extends JFrame implements ActionListener {
    private JTextField textField;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public ColorfulCalculator() {
        setTitle("Colorful Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // UI Font
        Font font = new Font("Arial", Font.BOLD, 24);

        // Display area
        textField = new JTextField();
        textField.setFont(font);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        add(textField, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(240, 240, 240));
        add(panel, BorderLayout.CENTER);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(font);
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);

            switch (text) {
                case "+": btn.setBackground(new Color(255, 99, 71)); break;
                case "-": btn.setBackground(new Color(255, 165, 0)); break;
                case "*": btn.setBackground(new Color(30, 144, 255)); break;
                case "/": btn.setBackground(new Color(60, 179, 113)); break;
                case "=": btn.setBackground(new Color(128, 0, 128)); break;
                case "C": btn.setBackground(new Color(220, 20, 60)); break;
                default: btn.setBackground(new Color(100, 149, 237)); break;
            }

            btn.addActionListener(this);
            panel.add(btn);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = ((JButton)e.getSource()).getText();

        if (input.matches("[0-9\\.]")) {
            textField.setText(textField.getText() + input);
        } else if (input.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(textField.getText());
            operator = input.charAt(0);
            textField.setText("");
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    result = (num2 != 0) ? num1 / num2 : 0;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (input.equals("C")) {
            textField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorfulCalculator::new);
    }
}
