package simulador;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class PruebaSimulador {

	public static void main(String[] args) {
	    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

	    // d) Instanciar un simulador
	    SimuladorPrestamo simulador = new SimuladorPrestamo(
	            LocalDate.now(), 
	            "Mariela", 
	            100000, 
	            12
	    );

	    // e) Generar y mostrar importes
	    System.out.println("PRÉSTAMO ORIGINAL =v");
	    simulador.mostrarCuotas(); // Ya llama a generarCuotas() por dentro

	    // f) Mostrar total pagado
	    System.out.println("Total pagado: " + SimuladorPrestamo.formatearMoneda(simulador.totalPagado()) + "$");

	    // g) Cambiar monto
	    simulador.setMontoPrestamo(150000);

	    // h) Generar y mostrar importes con nuevo monto
	    System.out.println("PRÉSTAMO MODIFICADO Bv");
	    simulador.mostrarCuotas(); // Ya llama a generarCuotas() por dentro al ver la lista limpia

	    // i) Mostrar total pagado
	    System.out.println("Total pagado: " + SimuladorPrestamo.formatearMoneda(simulador.totalPagado()) + "$");
		}
	}