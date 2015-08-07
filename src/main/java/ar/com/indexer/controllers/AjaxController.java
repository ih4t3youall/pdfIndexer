package ar.com.indexer.controllers;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.CodigosBO;
import ar.com.indexer.bo.UsuarioBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dto.CodigoVerificadorDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.formularios.FormBuscarDTO;
import ar.com.indexer.utilitis.FechaUtility;
import ar.com.indexer.utilitis.HtmlUtility;

@Controller
public class AjaxController {

	private File file;

	private Configuracion conf;

	private UsuarioBO usuarioBO;

	private UsuarioDTO usuarioDTO;

	private CodigosBO codigosBO;
	
	private ClavesController clavesController;

	@RequestMapping("menuPrincipal.htm")
	public ModelAndView menuPrincipal(ModelMap model) {

		ModelAndView mav = new ModelAndView("/inicio/MenuPrincipal2");
		return mav;
	}

	@RequestMapping("getDatePicker.htm")
	public ModelAndView getDatePicker() {
		ModelAndView mav = new ModelAndView("complementos/fecha");
		return mav;

	}

	@RequestMapping("aceptarArchivos")
	public ModelAndView administrarArchivos() {

		ModelAndView mav = new ModelAndView("archivos/aceptarArchivos");

		FormBuscarDTO buscar = new FormBuscarDTO();
		buscar.setArchivos(buscarAceptarArchivos());
		mav.addObject("buscar", buscar);
		Date fechaActual = FechaUtility.getFechaActual();
		mav.addObject("fechaActual", fechaActual);
		return mav;

	}
	
	private String[]  buscarAceptarArchivos(){
		
		file = new File(conf.getPATH_FTP());

		File[] listFiles = file.listFiles();
		ArrayList<String> listStringFiles = new ArrayList<String>();

		for (int i = 0; i < listFiles.length; i++) {
			if (!listFiles[i].isDirectory()) {
				listStringFiles.add(listFiles[i].getName());
			}

		}

		String[] listaString = new String[listStringFiles.size()];

		for (int i = 0; i < listStringFiles.size(); i++) {
			listaString[i] = listStringFiles.get(i);

		}

		return listaString;
		
	}

	private String[] buscarCarpetas() {

		file = new File(conf.getPATH_BASE());

		File[] listFiles = file.listFiles();
		ArrayList<String> listStringFiles = new ArrayList<String>();

		for (int i = 0; i < listFiles.length; i++) {
			if (listFiles[i].isDirectory()) {
				listStringFiles.add(listFiles[i].getName());
			}

		}

		String[] listaString = new String[listStringFiles.size()];

		for (int i = 0; i < listStringFiles.size(); i++) {
			listaString[i] = listStringFiles.get(i);

		}

		return listaString;

	}

	private String[] buscarArchivos() {
		file = new File(conf.getPATH_BASE());

		File[] listFiles = file.listFiles();
		ArrayList<String> listStringFiles = new ArrayList<String>();

		for (int i = 0; i < listFiles.length; i++) {
			if (!listFiles[i].isDirectory()) {
				listStringFiles.add(listFiles[i].getName());
			}

		}

		String[] listaString = new String[listStringFiles.size()];

		for (int i = 0; i < listStringFiles.size(); i++) {
			listaString[i] = listStringFiles.get(i);

		}

		return listaString;
	}

	@RequestMapping("buscarArchivosEnCarpeta.htm")
	private @ResponseBody
	String buscarArchivos(String carpeta) {
		file = new File(conf.getPATH_BASE() + "/" + carpeta);

		File[] listFiles = file.listFiles();
		ArrayList<String> listStringFiles = new ArrayList<String>();
		if(listFiles != null){
		for (int i = 0; i < listFiles.length; i++) {
			if (!listFiles[i].isDirectory()) {
				listStringFiles.add(listFiles[i].getName());
			}

		}

		String[] listaString = new String[listStringFiles.size()];

		String respuesta = HtmlUtility.cajaArchivos(listStringFiles);

		return respuesta;
		}else {
			return "";
			
		}
	}

	@RequestMapping("buscador.htm")
	public ModelAndView buscarController(ModelMap model) {
		ModelAndView mav = new ModelAndView("/buscador/buscarPaginador");

		String hint = "data-hint-position=\"left\" data-hint=\"Seleccion personalizada | Presione ctrl+click (mantenga ctrl) para seleccionar solamente los archivos que usted desee.\"";
		FormBuscarDTO buscar = new FormBuscarDTO();
		buscar.setArchivos(buscarCarpetas());
		mav.addObject("buscar", buscar);
		mav.addObject("restantes", usuarioDTO.getBusquedasRestantesDTO());
		mav.addObject("hint", hint);

		return mav;
	}

	@RequestMapping("listarArchivos.htm")
	public ModelAndView listarArchivos() {
		ModelAndView mav = new ModelAndView("archivos/seleccionarAnio");
		FormBuscarDTO buscar = new FormBuscarDTO();
		buscar.setArchivos(buscarArchivos());
		mav.addObject("buscar", buscar);

		return mav;

	}

	@RequestMapping("upload.htm")
	public ModelAndView upload(ModelMap model) {

		ModelAndView mav = new ModelAndView("/upload/file_upload_form");
		return mav;

	}

	@RequestMapping("opciones.htm")
	public ModelAndView opciones(ModelMap model) {

		ModelAndView mav = new ModelAndView("/opciones/opciones");
		return mav;

	}

	@RequestMapping("menuTiles.htm")
	public ModelAndView menuTiles(ModelMap model) {

		ModelAndView mav = new ModelAndView("/inicio/menuTiles");
		return mav;

	}

	@RequestMapping("cambiarContrasenia.htm")
	public ModelAndView cambiarCotrasenia(ModelMap model) {

		ModelAndView mav = new ModelAndView("/usuario/cambiarContrasenia");
		return mav;

	}

	@RequestMapping("fileInput.htm")
	public ModelAndView fileInput(ModelMap model) {

		ModelAndView mav = new ModelAndView("/test/fileInput");
		return mav;

	}

	@RequestMapping("resultadoHistorico2.htm")
	public ModelAndView resultadoHistorico2() {

		ModelAndView mav = new ModelAndView("resultados/resultadoHistorico2");

		return mav;

	}

	@RequestMapping("agregarUsuario.htm")
	public ModelAndView agregarUsuario() {

		ModelAndView mav = new ModelAndView("usuario/agregarUsuario");
		List<String> obtenerTiposDeusuario = usuarioBO.obtenerTiposDeusuario();
		mav.addObject("tipo_usuarios", obtenerTiposDeusuario);
		return mav;

	}

	@RequestMapping("altaUsuario.htm")
	public ModelAndView altaUsuario() {

		List<UsuarioDTO> usuariosDTO = usuarioBO.obtenerTodosLosUsuarios();
		String boxesUsers = HtmlUtility.boxesUsers(usuariosDTO);
		ModelAndView mav = new ModelAndView("usuario/altaUsuario");
		mav.addObject("usuarios", boxesUsers);

		return mav;

	}

	@RequestMapping("actualizarEstadoUsuario.htm")
	public @ResponseBody
	String actualizarEstadoUsuario(String nombreUsuario, boolean enabled) {

		if (usuarioDTO.getNombreUsuario().equals("root")) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNombreUsuario(nombreUsuario);
			usuarioDTO.setEnabled(enabled);
			usuarioBO.altaBajaUsuario(usuarioDTO);
			return "good";
		} else {

			return "bad :(";

		}

	}

	@RequestMapping("verClavesNoUtilizadas.htm")
	public ModelAndView verClavesNoUtilizadas() {

		List<CodigoVerificadorDTO> obtenerClavesNoUtilizadas = codigosBO
				.obtenerClavesNoUtilizadas();

		ModelAndView mav = new ModelAndView("/claves/tablaDeClaves");
		mav.addObject("listaCodigosDTO", obtenerClavesNoUtilizadas);
		return mav;
	}
	
	@RequestMapping("aceptarUsuariosTemporales.htm")
	public ModelAndView aceptarUsuariosTemporales(){
		List<UsuarioDTO> usuariosTemporales = usuarioBO.obtenerTodosLosUsuariosTemporales();
		ModelAndView mav =  new ModelAndView("usuariosTemporales/tablaUsuariosTemporales");
		mav.addObject("usuarioDTO",usuariosTemporales);
		return mav;
	}
	
	
	@RequestMapping("crearMailConCodigo.htm")
	public  ModelAndView crearMailconCodigo(String nombre){
		
		ModelAndView mav = new ModelAndView("usuariosTemporales/mail");
		
		String codigoVerificador = clavesController.alfanumerico(5, "estandard");
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNombreUsuario(nombre);
		usuarioDTO = usuarioBO.obtenerUsuarioPorNombreDeUsuario(usuarioDTO);
		usuarioDTO.setCodigoVerificador(codigoVerificador);
		mav.addObject("usuarioDTO",usuarioDTO);
	
		
		return mav;
		
	}
	
	

	@RequestMapping("eliminarUsuario.htm")
	public @ResponseBody
	String eliminarUsuario(String nombreUsuario) {

		if (usuarioDTO.getNombreUsuario().equals("root")) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNombreUsuario(nombreUsuario);

			usuarioBO.eliminarUsuario(usuarioDTO);
			return "good";
		} else {

			return "bad :(";

		}

	}

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
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

	public CodigosBO getCodigosBO() {
		return codigosBO;
	}

	public void setCodigosBO(CodigosBO codigosBO) {
		this.codigosBO = codigosBO;
	}

	public ClavesController getClavesController() {
		return clavesController;
	}

	public void setClavesController(ClavesController clavesController) {
		this.clavesController = clavesController;
	}
	
	

}
