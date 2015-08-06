package ar.com.indexer.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.indexer.dto.BcpDTO;

public class BcpDAO {
	private JdbcTemplate jdbcTemplate;
	
	
	public void saveBcp(BcpDTO bcpDTO) {
	
		
		String sql = "insert into bcp (monto,fecha,users_USER_ID,periodo_cubierto) values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{bcpDTO.getMonto(),bcpDTO.getFecha(),bcpDTO.getUser_id(),bcpDTO.getPeriodoCubierto()});
		
		
		
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
