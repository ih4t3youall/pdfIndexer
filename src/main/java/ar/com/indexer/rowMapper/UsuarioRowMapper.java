package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.Usuario;
import ar.com.indexer.dto.UsuarioDTO;

public class UsuarioRowMapper implements RowMapper<UsuarioDTO> {

	public UsuarioDTO mapRow(ResultSet rs, int index) throws SQLException {
		
		UsuarioDTO usuario =  new UsuarioDTO();
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellido(rs.getString("apellido"));
		usuario.setPasswd(rs.getString("PASSWORD"));
		usuario.setNombreUsuario(rs.getString("USERNAME"));
		usuario.setEnabled(rs.getBoolean("ENABLED"));
		usuario.setIdUsuario(rs.getInt("USER_ID"));
		usuario.setTelefono(rs.getString("telefono"));
		usuario.setRuc(rs.getString("ruc"));
		usuario.setMail(rs.getString("mail"));
		usuario.setRazonSocial(rs.getString("razonsocial"));
		usuario.setTipo_usuario(rs.getString("tipo_usuario"));
		usuario.setFecha_caducidad(rs.getDate("caduca"));
		usuario.setTemporal(rs.getBoolean("temporal"));
		return usuario;
	}

}
