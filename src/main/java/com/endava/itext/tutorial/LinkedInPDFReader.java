package com.endava.itext.tutorial;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;


import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class LinkedInPDFReader {

    private static String LINKEDIN_AUTHOR_NAME = "LinkedIn";
    private static String pdfAuthor;
    private static PdfDocument pdfDocument;



    public LinkedInPDFReader(String filePath) throws IOException {
        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
        this.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();

    }

    public static URL getProfile() throws MalformedURLException {

        if (isLinkedInPdf()) {
            return getLinkedInProfile();
        }
        return null;
    }
    public static String getEmail() throws MalformedURLException {

        if (isLinkedInPdf()) {
            return getLinkedInEmail();
        }
        return null;
    }


    public static String getCurrentEmployer() {

        if (isLinkedInPdf()) {
            return getLinkedInCurrentEmployer();
        }
        return null;
    }

    public static String getCurrentJobTitle() {

        if (isLinkedInPdf()) {
            return getLinkedInCurrentJobTitle();
        }
        return null;
    }


    public static Set<String> getLanguages() {

        if (isLinkedInPdf()) {
            return getLinkedInLanguages();
        }
        return null;
    }

    public static Set<String> getCertifications() {

        if (isLinkedInPdf()) {
            return getLinkedInCertifications();
        }
        return null;
    }
    public static String getPDFLanguage() {

        if (isLinkedInPdf()) {
            return getLinkedInPdfLanguage();
        }
        return null;
    }


    private static Set<String> getLinkedInLanguages() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractLanguages(actualText);

    }
    private static Set<String> getLinkedInCertifications() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractCertifications(actualText);

    }

    private static URL getLinkedInProfile() throws MalformedURLException {
        String actualText = getActualText(1, true);
        return extractProfile(actualText);

    }


    private static URL extractProfile(String actualText)  {
        String[] textLines = actualText.split("\n");
        String profile=textLines[3] ;
        URL url = null;
        try {
            url= new URL(profile);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  url;
    }


    private static String getLinkedInEmail() throws MalformedURLException {
        String actualText = getActualText(1, true);
        return extractEmail(actualText);

    }

    private static String extractEmail(String actualText)  {
        String[] textLines = actualText.split("\n");
        String email=textLines[2] ;

        return  email;
    }
    private static Set<String> extractLanguages(String actualText) {
        String[] textLines = actualText.split("\n");
        String stringsToRemove = "Certifications";
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Languages"))  {
                String languages = "";
                Set<String> languagesSet = new HashSet<String>();
                for (int j = i+1; j < i+6; j++)
                {
//
//                    languages += " " + textLines[j]+"\n";
                   languagesSet.add(textLines[j]);
                   if(textLines[j].equals("Certifications"))
                   {

                       languagesSet.removeAll(Collections.singleton(stringsToRemove));
                       break;
                   }

                }

                return languagesSet ;
            }
        }
        return null;
    }

    private static Set<String> extractCertifications(String actualText) {
        String[] textLines = actualText.split("\n");
        String certifs = "";
        Set<String> certifsSet = new HashSet<String>();
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Certifications") ) {
                i++;
//                    certifs += " " + textLines[i]+textLines[i+1] +"\n";
                certifsSet.add(textLines[i]+textLines[i+1]);

                return certifsSet ;
            }

        }
        return null;
    }

    private static String extractCurrentJobTitle(String actualText) {
        String[] textLines = actualText.split("\n");


            String currentJobTitle = "";


            currentJobTitle += " " + textLines[2];
           currentJobTitle= currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
            return currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));

        }


    private static String getLinkedInCurrentJobTitle() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, false);
        return extractCurrentJobTitle(actualText);

    }



    private static String extractCurrentEmployer(String actualText) {
        String[] textLines = actualText.split("\n");

            if (textLines[2].contains("la") || textLines[2].contains("at")) {
                String currentEmployer = "";


                    currentEmployer += " " + textLines[2];

          return   currentEmployer.substring(currentEmployer.lastIndexOf(" ")+1);
           }

        return null;
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
    private static String getLinkedInPdfLanguage() {
        // Get the resultant text after applying the custom filter
        String actualText=getActualText(1,true);
        return  extractPDFLanguage(actualText) ;

    }

    private static String getLinkedInCurrentEmployer() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, false);
        return extractCurrentEmployer(actualText);

    }
    static String getActualText(int pageNo, boolean isSummarySide) {
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

    private static boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }



}