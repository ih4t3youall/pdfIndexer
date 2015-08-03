package ar.com.indexer.bo;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import ar.com.indexer.dao.UsuarioDAO;
import ar.com.indexer.dominio.CodigoVerificador;
import ar.com.indexer.dto.BusquedasRestantesDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.exceptions.UsuarioCaducadoException;
import ar.com.indexer.exceptions.UsuarioException;
import ar.com.indexer.utilitis.FechaUtility;

public class UsuarioBO {

	private UsuarioDAO usuarioDAO;
	private UsuarioDTO usuarioDTO;
	private BusquedaBO busquedaBO;
	private CodigosBO codigosBO;
	
	

	public void guardarUsuarioTemporal(UsuarioDTO usuarioDTO) {
		usuarioDTO.setTemporal(true);
		usuarioDTO.setEnabled(false);
		crearNuevoUsuario(usuarioDTO);
	}

	
	public void actualizarUsuarioTemporal(UsuarioDTO usuarioDTO2) {
	
		usuarioDAO.updateTemporalUser(usuarioDTO2);
		
	}
	
	
	public void verificarUsuario(UsuarioDTO usuarioDTO) throws UsuarioException {
	
		boolean existeNombreUsuario = existeNombreUsuario(usuarioDTO.getNombreUsuario());
		
		UsuarioDTO usuarioByUsername = usuarioDAO.getUsuarioByUsername(usuarioDTO.getNombreUsuario());
		
		
		
		if (existeNombreUsuario) {
		
			
			if(usuarioByUsername.getPasswd().equals(usuarioDTO.getPasswd())){
				try{
				codigosBO.updateTemporalUser(usuarioDTO);
				}catch(EmptyResultDataAccessException e){
					throw new UsuarioException("El codigo verificador es invalido.");
				}
				
				
			}else {
				
				throw new UsuarioException("Las contrasenias no coinciden");
				
			}
			
			
			
		}else {
			throw new UsuarioException("El nombre de usuario no existe");
		}
		
		
	}
	
	
	public void altaBajaUsuario(UsuarioDTO usuarioDTOIncompleto) {
	
		
		usuarioDAO.upDownUser(usuarioDTOIncompleto);
		
	}
	
	
	public boolean existeNombreUsuario(String nombreUsuario){
		
		return  usuarioDAO.existUserName(nombreUsuario);
		
	}

	public int obtenerCodigoPorTipoDeUsuario(String tipo_usuario){
		
		return usuarioDAO.getUserCodeByType(tipo_usuario);
		
		
	}
	
	public String obtenerTipoDeUsuarioPorCodigo(CodigoVerificador codigoVerificador){
		
		return usuarioDAO.getTypeByCodeId(codigoVerificador.getIdTipoUsuario());
		
	}
	//crea el usuario para el usuarioDTO que es un objeto instancia para tener los datos de logueo
	public void crearUsuario(String username) throws UsuarioCaducadoException {

		  UsuarioDTO usuario = usuarioDAO.getUsuarioByUsername(username);
		  usuarioDTO.setFecha_caducidad(usuario.getFecha_caducidad());
		  usuarioDTO.setPasswd(usuario.getPasswd());
		  usuarioDTO.setApellido(usuario.getApellido());
		  usuarioDTO.setRazonSocial(usuario.getRazonSocial());
		  usuarioDTO.setRuc(usuario.getRuc());
		  usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		  usuarioDTO.setMail(usuario.getMail());
		  usuarioDTO.setNombre(usuario.getNombre());
		  usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
		  usuarioDTO.setTelefono(usuario.getTelefono());
		  usuarioDTO.setTipo_usuario(usuario.getTipo_usuario());
		  usuarioDTO.setTemporal(usuario.isTemporal());
		  
		  BusquedasRestantesDTO busquedasRestantes = busquedaBO.busquedasRestantes(usuarioDTO);
		  usuarioDTO.setBusquedasRestantesDTO(busquedasRestantes);
		  
		  boolean compararFechasConDate = FechaUtility.compararFechasConDate(usuarioDTO.getFecha_caducidad().toString(),FechaUtility.getFechaActual().toString());
		  
		  if(!compararFechasConDate){
			  throw new UsuarioCaducadoException();
			  
		  }
		  
	}
	
	

	public void eliminarUsuario(UsuarioDTO usuarioDTOAEliminar) {

		usuarioDAO.deleteUser(usuarioDTOAEliminar);
		
		
	}

	
	public List<UsuarioDTO> obtenerTodosLosUsuarios() {
		List<UsuarioDTO> usuariosDTO = usuarioDAO.getAllUsers();
		return usuariosDTO;
	}

	public void actualizarPasswdUsuario(UsuarioDTO usuarioDTO) {

		usuarioDAO.updateUserPasswd(usuarioDTO);
	}

	public void crearNuevoUsuario(UsuarioDTO usuarioDTO) {

		if(usuarioDTO.getCodigoVerificador() == null){
			int id = usuarioDAO.saveUsers(usuarioDTO);
			
			usuarioDAO.saveRoleUser(id);
			
		}else{
				
			codigosBO.usarCodigo(usuarioDTO);
			
		}
	}
	
	
	public List<String> obtenerTiposDeusuario(){
		
		
		return usuarioDAO.getUserTypes();
		
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}


	public BusquedaBO getBusquedaBO() {
		return busquedaBO;
	}


	public void setBusquedaBO(BusquedaBO busquedaBO) {
		this.busquedaBO = busquedaBO;
	}


	public CodigosBO getCodigosBO() {
		return codigosBO;
	}


	public void setCodigosBO(CodigosBO codigosBO) {
		this.codigosBO = codigosBO;
	}




	





	

}
