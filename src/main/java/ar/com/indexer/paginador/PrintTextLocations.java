package ar.com.indexer.paginador;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

public class PrintTextLocations extends PDFTextStripper {

	private LinkedList<String> linkedTexto = new LinkedList<String>();
	private int pagina;
	private int contador = 0;

	public PrintTextLocations() throws IOException {
		super.setSortByPosition(true);
	}

	/**
	 * @param text
	 *            The text to be processed
	 */
	@Override
	/* this is questionable, not sure if needed... */
	public void processTextPosition(TextPosition text) {
		// recibe una palabra exepto en los nuevos archivos , porque vienen
		// separadas las palabras
		String word = text.getCharacter();
		if (word.equals(" ")) {
			linkedTexto.add(" ");
		} else {
			linkedTexto.add(word);
		}

	}

	public LinkedList<String> getLinkedTexto() {

		LinkedList<String> linkedAux = new LinkedList<String>();
		String palabraFormada = "";
		for (int i = 0; i < linkedTexto.size(); i++) {
			
			if(!linkedTexto.get(i).equals(" ")){
				String nose = linkedTexto.get(i);
				palabraFormada+=nose;
				
				
			}else {
				linkedAux.add(palabraFormada);
				linkedAux.add(" ");
				palabraFormada="";
				
				
			}
			
			
			
		}
		
		if(linkedAux.size() == 0){
			
			
			for (String string : linkedTexto) {
				linkedAux.add(string);
				linkedAux.add(" ");
			}
			
		}
		

		return linkedAux;

	}

}