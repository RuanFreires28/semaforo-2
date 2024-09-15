package view;

import java.util.concurrent.Semaphore;
import controller.Threads2;

public class Main2 
{
	public static void main(String[] args) 
	{
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < 4; i++)
		{
			Thread t = new Threads2(semaforo, i + 1);
			t.start();
		}
	}
}
