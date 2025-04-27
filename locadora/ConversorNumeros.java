package locadora;

public class ConversorNumeros {

    public int stringToInt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double stringToDouble(String numero) {
        try {
            return Double.parseDouble(numero);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
