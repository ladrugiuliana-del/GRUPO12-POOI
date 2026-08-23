package Actividad3;

import java.time.LocalDate;

public class empleado {
	private Integer legajo;
	private String documento;
	private String nombre;
	private Integer cantidadHijos;
	private LocalDate fechaIngreso;
	private LocalDate fechaActual = LocalDate.now();
	private Double sueldoBase = 200000.00;
	
	public Integer obtenerAntiguedad() {
		if (fechaIngreso == null) {
			return 0;
		}
		return (fechaActual.getYear() - fechaIngreso.getYear());
	}
	
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Integer getCantidadHijos() {
		return cantidadHijos;
	}
	public void setCantidadHijos(Integer cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	
	public Double getSueldoNeto() {
	    int antiguedad = obtenerAntiguedad();
	    int bonusAntiguedad = 5000 * antiguedad;
	    int bonusFamiliar = 3000 * cantidadHijos;
	    int descuentos = bonusAntiguedad * 18 / 100;
	    
	    return (sueldoBase + bonusAntiguedad + bonusFamiliar - descuentos);
	}
	
	public void mostrarEmpleado() {
		System.out.println("Legajo: " + legajo + " - Documento: " + documento + " - Nombre: " + nombre + " - Fecha de Ingreso: " + fechaIngreso + " - Cantidad de hijos: " + cantidadHijos + " - Sueldo Neto: " + getSueldoNeto());
	}
	
	public void modificarHijosEmpleado(int nuevaCantidad) {
		setCantidadHijos(nuevaCantidad);
	}
}
