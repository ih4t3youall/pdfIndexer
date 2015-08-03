package ar.com.indexer.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.UsuarioBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.exceptions.UsuarioException;

@Controller
public class LandingController {
	
	private Configuracion conf;
	private UsuarioBO usuarioBO;

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
	
	

}
