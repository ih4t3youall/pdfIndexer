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

}
