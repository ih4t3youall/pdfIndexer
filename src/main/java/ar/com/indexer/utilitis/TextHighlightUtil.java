//package ar.com.indexer.utilitis;
//
//
//import java.awt.geom.Rectangle2D;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import org.pdfclown.documents.Page;
//import org.pdfclown.documents.contents.ITextString;
//import org.pdfclown.documents.contents.TextChar;
//import org.pdfclown.documents.interaction.annotations.TextMarkup;
//import org.pdfclown.documents.interaction.annotations.TextMarkup.MarkupTypeEnum;
//import org.pdfclown.files.File;
//import org.pdfclown.files.SerializationModeEnum;
//import org.pdfclown.util.math.Interval;
//import org.pdfclown.util.math.geom.Quad;
//import org.pdfclown.tools.TextExtractor;
//
//
//
///**
//  This sample demonstrates how to highlight text matching arbitrary patterns.
//  Highlighting is defined through text markup annotations.
//
//  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
//  @since 0.1.1
//  @version 0.1.1
//*/
//public class TextHighlightUtil 
//{
//    private int count;
//    public void highlight(String inputPath, final String outputPath, String [] words )
//    {           
//
//        // 1. Open the PDF file!
//        File file;
//        java.io.File jiofile = new java.io.File(inputPath);
//        jiofile.exists();
//        
//        
//        try
//        {
//            file = new File(inputPath);
//        }
//        catch(Exception e)
//        {
//            throw new RuntimeException(inputPath + " file access error.",e);
//        }
//        
//        
//        for(final String key : words) {
//            count = 0;
//            // Define the text pattern to look for!
//            //String textRegEx = promptChoice("Please enter the pattern to look for: ");
//            Pattern pattern = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
//
//            // 2. Iterating through the document pages...
//            TextExtractor textExtractor = new TextExtractor(true, true);
//            for(final Page page : file.getDocument().getPages())
//            {
//
//              // 2.1. Extract the page text!
//              Map<Rectangle2D,List<ITextString>> textStrings = textExtractor.extract(page);
//              // 2.2. Find the text pattern matches!
//              final Matcher matcher = pattern.matcher(TextExtractor.toString(textStrings));
//              // 2.3. Highlight the text pattern matches!
//              textExtractor.filter(textStrings,
//                new TextExtractor.IIntervalFilter()
//                {
//                  public boolean hasNext()
//                  {                   
//                      //if(key.getMatchCriteria() == 1){
//                          if (matcher.find()) {
//                            count++;
//                            return true;
//                          }
//                      /*} else if(key.getMatchCriteria() == 2) {
//                          if (matcher.hitEnd()) {
//                            count++;
//                            return true;
//                          }
//                      }*/
//                      return false;
//
//                  }
//
//                  public Interval<Integer> next()
//                  {
//                      return new Interval<Integer>(matcher.start(), matcher.end());
//                  }
//
//                  public void process(Interval<Integer> interval, ITextString match)
//                  {
//                    // Defining the highlight box of the text pattern match...
//                    List<Quad> highlightQuads = new ArrayList<Quad>();
//                    {
//                      Rectangle2D textBox = null;
//                      for(TextChar textChar : match.getTextChars())
//                      {
//                        Rectangle2D textCharBox = textChar.getBox();
//                        if(textBox == null)
//                        {textBox = (Rectangle2D)textCharBox.clone();}
//                        else
//                        {
//                          if(textCharBox.getY() > textBox.getMaxY())
//                          {
//                            highlightQuads.add(Quad.get(textBox));
//                            textBox = (Rectangle2D)textCharBox.clone();
//                          }
//                          else
//                          {textBox.add(textCharBox);}
//                        }
//                      }
//                      textBox.setRect(textBox.getX(), textBox.getY(), textBox.getWidth(), textBox.getHeight()+5);
//                      highlightQuads.add(Quad.get(textBox));
//                    }                  
//                    //TextMarkup.setPrintable(true);
//                    // Highlight the text pattern match!
//                    new TextMarkup(page, outputPath, MarkupTypeEnum.Highlight, highlightQuads);
//                    
//                    //estaba comentado
//                    TextMarkup temp = new TextMarkup(page, key, MarkupTypeEnum.Highlight, highlightQuads);
//                    temp.setMarkupBoxes(highlightQuads);
//                    temp.setPrintable(true);
//                 //
//                    temp.setVisible(true);
//                  //estaba comentado
//                    //temp.setMarkupType(MarkupTypeEnum.Highlight);
//                  }
//
//                  public void remove()
//                  {throw new UnsupportedOperationException();}
//                }
//                );
//            }
//        }
//
//        SerializationModeEnum serializationMode = SerializationModeEnum.Incremental;
//        try
//        {
//            file.save(new java.io.File(outputPath), serializationMode);
//            file.close();
//        }
//        catch(Exception e)
//        {
//          System.out.println("File writing failed: " + e.getMessage());
//          e.printStackTrace();
//         }
//
//      }     
//
//}