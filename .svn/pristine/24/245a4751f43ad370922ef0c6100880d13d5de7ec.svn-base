package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.indexer.dominio.Busqueda;
import org.springframework.jdbc.core.RowMapper;

public class BusquedaRowMapper implements RowMapper<Busqueda> {

	@Override
	public Busqueda mapRow(ResultSet rs, int arg1) throws SQLException {
		Busqueda busqueda = new Busqueda();
		busqueda.setIdBusqueda(rs.getInt("idBusqueda"));
		busqueda.setFecha(rs.getDate("fecha"));
		busqueda.setTipoBusqueda(rs.getString("tipo_busqueda"));
		return busqueda;
	}

}
