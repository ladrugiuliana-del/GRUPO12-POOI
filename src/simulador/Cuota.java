package simulador;


public class Cuota {

    private int numero;
    private double interes;
    private double importeCuota;
    private double saldo;

    public Cuota(int numero, double interes, double importeCuota, double saldo) {
        this.numero = numero;
        this.interes = interes;
        this.importeCuota = importeCuota;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public double getInteres() {
        return interes;
    }

    public double getImporteCuota() {
        return importeCuota;
    }

    public double getSaldo() {
        return saldo;
    }

}
