package Ejer3;

import java.util.Random;



public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2000; i++) {
			if(new Random().nextInt(4)>=3)
				System.out.println("si");
		}
		System.out.println("f");
	}

}
