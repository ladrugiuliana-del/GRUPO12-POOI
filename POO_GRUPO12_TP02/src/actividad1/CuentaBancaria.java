package actividad1;

import java.time.LocalDate;

public class CuentaBancaria {

	String numeroCuenta;
    LocalDate fechaApertura;
    String cliente;
    String estado;
    double saldo;
    
    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, LocalDate fechaApertura, String cliente, String estado, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.cliente = cliente;
        this.estado = estado;
        this.saldo = saldo;
    }
    
    //----- MÉTODOS -----
    
    public void depositar(double importe) {
        // Validación: Solo si la cuenta está HABILITADA
        if (!"HABILITADA".equalsIgnoreCase(this.estado)) {
            System.out.println("[!] ERROR: Cuenta " + this.estado);
            return;
        }

        if (importe > 0) {
            this.saldo += importe;
            System.out.println("Depósito: $" + importe + " | Nuevo saldo: " + this.saldo + " AR$");
        } else {
            System.out.println("[!] ERROR: El depósito debe ser mayor a 0.");
        }
    }
    
    public void extraer(double importe) {
        if (!"HABILITADA".equalsIgnoreCase(this.estado)) {
        	System.out.println("[!] ERROR: Cuenta " + this.estado);
            return;
        }

        if (importe > 0 && importe <= this.saldo) {
            this.saldo -= importe;
            System.out.println(" Extracción $" + importe + " | Saldo restante: " + this.saldo + " AR$");
        } else if (importe > this.saldo) {
            System.out.println("[!] ERROR: Saldo insuficiente.");
        } else {
            System.out.println("[!] ERROR: El importe a extraer debe ser mayor a 0.");
        }
    }
    
    //Mostrar información del cliente
    public void mostrarInformacion() {
        System.out.println("Titular: " + cliente + " - Numero de Cuenta: " + numeroCuenta + " - Fecha: " + fechaApertura + " - Saldo: " + saldo + " AR$");
    }

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
