import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//classe base para animal
class Animal {
    float tamanho; //atributo para o tamanho do animal
    String cor;    //atributo para a cor do animal

    //construtor da classe Animal
    Animal(float tamanho, String cor) {
        this.tamanho = tamanho; // inicializa o tamanho
        this.cor = cor;         // inicializa a cor
    }

    //método para simular o ato de comer
    void comer(JTextArea textArea) {
        textArea.append("animal de cor " + cor + " comendo.\n"); // adiciona mensagem ao JTextArea
    }
}

//classe cavalo herda herança
class Cavalo extends Animal {
    String raca; //atributo para a raça do cavalo

    //construto classe Cavalo
    Cavalo(float tamanho, String cor, String raca) {
        super(tamanho, cor); //chama o construtor da classe pai
        this.raca = raca;    // inicializa a raça
    }

    //método para simular o cavalo fugindo
    void fugir(JTextArea textArea) {
        textArea.append("o cavalo " + raca + " fugiu.\n"); // adiciona mensagem ao JTextArea
    }
}

//classe Leao que herda de Animal
class Leao extends Animal {
    boolean juba; //atributo para indicar se o leão tem juba

    //construtor da classe Leao
    Leao(float tamanho, String cor, boolean juba) {
        super(tamanho, cor); // chama o construtor da classe pai
        this.juba = juba;    // inicializa a juba
    }

    //amétodo para simular o leão caçandod
    void cacar(JTextArea textArea) {
        textArea.append("o leão está caçando!\n"); // adiciona mensagem ao JTextArea
    }
}

//main class principal
public class Prova3 {
    public static void main(String[] args) {
        //cria a janela do aplicativo
        JFrame frame = new JFrame("animais");
        frame.setSize(300, 300); //define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o fechamento da janela
        frame.setLayout(null); //define o layout como nulo

        JLabel label = new JLabel("escolha:"); //cria um rótulo
        label.setBounds(20, 20, 200, 30); //define a posição e tamanho do rótulo
        frame.add(label); //adiciona o rótulo à janela

        String[] animais = {"cavalo", "leão"}; //opções de animais
        JComboBox<String> animalComboBox = new JComboBox<>(animais); //combo box para seleção
        animalComboBox.setBounds(20, 60, 150, 30); //fine a posição e tamanho da combo box
        frame.add(animalComboBox); //diciona a combo box à janela

        JButton button = new JButton("criar situacao"); //botão para criar animal
        button.setBounds(20, 100, 150, 30); //eine a posição e tamanho do botão
        frame.add(button); //adiciona o botão à janela

        JTextArea textArea = new JTextArea(); //área de texto para exibir resultados
        textArea.setBounds(20, 140, 250, 100); //define a posição e tamanho da área de texto
        textArea.setEditable(false); //torna a ára de texto não editável
        frame.add(textArea); //adiciona a área de texto à janela

        //adiciona acao botao
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) animalComboBox.getSelectedItem(); //obtém o tipo de animal selecionado
                criarAnimal(tipo, textArea); //chama o método para criar o animal
            }
        });

        frame.setVisible(true); //torna a janela visível
    }

    //método para criar um animal baseado no tipo selecionado
    private static void criarAnimal(String tipo, JTextArea textArea) {
        if (tipo.equals("cavalo")) { //verifica se o tipo é Cavalo
            Cavalo cavalo = new Cavalo(1.5f, "marrom", "puro sangue arabe"); // cria um cavalo
            cavalo.comer(textArea); //chama o método de comer
            cavalo.fugir(textArea); //chama o método de fugir
        } else if (tipo.equals("leão")) { //verifica se o tipo é Leão
            Leao leao = new Leao(1.2f, "dourado", true); //leao
            leao.comer(textArea); //método comer
            leao.cacar(textArea); // caçar
        }
    }
}
