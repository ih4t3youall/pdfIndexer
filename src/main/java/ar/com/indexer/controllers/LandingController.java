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
import ar.com.indexer.dto.UsuarioTemporalDTO;

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
	public ModelAndView registroDePrueba(String passwd,String nombreUsuario,String apellido,String razonSocial,
			String ruc,String telefono,String correoElectronico){
	
		UsuarioTemporalDTO usuarioTemporalDTO = new UsuarioTemporalDTO();
		usuarioTemporalDTO.setPasswd(passwd);
		usuarioTemporalDTO.setNombreUsuario(nombreUsuario);
		usuarioTemporalDTO.setApellido(apellido);
		usuarioTemporalDTO.setRazonSocial(razonSocial);
		usuarioTemporalDTO.setRuc(ruc);
		usuarioTemporalDTO.setTelefono(telefono);
		usuarioTemporalDTO.setCorreoElectronico(correoElectronico);
		usuarioBO.guardarUsuarioTemporal(usuarioTemporalDTO);
		
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
