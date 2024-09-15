package controller;

import java.util.concurrent.Semaphore;

public class Threads1 extends Thread
{

	private Semaphore semaforo;
	private int tid = (int)getId();
	private String sentido = "";
	
	
	public Threads1(Semaphore semaforo) 
	{
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() 
	{
		
		EscolheSentido();
		
		try 
		{
			semaforo.acquire();
			cruzamento();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
		semaforo.release();
		}
	}

	private void EscolheSentido() 
	{
		switch (tid % 4)
		{	
			case 0:
				sentido = "norte";
				break;
			case 1:
				sentido = "leste";
				break;
			case 2:
				sentido = "sul";
				break;
			case 3:
				sentido = "oeste";
				break;
		}
		
		System.out.println("o carro de id #" + tid + " segue pelo sentido " + sentido);
	}

	private void cruzamento() 
	{
		System.out.println("o carro de id #" + tid + " vai passar pelo cruzamento");
		
		try {
			sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("o carro de id #" + tid + " passou pelo cruzamento");	
	}	
	
}
