package view;

import java.util.concurrent.Semaphore;

import controller.Threads3;

public class Main3 
{
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore(1);
		
	
		for (int i = 0; i<20; i++)
		{
			int saldo = (int) (Math.random() * 5000);
			int conta = (int) (Math.random() * 10);
			int valor = (int) (Math.random() * 3000);
			
			Thread t = new Threads3(i, conta, saldo, valor, semaforo,semaforo2);
			t.start();
		}
	}
}
