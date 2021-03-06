package ar.com.indexer.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.BusquedaBO;
import ar.com.indexer.bo.UsuarioBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.dto.ConfPdfDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.exceptions.UsuarioCaducadoException;
import ar.com.indexer.formularios.FormBuscarDTO;
import ar.com.indexer.paginador.Buscador;
import ar.com.indexer.servicios.BusquedaActual;
import ar.com.indexer.utilitis.HtmlUtility;
import ar.com.indexer.utilitis.PDFHighlighter;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

@Controller
public class MainController {

	private Buscador buscador;

	private ThreadPoolTaskExecutor taskExecutor;

	public BusquedaActual busquedaActual;

	private BusquedaBO busquedaBO;

	private UsuarioBO usuarioBO;

	private UsuarioDTO usuarioDTO;

	private File file;

	private Configuracion conf;

	private ConfPdfDTO confPdfDTO;

	
    
	
	@Autowired
	private java.util.Properties properties;

	@RequestMapping("*")
	public ModelAndView main(ModelMap model) {

        
		ModelAndView mav = new ModelAndView("/inicio/index");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = auth.getName(); // get logged in username
		try {
			usuarioBO.crearUsuario(username);
		} catch (UsuarioCaducadoException e) {
			e.printStackTrace();
			auth.setAuthenticated(false);
			usuarioDTO.setEnabled(false);
			usuarioBO.altaBajaUsuario(usuarioDTO);
			return new ModelAndView("/usuario/UsuarioCaducado");

		}

		mav.addObject("username", usuarioDTO.getNombreUsuario());

		return mav;
	}

	@RequestMapping("/rectangulo.htm")
	public void rectangulo() {

		String inputPath = "/home/ubuntu/Escritorio/directoriosServidor/republica 4.pdf";
		String outPutPath = "/home/ubuntu/Escritorio/directoriosServidor/republica 7.pdf";

	}

	// a verga

	private void circle(float x, float y, PdfWriter writer) {
		PdfContentByte canvas = writer.getDirectContent();

		canvas.saveState();
		canvas.setColorStroke(GrayColor.BLACK);
		canvas.setColorFill(GrayColor.BLACK);
		canvas.circle(x, y, 2);
		canvas.fillStroke();

		canvas.restoreState();
	}

	// public void testPossition() throws DocumentException, IOException {
	// OutputStream outputStream =
	// FileUtil.openOutputStream("testPosition.pdf");
	// //this is my personal file util, but it does not anything more
	// //then creating a file and opening the file stream.
	//
	// Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	// PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	// document.open();
	//
	// markPosition(100, 100, writer);
	// document.add(new Paragraph("Total: 595 x 842 -- 72pt (1 inch)"));
	//
	// document.close();
	// outputStream.flush();
	// outputStream.close();
	// }

	private void markPosition(float x, float y, PdfWriter writer)
			throws DocumentException, IOException {
		placeChunck("x: " + x + " y: " + y, x, y, writer);
		circle(x, y, writer);
	}

	private void placeChunck(String text, float x, float y, PdfWriter writer)
			throws DocumentException, IOException {
		PdfContentByte canvas = writer.getDirectContent();
		BaseFont font = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		canvas.saveState();
		canvas.beginText();
		canvas.moveText(x, y);
		canvas.setFontAndSize(font, 9);
		canvas.showText(text);
		canvas.endText();
		canvas.restoreState();
	}

	// a verga

	@RequestMapping("/resaltar.htm")
	public void highthlight() {

		try {
			PDFHighlighter pdf = new PDFHighlighter();
			String[] args = { "Bolsa", "Bolsa" };
			pdf.posiciones(
					"/home/ubuntu/Escritorio/directoriosServidor/republica 4.pdf",
					args);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("gelow");
	}

	@RequestMapping("/welcome.htm")
	public ModelAndView printWelcome(ModelMap model) {

		ModelAndView mav = new ModelAndView("/inicio/index");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = auth.getName(); // get logged in username

		try {
			usuarioBO.crearUsuario(username);
		} catch (UsuarioCaducadoException e) {
			e.printStackTrace();
			auth.setAuthenticated(false);
			usuarioDTO.setEnabled(false);
			usuarioBO.altaBajaUsuario(usuarioDTO);
			return new ModelAndView("/usuario/UsuarioCaducado");

		}

		mav.addObject("username", usuarioDTO.getNombreUsuario());

		return mav;

	}

	@RequestMapping("/buscar")
	public ModelAndView buscar() {

		BusquedaDTO buscarDTO = new BusquedaDTO();

		ModelAndView mav = new ModelAndView("/test/buscar");
		mav.addObject("buscar", buscarDTO);

		return mav;

	}

	private String[] buscarDirectorio() {

		File[] listFiles = file.listFiles();
		String[] listStringFiles = new String[listFiles.length];

		for (int i = 0; i < listFiles.length; i++) {

			listStringFiles[i] = listFiles[i].getName();

		}

		return listStringFiles;
	}

	@RequestMapping("/buscarPorPagina")
	public ModelAndView buscarPorPagina() {

		file = new File(conf.getPATH_BASE());
		ModelAndView mav = new ModelAndView("/test/buscarPaginador");
		FormBuscarDTO buscar = new FormBuscarDTO();
		// TODO corregir
		buscar.setArchivos(buscarDirectorio());
		mav.addObject("buscar", buscar);

		return mav;
	}

	@RequestMapping("/buscarPaginasCortadas")
	public ModelAndView buscarPaginasCortadas(FormBuscarDTO formBuscarDTO,
			BindingResult result) {

		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<Termino> listaTerminos = new ArrayList<Termino>();

		usuarioDTO.getBusquedasRestantesDTO().actualizar(
				formBuscarDTO.getTipoBusqueda(),
				formBuscarDTO.getTerminos().length);

		busquedaDTO.setUsuarioDTO(usuarioDTO);
		busquedaDTO.setTipoBusqueda(formBuscarDTO.getTipoBusqueda());
		busquedaBO.iniciarBusqueda(busquedaDTO);
		busquedaDTO.setCarpetas(formBuscarDTO.getArchivos());

		String[] terminos = formBuscarDTO.getTerminos();
		for (int i = 0; i < terminos.length; i++) {
			listaTerminos.add(new Termino(terminos[i], busquedaDTO
					.getIdBusqueda()));
		}
		busquedaDTO.setTerminos(listaTerminos);

		buscador.buscarThreads(busquedaDTO, busquedaBO);
		busquedaBO.salvarTerminos(busquedaDTO.getTerminos());
		busquedaDTO = busquedaBO.obtenerBusqueda(busquedaDTO);

		List<BusquedaDTO> listaBusquedaDTO = new ArrayList<BusquedaDTO>();
		listaBusquedaDTO.add(busquedaDTO);

		ModelAndView mav = new ModelAndView("/resultados/resultadoHistorico");
		HtmlUtility html = new HtmlUtility();

		String unString = "";
		unString += html.crearTab(listaBusquedaDTO);

		mav.addObject("contenido", unString);

		return mav;

	}

	@RequestMapping("historialBusquedas.htm")
	public ModelAndView hisotiralDeBusqueda(ModelMap model) {

		List<BusquedaDTO> obtenerBusquedasPorUsuario = busquedaBO
				.obtenerBusquedasPorUsuario(usuarioDTO);

		ModelAndView mav = new ModelAndView("/resultados/resultadoHistorico");

		HtmlUtility html = new HtmlUtility();
		List<String> lista = new ArrayList<String>();

		for (BusquedaDTO busquedaDTO : obtenerBusquedasPorUsuario) {
			boolean flag = true;
			for (String date : lista) {

				if (busquedaDTO.getFecha().toString().equals(date)) {
					flag = false;
				}

			}
			if (flag) {
				lista.add(busquedaDTO.getFecha().toString());
			}

		}

		String unString = "";
		unString += html.crearTab(obtenerBusquedasPorUsuario);

		mav.addObject("contenido", unString);

		return mav;
	}

	@RequestMapping("/seleccionarArchivo")
	public ModelAndView seleccionarArchivo() {

		ModelAndView mav = new ModelAndView();

		File basefile = new File(conf.getPATH_BASE());

		File[] listFiles = basefile.listFiles();

		String string = "";
		if (listFiles.length > 0) {

			for (int i = 0; i < listFiles.length; i++) {

				string += listFiles[i].getName();
			}

		}

		mav.addObject(string);

		return mav;
	}

	public BusquedaActual getBusquedaActual() {
		return busquedaActual;
	}

	public void setBusquedaActual(BusquedaActual busquedaActual) {
		this.busquedaActual = busquedaActual;
	}

	public BusquedaBO getBusquedaBO() {
		return busquedaBO;
	}

	public void setBusquedaBO(BusquedaBO busquedaBO) {
		this.busquedaBO = busquedaBO;
	}

	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public Buscador getBuscador() {
		return buscador;
	}

	public void setBuscador(Buscador buscador) {
		this.buscador = buscador;
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

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
		this.conf = conf;
	}

	public ConfPdfDTO getConfPdfDTO() {
		return confPdfDTO;
	}

	public void setConfPdfDTO(ConfPdfDTO confPdfDTO) {
		this.confPdfDTO = confPdfDTO;
	}

}