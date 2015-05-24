package ar.com.indexer.bo;

import java.io.File;
import java.sql.Date;
import java.util.List;

import ar.com.indexer.dao.BusquedaDAO;
import ar.com.indexer.dominio.Busqueda;
import ar.com.indexer.dominio.Resultado;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.dto.BusquedasRestantesDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.rowMapper.BusquedaRowMapper;

public class BusquedaBO {

	private BusquedaDAO busquedaDAO;

	
	
	
	public List<BusquedaDTO> obtenerBusquedasPorUsuario(UsuarioDTO usuarioDTO) {

		return busquedaDAO.getBusquedaByUserId(usuarioDTO);

	}

	public void guardarSoloResultado(int idBusqueda, File file,
			List<Resultado> listaResultado) {

		busquedaDAO.guardarSoloResultado(idBusqueda, file, listaResultado);

	}

	public void iniciarBusqueda(BusquedaDTO busquedaDTO) {
		this.busquedaDAO.nuevaBusqueda(busquedaDTO);

	}

	public BusquedasRestantesDTO busquedasRestantes(UsuarioDTO usuarioDTO) {

		return busquedaDAO.getBusquedasRestantes(usuarioDTO);

	}

	
	public BusquedaDTO obtenerBusquedaPorId(int id){
		
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		busquedaDTO.setIdBusqueda(id);
		return obtenerBusqueda(busquedaDTO);
		
	}
	
	public BusquedaDTO obtenerBusqueda(BusquedaDTO busquedaDTO) {

		return busquedaDAO.recuperarBusqueda(busquedaDTO);

	}

	public BusquedaDAO getBusquedaDAO() {
		return busquedaDAO;
	}

	public void setBusquedaDAO(BusquedaDAO busquedaDAO) {
		this.busquedaDAO = busquedaDAO;
	}

	public void salvarTerminos(List<Termino> terminos) {
		busquedaDAO.saveTerms(terminos);

	}

}
