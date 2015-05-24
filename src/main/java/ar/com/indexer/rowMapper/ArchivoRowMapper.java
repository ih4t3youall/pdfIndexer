package ar.com.indexer.rowMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.ArchivoBusqueda;

public class ArchivoRowMapper implements  RowMapper<ArchivoBusqueda> {


	@Override
	public ArchivoBusqueda mapRow(ResultSet rs, int arg1) throws SQLException {
		ArchivoBusqueda file = new ArchivoBusqueda();
		File file2 = new File(rs.getString("archivo"));
		file.setArchivo(file2);
		file.setNombre(file2.getName());
		file.setBusqueda_idBuqueda(rs.getInt("busqueda_idBusqueda"));
		file.setFechaInclucion(rs.getDate("fechaInclucion"));
		file.setIdArchivo(rs.getInt("idArchivo"));
		return file;
	}

}
