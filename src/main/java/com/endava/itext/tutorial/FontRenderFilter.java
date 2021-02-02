package com.endava.itext.tutorial;

import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

class FontRenderFilter extends RenderFilter {
    public boolean allowText(TextRenderInfo renderInfo) {
        String font = renderInfo.getFont().getPostscriptFontName();
        return font.endsWith("Bold") || font.endsWith("Oblique");
    }
}
