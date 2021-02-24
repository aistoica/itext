package com.endava.itext.tutorial;


import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class EuropassPDFReader {

    private static String EUROPASS_TITLE = "Europass";
    private static String pdfTitle;
    private static PdfDocument pdfDocument;



    public EuropassPDFReader(String filePath) throws IOException {
        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
        this.pdfTitle = pdfDocument.getDocumentInfo().getTitle();

    }




    private static String extractPDFLanguage(String actualText) {
        String[] textLines = actualText.split("\n");


        if (textLines[1].equals("Contact")) {
            String currentLanguage = "English";
            return currentLanguage;
        } else if (textLines[1].equals("Contactați")) {
            String currentLanguage = "Romanian";
            return currentLanguage;
        }
        else if (textLines[1].equals("Kontakt") && actualText.contains("Mest repræsenterede")) {
            String currentLanguage = "Danish";
            return currentLanguage;
        }
        else if (textLines[1].equals("Coordonnées")) {
            String currentLanguage = "French";
            return currentLanguage;
        }
        else if (textLines[1].equals("Kontakt") && actualText.contains("Top-Kenntnisse")) {
            String currentLanguage = "German";
            return currentLanguage;
        }
        else if (textLines[1].equals("Способы связаться")) {
            String currentLanguage = "Russian";
            return currentLanguage;
        }
        else if (textLines[1].equals("Contactar")) {
            String currentLanguage = "Spanish";
            return currentLanguage;
        }
        else {

            return null;
        }
   }
    private static String getEuropassPdfLanguage() {
        // Get the resultant text after applying the custom filter
        String actualText=getActualText(1);
        return  extractPDFLanguage(actualText) ;

    }


    static String getActualText(int pageNo) {


            float pageWidth = pdfDocument.getPage(pageNo).getPageSize().getWidth();
            float pageHeight = pdfDocument.getPage(pageNo).getPageSize().getHeight();

            float left = pdfDocument.getPage(pageNo).getPageSize().getLeft();
            float bottom = pdfDocument.getPage(pageNo).getPageSize().getBottom();

            Rectangle summaryRectangle;


            summaryRectangle = new Rectangle(left, bottom, pageWidth, pageHeight);
            TextRegionEventFilter regionEventFilter = new TextRegionEventFilter(summaryRectangle);
            FilteredEventListener listener = new FilteredEventListener();


            // Create a text extraction renderer
            LocationTextExtractionStrategy extractionStrategy = listener
                    .attachEventListener(new LocationTextExtractionStrategy(), regionEventFilter);

            // Note: If you want to re-use the PdfCanvasProcessor, you must call PdfCanvasProcessor.reset()
            PdfCanvasProcessor parser = new PdfCanvasProcessor(listener);
            parser.processPageContent(pdfDocument.getPage(pageNo));

            // Get the resultant text after applying the custom filter
            return extractionStrategy.getResultantText();


    }

    private static boolean isEuropassPdf() {
        //TODO: implement this
        return pdfTitle.equals(EUROPASS_TITLE);
    }



}