import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.text.DecimalFormat;

public class UnitConverterGUI {
    private JFrame frame;
    private JTextField inputField;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JLabel resultLabel;

    public UnitConverterGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Creative Innovators Unit Converter");
        frame.setBounds(100, 100, 450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(5, 2, 10, 10));
        // DecimalFormat decimalFormat = new DecimalFormat("#.##");
        JLabel inputLabel = new JLabel("Enter Value:");
        inputField = new JTextField();
        JLabel fromLabel = new JLabel("From:");
        fromComboBox = new JComboBox<>(new String[]{"Feet", "Pounds", "Fahrenheit"});
        JLabel toLabel = new JLabel("To:");
        toComboBox = new JComboBox<>(new String[]{"Meters", "Kilograms", "Celsius"});

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertButtonClicked();
            }
        });

        resultLabel = new JLabel("Result:");

        frame.getContentPane().add(inputLabel);
        frame.getContentPane().add(inputField);
        frame.getContentPane().add(fromLabel);
        frame.getContentPane().add(fromComboBox);
        frame.getContentPane().add(toLabel);
        frame.getContentPane().add(toComboBox);
        frame.getContentPane().add(new JLabel()); // Empty space for better layout
        frame.getContentPane().add(convertButton);
        frame.getContentPane().add(resultLabel);

        frame.setVisible(true);
    }

    private void convertButtonClicked() {
        try {
            double inputValue = Double.parseDouble(inputField.getText().replaceAll("\\s",""));
            String fromUnit = (String) fromComboBox.getSelectedItem();
            String toUnit = (String) toComboBox.getSelectedItem();

            // Validate;
            // inputValue = inputValue.replace(" ","");
            

            // Validate and accept only one "."
            

            if(fromUnit == toUnit){
                JOptionPane.showMessageDialog(frame, "Invalid input. You cant choose the same Units");
            }else if(fromUnit == "Feet" && toUnit == "Meters"){
                double result = convert(inputValue, fromUnit, toUnit);
                resultLabel.setText("Result: " + Math.round(result*100.0)/100.0 + " " + toUnit);
            }else if(fromUnit == "Pounds" && toUnit =="Kilograms"){
                double result = convert(inputValue, fromUnit, toUnit);
                resultLabel.setText("Result: " +Math.round(result*100.0)/100.0 + " " + toUnit);
            }else if(fromUnit == "Fahrenheit" && toUnit == "Celsius"){
                double result = convert(inputValue, fromUnit, toUnit);
                resultLabel.setText("Result: " + Math.round(result*100.0)/100.0 + " " + toUnit);
            }else{
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");    
            }
            

            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
        }
    }

    private double convert(double value, String fromUnit, String toUnit) {
        // Conversion logic for specific units
        if (fromUnit.equals("Feet") && toUnit.equals("Meters")) {
            return value * 0.3048; // 1 foot = 0.3048 meters
        } else if (fromUnit.equals("Pounds") && toUnit.equals("Kilograms")) {
            return value * 0.453592; // 1 pound = 0.453592 kilograms
        } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            return (value - 32) * 5 / 9; // Fahrenheit to Celsius conversion
        } else {
            return -3; // If units are the same
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UnitConverterGUI();
            }
        });
    }
}
