package ar.com.indexer.rowMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.ArchivoBusqueda;

public class StringRowMapper implements RowMapper<String> {


	@Override
	public String mapRow(ResultSet rs, int arg1) throws SQLException {
		return rs.getString("tipo_nombre");
	}

}