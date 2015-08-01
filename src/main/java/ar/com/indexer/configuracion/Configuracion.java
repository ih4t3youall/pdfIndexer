package ar.com.indexer.configuracion;

import org.springframework.beans.factory.annotation.Value;

public class Configuracion {

	// path desarrollo
	
	@Value("${path.base}")
    private String PATH_BASE;
	// private String
	@Value("${path.temp}")
	private String PATH_TEMP;
	// fin path desarrollo
	// servidor local
	@Value("${path.ftp}")
	private String PATH_FTP;
	//path de los textos del sistema
	@Value("${path.textos}")
	private String PATH_TEXTOS;
	
	public String getPATH_TEXTOS(){
		
		return PATH_TEXTOS;
		
	}

	// fin servidor local

	public String getPATH_BASE() {
		return PATH_BASE;
	}

	public void setPATH_BASE(String PATH_BASE) {
		PATH_BASE = PATH_BASE;
	}

	public String getPATH_TEMP() {
		return PATH_TEMP;
	}

	public void setPATH_TEMP(String pATH_TEMP) {
		PATH_TEMP = pATH_TEMP;
	}
	
	public String getPATH_FTP(){
		return PATH_FTP;
		
	}

}
