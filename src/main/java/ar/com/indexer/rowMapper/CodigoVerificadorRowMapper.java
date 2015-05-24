package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.CodigoVerificador;

public class CodigoVerificadorRowMapper implements
		RowMapper<CodigoVerificador> {

	@Override
	public CodigoVerificador mapRow(ResultSet rs, int arg1)
			throws SQLException {

		CodigoVerificador codigoVerificador= new CodigoVerificador();

		codigoVerificador.setCodigo(rs.getString("codigo"));
		codigoVerificador.setDias(rs.getInt("dias"));
		codigoVerificador.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
		
		String usado = rs.getString("usado");
		
		if (usado.equals("true")) {

			codigoVerificador.setUsado(true);

		} else {

			codigoVerificador.setUsado(false);

		}

		return codigoVerificador;

	}

}
