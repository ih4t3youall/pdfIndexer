package ar.com.indexer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.CodigosBO;
import ar.com.indexer.bo.UsuarioBO;
import ar.com.indexer.dominio.CodigoVerificador;
import ar.com.indexer.dto.CodigoVerificadorDTO;

@Controller
public class ClavesController {

	private CodigosBO codigosBO;
	private UsuarioBO usuarioBO;

	@RequestMapping("verificarCodigo.htm")
	public @ResponseBody
	String verificarCodigo(String codigo) {

		boolean verificarCodigo = codigosBO.verificarCodigo(codigo);

		if (verificarCodigo) {
			return "true";

		} else {

			return "false";

		}

	}

	@RequestMapping("generadorClavesPorLote.htm")
	public ModelAndView generarClavesPorLote(int dias,String tipo,int cantidad) {
		
		String claveAleatoria = generaClaveAleatoria();
		List<CodigoVerificador> listaCodigos= new ArrayList<CodigoVerificador>();
		
		int obtenerCodigoPorTipoDeUsuario = usuarioBO
				.obtenerCodigoPorTipoDeUsuario(tipo);
		
		for (int i = 0 ; i< cantidad ; i++){
		boolean flag = true;
		while (flag) {

			claveAleatoria = generaClaveAleatoria();
			flag = codigosBO.verificarCodigo(claveAleatoria);
		}
		
		CodigoVerificador codigoVerificador= new CodigoVerificador();
		codigoVerificador.setCodigo(claveAleatoria);
		codigoVerificador.setDias(dias);
		codigoVerificador.setIdTipoUsuario(obtenerCodigoPorTipoDeUsuario);
		
		listaCodigos.add(codigoVerificador);
		
		
		}
		List<CodigoVerificadorDTO> listaCodigosDTO = new ArrayList<CodigoVerificadorDTO>();
		
		for (CodigoVerificador codigoVerificador : listaCodigos) {
			
			codigosBO.agregarCodigo(codigoVerificador);
			
			CodigoVerificadorDTO codigoVerificadorDTO = new CodigoVerificadorDTO();
			codigoVerificadorDTO.setCodigo(codigoVerificador.getCodigo());
			codigoVerificadorDTO.setDias(codigoVerificador.getDias());
			codigoVerificadorDTO.setUsado(codigoVerificador.isUsado());
			codigoVerificadorDTO.setIdTipoUsuario(tipo);
			
			listaCodigosDTO.add(codigoVerificadorDTO);
			
			
		}
		
		
		ModelAndView mav = new ModelAndView("/claves/tablaDeClaves");
		mav.addObject("listaCodigosDTO",listaCodigosDTO);
		return mav;
		
		

	}
	
	
	

	@RequestMapping("generarClaves.htm")
	public ModelAndView generarClaves() {

		ModelAndView mav = new ModelAndView("claves/generarClaves");
		List<String> obtenerTiposDeusuario = usuarioBO.obtenerTiposDeusuario();
		mav.addObject("tipo_usuarios", obtenerTiposDeusuario);
		return mav;

	}

	public String generaClaveAleatoria() {

		String cadenaAleatoria = "";

		int longitud = 6;

		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while (i < longitud) {
			char c = (char) r.nextInt(255);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				cadenaAleatoria += c;
				i++;
			}
		}

		return cadenaAleatoria.toLowerCase();

	}

	@RequestMapping("generadorClave.htm")
	public @ResponseBody
	String alfanumerico(int dias, String tipo) {
		boolean flag = true;
		String cadenaAleatoria="";

		while (flag) {

			cadenaAleatoria = generaClaveAleatoria();
			flag = codigosBO.verificarCodigo(cadenaAleatoria);
		}
		int obtenerCodigoPorTipoDeUsuario = usuarioBO
				.obtenerCodigoPorTipoDeUsuario(tipo);
		
		CodigoVerificador codigoVerificador = new CodigoVerificador();
		codigoVerificador.setCodigo(cadenaAleatoria);
		codigoVerificador.setDias(dias);
		codigoVerificador.setIdTipoUsuario(obtenerCodigoPorTipoDeUsuario);
		codigosBO.agregarCodigo(codigoVerificador);

		return cadenaAleatoria;

	}

	public CodigosBO getCodigosBO() {
		return codigosBO;
	}

	public void setCodigosBO(CodigosBO codigosBO) {
		this.codigosBO = codigosBO;
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

}
