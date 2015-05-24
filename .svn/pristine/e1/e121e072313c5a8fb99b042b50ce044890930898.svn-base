package ar.com.indexer.dao;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.indexer.dominio.ArchivoBusqueda;
import ar.com.indexer.dominio.Busqueda;
import ar.com.indexer.dominio.Resultado;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.dto.BusquedasRestantesDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.rowMapper.ArchivoRowMapper;
import ar.com.indexer.rowMapper.BusquedaRowMapper;
import ar.com.indexer.rowMapper.BusquedasRestantesDTORowMapper;
import ar.com.indexer.rowMapper.ResultadoRowMapper;
import ar.com.indexer.rowMapper.TerminoRowMapper;
import ar.com.indexer.utilitis.FechaUtility;

public class BusquedaDAO {

	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void nuevaBusqueda(BusquedaDTO busquedaDTO) {
		String sql = "INSERT INTO busquedas (fecha,users_USER_ID,tipo_busqueda) values (now(),?,?)";

		jdbcTemplate.update(sql,
				new Object[] { busquedaDTO.getUsuarioDTO().getIdUsuario(),
						busquedaDTO.getTipoBusqueda() });
		busquedaDTO.setIdBusqueda(jdbcTemplate
				.queryForInt("select last_insert_id()"));

	}

	public void saveTerms(List<Termino> terminos) {

		for (Termino termino : terminos) {
			String sql = "insert into terminos (idbusqueda,termino) values (?,?)";
			jdbcTemplate.update(sql, new Object[] { termino.getIdBusqueda(),
					termino.getPalabra() });

		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void guardarSoloResultado(int idBusqueda, File file,
			List<Resultado> listaResultado) {

		String sql = "insert into archivos (busqueda_idBusqueda,archivo ,fechaInclucion) values (?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { idBusqueda, file.getAbsolutePath(), null });

		int idArchivo = jdbcTemplate.queryForInt("select last_insert_id()");

		for (Resultado resultado : listaResultado) {
			String sqlResultados = "insert into resultado (pagina,archivo,veces_encontrada,resultado,archivo_idArchivo,palabra) values (?,?,?,?,?,?)";

			List<String> resultado2 = resultado.getResultado();
			String stringResultado = "";
			for (String string : resultado2) {
				stringResultado += string;
				stringResultado += " // ";

			}

			Object[] parametros = new Object[] { resultado.getPagina(),
					resultado.getDocumento().getAbsolutePath(),
					resultado.getVecesEncontrado(), stringResultado, idArchivo,
					resultado.getPalabra() };

			jdbcTemplate.update(sqlResultados, parametros);
		}

	}

	public List<BusquedaDTO> getBusquedaByUserId(UsuarioDTO usuarioDTO) {

		List<BusquedaDTO> listaBusquedasDTO = new ArrayList<BusquedaDTO>();

		String sql = "select * from busquedas where busquedas.users_USER_ID = ?";
		List<Busqueda> listaDeBusquedas = jdbcTemplate.query(sql,
				new Object[] { usuarioDTO.getIdUsuario() },
				new BusquedaRowMapper());

		for (Busqueda busqueda : listaDeBusquedas) {
			BusquedaDTO busquedaDTO = new BusquedaDTO();
			busquedaDTO.setIdBusqueda(busqueda.getIdBusqueda());
			busquedaDTO.setFecha(busqueda.getFecha());
			busquedaDTO.setTipoBusqueda(busqueda.getTipoBusqueda());
			sql = "select * from terminos where idBusqueda = ?";
			List<Termino> terminos = jdbcTemplate.query(sql,
					new Object[] { busqueda.getIdBusqueda() },
					new TerminoRowMapper());

			sql = "select * from archivos where busqueda_idBusqueda = ?";
			List<ArchivoBusqueda> files = jdbcTemplate.query(sql,
					new Object[] { busqueda.getIdBusqueda() },
					new ArchivoRowMapper());

			busquedaDTO.setTerminos(terminos);

			List<Resultado> resultados = new ArrayList<Resultado>();

			for (ArchivoBusqueda fileBusqueda : files) {
				sql = "select * from resultado where archivo_idArchivo= ?";
				List<Resultado> query = jdbcTemplate.query(sql,
						new Object[] { fileBusqueda.getIdArchivo() },
						new ResultadoRowMapper());
				fileBusqueda.setResultados(query);
			}

			busquedaDTO.setArchivos(files);
			listaBusquedasDTO.add(busquedaDTO);
		}
		return listaBusquedasDTO;

	}

	public BusquedaDTO recuperarBusqueda(BusquedaDTO busquedaDTO) {

		List<BusquedaDTO> listaBusquedasDTO = new ArrayList<BusquedaDTO>();

		String sql = "select * from busquedas where busquedas.idBusqueda = ?";
		Busqueda busqueda = jdbcTemplate.queryForObject(sql,
				new Object[] { busquedaDTO.getIdBusqueda() },
				new BusquedaRowMapper());

		busquedaDTO.setTipoBusqueda(busqueda.getTipoBusqueda());
		busquedaDTO.setFecha(busqueda.getFecha());
		sql = "select * from terminos where idBusqueda = ?";
		List<Termino> terminos = jdbcTemplate.query(sql,
				new Object[] { busqueda.getIdBusqueda() },
				new TerminoRowMapper());

		sql = "select * from archivos where busqueda_idBusqueda = ?";
		List<ArchivoBusqueda> files = jdbcTemplate.query(sql,
				new Object[] { busqueda.getIdBusqueda() },
				new ArchivoRowMapper());

		busquedaDTO.setTerminos(terminos);

		List<Resultado> resultados = new ArrayList<Resultado>();

		for (ArchivoBusqueda fileBusqueda : files) {
			sql = "select * from resultado where archivo_idArchivo= ?";
			List<Resultado> query = jdbcTemplate.query(sql,
					new Object[] { fileBusqueda.getIdArchivo() },
					new ResultadoRowMapper());
			fileBusqueda.setResultados(query);
		}

		busquedaDTO.setArchivos(files);
		listaBusquedasDTO.add(busquedaDTO);
		return busquedaDTO;

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public BusquedasRestantesDTO getBusquedasRestantes(UsuarioDTO usuarioDTO) {

		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		BusquedasRestantesDTO busquedasRestantesDTO ;
		
		String sqlTipoUsuario ="select * from tipo_usuario where tipo_nombre = ?";
		 busquedasRestantesDTO = jdbcTemplate.queryForObject(sqlTipoUsuario, new Object[]{usuarioDTO.getTipo_usuario()},new BusquedasRestantesDTORowMapper());
		
		
		GregorianCalendar calen = new GregorianCalendar();
		cal.setTime(sqlDate);

		String sqlDiarias = "select count(*) from busquedas inner join terminos on busquedas.idBusqueda = terminos.idBusqueda where fecha = ? and busquedas.users_USER_ID = ? and busquedas.tipo_busqueda = ?";
		int busquedasDiarias = jdbcTemplate.queryForInt(sqlDiarias, new Object[] {
				sqlDate.toString(), usuarioDTO.getIdUsuario(),"Diaria" });
		busquedasRestantesDTO.setDiarias(busquedasRestantesDTO.getDiarias() - busquedasDiarias);

		int restarSemana = calen.get(Calendar.DAY_OF_WEEK - 1);
		Date semanaAnterior = FechaUtility.restarFechasDias(sqlDate,
				restarSemana);

		String sqlSemanales = "select count(*) from busquedas inner join terminos on busquedas.idBusqueda = terminos.idBusqueda where fecha between ? and ? and busquedas.users_USER_ID = ? and busquedas.tipo_busqueda = 'Semanal' ";
		int busquedasSemanales = jdbcTemplate.queryForInt(
				sqlSemanales,
				new Object[] { semanaAnterior, sqlDate.toString(),
						usuarioDTO.getIdUsuario() });
		busquedasRestantesDTO.setSemanales(busquedasRestantesDTO.getSemanales() - busquedasSemanales);

		int restarMes = calen.get(Calendar.DAY_OF_MONTH - 1);
		Date mesAnterior = FechaUtility.restarFechasDias(sqlDate, restarMes);

		String sqlMensuales = "select count(*) from busquedas inner join terminos on busquedas.idBusqueda = terminos.idBusqueda where fecha between ? and ? and busquedas.users_USER_ID = ? and busquedas.tipo_busqueda = 'Mensual'";
		int busquedasMensuales = jdbcTemplate.queryForInt(
				sqlMensuales,
				new Object[] { mesAnterior, sqlDate.toString(),
						usuarioDTO.getIdUsuario() });
		busquedasRestantesDTO.setMensuales(busquedasRestantesDTO.getMensuales() - busquedasMensuales);
		
		return busquedasRestantesDTO;

	}

}
