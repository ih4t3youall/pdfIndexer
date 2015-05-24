package ar.com.indexer.dao;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.indexer.dominio.CodigoVerificador;
import ar.com.indexer.dto.CodigoVerificadorDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.rowMapper.CodigoVerificadorRowMapper;

public class CodigosDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	public boolean verfyCode(String codigo){
		
		String sql = "select * from CodigosVerificacion where codigo = ? and usado= ?";
		
		try{
		CodigoVerificador codigoVerificador = jdbcTemplate.queryForObject(sql, new Object[]{codigo,"false"},new CodigoVerificadorRowMapper());
		}catch(IncorrectResultSizeDataAccessException e){
			return false;
		}
		
		return true;
	}


	
	
	public void saveNewCode(CodigoVerificador codigoVerificadorDTO) {
		
		String sqlInsert="insert into CodigosVerificacion (codigo,dias,usado,id_tipo_usuario) values (?,?,?,?)"; 		
		jdbcTemplate.update(sqlInsert,new Object[]{codigoVerificadorDTO.getCodigo(),codigoVerificadorDTO.getDias(),"false",codigoVerificadorDTO.getIdTipoUsuario()});
		
		
	}
	public CodigoVerificador useCode(UsuarioDTO usuarioDTO){
		
		String sqlUpdate ="update CodigosVerificacion set usado = ? where codigo = ?";
		jdbcTemplate.update(sqlUpdate,new Object[]{"true",usuarioDTO.getCodigoVerificador()});
		String sql = "select * from CodigosVerificacion where codigo = ?";
		CodigoVerificador codigoVerificador = jdbcTemplate.queryForObject(sql, new Object[]{usuarioDTO.getCodigoVerificador()},new CodigoVerificadorRowMapper());
		return codigoVerificador;
	}

	public List<CodigoVerificador> getNotUsedKeys() {
		
		String sql ="select * from CodigosVerificacion where usado = ?";
		List<CodigoVerificador> listaCodigoVerificadorDTO = jdbcTemplate.query(sql, new Object[]{"false"}, new CodigoVerificadorRowMapper());
		return listaCodigoVerificadorDTO;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	
	
}
