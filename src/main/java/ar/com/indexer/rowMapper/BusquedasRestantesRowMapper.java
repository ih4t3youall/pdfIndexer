package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.Busqueda;

public class BusquedasRestantesRowMapper implements RowMapper<Busqueda> {

	@Override
	public Busqueda mapRow(ResultSet rs, int arg1) throws SQLException {
		Busqueda busqueda = new Busqueda();
		busqueda.setIdBusqueda(rs.getInt("idBusqueda"));
		busqueda.setFecha(rs.getDate("fecha"));
		return busqueda;
	}

}
