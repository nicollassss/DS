import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prova2 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("converter");
        frame.setSize  (600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout (null);

        JLabel clabel = new JLabel("celsius:");
        clabel.setBounds(40, 40, 100, 50);
        frame.add(clabel);

        JTextField cinput = new JTextField();
        cinput.setBounds(160, 40, 160, 50);
        frame.add(cinput);

        JButton convertButton = new JButton("converta");
        convertButton.setBounds(40, 120, 480, 60);
        frame.add(convertButton);

        JLabel klabel = new JLabel("K: ");
        klabel.setBounds(40, 200, 480, 50);
        frame.add (klabel);

        JLabel flabel = new JLabel("F:");
        flabel.setBounds(40, 260, 480, 50);
         frame.add(flabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double ce = Double.parseDouble(cinput.getText());
                    double kelvin = ce + 273.15;
                    
                    double fahrenheit = (ce * 9/5) + 32;

                    klabel.setText("K: " + kelvin);
                    flabel.setText("F: " + fahrenheit);
                } catch (NumberFormatException ex) {
                      JOptionPane.showMessageDialog(frame, "voce fez algo de errado, tente dnv.");
                }
            }
        });

        frame.setVisible(true);
    }
}
