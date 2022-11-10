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

/**
 *
 * @author Dell
 */
public class Authority extends User {
    
    public Authority(String fName, String lName, String email, String phone, String type, String userID, String password) {
        super(fName, lName, email, phone, type, userID, password);
    }

    public Authority(String userID, String password, String type) {
        super(userID, password, type);
    }

    public Authority(String userID) {
        super(userID);
    }
    
    
    
    public void createNotice(String notice){
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Notices.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(userID+" :\n"+notice+"\n\n");           
            
        } catch (IOException ex) {
            Logger.getLogger(CreateNoticeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateNoticeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Animal[] checkAllPricing() throws FileNotFoundException{
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
    
    public static void updateAnimalPrice(String name, String newPrice) throws FileNotFoundException, IOException{
        File f = null;
        Scanner s = null;
        FileWriter fw = null;
        String string = "";
        
        f = new File("AnimalDetails.txt");
        s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] st = str.split(",");
            if(st[0].equals(name)){
                string += st[0] + "," + st[1] + "," + st[2] + "," + newPrice + "," + st[4] + "\n";
            }else{
                string += str + "\n";
            }
        }
        
        if(f.delete()){}
        
        f = new File("AnimalDetails.txt");
        fw = new FileWriter(f);
        fw.write(string);
        fw.close();
    }
    
    
}
