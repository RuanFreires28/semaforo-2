package view;

import java.util.concurrent.Semaphore;

import controller.Thread4;

public class Main4 
{

	public static void main(String[] args) 
	{
		
		Semaphore s1 = new Semaphore(5);
		Semaphore s2 = new Semaphore(1);
		
		for(int e = 0; e < 7; e++)
		{
			for (int carro = 1; carro < 3; carro++)
			{
				Thread t = new Thread4(e + 1, carro, s1, s2);
				t.start();
			}
		}
	}
}
