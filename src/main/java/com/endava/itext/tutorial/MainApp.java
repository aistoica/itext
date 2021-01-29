package com.endava.itext.tutorial;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) throws IOException {
        PDDocument document = null;
        File file = new File(MainApp.class.getClassLoader().getResource("pdfs/BogdanBengaProfile.pdf").getPath());
        document = PDDocument.load(file);
        int pageNum = 0;
        for( PDPage page : document.getPages() ){
            for (COSName cosName : page.getResources().getXObjectNames()){
                System.out.println(page.getResources().getXObject(cosName).toString());

            }
        }


    }
}
