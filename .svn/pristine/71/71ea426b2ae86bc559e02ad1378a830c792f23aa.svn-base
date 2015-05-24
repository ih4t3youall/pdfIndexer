package ar.com.indexer.paginador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class Paginador {

	private File file;
	private String word;
	private LinkedList<LinkedList<String>> paginas;
	
	public Paginador (File file,String word){
		this.file = file;
		this.word = word;
		paginas = new LinkedList<LinkedList<String>>();
	}
	
	public LinkedList<LinkedList<String>> Cortar() throws IOException, CryptographyException{
		PDDocument document = null;
		PrintTextLocations printer = new PrintTextLocations();
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
				}
			}

			List allPages = document.getDocumentCatalog().getAllPages();
			for (int i = 0; i < allPages.size(); i++) {
				PDPage page = (PDPage) allPages.get(i);
				System.out.println("Processing page: " + i);
				PDStream contents = page.getContents();
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
        
        return paginas;
		
	}
	
	
	
	
}
