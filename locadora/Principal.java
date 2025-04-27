package locadora;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Principal {
    public static void main(String[] args) {
        try {
            // Setando o tema Nimbus
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao aplicar o tema Nimbus: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            new MenuLocadoraVeiculos().executarLocadoraVeiculos();
        });
    }
}
