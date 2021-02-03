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
            // Get the resultant text after applying the custom filter
            String actualText = getActualText(1, false);
            //in string you can split by \\nl and get it into an array
            // extract the string after "at" or after "la" from the second line

            return actualText;
        } else {
            return null;
        }
    }

    public String getTopSkills() {

        if (isLinkedInPdf()) {
            // Get the resultant text after applying the custom filter
            String actualText = getActualText(1, true);

            //check if Top Skills and Languages exist in text, if true apply this one
            String topSkills = CustomStringUtils.getBetweenStrings(actualText, "Top Skills\n", "\nLanguages");

            //else check if "Aptitudini Principale" and "Languages" exist then update the call of topsSkills assignment
            return topSkills.replace("\n", ", ");
        } else {
            return null;
        }
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

    public String getCurrentJobTitle() {
        return null;
    }

    public Integer getTotalYearsOfExperience() {
        return null;
    }


    public void readPdf() {


    }


}