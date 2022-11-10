/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Dell
 */
public class Customer extends User {
    
    public Customer(String fName, String lName, String email, String phone, String type, String userID, String password) {
        super(fName, lName, email, phone, type, userID, password);
    }

    public Customer(String userID, String password, String type) {
        super(userID, password, type);
    }

    public Customer(String userID) {
        super(userID);
    }
    
    
    
    public Animal[] availableAnimals() throws FileNotFoundException{
        Animal[] ani = new Animal[99];
        int i = 0;
        File f = new File("AnimalDetails.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] st = str.split(",");
            
            ani[i++] = new Animal(st[0], st[1], st[2], st[3], st[4]);
                            
        }
        
        return ani;
    }
    
    public static void purchase(String tk){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("PAY");
        a.setContentText("PAY BDT "+tk+" by Mobile Banking");
        a.showAndWait();
    }
    
    public void review(String review){
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Reviews.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(userID+" :\n"+review+"\n\n");           
            
        } catch (IOException ex) {
            Logger.getLogger(ReviewFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ReviewFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
