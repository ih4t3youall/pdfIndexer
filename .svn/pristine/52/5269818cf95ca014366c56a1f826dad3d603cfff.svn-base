package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.Documento;
import ar.com.indexer.dominio.Resultado;

public class DocumentosRowMapper implements RowMapper<Documento> {

	@Override
	public Documento mapRow(ResultSet rs, int arg1) throws SQLException {
		Documento documento = new Documento();

		documento.setIdDocumento(rs.getInt("idDocumento"));
		documento.setFecha_inclusion(rs.getDate("fecha_inclusion"));
		documento.setUbicacion(rs.getString("ubicacion"));
		
		
		return documento;
	}

}
