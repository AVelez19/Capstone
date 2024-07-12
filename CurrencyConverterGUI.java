package Capstone;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends JFrame {
    private JLabel titleLabel;
    private JLabel amountLabel;
    private JLabel resultLabel;
    private JTextField amountTextField;
    private JTextField resultTextField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JButton convertButton;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen
        getContentPane().setBackground(Color.decode("#D593FC")); // Set background color

        // Initialize components
        titleLabel = new JLabel("Currency Converter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Set font size to 16pt
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        amountLabel = new JLabel("Amount:");
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        amountTextField = new JTextField(10);
        resultTextField = new JTextField(10);
        resultTextField.setEditable(false); // Result field is read-only
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "CAD", "INR", "MXN"});
        toCurrencyComboBox = new JComboBox<>(new String[]{"EUR", "USD", "GBP", "JPY", "CAD", "INR", "MXN"});
        convertButton = new JButton("Convert");
        convertButton.setBackground(Color.WHITE);

        // Layout setup (using BorderLayout for simplicity)
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(Color.decode("#D593FC"));
        inputPanel.add(amountLabel);
        inputPanel.add(amountTextField);
        inputPanel.add(new JLabel("From:"));
        inputPanel.add(fromCurrencyComboBox);
        inputPanel.add(new JLabel("To:"));
        inputPanel.add(toCurrencyComboBox);
        inputPanel.add(convertButton);

        // Panel for result
        JPanel resultPanel = new JPanel(new FlowLayout());
        resultPanel.add(resultLabel);
        resultPanel.add(resultTextField);

        // Add panels to frame
        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Add action listener to convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    // Method to perform currency conversion
    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
            String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
            double result = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
            resultTextField.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurrencyConverterGUI converter = new CurrencyConverterGUI();
                converter.setVisible(true);
            }
        });
    }
}
