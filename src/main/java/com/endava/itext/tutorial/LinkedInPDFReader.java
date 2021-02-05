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


            String currentJobTitle = "";


            currentJobTitle += " " + textLines[2];
           currentJobTitle= currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
            return currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
            //  }
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
                for (int j = i + 1; j < i + 4; j++) {
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
        int years = 0;
        int months = 0;
        for (int page = 1; page <= pdfDocument.getNumberOfPages(); page++) {
            final String textOnPage = getActualText(page, false);
            String[] linesOnPage = textOnPage.split("\n");
            for (String line : linesOnPage) {
                if (line.contains("year")) {
                    int yearIndex = line.indexOf("year");
                    int pIndex = line.indexOf("(");
                    years += Integer.valueOf(line.substring(pIndex + 1, yearIndex - 1).trim());
                    if (line.contains("month")) {
                        int monthIndex = line.indexOf("month");
                        months += Integer.valueOf(line.substring(yearIndex + 5, monthIndex - 1).trim());
                    }
                } else if (line.contains("month")) {
                    int monthIndex = line.indexOf("month");
                    int pIndex = line.indexOf("(");
                    months += Integer.valueOf(line.substring(pIndex + 1, monthIndex - 1).trim());
                }
            }
        }
        years += months / 12;
        return years;
    }


}