import java.util.Random;

public class Controlador {

	private Vista vista;
	public Modelo modelo;
	
	public static void main(String[] args) {
		
		new Controlador();

	}
	
	public Controlador(){
		
		this.vista=new Vista(this);
		this.modelo=new Modelo();
		
		this.modelo.añadirIniciales();
		this.modelo.añadirSilabas();
		this.modelo.añadirTerminaciones();
		
	}

	public String generateRandomNick() {

		String nick="";

		int numeroSilabas=2;

		Random random = new Random();

		numeroSilabas+=random.nextInt(2);

		//añadir inicial
		int maxIniciales=this.modelo.listaIniciales.size();
		nick+=modelo.listaIniciales.get(random.nextInt(maxIniciales));

		//añadir silabas
		for (int i = 0; i < numeroSilabas; i++) {

			int maxSilabas=this.modelo.listaSilabas.size();
			nick+=modelo.listaSilabas.get(random.nextInt(maxSilabas));

		}

		//añadir terminacion
		int maxTerminaciones=this.modelo.listaTerminaciones.size();
		nick+=modelo.listaTerminaciones.get(random.nextInt(maxTerminaciones));

		return nick;
	}
	
}
