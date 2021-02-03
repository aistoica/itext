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
        return null;
    }

    public String getTopSkills() {

        if (isLinkedInPdf()) {

            float pageWidth = pdfDocument.getFirstPage().getPageSize().getWidth();
            float pageHeight = pdfDocument.getFirstPage().getPageSize().getHeight();

            float left = pdfDocument.getFirstPage().getPageSize().getLeft();
            float bottom = pdfDocument.getFirstPage().getPageSize().getBottom();

            Rectangle summaryRectangle = new Rectangle(left, bottom, pageWidth / 3, pageHeight);
            TextRegionEventFilter regionEventFilter = new TextRegionEventFilter(summaryRectangle);
            FilteredEventListener listener = new FilteredEventListener();


            // Create a text extraction renderer
            LocationTextExtractionStrategy extractionStrategy = listener
                    .attachEventListener(new LocationTextExtractionStrategy(), regionEventFilter);

            // Note: If you want to re-use the PdfCanvasProcessor, you must call PdfCanvasProcessor.reset()
            PdfCanvasProcessor parser = new PdfCanvasProcessor(listener);
            parser.processPageContent(pdfDocument.getFirstPage());

            // Get the resultant text after applying the custom filter
            String actualText = extractionStrategy.getResultantText();
            String topSkills = CustomStringUtils.getBetweenStrings(actualText, "Top Skills\n", "\nLanguages");
            return topSkills.replace("\n", ", ");
        } else {
            return null;
        }
    }

    private boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }

    public <ITextExtractionStrategy> String getCurrentJobTitle() {
        return null;
    }

    public Integer getTotalYearsOfExperience() {
        return null;
    }


    public void readPdf() {


    }




}