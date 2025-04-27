package locadora;

public class CustoAluguelVeiculo {
    private double totalAluguel;

    public void calcularAluguel(AlugarVeiculo a) {
        totalAluguel = (a.getValorDia() * a.getNumeroDias()) + 
                       (a.getKilometrosRodados() * a.getValorKilometroRodado());
    }

    public double getTotalAluguel() {
        return totalAluguel;
    }
}
