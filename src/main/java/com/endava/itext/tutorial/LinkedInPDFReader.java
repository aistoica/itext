package com.endava.itext.tutorial;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LinkedInPDFReader {

    private static String LINKEDIN_AUTHOR_NAME = "LinkedIn";

    PdfDocument pdfDocument;
    String pdfAuthor;


    public LinkedInPDFReader(String filePath) throws IOException {
        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
        this.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();

    }

    public String getCurrentEmployer() {

        if (isLinkedInPdf()) {
            return getLinkedInCurrentEmployer();
        }
        return null;
    }

    public String getCurrentJobTitle() {

        if (isLinkedInPdf()) {
            return getLinkedInCurrentJobTitle();
        }
        return null;
    }


    public String getLanguages() {

        if (isLinkedInPdf()) {
            return getLinkedInLanguages();
        }
        return null;
    }

    public String getCertifications() {

        if (isLinkedInPdf()) {
            return getLinkedInCertifications();
        }
        return null;
    }
    public  String getPDFLanguage() {

        if (isLinkedInPdf()) {
            return getLinkedInPdfLanguage();
        }
        return null;
    }


    private String getLinkedInLanguages() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractLanguages(actualText);

    }
    private String getLinkedInCertifications() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractCertifications(actualText);

    }


    private String extractLanguages(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Languages"))  {
                String languages = "";
                for (int j = i+1; j < i+5; j++)
                {
                    languages += " " + textLines[j]+"\n";
                }

                return languages ;
            }
        }
        return null;
    }

    private String extractCertifications(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Certifications") ) {
                i++;
                String certifs = "";

                    certifs += " " + textLines[i]+textLines[i+1] +"\n";


                return certifs ;
            }

        }
        return null;
    }

    private String extractCurrentJobTitle(String actualText) {
        String[] textLines = actualText.split("\n");


            String currentJobTitle = "";


            currentJobTitle += " " + textLines[2];
           currentJobTitle= currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
            return currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));

        }


    private String getLinkedInCurrentJobTitle() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, false);
        return extractCurrentJobTitle(actualText);

    }



    private String extractCurrentEmployer(String actualText) {
        String[] textLines = actualText.split("\n");

            if (textLines[2].contains("la") || textLines[2].contains("at")) {
                String currentEmployer = "";


                    currentEmployer += " " + textLines[2];

          return   currentEmployer.substring(currentEmployer.lastIndexOf(" ")+1);
           }

        return null;
    }



    private String extractPDFLanguage(String actualText) {
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
    private String getLinkedInPdfLanguage() {
        // Get the resultant text after applying the custom filter
        String actualText=getActualText(1,true);
        return  extractPDFLanguage(actualText) ;

    }

    private String getLinkedInCurrentEmployer() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, false);
        return extractCurrentEmployer(actualText);

    }




    String getActualText(int pageNo, boolean isSummarySide) {
        float pageWidth = pdfDocument.getPage(pageNo).getPageSize().getWidth();
        float pageHeight = pdfDocument.getPage(pageNo).getPageSize().getHeight();

        float left = pdfDocument.getPage(pageNo).getPageSize().getLeft();
        float bottom = pdfDocument.getPage(pageNo).getPageSize().getBottom();

        Rectangle summaryRectangle;

        if (isSummarySide) {
            summaryRectangle = new Rectangle(left, bottom, pageWidth / 3, pageHeight);
        } else {
            summaryRectangle = new Rectangle(pageHeight / 3, bottom, pageWidth - pageWidth / 3, pageHeight);
        }

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

    private boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }



}