package simulador;

/**
 * Representa una fila de la tabla de amortización: los datos ya
 * calculados de UNA cuota puntual (interés, importe total y saldo
 * de deuda restante). Es una clase simple, sin lógica de cálculo:
 * esa lógica vive en SimuladorPrestamo.
 */
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
