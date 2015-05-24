package ar.com.indexer.buscador;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFIndexer {
	public IndexItem index(File file) throws IOException {
		PDDocument doc = PDDocument.load(file);
		String content = new PDFTextStripper().getText(doc);
		System.out.println(content);
		doc.close();
		return new IndexItem((long) file.getName().hashCode(), file.getName(),
				content);
	}

}
