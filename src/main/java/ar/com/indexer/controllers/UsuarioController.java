package ar.com.indexer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.CodigosBO;
import ar.com.indexer.bo.UsuarioBO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.utilitis.FechaUtility;

@Controller
public class UsuarioController {
	private UsuarioDTO usuarioDTO;
	private UsuarioBO usuarioBO;
	private CodigosBO codigoBO;

	@RequestMapping("/changePasswd.htm")
	public ModelAndView cambiarContrasenia(@RequestParam String contrasenia,@RequestParam String contraseniaAntigua) {
		
		
		if(usuarioDTO.getPasswd().equals(contraseniaAntigua)){
		usuarioDTO.setPasswd(contrasenia);
		usuarioBO.actualizarPasswdUsuario(usuarioDTO);
		return new ModelAndView("usuario/cambioExito");
		}else {
			return new ModelAndView("usuario/contraseniaNoValida");	
			
			
		}

	}

	@RequestMapping("/addUser.htm")
	public @ResponseBody String addUser(UsuarioDTO usuarioDTOaCrear) {
		if(usuarioDTO.getNombreUsuario().equals("root")){
		usuarioDTO.setEnabled(true);
		usuarioDTOaCrear.setFecha_caducidad(FechaUtility.sumarFechasDias(FechaUtility.getFechaActual(), 365));
		usuarioBO.crearNuevoUsuario(usuarioDTOaCrear);
		return "Se agrego el usuario "+usuarioDTOaCrear.getNombreUsuario();
		}
		return "Error codigo 2";
		
	}
	
	
	@RequestMapping(value = "/doAgregarUsuario.htm", method = RequestMethod.POST)
	public ModelAndView agregarNuevaCuenta(
			@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
		
		usuarioDTO.setEnabled(true);
		
		
		
		usuarioBO.crearNuevoUsuario(usuarioDTO);
	
		return new ModelAndView("usuario/usuarioExito");
		
		
	}
	
	
	
	
	
	
	@RequestMapping("/existeUsuario.htm")
	public @ResponseBody String existUsername(String nombreUsuario){
		boolean existeNombreUsuario = usuarioBO.existeNombreUsuario(nombreUsuario);
		
		
		if(existeNombreUsuario){
			
			return "true";
		}else {
			return "false";
			
		}
	}
	
	
	
	@RequestMapping("/crearCuenta.htm")
	public ModelAndView crearcuenta(UsuarioDTO usuarioDTOaCrear) {
		ModelAndView mav = new ModelAndView("usuario/crearCuenta");
		
		mav.addObject("usuarioDTO",new UsuarioDTO());
		
		return mav;
		
		
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

}
