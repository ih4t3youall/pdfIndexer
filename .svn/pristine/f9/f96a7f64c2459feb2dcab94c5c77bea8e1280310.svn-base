package ar.com.indexer.pruebas;

public class PrintTask implements Runnable{
 
	String name;
	int numero;
 
	public PrintTask(String name,int numero){
		this.name = name;
		this.numero = numero;
	}
 
	@Override
	public void run() {
 
	for (int i = 0 ; i < numero ; i++){
		System.err.println(i);
	}
		System.out.println("nombre: "+this.name+" numero:"+this.numero);
	
	}
 
}