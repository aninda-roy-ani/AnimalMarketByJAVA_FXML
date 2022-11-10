/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 *
 * @author Dell
 */
public class Supplier extends User {
    
    public Supplier(String fName, String lName, String email, String phone, String type, String userID, String password) {
        super(fName, lName, email, phone, type, userID, password);
    }

    public Supplier(String userID, String password, String type) {
        super(userID, password, type);
    }

    public Supplier(String userID) {
        super(userID);
    }
    
    
    
    public Product[] viewOrders() throws FileNotFoundException{
        Product[] p = new Product[99];
        int i = 0;
        File f = new File("Products.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] st = str.split(",");
            if(st[4].equals(userID))
                p[i++] = new Product(st[0], st[1], st[2], st[3], st[5]);
            
            //System.out.println(p[i].getIssueDate());
            
        }
        
        return p;
    }
    
    public void downloadDocument(){
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){
                
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Detailes of all the ordered products :.\n";
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Product Orders");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    
                
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text title = new Text("Detailes of all the ordered products :").setFont(fontBold);
                title.setFontColor(Color.RED);
                Paragraph titler = new Paragraph().add(title);
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(titler);
                doc.add(lineSpace);
                
                
                float colWidthArr[] = {70f, 200f, 100f, 100f};
                Table pdfTable = new Table(colWidthArr); 
                
                
                Cell cell_00 = new Cell(); 
                cell_00.add("Product ID");
                cell_00.setBackgroundColor(Color.GREEN);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.GREEN).add("Product Name"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.GREEN).add("Num of Product"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.GREEN).add("Orderer ID"));
                
                
                File ff = new File("Products.txt");
                Scanner s = null;
                try {
                    s = new Scanner(ff);
                    
                    while(s.hasNext()){
                        String str = s.nextLine();
                        String[] st = str.split(",");
                        if(st[4].equals(userID)){
                            pdfTable.addCell(new Cell().add(st[0]));
                            pdfTable.addCell(new Cell().add(st[1]));
                            pdfTable.addCell(new Cell().add(st[2]));
                            pdfTable.addCell(new Cell().add(st[5]));
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SupplierFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                doc.add(pdfTable);
                
                doc.close();
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The SUPPLY DOCUMENT (PDF): saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving SUPPLY DOCUMENT (PDF): cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
        }
    }
    
   
}
