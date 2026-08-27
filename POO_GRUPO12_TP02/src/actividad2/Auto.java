package actividad2;

public class Auto {
    
	//Atributos
    private String marca;
    private int modelo;
    private int velocidad;
    private boolean encendido;

    public Auto() {
    }
    
    // Constructor:recibe los datos y los guarda en el objeto
    public Auto(String marca, int mod, int vel, boolean enc) {
        this.marca = marca;
        this.modelo = mod;
        this.velocidad = vel;
        this.encendido = enc;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	
	
	
	public void encender() {
	    encendido = true;
	}
	
	//Logica
	
	//Solo acelera si el auto ya estaba encendido
	public void acelerar () {
		if(encendido== true ) {
			velocidad = velocidad + 10;
			
		}
	}
	//Evita que la velocidad baje de cero
	public void frenar() {
		if (velocidad > 0) {
			
			velocidad = velocidad -10;
		}
		
	}
	
	//Solo permite apagar el motor si el auto está detenido por completo
	
	public void apagar () {
		
		if(velocidad == 0) {
			
			encendido = false;
		}
			
	}
	
	public void mostrarDatos() {
		System.out.println(marca);
		System.out.println(modelo);
		System.out.println(velocidad);
		System.out.println(encendido);
		System.out.println("-------------------");
		
	}
	
	

}

