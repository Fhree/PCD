package Ejer1;

import java.util.concurrent.locks.ReentrantLock;

public class Matriz {

	private int[][] matriz;
	private ReentrantLock lock;

	public Matriz(int valor) {
		matriz = new int[3][3];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = valor;
			}
		}
		lock = new ReentrantLock();
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public Matriz suma(Matriz variableCompartida) {
		Matriz resul = new Matriz(0);
		lock.lock();
		try {
			for (int x = 0; x < variableCompartida.getMatriz().length; x++) {
				for (int y = 0; y < variableCompartida.getMatriz()[x].length; y++) {
					resul.matriz[x][y] = variableCompartida.getMatriz()[x][y] + variableCompartida.getMatriz()[x][y];
				}
			}
		} finally {
			lock.unlock();
		}
		System.out.println("Suma :\n"+resul.toString());
		return resul;
	}
	
	public Matriz multiplicacion(Matriz variableCompartida) {
		Matriz resul = new Matriz(0);
		lock.lock();
		try {
			for (int i = 0; i < variableCompartida.matriz.length; i++) {
	            for (int j = 0; j < variableCompartida.matriz[i].length; j++) {
	                for (int k = 0; k < variableCompartida.matriz[0].length; k++) {
	                    resul.matriz[i][j] += variableCompartida.matriz[i][k] * variableCompartida.matriz[k][j];
	                }
	            }
	        }
		} finally {
			lock.unlock();
		}
		System.out.println("Multiplicacion :\n"+resul.toString());
		return resul;
	}
	
	@Override
	public String toString() {
		return matriz[0][0]+" "+matriz[0][1]+" "+matriz[0][2]+"\n"+
			   matriz[1][0]+" "+matriz[1][1]+" "+matriz[1][2]+"\n"+
			   matriz[2][0]+" "+matriz[2][1]+" "+matriz[2][2];
	}
}
