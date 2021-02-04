package com.endava.itext.tutorial;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;


import java.io.IOException;


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

    public String getTopSkills() {

        if (isLinkedInPdf()) {
            return getLinkedInTopSkills();
        }
        return null;
    }

    private String getLinkedInTopSkills() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractTopSkills(actualText);

    }

    private String extractCurrentJobTitle(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = -1; i <0; i++) {
            //  if (textLines[i].contains("la") || textLines[i].contains("at")) {
            String currentJobTitle= "";
            for (int j = i+3; j <= i+4; j++)
            {
                currentJobTitle+= " " + textLines[j++];
            }
currentJobTitle=currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
            return currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
            //  }
        }
        return null;
    }


    private String getLinkedInCurrentJobTitle() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, false);
        return extractCurrentJobTitle(actualText);

    }



    private String extractCurrentEmployer(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = -1; i <0; i++) {
          //  if (textLines[i].contains("la") || textLines[i].contains("at")) {
                String currentEmployer = "";
                for (int j = i+3; j <= i+4; j++)
                {
                    currentEmployer += " " + textLines[j++];
                }
          return   currentEmployer.substring(currentEmployer.lastIndexOf(" ")+1);
          //  }
        }
        return null;
    }


    private String getLinkedInCurrentEmployer() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, false);
        return extractCurrentEmployer(actualText);

    }

    private String extractTopSkills(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Top Skills") || textLines[i].contains("Aptitudini principale")) {
                String topSkills = "";
                for (int j = i+1; j < i+4; j++)
                {
                    topSkills += " " + textLines[j++];
                }
                topSkills = topSkills.trim().replace(" ", ", ");
                return topSkills;
            }
        }
        return null;
    }


    private String getActualText(int pageNo, boolean isSummarySide) {
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


    public Integer getTotalYearsOfExperience() {
        return null;
    }


    public void readPdf() {


    }


}