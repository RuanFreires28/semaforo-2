package controller;

import java.util.concurrent.Semaphore;

public class Threads2 extends Thread 
{

	private Semaphore semaforo;	
	private int pessoa;
	private int corredor;
	
	public Threads2(Semaphore semaforo, int pessoa ) 
	{
		
		this.semaforo = semaforo;
		this.pessoa = pessoa;
		this.corredor = pessoa;
	}
	
	@Override
	public void run() 
	{
		Corredor();
		
		try 
		{
			semaforo.acquire();
			Porta();
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

	private void Corredor() 
	{
		System.out.println("A pessoa " + pessoa + " vai começar o trajeto pelo corredor " +  corredor);
		
		int trajeto = 0;
		
		while(trajeto<200)
		{
			int passo = (int) ((Math.random() * 3) + 4);
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			trajeto += passo;
			System.out.println("A pessoa " + pessoa + " andou " + passo + " metros, totalizando " + trajeto + " metros");
		}
		
		System.out.println("A pessoa " + pessoa + " terminou o corredor");
	}

	private void Porta() 
	{
		System.out.println("A pessoa " + pessoa + " vai abrir a porta");
		
		try {
			sleep((long)((Math.random()*1000)+1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("A pessoa " + pessoa + " passou pela porta");	
	}
}
