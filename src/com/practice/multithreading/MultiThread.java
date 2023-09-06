package com.practice.multithreading;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiThread {
    public static void main(String[] args) {
        File pdfFile = new File("C:\\Users\\bgdit\\Desktop\\HDFC DOc\\3.pdf");
        int num=0;
        try (PDDocument document = PDDocument.load(pdfFile)) {
        	
            MultiThread finder = new MultiThread();
            List<Integer> colorPages = finder.findColorPages(document);
            
            System.out.println("Color pages found at:");
            System.out.print("Page ==>");
            
            for (int pageNumber : colorPages) {
            	
                System.out.print(pageNumber+",");
                num++;
            }
            System.out.println("");
            System.out.println("Total Color pages count :"+num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> findColorPages(PDDocument document) throws IOException {
        List<Integer> colorPages = new ArrayList<>();
        
        for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); pageNumber++) {
            PDPage page = document.getPage(pageNumber);
            boolean hasColorObjects = checkPageForColorObjects(page);
            if (hasColorObjects) {
                colorPages.add(pageNumber + 1); // Adding 1 to convert to 1-based page numbering
            }
        }
        
        return colorPages;
    }

    private boolean checkPageForColorObjects(PDPage page) throws IOException {
        PDResources resources = page.getResources();
        if (resources != null) {
            for (COSName xObjectName : resources.getXObjectNames()) {
                PDXObject xObject = resources.getXObject(xObjectName);
                if (xObject instanceof PDImageXObject) {
                    PDImageXObject imageXObject = (PDImageXObject) xObject;
                    PDColorSpace colorSpace = imageXObject.getColorSpace();
                    
                    if (colorSpace != null || colorSpace instanceof PDDeviceRGB) {
                        return true;
                    }
                }
                // Add more checks for other types of color objects if needed
            }
        }
        return false;
    }
}