package simulador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Simulador de préstamo con sistema de amortización ALEMÁN.
 *
 * En este sistema la amortización de CAPITAL es siempre la misma en
 * todas las cuotas (monto / cantidadCuotas). Lo que cambia es el
 * INTERÉS (porfavor no confundir enserio xd), que se calcula sobre el saldo que va quedando. Por eso el
 * importe de la cuota va bajando mes a mes (a diferencia del sistema
 * francés, donde la cuota es siempre igual).
 */
public class SimuladorPrestamo {

    // Regla fija del banco: 60% de interés anual para todos los préstamos.
    public static final double TASA_INTERES_ANUAL = 0.60;

    private LocalDate fecha;
    private String nombreCliente;
    private double montoPrestamo;
    private int cantidadCuotas;
    private List<Cuota> cuotas;

    public SimuladorPrestamo(LocalDate fecha, String nombreCliente, double montoPrestamo, int cantidadCuotas) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.montoPrestamo = montoPrestamo;
        this.cantidadCuotas = cantidadCuotas;
        this.cuotas = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
        this.cuotas.clear(); // si cambia el monto, la tabla anterior queda obsoleta
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
        this.cuotas.clear();
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    /**
     * Genera la tabla de amortización alemana.
     */
    public List<Cuota> generarCuotas() {
        cuotas.clear();
        double tasaMensual = TASA_INTERES_ANUAL / 12;
        double amortizacionCapital = montoPrestamo / cantidadCuotas;
        double saldo = montoPrestamo;

        for (int i = 1; i <= cantidadCuotas; i++) {
            double interes = saldo * tasaMensual;
            double importeCuota = interes + amortizacionCapital;
            saldo -= amortizacionCapital;
            if (i == cantidadCuotas) {
                saldo = 0; // corrige arrastre de redondeo en la última cuota
            }
            cuotas.add(new Cuota(i, interes, importeCuota, saldo));
        }
        return cuotas;
    }

    /** a) Muestra importes de cada cuota con el formato pedido. */
    public void mostrarCuotas() {
        if (cuotas.isEmpty()) {
            generarCuotas();
        }
        System.out.println("Cliente: " + nombreCliente + "   Fecha: " + getFechaFormateada());
        System.out.println("Importe préstamo: " + formatearMoneda(montoPrestamo) + "$");
        System.out.println("Cantidad de cuotas: " + cantidadCuotas);
        System.out.println();
        System.out.printf("%-6s %-12s %-15s %-12s%n", "Cuota", "Interés", "Importe Cuota", "Saldo");
        for (Cuota c : cuotas) {
            System.out.printf("%-6d %-12s %-15s %-12s%n",
                    c.getNumero(),
                    formatearMoneda(c.getInteres()),
                    formatearMoneda(c.getImporteCuota()),
                    formatearMoneda(c.getSaldo()));
        }
    }

    /** b) Total pagado = suma de todos los importes de cuota. */
    public double totalPagado() {
        if (cuotas.isEmpty()) {
            generarCuotas();
        }
        double total = 0;
        for (Cuota c : cuotas) {
            total += c.getImporteCuota();
        }
        return total;
    }

    /** c) Total de intereses = suma de todos los intereses pagados. */
    public double totalIntereses() {
        if (cuotas.isEmpty()) {
            generarCuotas();
        }
        double total = 0;
        for (Cuota c : cuotas) {
            total += c.getInteres();
        }
        return total;
    }

    public String getFechaFormateada() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /** Formatea con coma decimal y punto de miles mas que nada para evitar que se rompa el grafico xd */
    public static String formatearMoneda(double valor) {
        return String.format(Locale.forLanguageTag("es-AR"), "%,.2f", valor);
    }
}
