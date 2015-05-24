package ar.com.indexer.dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Resultado {

	private int idResultado;
	private List<String> resultado;
	private String palabra;
	private File documento;
	private int pagina;
	private int vecesEncontrado;
	private int archivo_idArchivo;

	public Resultado(){
		this.vecesEncontrado = 0;
	}
	
	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public void aumentarVecesEncontrado() {
		
		this.vecesEncontrado++;
	}

	public int getArchivo_idArchivo() {
		return archivo_idArchivo;
	}

	public void setArchivo_idArchivo(int archivo_idArchivo) {
		this.archivo_idArchivo = archivo_idArchivo;
	}

	public File getDocumento() {
		return documento;
	}

	public void setDocumento(File documento) {
		this.documento = documento;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public int getVecesEncontrado() {
		return vecesEncontrado;
	}

	public void setVecesEncontrado(int vecesEncontrado) {
		this.vecesEncontrado = vecesEncontrado;
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public List<String> getResultado() {
		return resultado;
	}

	public void addResultado(String resultado) {
		if(this.resultado == null){
			this.resultado=new ArrayList<String>();
		}
		this.resultado.add(resultado);
	}


}
