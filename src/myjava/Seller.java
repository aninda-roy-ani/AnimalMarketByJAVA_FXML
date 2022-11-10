/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Seller extends User {
    
    public Seller(String fName, String lName, String email, String phone, String type, String userID, String password) {
        super(fName, lName, email, phone, type, userID, password);
    }

    public Seller(String userID, String password, String type) {
        super(userID, password, type);
    }

    public Seller(String userID) {
        super(userID);
    }
    
    
    
    public void addAnimal(Animal animal){
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("AnimalDetails.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(animal.animalDetails());           
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                
            }
        }
    }
    
    public void order(Product product) {
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Products.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(product.productDetails()+"\n");           
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                
            }
        }
    }
    
    
    
    
}
