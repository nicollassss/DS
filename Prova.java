
package prova;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prova extends JFrame {
    private JTextField pesoField;
    private JTextField alturaField;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    public Prova() {
        setTitle("imc calculadora");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel pesoLabel = new JLabel("peso:");
        pesoLabel.setBounds(20, 20, 100, 25);
        add(pesoLabel);

        pesoField = new JTextField();
        pesoField.setBounds(120, 20, 150, 25);
        add(pesoField);

        JLabel alturaLabel = new JLabel("altura em metros ");
        alturaLabel.setBounds(20, 60, 100, 25);
        add(alturaLabel);

        alturaField = new JTextField();
        alturaField.setBounds(120, 60, 150, 25);
        add(alturaField);

        calcularButton = new JButton("CALCULE");
        
        calcularButton.setBounds(40, 100, 250, 30);
        add(calcularButton);

        resultadoLabel = new JLabel("IMC:");
        resultadoLabel.setBounds(20, 140, 250, 25);
        
        add(resultadoLabel);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {     double peso = Double.parseDouble(pesoField.getText());
        double altura = Double.parseDouble(alturaField.getText());
        double imc = peso / (altura * altura);
        
        String categoria;
        if (imc < 18.5) {
            categoria = "abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            categoria = "peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            categoria = "sobrepeso";
        } else {
            categoria = "obeso";
        }
        
        resultadoLabel.setText(String.format("IMC: %.2f - %s", imc, categoria));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "não é assim que faz meu amigo :(, faz dnv");
    }
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Prova calculadora = new Prova();
            calculadora.setVisible(true);
        });
    }
}
