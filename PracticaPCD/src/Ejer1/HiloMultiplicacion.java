package Ejer1;

public class HiloMultiplicacion extends Thread{

	private Matriz matrizCompartida;
	
	public HiloMultiplicacion(Matriz matrizCompartida) {
		this.matrizCompartida = matrizCompartida;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			matrizCompartida.multiplicacion(matrizCompartida);
		}
	}
}
