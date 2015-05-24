package ar.com.indexer.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.bo.BusquedaBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dominio.PosicionPalabra;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.dto.ConfPdfDTO;
import ar.com.indexer.dto.UsuarioDTO;
import ar.com.indexer.marcador.Marcar;
import ar.com.indexer.paginador.CortaPaginas;
import ar.com.indexer.paginador.Pruebas;

@Controller
public class PdfController {

	private CortaPaginas corta;
	private ConfPdfDTO confPdfDTO;
	private Configuracion conf;
	private UsuarioDTO usuarioDTO;
	
	private BusquedaBO busquedaBO;
	

	@RequestMapping("/peticionPDF.htm")
	public void peticionPDF(int index, String documento,int idBusqueda,String palabra) {
		
		BusquedaDTO busquedaDTO = busquedaBO.obtenerBusquedaPorId(idBusqueda);
		confPdfDTO.setDocumento(documento);
		confPdfDTO.setIndex(index);
		confPdfDTO.setBusquedaDTO(busquedaDTO);
		confPdfDTO.setPalabra(palabra);
		 
		System.out.println(confPdfDTO.getDocumento());
		System.out.println(confPdfDTO.getIndex());
		

	}

	@RequestMapping("/comodin.htm")
	public ModelAndView comodin() {

		ModelAndView mav = new ModelAndView("comodin/comodin");
		return mav;

	}

	public List<PosicionPalabra> marcarPalabras(String palabra,String inputPath) throws IOException, CryptographyException {

		Pruebas printer = null;
		try {
			int cantPaginas = 0;

			PDDocument document = null;
			try {
				File input = new File(inputPath);
				document = PDDocument.load(input);
				if (document.isEncrypted()) {
					try {
						document.decrypt("");
					} catch (InvalidPasswordException e) {
						System.err
								.println("Error: Document is encrypted with a password.");
						System.exit(1);
					}
				}
				 printer = new Pruebas(palabra);
				List allPages = document.getDocumentCatalog().getAllPages();
				cantPaginas = allPages.size();
				for (int i = 0; i < allPages.size(); i++) {
					PDPage page = (PDPage) allPages.get(i);

					System.out.println("Processing page: " + i);
					PDStream contents = page.getContents();
					if (contents != null) {
						printer.processStream(page, page.findResources(), page
								.getContents().getStream());
					}
				}
			} catch (Exception e) {

			}

			finally {
				if (document != null) {
					document.close();
				}
			}

		} catch (Exception e) {
			System.out.println("do nothing");

		}
		
		return printer.getPosicionpalPalabra();

	}

//	@RequestMapping("/prueba.htm")
//	public void nose() {
//
//		PDFHighlighter pdfh;
//		try {
//			pdfh = new PDFHighlighter();
//
//			String document = "/home/ubuntu/Escritorio/directoriosServidor/republica 4.pdf";
//			String[] nose = { "Humala" };
//			pdfh.posiciones(document, nose);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@RequestMapping("/visualizarPdf.htm")
	@ResponseBody
	public ResponseEntity<byte[]> generatePdf() throws IOException {
		PDDocument document = null;


		List<Termino> terminos = confPdfDTO.getBusquedaDTO().getTerminos();
		try {
			document = new PDDocument();
			// PDPage page = new PDPage();
			PDPage page = corta.cut(confPdfDTO);

			
			
			
			document.addPage(page);
			
			//aca guarda con nombre aleatorio e unico
			File fileOut = new File(conf.getPATH_TEMP()+usuarioDTO.getNombre()+".pdf");
			File fileIn = new File(conf.getPATH_TEMP()+usuarioDTO.getNombre()+"cut.pdf");
			
			document.save(fileIn.getAbsolutePath());
			
			LinkedList<PosicionPalabra> posicionPalabras = new LinkedList<PosicionPalabra>();
			Marcar marcar = new Marcar();
			
			
			for (Termino termino : terminos) {
				List<PosicionPalabra> listaPosicionPalabras = marcarPalabras(confPdfDTO.getPalabra(), fileIn.getAbsolutePath());
				
//				for (PosicionPalabra posicionPalabra : listaPosicionPalabras) {
					
					marcar.marcar(fileIn, fileOut, listaPosicionPalabras);
//				}
				
			}
			
//			Marcar marcar = new Marcar();
//			
//			for (PosicionPalabra posicionPalabra : posicionPalabras) {
//				
//			marcar.marcar(fileIn, fileOut, posicionPalabra);
//			}
			
			document = PDDocument.load(fileOut.getAbsolutePath());
			 page = (PDPage)document.getDocumentCatalog().getAllPages().get(0);	
			
			
			
			//aca guarda con nombre aleatorio e unico
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			document.save(baos);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "pdf"));
			headers.setContentLength(baos.toByteArray().length);
			return new ResponseEntity<byte[]>(baos.toByteArray(), headers,
					HttpStatus.CREATED);
		} catch (Exception e) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.TEXT_PLAIN);
			return new ResponseEntity<byte[]>("BROKEN".getBytes(), headers,
					HttpStatus.CREATED);
		} finally {
			if (document != null) {
//				try {
//					document.save("/home/ubuntu/Escritorio/directoriosServidor/pagina.pdf");
//				} catch (COSVisitorException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				document.close();
			}
		}
	}

	public CortaPaginas getCorta() {
		return corta;
	}

	public void setCorta(CortaPaginas corta) {
		this.corta = corta;
	}

	public ConfPdfDTO getConfPdfDTO() {
		return confPdfDTO;
	}

	public void setConfPdfDTO(ConfPdfDTO confPdfDTO) {
		this.confPdfDTO = confPdfDTO;
	}

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
		this.conf = conf;
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
	
	
	

}
