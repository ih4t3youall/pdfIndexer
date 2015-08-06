package ar.com.indexer.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.BcpBO;
import ar.com.indexer.bo.UsuarioBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dto.BcpDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.exceptions.UsuarioException;

@Controller
public class LandingController {
	
	private Configuracion conf;
	private UsuarioBO usuarioBO;
	private UsuarioDTO usuarioDTO;
	private BcpBO bcpBO;

	@RequestMapping("pruebe.htm")
	public @ResponseBody
	String pruebe() {
		String texto = "";
		try {
			texto = leerArchivo("textoPruebe.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return texto;

	}

	@RequestMapping("pruebeDerecha.htm")
	public @ResponseBody
	String pruebeDerecha() {
		String texto = "";
		try {
			texto = leerArchivo("textoPruebeDerecha.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return texto;

	}
	
	@RequestMapping("regristoConBcp.htm")
	public ModelAndView registroConBcp(String passwd,String nombreUsuario,String nombre,String apellido,String razonSocial,
			String ruc,String telefono,String correoElectronico,String bcp){
	
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setPasswd(passwd);
		usuarioDTO.setNombreUsuario(nombreUsuario);
		usuarioDTO.setNombre(nombre);
		usuarioDTO.setApellido(apellido);
		usuarioDTO.setRazonSocial(razonSocial);
		usuarioDTO.setRuc(ruc);
		usuarioDTO.setTelefono(telefono);
		usuarioDTO.setMail(correoElectronico);
		usuarioDTO.setBcp(new BcpDTO(bcp));
		int idUsuario = usuarioBO.guardarUsuarioTemporal(usuarioDTO);
		usuarioDTO.getBcp().setUser_id(idUsuario);
		
		bcpBO.guardarBcp(usuarioDTO.getBcp());
		ModelAndView mav = new ModelAndView("fueraLogin/registroConBcpExitoso");
		return mav;
		
	}
	
	
	@RequestMapping("compre.htm")
	public ModelAndView compre(){
		ModelAndView mav = new ModelAndView("fueraLogin/crearCuentaCuentaExistente");
		mav.addObject("usuarioDTO",new UsuarioDTO());
		
		
		return mav;
		
	}
	
	
	public void verificarUsuarioDTO(UsuarioDTO usuarioDTO) throws UsuarioException{
		
		
		if(usuarioBO.existeNombreUsuario(usuarioDTO.getNombreUsuario())){
			
			throw new UsuarioException("El usuario ya existe");
			
		}
		
//		codi
		
	}
	
	@RequestMapping("/registroDePrueba.htm")
	public ModelAndView registroDePrueba(String passwd,String nombreUsuario,String nombre,String apellido,String razonSocial,
			String ruc,String telefono,String correoElectronico){
	
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setPasswd(passwd);
		usuarioDTO.setNombreUsuario(nombreUsuario);
		usuarioDTO.setNombre(nombre);
		usuarioDTO.setApellido(apellido);
		usuarioDTO.setRazonSocial(razonSocial);
		usuarioDTO.setRuc(ruc);
		usuarioDTO.setTelefono(telefono);
		usuarioDTO.setMail(correoElectronico);
		try {
			verificarUsuarioDTO(usuarioDTO);
		} catch (UsuarioException e) {
			ModelAndView mav =new ModelAndView("fueraLogin/error");
			mav.addObject("error",e.getMensajeAMostrar());
			return mav;
		}
		usuarioBO.guardarUsuarioTemporal(usuarioDTO);
		
		ModelAndView mav = new ModelAndView("fueraLogin/registroTemporalExito");
		
		return mav;
		
	}
	

	public  String leerArchivo(String archivo)
			throws FileNotFoundException, IOException {
		String cadena;

		FileReader f = new FileReader(conf.getPATH_TEXTOS() + archivo);
		BufferedReader buffer = new BufferedReader(f);
		String texto = "";
		while ((cadena = buffer.readLine()) != null) {
			texto += cadena;
		}
		buffer.close();
		return texto;
	}
	@RequestMapping("pedirClave.htm")
	public ModelAndView pedirClave(){
		ModelAndView mav = new ModelAndView("fueraLogin/formularioPedirClave");
		
		return mav;
	}
	
	@RequestMapping("crearCuentaConClaveLogin.htm")
	public ModelAndView crearCuentaConClaveLogin(){
		ModelAndView mav = new ModelAndView("fueraLogin/crearCuentaFueraLogin");
		mav.addObject("usuarioDTO",new UsuarioDTO());
		return mav;
		
	}
	
	@RequestMapping("crearCuentaConClave.htm")
	public ModelAndView crearCuentaConClave(UsuarioDTO usuarioDTO){
		
		
		try {
			usuarioBO.verificarUsuario(usuarioDTO);
		} catch (UsuarioException e) {
			
			ModelAndView mav = new ModelAndView("fueraLogin/error");
			mav.addObject("error",e.getMensajeAMostrar());
			return mav;
		}
		
		ModelAndView mav =new ModelAndView("fueraLogin/exito");
		
		return mav;
		
	}
	

	public  Configuracion getConf() {
		return conf;
	}

	public  void setConf(Configuracion conf) {
		this.conf = conf;
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public BcpBO getBcpBO() {
		return bcpBO;
	}

	public void setBcpBO(BcpBO bcpBO) {
		this.bcpBO = bcpBO;
	}
	
	
	
	
	

}
