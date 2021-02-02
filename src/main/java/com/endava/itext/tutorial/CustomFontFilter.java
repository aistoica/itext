package com.endava.itext.tutorial;


import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.EventType;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.geom.Rectangle;


import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.parser.TextRenderInfo;


public class CustomFontFilter extends TextRegionEventFilter {
    private static final String SRC = "";


    public CustomFontFilter(Rectangle filterRect) {
        super(filterRect);
    }

    @Override
    public boolean accept(IEventData data, EventType type) {
        if (type.equals(EventType.RENDER_TEXT)) {
            TextRenderInfo renderInfo = (TextRenderInfo) data;
            DocumentFont font = renderInfo.getFont();
            if (null != font) {
                String fontName = font.getFullFontName().toString();
                return fontName.endsWith("Bold") || fontName.endsWith("Oblique");
            }
        }

        return false;
    }

    protected void manipulatePdf(String dest) throws IOException, java.io.IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC));

        Rectangle rect = new Rectangle(36, 750, 523, 56);
        CustomFontFilter fontFilter = new CustomFontFilter(rect);
        FilteredEventListener listener = new FilteredEventListener();

        // Create a text extraction renderer
        LocationTextExtractionStrategy extractionStrategy = (LocationTextExtractionStrategy) listener
                .attachEventListener(new LocationTextExtractionStrategy(), fontFilter);

        // Note: If you want to re-use the PdfCanvasProcessor, you must call PdfCanvasProcessor.reset()
        PdfCanvasProcessor parser = new PdfCanvasProcessor(listener);
        parser.processPageContent(pdfDoc.getFirstPage());

        // Get the resultant text after applying the custom filter
        String actualText = extractionStrategy.getResultantText();

        pdfDoc.close();


    }
}