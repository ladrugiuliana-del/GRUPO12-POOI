package actividad2;

public class PruebaAuto {

    public static void main(String[] args) {
    	
    	// a. Instanciar el auto con sus valores iniciales
        Auto miAuto = new Auto("Ford", 2022, 0, false);
        
        // b. Encender y acelerar hasta 50 km/h
        miAuto.encender();
        
        // El ciclo da 5 vueltas sumando 10 km/h por cada una (5 x 10 = 50)
        for (int i = 0; i < 5; i++) {
            miAuto.acelerar();
        }
        
        miAuto.mostrarDatos();
        
        // d. Frenar el auto hasta los 20 km/h (Restamos 30 km/h en 3 vueltas)
        for (int i = 0; i < 3; i++) {
            miAuto.frenar();
        }
        
        miAuto.mostrarDatos();
        
         // e. Parar el auto a 0 km/h y restamos los 20 km restantes en 2 vueltas
        for (int i = 0; i < 2; i++) {
            miAuto.frenar();
        }
        
        miAuto.mostrarDatos();
        
        // f. Apagar el auto y mostrar el estado final
        miAuto.apagar();
        
        miAuto.mostrarDatos();
    }
}