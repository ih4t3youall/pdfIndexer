package ar.com.indexer.paginador;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import ar.com.indexer.configuracion.Configuracion;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class FotoPagina {

	private Configuracion conf;
	private LinkedList<Integer> lista;
	private File file;
	
//	private String ARCHIVOS_TEMBOPRALES = "/Users/martinLequerica/proyectos java/workspacePdfIndexer/SpringMVC/src/main/webapp/resources/tmp/";
	
	
	public FotoPagina(File file,LinkedList<Integer> lista) {
		
		this.lista = lista;
		this.file = file;

	}

	public LinkedList<String> convert() throws Exception {
		// load a pdf from a file
		LinkedList<String> listaImagenes =new LinkedList<String>();
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		FileChannel channel = raf.getChannel();
		ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0,
				channel.size());
		PDFFile pdffile = new PDFFile(buf);
		// get number of pages
		// iterate through the number of pages
		
		for (Integer numeroPagina : this.lista) {
			
			PDFPage page = pdffile.getPage(numeroPagina);
			Rectangle rect = new Rectangle(0, 0, (int) page.getBBox()
					.getWidth(), (int) page.getBBox().getHeight());
			Image img = page.getImage(rect.width, rect.height, // width & height
					rect, // clip rect
					null, // null for the ImageObserver
					true, // fill background with white
					true // block until drawing is done
					);
			BufferedImage bufferedImage = new BufferedImage(rect.width,
					rect.height, BufferedImage.TYPE_INT_RGB);
			Graphics g = bufferedImage.createGraphics();
			g.drawImage(img, 0, 0, null);
			g.dispose();
			File imagen = new File(conf.getPATH_BASE()+file.getName()+"-"+ numeroPagina + ".jpg");
			imagen.createNewFile();
			listaImagenes.add(imagen.getAbsolutePath());
			if (imagen.exists()) {
				imagen.delete();
			}
			ImageIO.write(bufferedImage, "jpg", imagen);
			
		}
		
		return listaImagenes;
		
		
	}

}
