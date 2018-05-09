package Ejer1;

public class HiloSuma extends Thread{

	private Matriz matrizCompartida;
	
	public HiloSuma(Matriz matrizCompartida) {
		this.matrizCompartida = matrizCompartida;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			matrizCompartida.suma(matrizCompartida);
		}
	}
}
