package Ejer3;

import java.util.Random;

public class Monitor {

	synchronized public int generarNumero() {
		return new Random().nextInt(4);
	}
	
}
