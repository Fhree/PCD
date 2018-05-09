package Ejer1;

public class MainReentrantLock {

	public static void main(String[] args) {
		Matriz varCompartida = new Matriz(1);
		HiloSuma threadSuma = new HiloSuma(varCompartida);
		HiloMultiplicacion threadMultiplicacion = new HiloMultiplicacion(varCompartida);

		threadSuma.start();
		threadMultiplicacion.start();
		
		try {
			threadSuma.join();
			threadMultiplicacion.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
