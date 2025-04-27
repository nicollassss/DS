package locadora;

import javax.swing.JOptionPane;

public class EntradaSaidaDados {

    public String entradaDados(String mensagemEntrada) {
        return JOptionPane.showInputDialog(null, mensagemEntrada, "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
    }

    public void saidaDados(String mensagemSaida) {
        JOptionPane.showMessageDialog(null, mensagemSaida, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }
}
