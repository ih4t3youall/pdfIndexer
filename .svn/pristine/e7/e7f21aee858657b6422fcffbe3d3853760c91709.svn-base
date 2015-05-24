package ar.com.indexer.paginador;

import java.io.File;
import java.util.LinkedList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dto.ConfPdfDTO;


public class CortaPaginas {
	
	
	 private Configuracion conf;
	
	public   PDPage cut(ConfPdfDTO confPdfDTO){
		File file = new File(confPdfDTO.getDocumento());
		PDPage firstPage = null;
		PDDocument document = null;
		try {
			File input = file;
			document = PDDocument.load(input);
			firstPage = (PDPage)document.getDocumentCatalog().getAllPages().get(confPdfDTO.getIndex()-1);			
		
		}catch(Exception e){
		e.printStackTrace();
		
		}
		
		
		return firstPage;
		
	}

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
		this.conf = conf;
	}
	
	
}
