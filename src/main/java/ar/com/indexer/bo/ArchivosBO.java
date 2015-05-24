package ar.com.indexer.bo;

import java.sql.Date;

import ar.com.indexer.dao.ArchivosDAO;

public class ArchivosBO {
	
	private ArchivosDAO archivosDAO;
	
	
	public void listarArchivos(Date fecha){
		
		archivosDAO.listDocuments(fecha);
		
	}
	
	
	public void guardarNuevoArchivo(String documento) {
	
		archivosDAO.saveNewDocument(documento);
		
	}
	


	public ArchivosDAO getArchivosDAO() {
		return archivosDAO;
	}


	public void setArchivosDAO(ArchivosDAO archivosDAO) {
		this.archivosDAO = archivosDAO;
	}


	



	
	
}
