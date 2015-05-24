package ar.com.indexer.paginador;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFTextParser {

	private PDFParser parser;
	private String parsedText;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private COSDocument cosDoc;
	private PDDocumentInformation pdDocInfo;

	public PDFTextParser() {

	}

	public String pdftoText(String fileName) {

		File file = new File(fileName);

		try {

			parser = new PDFParser(new FileInputStream(file));

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return parsedText;

	}

	public void writeTexttoFile(String pdfText, String fileName) {

		try {
			PrintWriter pw = new PrintWriter(fileName);
			pw.print(pdfText);
			pw.close();
		} catch (Exception e) {
			System.out
					.println("An exception occured in writing the pdf text to file.");
			e.printStackTrace();
		}

	}

	public PDFTextParser(File fileOrigen, File fileDestino) throws Exception {

		if (fileOrigen == null || fileDestino == null){
			
			JOptionPane.showMessageDialog(null, "Estan mal los parametros");
			throw new Exception("mal los parametros");
			
		}
		

		PDFTextParser pdfTextParserObj = new PDFTextParser();
		String pdfToText = pdfTextParserObj.pdftoText(fileOrigen.getAbsolutePath());

		if (pdfToText == null) {
			System.out.println("PDF to Text Conversion failed.");
		} else {
			System.out.println("\nThe text parsed from the PDF Document....\n"
					+ pdfToText);
			pdfTextParserObj.writeTexttoFile(pdfToText, fileDestino.getAbsolutePath());
		}
	}

}
