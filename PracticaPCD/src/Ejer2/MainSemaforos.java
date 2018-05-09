package Ejer2;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import Panel.Panel;

public class MainSemaforos {

	public static Semaphore semaforoGeneral = new Semaphore(3);
	public static Panel panel1 = new Panel("Panel 1", 200, 50);
	public static Panel panel2 = new Panel("Panel 2", 650, 50);
	public static Panel panel3 = new Panel("Panel 3", 500, 550);
	public static LinkedList<Panel> panelesDisponibles = new LinkedList<>();			
	
	
	public static void main(String[] args) {
		panelesDisponibles.add(panel1);
		panelesDisponibles.add(panel2);
		panelesDisponibles.add(panel3);
		Hilo hilo1 = new Hilo("Hilo 1");
		Hilo hilo2 = new Hilo("Hilo 2");
		Hilo hilo3 = new Hilo("Hilo 3");
		Hilo hilo4 = new Hilo("Hilo 4");
		Hilo hilo5 = new Hilo("Hilo 5");
		Hilo hilo6 = new Hilo("Hilo 6");
		Hilo hilo7 = new Hilo("Hilo 7");
		Hilo hilo8 = new Hilo("Hilo 8");
		Hilo hilo9 = new Hilo("Hilo 9");
		Hilo hilo10 = new Hilo("Hilo 10");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
		hilo9.start();
		hilo10.start();
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
			hilo6.join();
			hilo7.join();
			hilo8.join();
			hilo9.join();
			hilo10.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("fin hilo principal");
	}

}
