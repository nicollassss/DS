import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prova4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("peso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel labelPesoTerra = new JLabel("terra (kg):");
        labelPesoTerra.setBounds(50, 30, 150, 30);
        frame.add(labelPesoTerra);

        JTextField textPesoTerra = new JTextField();
        textPesoTerra.setBounds(200, 30, 150, 30);
        frame.add(textPesoTerra);

        JButton botaoCalcular = new JButton("calcule");
        botaoCalcular.setBounds(130, 80, 150, 30);
        frame.add(botaoCalcular);

        JLabel labelResultado = new JLabel("");
        labelResultado.setBounds(50, 130, 300, 150);
        frame.add(labelResultado);

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double pesoTerra = Double.parseDouble(textPesoTerra.getText());
                    StringBuilder resultado = new StringBuilder("<html>peso interplanetario:<br>");

                    //constante gravitacional em outros planetas
                    Object[][] planetas = {
                        {"mercúrio", 3.7},
                        {"vênus", 8.87},
                        {"marte", 3.71},
                        {"júpiter", 24.79},
                        {"daturno", 10.44},
                        {"urano", 8.69}
                    };

                    for (Object[] planeta : planetas) {
                        String nome = (String) planeta[0];
                        double gravidade = (double) planeta[1];
                        double pesoPlaneta = pesoTerra * (gravidade / 9.81);
                        resultado.append(nome).append(": ").append(String.format("%.2f", pesoPlaneta)).append(" kg<br>");
                    }

                    resultado.append("</html>");
                    labelResultado.setText(resultado.toString());
                } catch (NumberFormatException ex) {
                    labelResultado.setText("errado");
                }
            }
        });

        frame.setVisible(true);
    }
}
