package actividad3;

import java.time.LocalDate;

public class PruebaEmpleado {

	public static void main(String[] args) {
		System.out.println("------ Empleado 1 ------");
		empleado empleado1 = new empleado();
		empleado1.setLegajo(100);
		empleado1.setDocumento("46645028");
		empleado1.setNombre("Santiago");
		empleado1.setFechaIngreso(LocalDate.of(2018, 5, 15));
		empleado1.setCantidadHijos(2);
		empleado1.mostrarEmpleado();
		System.out.println("### Modificamos su cantidad de hijos de 2 a 4 ");
		empleado1.modificarHijosEmpleado(4);
		empleado1.mostrarEmpleado();
		System.out.println(" ");
		System.out.println("------ Empleado 2 ------");
		empleado empleado2 = new empleado();
		empleado2.setLegajo(101);
		empleado2.setDocumento("49756135");
		empleado2.setNombre("Daniel");
		empleado2.setFechaIngreso(LocalDate.of(2012, 9, 22));
		empleado2.setCantidadHijos(0);
		empleado2.mostrarEmpleado();
		System.out.println("### Modificamos su cantidad de hijos de 0 a 1 ");
		empleado2.modificarHijosEmpleado(1);
		empleado2.mostrarEmpleado();
		System.out.println(" ");
		System.out.println("------ Empleado 3 ------");
		empleado empleado3 = new empleado();
		empleado3.setLegajo(102);
		empleado3.setDocumento("28648956");
		empleado3.setNombre("Cintia");
		empleado3.setFechaIngreso(LocalDate.of(2008, 2, 19));
		empleado3.setCantidadHijos(0);
		empleado3.mostrarEmpleado();
		System.out.println(" ");
		System.out.println("------ Empleado 4 ------");
		empleado empleado4 = new empleado();
		empleado4.setLegajo(103);
		empleado4.setDocumento("38941675");
		empleado4.setNombre("Manuel");
		empleado4.setFechaIngreso(LocalDate.of(2018, 5, 15));
		empleado4.setCantidadHijos(3);
		empleado4.mostrarEmpleado();
		System.out.println("### Modificamos su cantidad de hijos de 3 a 1 ");
		empleado4.modificarHijosEmpleado(1);
		empleado4.mostrarEmpleado();
		System.out.println(" ");
		System.out.println("------ FIN DEL PROGRAMA ------");
	}
}
