package ar.com.indexer.servicios;

import java.util.LinkedList;

public class BusquedaActual {

	int total = 0;
	int threadTerminados = 0;
	private LinkedList<String> resultados = new LinkedList<String>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getThreadTerminados() {
		return threadTerminados;
	}

	public void setThreadTerminados(int threadTerminados) {
		this.threadTerminados = threadTerminados;
	}

	public LinkedList<String> getResultados() {
		return resultados;
	}

	public void setResultados(LinkedList<String> resultados) {
		this.resultados = resultados;
	}

	public  boolean threadsTerminados(){
		return (total == threadTerminados);
		
		
	}
	
	public  void  terminoTrhead(){
		threadTerminados++;
		
	}
	
}
