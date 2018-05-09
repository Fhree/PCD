package Ejer2;
import java.util.LinkedList;
import java.util.Random;
import Panel.Panel;

public class Hilo extends Thread {
	private int TAMAÑOMATRIZ = 10;
	
	private int[][] matrizA;
	private int[][] matrizB;
	private int[][] matrizC;
	private String nombreObjeto;
	private LinkedList<String> panelesUsados = new LinkedList<>();
	
	public Hilo(String nombre) {
		nombreObjeto = nombre;
	}
	
	public String getNombre() {
		return nombreObjeto;
	}
	
	public String getPanelesUsados() {
		String out = "";
		for (String item : panelesUsados) {
			out += item+", ";
		}
		return out;
	}
	
	public String getMatrizA() {
		String out = "";
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				out += matrizA[i][j]+" ";
			}
			out += "\n\t";
		}
		return out;
	}
	
	public String getMatrizB() {
		String out = "";
		for (int i = 0; i < matrizB.length; i++) {
			for (int j = 0; j < matrizB[i].length; j++) {
				out += matrizB[i][j]+" ";
			}
			out += "\n\t";
		}
		return out;
	}
	
	public String getMatrizC() {
		String out = "";
		for (int i = 0; i < matrizC.length; i++) {
			for (int j = 0; j < matrizC[i].length; j++) {
				out += matrizC[i][j]+" ";
			}
			out += "\n\t";
		}
		return out;
	}
	
	public void crearMatrices() {
		matrizA = new int[TAMAÑOMATRIZ][TAMAÑOMATRIZ];
		matrizB = new int[TAMAÑOMATRIZ][TAMAÑOMATRIZ];
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				matrizA[i][j] = new Random().nextInt(10);
				matrizB[i][j] = new Random().nextInt(10);
			}
		}
	}
	
	public void suma() {
		matrizC = new int[TAMAÑOMATRIZ][TAMAÑOMATRIZ];
		for (int x = 0; x < matrizA.length; x++) {
			for (int y = 0; y < matrizA[x].length; y++) {
				matrizC[x][y] = matrizA[x][y] + matrizB[x][y];
			}
		}

	}
	
	public String escribir() {
		return "Usando panel el hilo: " + getNombre()
			  +"\nMatriz A = \t" + getMatrizA()
			  +"\nMatriz B = \t" + getMatrizB()
			  +"\nMatriz C = \t" + getMatrizC()
			  +"\nTerminando de usar el panel el hilo: "+ getNombre(); 
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			Panel panel = null;
			crearMatrices();
			suma();
			try {
				MainSemaforos.semaforoGeneral.acquire();
				panel = MainSemaforos.panelesDisponibles.removeFirst();
			} catch (Exception e) {
				e.printStackTrace();
			}
			panel.escribir_mensaje(escribir());
			MainSemaforos.panelesDisponibles.add(panel);
			//ELIMINAR LA DE ABAJO
			panelesUsados.add(panel.getNombre());
			MainSemaforos.semaforoGeneral.release();
		}
		//ELIMINAR LA DE ABAJO
		System.out.println("El hilo: "+ nombreObjeto + " ha terminado y :"+getPanelesUsados());
	}
}
