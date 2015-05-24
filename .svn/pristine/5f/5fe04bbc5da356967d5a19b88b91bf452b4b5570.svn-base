package ar.com.indexer.objetos;

import ar.com.indexer.dominio.Resultado;

public class ResultadoEspera {

	private Resultado resultado;
	private int tiempo;
	private int numeroDeLista;
	private String palabra;


	public ResultadoEspera(Resultado resultado, int tiempo,
			String palabra) {
		super();
		this.resultado = resultado;
		this.tiempo = tiempo;
		this.palabra = palabra;
	}
	public ResultadoEspera(Resultado resultado, int tiempo) {
		this.tiempo = tiempo;
		this.resultado = resultado;

	}
	public String getPalabra() {
		return palabra;
	}
	
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	public int getNumeroDeLista() {
		return numeroDeLista;
	}
	
	public void setNumeroDeLista(int numeroDeLista) {
		this.numeroDeLista = numeroDeLista;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void decrementarTiempoEspera(){
		this.tiempo--;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}
