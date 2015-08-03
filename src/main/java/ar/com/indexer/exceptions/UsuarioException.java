package ar.com.indexer.exceptions;

public class UsuarioException extends Exception {

	private String mensajeAMostrar ;
	public UsuarioException(String exepcion){
		
		super(exepcion);
		mensajeAMostrar = exepcion;
	}
	
	
	public String getMensajeAMostrar(){
		
		return mensajeAMostrar;
		
	}
	
	
	
}
