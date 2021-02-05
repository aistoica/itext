package com.endava.itext.tutorial;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LinkedInPDFReaderTests {

    @Test
    public void testCreateReader() throws IOException {
        String pdfPath = "/pdfs/BogdanBengaProfile.pdf";
        LinkedInPDFReader linkedInPDFReader = new LinkedInPDFReader(pdfPath);
        Assertions.assertNotNull(linkedInPDFReader);
    }


}
