package ar.com.indexer.threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;

import ar.com.indexer.bo.BusquedaBO;
import ar.com.indexer.dominio.Resultado;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.objetos.ListaFrase;
import ar.com.indexer.paginador.PrintTextLocations;

public class BuscarThreads implements Runnable {

	private File file;
	private List<Termino> words;
	private LinkedList<LinkedList<String>> paginas;
	private BusquedaBO busquedaBO;
	private BusquedaDTO busquedaDTO;

	public BuscarThreads() {

	}

	public BuscarThreads(File file, BusquedaDTO busquedaDTO,
			BusquedaBO busquedaBO) {
		this.busquedaBO = busquedaBO;
		this.paginas = new LinkedList<LinkedList<String>>();
		this.busquedaDTO = busquedaDTO;
		this.file = file;
		this.words = busquedaDTO.getTerminos();
	}
	
	
	public static String sinAcentos(String input) {
	    // Cadena de caracteres original a sustituir.
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    // Cadena de caracteres ASCII que reemplazarán los originales.
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }//for i
	    return output;
	}//remove1

	public void run() {


		PDDocument document = null;
		PrintTextLocations printer = null;
		try {
			printer = new PrintTextLocations();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			File input = file;
			document = PDDocument.load(input);
			if (document.isEncrypted()) {
				try {
					document.decrypt("");
				} catch (InvalidPasswordException e) {
					System.err
							.println("Error: Document is encrypted with a password.");
					System.exit(1);
				} catch (CryptographyException e) {
					e.printStackTrace();
				}
			}

			List allPages = document.getDocumentCatalog().getAllPages();
			try {
				for (int i = 0; i < allPages.size(); i++) {
					PDPage page = (PDPage) allPages.get(i);
					System.out.println("Processing page: " + i);
					PDStream contents;
					contents = page.getContents();
					if (contents != null) {
						printer.processStream(page, page.findResources(), page
								.getContents().getStream());
					}
					paginas.add(printer.getLinkedTexto());
					printer = new PrintTextLocations();
				}
			} finally {
				if (document != null) {
					document.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		int numeroPagina = 1;

		ListaFrase listaFrase = new ListaFrase();
		List<Resultado> listaResultado = new ArrayList<Resultado>();

		for (LinkedList<String> listaPaginas : paginas) {

			int contadorPalabras = 0;
			for (String textoPagina : listaPaginas) {

				listaFrase.add(textoPagina);
				boolean contains = false;
				String palabra = "";
				for (int i = 0; i < words.size(); i++) {

					String aux = words.get(i).getPalabra().toLowerCase();
					aux = sinAcentos(aux);
					
					if (sinAcentos(textoPagina.toLowerCase()).contains(aux)) {
						contains = true;
						palabra = aux;
					}
				}

				// si estoy en una coincidencia
				if (contains) {
					boolean flag = true;
					for (Resultado resultado : listaResultado) {

						if (resultado.getPalabra().toLowerCase()
								.contains(textoPagina.toLowerCase())
								&& resultado.getPagina() == numeroPagina) {
							resultado.aumentarVecesEncontrado();
							resultado.setDocumento(this.file);

							String frase = "";
							for (int i = 1; i < listaFrase.getTotal(); i++) {
								if (contadorPalabras + i < listaPaginas.size()) {
									frase += listaPaginas.get(i
											+ contadorPalabras);
								}

							}

							resultado.addResultado(listaFrase.leerCola()
									+ frase);

							flag = false;

						}

					}

					if (flag) {

						Resultado resultado = new Resultado();
						resultado.setPagina(numeroPagina);
						resultado.setDocumento(this.file);
						resultado.aumentarVecesEncontrado();
						resultado.setPalabra(palabra);
						String frase = "";
						for (int i = 1; i < listaFrase.getTotal(); i++) {
							if (contadorPalabras + i < listaPaginas.size()) {
								frase += listaPaginas.get(i + contadorPalabras);
							}

						}
						resultado.addResultado(listaFrase.leerCola() + frase);
						listaResultado.add(resultado);

					}

				}

				contadorPalabras++;

			}

			numeroPagina++;

		}

		busquedaBO.guardarSoloResultado(busquedaDTO.getIdBusqueda(), file,
				listaResultado);

		System.out.println("thread: " + file.getAbsolutePath() + " terminado");

	}

	public BusquedaBO getBusquedaBO() {
		return busquedaBO;
	}

	public void setBusquedaBO(BusquedaBO busquedaBO) {
		this.busquedaBO = busquedaBO;
	}

}
