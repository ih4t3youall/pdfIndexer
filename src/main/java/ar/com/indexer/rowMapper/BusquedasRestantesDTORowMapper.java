package ar.com.indexer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dto.BusquedasRestantesDTO;

public class BusquedasRestantesDTORowMapper implements RowMapper<BusquedasRestantesDTO> {

	@Override
	public BusquedasRestantesDTO mapRow(ResultSet rs, int index) throws SQLException {
		BusquedasRestantesDTO busquedasRestantesDTO = new BusquedasRestantesDTO(); 
		busquedasRestantesDTO.setDiarias(rs.getInt("dia"));
		busquedasRestantesDTO.setSemanales(rs.getInt("semana"));
		busquedasRestantesDTO.setMensuales(rs.getInt("mes"));
		return busquedasRestantesDTO;
	}

}
