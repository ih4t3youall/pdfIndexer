package ar.com.indexer.paginador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

import ar.com.indexer.dominio.PosicionPalabra;

public class Pruebas extends PDFTextStripper {
	
	
	private File file;
	private String palabra;
	private String cadena = "";
	private PosicionPalabra posicionPalabra;
	private PosicionPalabra posicionPalabraAux;
	private List<PosicionPalabra> listaPosicionPalabra ;
	

    public Pruebas(String palabra) throws IOException {
		super();
//		this.file = file;
		posicionPalabra = new PosicionPalabra();
		listaPosicionPalabra = new ArrayList<PosicionPalabra>();
		posicionPalabraAux = new PosicionPalabra();
		this.palabra =palabra;
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
    

	public int probar() throws IOException, CryptographyException {

    	int cantPaginas = 0;
    	
        PDDocument document = null;
        try {
            File input = file;
            document = PDDocument.load(input);
            if (document.isEncrypted()) {
                try {
                    document.decrypt("");
                } catch (InvalidPasswordException e) {
                    System.err.println("Error: Document is encrypted with a password.");
                    System.exit(1);
                }
            }
            PrintTextLocations printer = new PrintTextLocations();
            List allPages = document.getDocumentCatalog().getAllPages();
            cantPaginas = allPages.size();
            for (int i = 0; i < allPages.size(); i++) {
                PDPage page = (PDPage) allPages.get(i);
                
                System.out.println("Processing page: " + i);
                PDStream contents = page.getContents();
                if (contents != null) {
                    printer.processStream(page, page.findResources(), page.getContents().getStream());
                }
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
        
        return cantPaginas;
        
    }
    
    public void PrintTextLocations() throws IOException {
        super.setSortByPosition(true);
    }

    /**
     * @param text The text to be processed
     */
    boolean flag = true;
    @Override
    protected void processTextPosition(TextPosition text) {
    	
    	
    	
     	if(!text.getCharacter().equals(" ")){
     		
     	if(flag){
     		flag = false;
     		
     		posicionPalabraAux.setIheight((int)text.getHeight());
     		posicionPalabraAux.setIwidth((int)text.getWidth());
     		posicionPalabraAux.setIx( (int)text.getX() );
     		posicionPalabraAux.setIy( (int)text.getY() );
     	}	
     		
    	cadena +=text.getCharacter();
    	}else {
    		
    		if(sinAcentos(cadena).toLowerCase().indexOf(sinAcentos(palabra).toLowerCase()) != -1){
    			   System.out.println("String[text x" + text.getX() + ",texty"
    		                + text.getY() + " fs=" + text.getFontSize() + " xscale="
    		                + text.getXScale() + "text height=" + text.getHeight() + " space="
    		                + text.getWidthOfSpace() + "text width="
    		                + text.getWidth() + "]" + text.getCharacter());
    			   posicionPalabra = new PosicionPalabra();
    			   posicionPalabra.setHeight((int)text.getHeight());
    			   posicionPalabra.setWidth((int)text.getWidth());
    			   posicionPalabra.setX( (int)text.getX() );
    			   posicionPalabra.setY( (int)text.getY() );
    			   
    			   posicionPalabra.setIy(posicionPalabraAux.getIy());
    			   posicionPalabra.setIx(posicionPalabraAux.getIx());
    			   posicionPalabra.setIheight(posicionPalabraAux.getIheight());
    			   posicionPalabra.setIwidth(posicionPalabraAux.getIwidth());
    			   
    			   listaPosicionPalabra.add(posicionPalabra);
    		    }			
    		
    		cadena="";
    		flag = true;
    			
    		} 
    	
    		
    	}
     
    public List<PosicionPalabra> getPosicionpalPalabra(){
    	
    	return listaPosicionPalabra;
    	
    	
    }
    
}