package controller;

import java.util.concurrent.Semaphore;

public class Threads3 extends Thread
{

	private Semaphore semaforo;
	private Semaphore semaforo2;
	private int codConta;
	private int saldoConta;
	private int valorTransacao;
	private int transacao;
	
	
	private int op ;
	
	public Threads3(int transacao, int codConta, int saldoConta, int valorTransacao, Semaphore semaforo, Semaphore semaforo2) 
	{
		this.transacao = transacao;
		this.codConta = codConta;
		this.saldoConta = saldoConta;
		this.valorTransacao = valorTransacao;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
	}
	
	
	@Override
	public void run() 
	{
		EscolheOp();
		
		switch(op)
		{
			case 1 :
				try 
				{
					semaforo.acquire();
					Saque();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				finally
				{
				semaforo.release();
				}
				
				break;
				
			case 2:
				try 
				{
					semaforo2.acquire();
					Deposito();
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				finally
				{
				semaforo2.release();
				}
				
				break;
		}
		
		
		System.out.println("A conta " + codConta + " ficou com " + saldoConta + " reais, após a transação " + transacao);
	
		
	}


	private void EscolheOp() 
	{
		op = (int) ((Math.random()*2)+1);
		//op = 1 => saque
		//op = 2 => deposito
		
		String nomeop = "";
		
		switch(op)
		{
			case 1:
				nomeop = "saque";
				break;
			case 2 :
				nomeop = "depósito";
				break;
		}
		
		System.out.println("a transação " + transacao + " é um " + nomeop);
	}


	private void Saque() throws Exception
	{
		if(saldoConta < valorTransacao)
		{
			throw new Exception ("Saldo insuficiente para a transação " + transacao);
		}
		else
		{
			saldoConta -= valorTransacao;
			
			System.out.println("a transação " + transacao + " sacou " + valorTransacao + " da conta " + codConta);
		}
	}

	private void Deposito() 
	{
		saldoConta += valorTransacao;
		
		System.out.println("a transação " + transacao + " depositou " + valorTransacao + " na conta " + codConta);
	}
}
