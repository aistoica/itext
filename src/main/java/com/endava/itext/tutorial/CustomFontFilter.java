package com.endava.itext.tutorial;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import jdk.jfr.EventType;

protected class CustomFontFilter extends TextRegionEventFilter {
    public CustomFontFilter(Rectangle filterRect) {
        super(filterRect);
    }

    @Override
    public boolean accept(IEventData data, EventType type) {
        if (type.equals(EventType.RENDER_TEXT)) {
            TextRenderInfo renderInfo = (TextRenderInfo) data;
            DocumentFont font = renderInfo.getFont();
            if (null != font) {
                String fontName = font.getFontProgram().getFontNames().getFontName();
                return fontName.endsWith("Bold") || fontName.endsWith("Oblique");
            }
        }

        return false;
    }
}