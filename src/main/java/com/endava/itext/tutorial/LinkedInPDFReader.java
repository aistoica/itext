package com.endava.itext.tutorial;

public class LinkedInPDFReader {

//    PdfReader pdfReader;
//
//    public LinkedInPDFReader(String filePath) throws IOException {
//        this.pdfReader = new PdfReader(filePath);
//    }
//
//    public String getCurrentEmployer() throws IOException {
//
//        return null;
//    }
//
//    public <ITextExtractionStrategy> String getCoreSkills() {
////
//        return null;
//    }
//
//    public <ITextExtractionStrategy> String getCurrentJobTitle() {
////
//        return null;
//    }
//
//    public Integer getTotalYearsOfExperience() {
////
//        return null;
//    }
//
//
//    public void readPdf() throws IOException {
//
//        //Get the number of pages in pdf.
//        int pages = pdfReader.getNumberOfPages();
//
//        for (int i = 0; i < pdfReader.getXrefSize(); i++) {
//            PdfObject pdfobj = pdfReader.getPdfObject(i);
//            if (pdfobj == null || !pdfobj.isStream()) {
//                continue;
//            }
//            PdfStream stream = (PdfStream) pdfobj;
//            PdfObject pdfsubtype = stream.get(PdfName.SUBTYPE);
//            System.out.println(pdfsubtype.toString());
//        }
//        pdfReader.close();
//    }


}