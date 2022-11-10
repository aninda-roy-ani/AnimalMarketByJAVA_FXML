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
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 *
 * @author Dell
 */
public class Admin extends User {
    
    public Admin(String fName, String lName, String email, String phone, String type, String userID, String password) {
        super(fName, lName, email, phone, type, userID, password);
    }

    public Admin(String userID, String password, String type) {
        super(userID, password, type);
    }

    public Admin(String userID) {
        super(userID);
    }

    
    
    
    
    public static void createReport(){
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
                        = "This is an issued document of the hut.\n"
                        + "The table below shows the name of the chieves.\n";
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("QURBANIR HUT");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    
                
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text title = new Text("Name of our honorable supervisors:").setFont(fontBold);
                title.setFontColor(Color.BLUE);
                Paragraph highestRevInfo = new Paragraph().add(title);
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(highestRevInfo);
                //doc.add(lineSpace);
                
                
                List supervisorList = new List();
                supervisorList.add("Mr. Mostafa Kamal");
                supervisorList.add("Mrs. Nushrat Nahar");
                supervisorList.add("Mr. Ahmed Saif");
                
                doc.add(supervisorList);
                doc.add(lineSpace);
                
                
                float colWidthArr[] = {70f, 200f};
                Table pdfTable = new Table(colWidthArr); 
                
                
                Cell cell_00 = new Cell(); 
                cell_00.add("Designation");
                cell_00.setBackgroundColor(Color.GREEN);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.GREEN).add("Name"));
                
                pdfTable.addCell(new Cell().add("Owner"));
                pdfTable.addCell(new Cell().add("Md. Jamshed Bhuiyan"));

                pdfTable.addCell(new Cell().add("Director"));
                pdfTable.addCell(new Cell().add("Bakul Bhattacharya"));

                pdfTable.addCell(new Cell().add("Admin"));
                pdfTable.addCell(new Cell().add("Abida Reza Khan"));

                doc.add(pdfTable);
                
                doc.close();
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The Report is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
        }
    }
    
    public void updateDiscription(String string) throws IOException{
        File f = new File("Discription.txt");
        if(f.delete()){
            //
        }
        FileWriter fw = new FileWriter(f);
        fw.write(string);
        fw.close();
    }
    
    public void updateContact(String string) throws IOException{
        File f = new File("Contact.txt");
        if(f.delete()){
            //
        }
        FileWriter fw = new FileWriter(f);
        fw.write(string);
        fw.close();
    }
    
}
