package com.endava.itext.tutorial;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

import java.io.IOException;

public class LinkedInPDFReader {

    PdfReader pdfReader;

    public LinkedInPDFReader(String filePath) throws IOException {
        this.pdfReader = new PdfReader(filePath);
    }

    public <ITextExtractionStrategy> String getCurrentEmployer(){
        Rectangle rect = null;
        RenderFilter[] filter = {new RegionTextRenderFilter(rect)};
        ITextExtractionStrategy strategy;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            strategy = (ITextExtractionStrategy) new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            sb.appendLine(PdfTextExtractor.getTextFromPage(pdfReader, i, strategy));
        }
        return null;
    }

    public <ITextExtractionStrategy> String getCoreSkills(){
        Rectangle rect = null;
        RenderFilter[] filter = {new RegionTextRenderFilter(rect)};
        ITextExtractionStrategy strategy;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            strategy = (ITextExtractionStrategy) new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            sb.AppendLine(PdfTextExtractor.GetTextFromPage(pdfReader, i, strategy));
        }
        return null;
    }

    public <ITextExtractionStrategy> String getCurrentJobTitle(){
        Rectangle rect = null;
        RenderFilter[] filter = {new RegionTextRenderFilter(rect)};
        ITextExtractionStrategy strategy;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            strategy = (ITextExtractionStrategy) new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            sb.AppendLine(PdfTextExtractor.GetTextFromPage(pdfReader, i, strategy));
        }
        return null;
    }

    public <ITextExtractionStrategy> String getTotalYearsOfExperience(){
        Rectangle rect = null;
        RenderFilter[] filter = {new RegionTextRenderFilter(rect)};
        ITextExtractionStrategy strategy;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            strategy = (ITextExtractionStrategy) new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            sb.AppendLine(PdfTextExtractor.GetTextFromPage(pdfReader, i, strategy));
        }
        return null;
    }


    public void readPdf() throws IOException {

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            //Iterate the pdf through pages.
            for (int i = 1; i <= pages; i++) {
                //Extract the page content using PdfTextExtractor.
                String pageContent =
                        PdfTextExtractor.getTextFromPage(pdfReader, i);

                //Print the page content on console.
                System.out.println("Content on Page "
                        + i + ": " + pageContent);
            }

            //Close the PdfReader.
            pdfReader.close();
    }


}