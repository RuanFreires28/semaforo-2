package controller;

import java.util.concurrent.Semaphore;

import br.fateczl.calc.quicksort.operations;

public class Thread4 extends Thread 
{

	operations op = new operations();
	
	private Semaphore s1;
	private Semaphore s2;
	private int escuderia;
	private int carro;
	
	
	
	static private int[] grid = new int[14];
	static private int indice = 0;
	private int melhorVolta = 0;
	private int volta = 1;
	
	
	public Thread4(int escuderia, int carro, Semaphore s1, Semaphore s2)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.escuderia = escuderia;
		this.carro = carro;
	}
	
	@Override
	public void run() 
	{
		while (volta<=3)
		{
			switch (escuderia % 7)
			{
				case 0:
					Pista();
					break;
				case 1:
					Pista();
					break;
				case 2:
					Pista();
					break;
				case 3:
					Pista();
					break;
				case 4:
					Pista();
					break;
				case 5:
					Pista();
					break;
				case 6:
					Pista();
					break;
			}
		}
		
		grid[indice] = melhorVolta;
		indice++;
		
		if (indice == 14)
		{
			grid = op.QuickSort(grid, 0, 13);
			
			for( int i : grid)
			{
				System.out.print(i + " ");
			}
		}
		
	}

	private void Pista() 
	{
				try 
				{
					s1.acquire();
					s2.acquire();
					Volta();
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				finally
				{
				s2.release();
				s1.release();
				}
			
		
	}
	
	private void Volta() 
	{
		int tempoVolta = (int)((Math.random()*40)+10);
		
		try {
			sleep(tempoVolta);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("o carro " + carro + "da escuderia " + escuderia + " fez a volta " + volta + " em " + tempoVolta + "s");
		
		if (melhorVolta == 0)
		{
			melhorVolta = tempoVolta;
		}
		else if (melhorVolta > tempoVolta)
		{
			melhorVolta = tempoVolta;
		}
		
		volta++;
	}
	
	
	
	
}
