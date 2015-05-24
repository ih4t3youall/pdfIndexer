package ar.com.indexer.rowMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import org.springframework.jdbc.core.RowMapper;

import ar.com.indexer.dominio.Resultado;

public class ResultadoRowMapper implements RowMapper<Resultado> {

	@Override
	public Resultado mapRow(ResultSet rs, int arg1) throws SQLException {
		Resultado resultado = new Resultado();
		
		File file = new File(rs.getString("archivo"));
		resultado.setDocumento(file);
		
		resultado.setPagina(rs.getInt("pagina"));
		resultado.setVecesEncontrado(rs.getInt("veces_encontrada"));
		resultado.setIdResultado(rs.getInt("idResultado"));
		resultado.setPalabra(rs.getString("palabra"));
		String string = rs.getString("resultado");
		StringTokenizer tokens=new StringTokenizer(string, "//");
		
		while(tokens.hasMoreTokens()){
			
			resultado.addResultado(tokens.nextToken());	
			
		}
		
		
		
		resultado.setArchivo_idArchivo(rs.getInt("archivo_idArchivo"));
		return resultado;
	}

}
