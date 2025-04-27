package locadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLocadoraVeiculos {

    private AlugarVeiculo alugarveiculo = new AlugarVeiculo();
    private CustoAluguelVeiculo custos = new CustoAluguelVeiculo();
    private ConversorNumeros conversor = new ConversorNumeros();
    private EntradaSaidaDados io = new EntradaSaidaDados();
    private int opcao;
    private CadastrarVeiculo veiculo = new CadastrarVeiculo();
    private JFrame frame;

    public void executarLocadoraVeiculos() {
        frame = new JFrame("Locadora de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(210, 228, 238)); // Cor agradável

        JButton btnCadastrarAluguel = criarBotao("1 - Cadastrar Aluguel");
        JButton btnCadastrarVeiculo = criarBotao("2 - Cadastrar Veículo");
        JButton btnExibirAluguel = criarBotao("3 - Exibir Dados do Aluguel");
        JButton btnExibirVeiculo = criarBotao("4 - Exibir Dados do Veículo");
        JButton btnCalcularAluguel = criarBotao("5 - Calcular Aluguel");
        JButton btnSair = criarBotao("0 - Sair");

        panel.add(btnCadastrarAluguel);
        panel.add(btnCadastrarVeiculo);
        panel.add(btnExibirAluguel);
        panel.add(btnExibirVeiculo);
        panel.add(btnCalcularAluguel);
        panel.add(btnSair);

        adicionarEventos(btnCadastrarAluguel, btnCadastrarVeiculo, btnExibirAluguel, btnExibirVeiculo, btnCalcularAluguel, btnSair);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }

    private void adicionarEventos(JButton btnCadastrarAluguel, JButton btnCadastrarVeiculo, JButton btnExibirAluguel,
                                   JButton btnExibirVeiculo, JButton btnCalcularAluguel, JButton btnSair) {
        btnCadastrarAluguel.addActionListener(e -> cadastrarAluguel());
        btnCadastrarVeiculo.addActionListener(e -> cadastrarVeiculo());
        btnExibirAluguel.addActionListener(e -> exibirAluguel());
        btnExibirVeiculo.addActionListener(e -> exibirVeiculo());
        btnCalcularAluguel.addActionListener(e -> calcularAluguel());
        btnSair.addActionListener(e -> sairPrograma());
    }

    private void cadastrarAluguel() {
        double valorDia = conversor.stringToDouble(io.entradaDados("Informe o valor da diária:"));
        int numeroDias = conversor.stringToInt(io.entradaDados("Informe o número de dias:"));
        double kmRodados = conversor.stringToDouble(io.entradaDados("Informe a quilometragem rodada:"));
        double valorKmRodado = conversor.stringToDouble(io.entradaDados("Informe o valor por quilômetro rodado:"));

        alugarveiculo.cadastrarAluguel(valorDia, numeroDias, kmRodados, valorKmRodado);
        io.saidaDados("Aluguel cadastrado com sucesso!");
    }

    private void cadastrarVeiculo() {
        String modelo = io.entradaDados("Informe o modelo do veículo:");
        int anoFabricacao = conversor.stringToInt(io.entradaDados("Informe o ano de fabricação:"));

        veiculo.cadastrarVeiculo(modelo, anoFabricacao);
        io.saidaDados("Veículo cadastrado com sucesso!");
    }

    private void exibirAluguel() {
        io.saidaDados(alugarveiculo.listarAluguel());
    }

    private void exibirVeiculo() {
        io.saidaDados(veiculo.toString());
    }

    private void calcularAluguel() {
        custos.calcularAluguel(alugarveiculo);
        io.saidaDados("Valor total do aluguel: R$ " + String.format("%.2f", custos.getTotalAluguel()));
    }

    private void sairPrograma() {
        int confirm = JOptionPane.showConfirmDialog(frame, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            frame.dispose();
        }
    }
}
