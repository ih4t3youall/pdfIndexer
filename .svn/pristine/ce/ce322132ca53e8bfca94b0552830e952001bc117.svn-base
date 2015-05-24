package ar.com.indexer.marcador;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import ar.com.indexer.dominio.PosicionPalabra;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class Marcar {

	
//	public String in = "/home/ubuntu/Escritorio/directoriosServidor/republica 4.pdf";
	
	public String out = "/home/ubuntu/Escritorio/directoriosServidor/republicaNuevo.pdf";
	
	public void marcar(File fileIn,File fileOut,List<PosicionPalabra>  listaPosicionPalabra){
		
		
		 try {
//			 if(fileOut.exists()){
//				 fileOut.delete();	 
//			 }
			 
			 
			 PdfReader pdfReader = new PdfReader(fileIn.getAbsolutePath());
	            PdfStamper pdfStamper = new PdfStamper(pdfReader,
	                    new FileOutputStream(fileOut.getAbsolutePath()));
	            for(int i=1; i<= pdfReader.getNumberOfPages(); i++){
	 
	                //put content under
	                PdfContentByte content = pdfStamper.getUnderContent(i);
	                Rectangle pageSize = pdfReader.getPageSize(1);
	                content = pdfStamper.getOverContent(i);
	                content.getHorizontalScaling();
	                Graphics2D graphic = content.createGraphics(pageSize.getWidth(),pageSize.getHeight());
	                graphic.setColor(Color.RED);
	                
	                for (PosicionPalabra posicionPalabra : listaPosicionPalabra) {
						
	                	graphic.drawRect(posicionPalabra.getIx(),posicionPalabra.getY()-posicionPalabra.getHeight(), posicionPalabra.getX()-posicionPalabra.getIx(), posicionPalabra.getHeight());
					}
	                
	                
	                graphic.create();
	 
	                //Text over the existing page
	                BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
	                        BaseFont.WINANSI, BaseFont.EMBEDDED);
	                content.beginText();
	                content.setFontAndSize(bf, 18);
	                content.showTextAligned(PdfContentByte.ALIGN_LEFT,"Page No: " + i,430,15,0);
	                content.endText();
	 
	            }
	            
	            pdfReader.close();
	            pdfStamper.close();
	            
	 System.out.println("fin");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }
		
		
	}
	
	
}
