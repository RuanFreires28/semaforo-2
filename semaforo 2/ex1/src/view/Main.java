package view;

import java.util.concurrent.Semaphore;

import controller.Threads1;

public class Main 
{
	public static void main(String[] args) 	
	{
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < 20; i++)
		{
			Thread t = new Threads1(semaforo);
			t.start();
		}
		
		
	}
}
