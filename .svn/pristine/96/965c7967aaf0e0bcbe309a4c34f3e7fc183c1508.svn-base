package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.Termino;

public class TerminoRowMapper implements RowMapper<Termino> {

	@Override
	public Termino mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Termino termino = new Termino();
		termino.setIdTermino(rs.getInt("idTermino"));
		termino.setPalabra(rs.getString("termino"));
		
		return termino;
	}


}
