package ar.com.indexer.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.indexer.dominio.Documento;
import ar.com.indexer.rowMapper.DocumentosRowMapper;

public class ArchivosDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	public List<Documento> listDocuments(Date fecha){
		
		
		String sql = "select * from documentos fecha_inclusion = ? ";
		List<Documento> documentos = jdbcTemplate.query(sql, new Object[]{fecha},new DocumentosRowMapper());
		
		return documentos;
		
	}

	

	public void saveNewDocument(String documento) {
	
			String sql = "insert into documentos (fecha_inclusion,path)values(now(),?)";
			jdbcTemplate.update(sql,new Object[]{documento});
		
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	
}
