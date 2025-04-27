package locadora;

public class CadastrarVeiculo {
    private String modelo;
    private int anofabri;

    public void cadastrarVeiculo(String mod, int anofabri) {
        this.modelo = mod;
        this.anofabri = anofabri;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + " | Ano de Fabricação: " + anofabri;
    }
}
