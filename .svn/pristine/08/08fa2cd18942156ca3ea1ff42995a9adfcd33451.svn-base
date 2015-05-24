//package ar.com.indexer.utilitis;
//
//import java.awt.geom.Rectangle2D;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.pdfclown.documents.Page;
//import org.pdfclown.documents.contents.ITextString;
//import org.pdfclown.documents.contents.TextChar;
//import org.pdfclown.documents.interaction.annotations.TextMarkup;
//import org.pdfclown.documents.interaction.annotations.TextMarkup.MarkupTypeEnum;
//import org.pdfclown.files.File;
//import org.pdfclown.tools.TextExtractor;
//import org.pdfclown.util.math.Interval;
//import org.pdfclown.util.math.geom.Quad;
//
///**
// * This sample demonstrates how to highlight text matching arbitrary patterns.
// * Highlighting is defined through text markup annotations.
// * 
// * @author Stefano Chizzolini (http://www.stefanochizzolini.it)
// * @since 0.1.1
// * @version 0.1.1
// */
//public class TextHighlightSample {
//
//	public TextHighlightSample(String filePath) {
//
//
//		// 1. Open the PDF file!
//		org.pdfclown.files.File file;
//		try {
//			file = new File(filePath);
//		} catch (Exception e) {
//			throw new RuntimeException(filePath + " file access error.", e);
//		}
//
//		// Define the text pattern to look for!
//		String textRegEx = "anterior";
//		Pattern pattern = Pattern.compile(textRegEx, Pattern.CASE_INSENSITIVE);
//
//		// 2. Iterating through the document pages...
//		TextExtractor textExtractor = new TextExtractor(true, true);
//		for (final Page page : file.getDocument().getPages()) {
//			System.out.println("\nScanning page " + (page.getIndex() + 1)
//					+ "...\n");
//
//			// 2.1. Extract the page text!
//			Map<Rectangle2D, List<ITextString>> textStrings = textExtractor.extract(page);
//
//			// 2.2. Find the text pattern matches!
//			final Matcher matcher = pattern.matcher(TextExtractor
//					.toString(textStrings));
//
//			// 2.3. Highlight the text pattern matches!
//			textExtractor.filter(textStrings,
//					new TextExtractor.IIntervalFilter() {
//						@Override
//						public boolean hasNext() {
//							return matcher.find();
//						}
//
//						@Override
//						public Interval next() {
//							return new Interval(matcher.start(), matcher.end());
//						}
//
//						@Override
//						public void process(Interval interval, ITextString match) {
//							// Defining the highlight box of the text pattern
//							// match...
//							List<Quad> highlightQuads = new ArrayList<Quad>();
//							{
//								/*
//								 * NOTE: A text pattern match may be split
//								 * across multiple contiguous lines, so we have
//								 * to define a distinct highlight box for each
//								 * text chunk.
//								 */
//								Rectangle2D textBox = null;
//								for (TextChar textChar : match.getTextChars()) {
//									Rectangle2D textCharBox = textChar.getBox();
//									if (textBox == null) {
//										textBox = (Rectangle2D) textCharBox
//												.clone();
//									} else {
//										if (textCharBox.getY() > textBox
//												.getMaxY()) {
//											highlightQuads.add(Quad
//													.get(textBox));
//											textBox = (Rectangle2D) textCharBox
//													.clone();
//										} else {
//											textBox.add(textCharBox);
//										}
//									}
//								}
//								highlightQuads.add(Quad.get(textBox));
//							}
//							// Highlight the text pattern match!
//							new TextMarkup(page, null,
//									MarkupTypeEnum.Highlight, highlightQuads);
//						}
//
//						@Override
//						public void remove() {
//							throw new UnsupportedOperationException();
//						}
//					});
//		}
//		try {
//			file.save();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 3. Highlighted file serialization.
//		// serialize(file, false);
//		//
//		// return true;
//	}
//}