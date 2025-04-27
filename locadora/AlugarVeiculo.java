package locadora;

public class AlugarVeiculo {
    private double valorDia;
    private int numeroDias;
    private double kilometrosRodados;
    private double valorKilometroRodado;

    public void cadastrarAluguel(double vDia, int nDias, double kmRodados, double vKilometro) {
        this.valorDia = vDia;
        this.numeroDias = nDias;
        this.kilometrosRodados = kmRodados;
        this.valorKilometroRodado = vKilometro;
    }

    public String listarAluguel() {
        return "Valor Dia: " + valorDia + " | Número Dias: " + numeroDias +
               " | KM Rodados: " + kilometrosRodados + " | Valor KM Rodado: " + valorKilometroRodado;
    }

    public double getValorDia() { return valorDia; }
    public int getNumeroDias() { return numeroDias; }
    public double getKilometrosRodados() { return kilometrosRodados; }
    public double getValorKilometroRodado() { return valorKilometroRodado; }
}
