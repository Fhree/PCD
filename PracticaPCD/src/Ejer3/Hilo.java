package Ejer3;
import java.util.Random;

public class Hilo extends Thread{

		private int SEEDTIME = 10000;
	
		private int numSeleccionado;
		
		private void generarNumero() {
			numSeleccionado = new Random().nextInt(4);
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(SEEDTIME));
			} catch (Exception e) {
				e.printStackTrace();
			}
			generarNumero();
			try {
				Thread.sleep(new Random().nextInt(SEEDTIME));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
