package ar.com.indexer.buscador;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.lucene.queryParser.ParseException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class SimplePDFSearch {
	// location where the index will be stored.
	private static final String INDEX_DIR = "src/main/resources/index";
	private static final int DEFAULT_RESULT_SIZE = 100;

	 private File pdfFile;
	 private String searchWord; 
	
	
	public SimplePDFSearch(File pdfFile,String searchWord){
		this.pdfFile = pdfFile;
		this.searchWord = searchWord;
		
		
	}
	
	
	public boolean buscar() {

		int result = 0;
		
		try {
			IndexItem pdfIndexItem;
			pdfIndexItem = index(pdfFile);

			// creating an instance of the indexer class and indexing the items
			Indexer indexer = new Indexer(INDEX_DIR);
			indexer.index(pdfIndexItem);
			indexer.close();

			// creating an instance of the Searcher class to the query the index
			Searcher searcher = new Searcher(INDEX_DIR);


			result = searcher.findByContent(searchWord,
					DEFAULT_RESULT_SIZE);
			searcher.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 1 ){
			return true;
		}else {
			return false;
		}
	}
	

	// Extract text from PDF document
	public static IndexItem index(File file) throws IOException {
		PDDocument doc = PDDocument.load(file);
		
		String content = new PDFTextStripper().getText(doc);
		doc.close();
		return new IndexItem((long) file.getName().hashCode(), file.getName(),
				content);
	}

	// Print the results
	private static void print(int result) {
		if (result == 1)
			JOptionPane.showMessageDialog(null,
					"The document contains the search keyword");
		else
			JOptionPane.showMessageDialog(null,
					"The document does not contain the search keyword");
	}
}
