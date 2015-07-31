package ar.com.indexer.controllers;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.ArchivosBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.utilitis.FechaUtility;

@Controller
public class ArchivosController {

	private File file;
	private Configuracion conf;
	private ArchivosBO archivosBO;

	@RequestMapping("agregarFechaHoy.htm")
	public ModelAndView agregarFechaHoy(String documento) {

		ModelAndView mav = new ModelAndView();

		archivosBO.guardarNuevoArchivo(documento);

		FechaUtility.getFechaActual();

		return mav;

	}

	@RequestMapping("agregarFechaADocumento.htm")
	public  @ResponseBody String  agregarFechaADocumento( String documento,String fecha) {

		

		boolean existeDirectorio = existeDirectorio(fecha);
		if (fecha == "") {
			fecha = FechaUtility.getFechaActual().toString();
		}
		fecha = fecha.replace("/", "-");
		File pathArch = pathAbsolutoDelArchivo(documento);

		if (existeDirectorio) {

			agregarAlDirectorio(pathArch, fecha);

		} else {

			crearDirectorio(pathArch, fecha);

		}

		archivosBO.guardarNuevoArchivo(documento);

		FechaUtility.getFechaActual();
		return "un texto";

	}
	
	
	@RequestMapping ("agregarDocumentosExito.htm")
	public ModelAndView agregarDocumentosExito(){
		ModelAndView mav = new ModelAndView("archivos/adicionDeArchivoExitosa");
		return mav;
		
		
	} 
	
	
	
	

	private void crearDirectorio(File documento, String fecha) {
		File file = new File(conf.getPATH_BASE() + fecha);
		file.mkdir();
		documento.renameTo(new File(conf.getPATH_BASE() + fecha + "/"
				+ documento.getName()));

	}

	private File pathAbsolutoDelArchivo(String documento) {
		File[] listFiles = new File(conf.getPATH_FTP()).listFiles();
		File doc = null;
		
		for (File file : listFiles) {
			if (file.getName().equals(documento)) {

				doc = file;

			}
		}

		return doc;

	}

	private void agregarAlDirectorio(File documento, String fecha) {

		documento.renameTo(new File(conf.getPATH_BASE() + fecha + "/"
				+ documento.getName()));

	}

	private boolean existeDirectorio(String directorio) {
		file = new File(conf.getPATH_BASE());
		File[] listFiles = file.listFiles();
		ArrayList<String> listStringFiles = new ArrayList<String>();
		boolean flag = false;
		for (int i = 0; i < listFiles.length; i++) {
			if (listFiles[i].getName().equals(directorio)) {
				flag = true;
			}

		}

		return flag;

	}

	private String[] buscarDirectorio() {
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

	public ArchivosBO getArchivosBO() {
		return archivosBO;
	}

	public void setArchivosBO(ArchivosBO archivosBO) {
		this.archivosBO = archivosBO;
	}

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
		this.conf = conf;
	}

}
