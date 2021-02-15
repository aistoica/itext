package com.endava.itext.tutorial;

import java.io.IOException;

public class LinkedInPDFReaderFR extends LinkedInPDFReader{
    public LinkedInPDFReaderFR(String filePath) throws IOException {
        super(filePath);
        super.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();
    }
}
