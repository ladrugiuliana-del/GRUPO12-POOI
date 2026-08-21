package actividad1;

import java.time.LocalDate;
import java.util.Scanner;

public class PruebaClaseBancaria {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
        //a) Instanciar un cuenta bancaria
        //Titular=Maria Perez-Numero de Cuenta=213123 – Fecha=25/08/2023 – Saldo=1200 AR$
        CuentaBancaria cuenta = new CuentaBancaria("213123", LocalDate.of(2023, 8, 25), "Maria Perez", "HABILITADA", 1000.0);


        System.out.println("--- DEPÓSITO Y EXTRACCIÓN ---");
        
        //b) Solicitar por teclado una cantidad x de dinero para depositar en la cuenta bancaria
        System.out.println("Ingrese el monto a DEPOSITAR: ");
        double montoDeposito = scanner.nextDouble();
        cuenta.depositar(montoDeposito);
        
        //c) Mostrar el saldo actual de la cuenta
        System.out.println("Saldo actual disponible: $" + cuenta.getSaldo() + " AR$");
        
        //d) Solicitar por teclado una cantidad x de dinero para extraer de la cuenta
        System.out.print("Ingrese el monto a EXTRAER: ");
        double montoExtraccion = scanner.nextDouble();
        cuenta.extraer(montoExtraccion);

        // e) Mostrar información detallada de la cuenta
        System.out.println("Información detallada de la cuenta:");
        cuenta.mostrarInformacion();

        // f) Deshabilitar la cuenta bancaria
        System.out.println("Deshabilitando la cuenta bancaria...");
        cuenta.setEstado("DESHABILITADA");

        // g) Solicitar por teclado una cantidad x de dinero para extraer
        System.out.print("Ingrese el monto a EXTRAER (cuenta deshabilitada): ");
        montoExtraccion = scanner.nextDouble();
        cuenta.extraer(montoExtraccion);
        
        System.out.print("--- FIN DEL PROGRAMA ---");
        
        scanner.close();
        
	}

}
