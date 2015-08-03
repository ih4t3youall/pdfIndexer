package ar.com.indexer.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.indexer.dominio.Busqueda;
import ar.com.indexer.dto.BusquedasRestantesDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.dto.UsuarioTemporalDTO;
import ar.com.indexer.rowMapper.BusquedaRowMapper;
import ar.com.indexer.rowMapper.BusquedasRestantesRowMapper;
import ar.com.indexer.rowMapper.StringRowMapper;
import ar.com.indexer.rowMapper.UsuarioRowMapper;

public class UsuarioDAO {

	private JdbcTemplate jdbcTemplate;

	
	
	public List<String> getUserTypes() {

		String sql ="select tipo_nombre from tipo_usuario";
		List<String> tipos_usuarios = jdbcTemplate.query(sql, new StringRowMapper());
		return tipos_usuarios;
		
	}
	public void updateTemporalUser(UsuarioDTO usuarioDTO2) {
	
		
		String sql ="update users set temporal=false,enabled=true,tipo_usuario=?,caduca=? where users.USERNAME = ?";
		jdbcTemplate.update(sql,new Object[]{usuarioDTO2.getTipo_usuario(),usuarioDTO2.getFecha_caducidad(),usuarioDTO2.getNombreUsuario()});
		
	}


	
	
	
	public void deleteUser(UsuarioDTO usuarioDTOAEliminar) {

		int id = getUsuarioByUsername(usuarioDTOAEliminar.getNombreUsuario())
				.getIdUsuario();

		String sql = "delete from user_roles where user_id = ?";
		jdbcTemplate.update(sql, new Object[] { id });
		sql = "delete from users where user_id = ?";
		jdbcTemplate.update(sql, new Object[] { id });

	}

	public void upDownUser(UsuarioDTO usuarioDTOIncompleto) {
		String sql = "update users set ENABLED = ? where USERNAME = ?";
		int enabled = 0;
		if (usuarioDTOIncompleto.isEnabled()) {
			enabled = 1;

		} else {

			enabled = 0;
		}

		jdbcTemplate
				.update(sql,
						new Object[] { enabled,
								usuarioDTOIncompleto.getNombreUsuario() });

	}

	public UsuarioDTO getUsuarioByUsername(String username) {

		String sql = " select * from users where USERNAME = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { username },
				new UsuarioRowMapper());

	}

	
	public void saveTemporalUser(UsuarioTemporalDTO usuarioTemporalDTO) {

		String sql ="insert into usuario_temporal (nombreUsuario,apellido,razonsocial,ruc,telefono,mail,passwd)values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{usuarioTemporalDTO.getNombreUsuario(),usuarioTemporalDTO.getApellido(),usuarioTemporalDTO.getRazonSocial(),
				usuarioTemporalDTO.getRuc(),usuarioTemporalDTO.getTelefono(),usuarioTemporalDTO.getCorreoElectronico(),usuarioTemporalDTO.getPasswd()});
		
		
		
	}

	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int saveUsers(UsuarioDTO usuarioDTO) {
		String sql = "insert into users (USERNAME,PASSWORD, ENABLED,nombre,apellido,razonsocial,telefono,ruc,mail,tipo_usuario,caduca,temporal) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] { usuarioDTO.getNombreUsuario(),
						usuarioDTO.getPasswd(), usuarioDTO.isEnabled(),
						usuarioDTO.getNombre(), usuarioDTO.getApellido(),
						usuarioDTO.getRazonSocial(), usuarioDTO.getTelefono(),
						usuarioDTO.getRuc(), usuarioDTO.getMail(),
						usuarioDTO.getTipo_usuario(),usuarioDTO.getFecha_caducidad(),usuarioDTO.isTemporal() });
		return jdbcTemplate.queryForInt("select last_insert_id()");

	}


	
	
	public void updateUserPasswd(UsuarioDTO usuarioDTO) {

		String sql = "update users set PASSWORD = ? where users.USER_ID = ?";

		jdbcTemplate.update(sql, new Object[] { usuarioDTO.getPasswd(),
				usuarioDTO.getIdUsuario() });

	}

	public boolean existUserName(String nombreUsuario) {

		String sql = "select * from users where username = ?";
		try {
			UsuarioDTO usuario = jdbcTemplate.queryForObject(sql,
					new Object[] { nombreUsuario }, new UsuarioRowMapper());
		} catch (IncorrectResultSizeDataAccessException e) {
			return false;
		}
		return true;

	}

	public void saveRoleUser(int id) {
		String sql = "INSERT INTO pdfindexer.user_roles (USER_ID,AUTHORITY) VALUES (?, 'ROLE_USER');";
		jdbcTemplate.update(sql, new Object[] { id });

	}

	public List<UsuarioDTO> getAllUsers() {
		String sql = "select * from users;";
		List<UsuarioDTO> usuariosDTO = jdbcTemplate.query(sql,
				new UsuarioRowMapper());
		return usuariosDTO;
	}
	
	


	public int getUserCodeByType(String tipo_usuario) {
	
		String sql ="select idTipo_usuario from tipo_usuario where tipo_nombre = ?";
		int id_tipo_usuario = jdbcTemplate.queryForInt(sql,new Object[]{tipo_usuario});
		return id_tipo_usuario;
	}
	
	public String getTypeByCodeId(int idTipoUsuario) {
	
		String sql = "select tipo_nombre from tipo_usuario where idTipo_usuario = ?";
		String tipoUsuario = jdbcTemplate.queryForObject(sql, new Object[]{idTipoUsuario},new StringRowMapper());
		
		return tipoUsuario;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}






	














	

}
