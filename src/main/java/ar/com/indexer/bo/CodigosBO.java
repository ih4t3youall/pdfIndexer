package ar.com.indexer.bo;

import java.util.ArrayList;
import java.util.List;

import ar.com.indexer.dao.CodigosDAO;
import ar.com.indexer.dominio.CodigoVerificador;
import ar.com.indexer.dto.CodigoVerificadorDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.utilitis.FechaUtility;

public class CodigosBO {

	
	private CodigosDAO codigosDAO;
	private UsuarioBO usuarioBO;
	
	public void agregarCodigo(CodigoVerificador codigoVerificadorDTO){
		
		
		codigosDAO.saveNewCode(codigoVerificadorDTO);
		
		
	}
	
	
	public boolean verificarCodigo(String codigo){
		
		return codigosDAO.verfyCode(codigo);
		
	}
	
	public void usarCodigo(UsuarioDTO usuarioDTO){
		
		CodigoVerificador codigoVerificador = codigosDAO.useCode(usuarioDTO);
		
		String tipo_usuario = usuarioBO.obtenerTipoDeUsuarioPorCodigo(codigoVerificador);
		
		usuarioDTO.setFecha_caducidad(FechaUtility.sumarFechasDias(FechaUtility.getFechaActual(), codigoVerificador.getDias()));
		usuarioDTO.setTipo_usuario(tipo_usuario);
		usuarioDTO.setCodigoVerificador(null);
		usuarioBO.crearNuevoUsuario(usuarioDTO);
		
		
	}



	public List<CodigoVerificadorDTO> obtenerClavesNoUtilizadas() {
	List<CodigoVerificador> notUsedKeys = codigosDAO.getNotUsedKeys();
	
	List<CodigoVerificadorDTO> listaCodigoVerificadorDTO = new ArrayList<CodigoVerificadorDTO>();
	for (CodigoVerificador codigoVerificador : notUsedKeys) {
		
		CodigoVerificadorDTO codigoVerificadorDTO = new CodigoVerificadorDTO();
		codigoVerificadorDTO.setCodigo(codigoVerificador.getCodigo());
		codigoVerificadorDTO.setDias(codigoVerificador.getDias());
		
		String obtenerTipoDeUsuarioPorCodigo = usuarioBO.obtenerTipoDeUsuarioPorCodigo(codigoVerificador);
		codigoVerificadorDTO.setIdTipoUsuario(obtenerTipoDeUsuarioPorCodigo);
		codigoVerificadorDTO.setUsado(codigoVerificador.isUsado());
		listaCodigoVerificadorDTO.add(codigoVerificadorDTO);
		
	}
	
	
	return listaCodigoVerificadorDTO;
		
	}
	

	public CodigosDAO getCodigosDAO() {
		return codigosDAO;
	}


	public void setCodigosDAO(CodigosDAO codigosDAO) {
		this.codigosDAO = codigosDAO;
	}


	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}


	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	
}
