/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class User {
    
    private String fName;
    private String lName;
    private String email;
    private String phone;
    protected String userID;
    private String password;
    private String type;

    public User(String fName, String lName, String email, String phone, String type, String userID, String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.userID = userID;
        this.password = password;
    }

    public User(String userID, String password, String type) {
        this.userID = userID;
        this.password = password;
        this.type = type;
    }

    public User(String userID) {
        this.userID = userID;
    }
    
    

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static boolean checkUserIdExistence(String userId) {
        boolean match = false;
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str1="", str2 = "", str3="";
        try {
            f = new File("User.bin");
            if(!f.exists()){
            }
            else{
                
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while(true){
                    str1 = dis.readUTF();
                    str2 = dis.readUTF();
                    str3 = dis.readUTF();
                    if(str1.equals(userId)){
                        match = true;
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            //
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                //
            }
        } 
        return match;
    }
    
    public void saveInUserBinFile(){
        File f = null;
        FileOutputStream fos = null;      
        DataOutputStream dos = null;
        
        try {
            f = new File("User.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            dos = new DataOutputStream(fos);
            
            dos.writeUTF(userID);
            dos.writeUTF(password);
            dos.writeUTF(type);

        } catch (IOException ex) {
            //
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                //
            }
        }
    }
    
    public void saveInProfilesTextFile(){
        String str = fName + "#"+ lName + "#"+ email + "#"+ phone + "#" + type + "#" + userID + "\n";
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Profiles.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(str);           
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void saveInLoggedInBinFile(){
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("LoggedIn.bin");
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
          
            dos.writeUTF(userID);
            dos.writeUTF(type);

        } catch (IOException ex) {
            //
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                //
            }
        }
    }
    
    public static boolean checkIdPasswordMatch(String id1, String password1, String type1){
        boolean match = false;
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str1="", str2 = "", str3="";
        try {
            f = new File("User.bin");
            if(!f.exists()){
            }
            else{
                
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while(true){
                    str1 = dis.readUTF();
                    str2 = dis.readUTF();
                    str3 = dis.readUTF();
                    if(str1.equals(id1) && str2.equals(password1) && str3.equals(type1)){
                        match = true;
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            //
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                //
            }
        } 
        return match;
    }
    
    public static String findLoggedInID(){
        String userID = "";
        File f = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
       
        try {
            f = new File("LoggedIn.bin");
               
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            userID = dis.readUTF();  
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                
            }
        }
        //return 
        return userID;
    }
    
    public static String seeNotices(){
        String string = "";
        File f = null;
        FileReader fr = null;
        Scanner s = null;
        try {
            f = new File("Notices.txt");
            fr = new FileReader(f);    
            int i;    
            try {
                while((i=fr.read())!=-1)    
                    string += (char)i;
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            try { 
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReviewBoardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(string[0]+" "+string[1]);
        return string;
    }
    
    public static String reviews(){
        String string = "";
        File f = null;
        FileReader fr = null;
        Scanner s = null;
        try {
            f = new File("Reviews.txt");
            fr = new FileReader(f);    
            int i;    
            try {
                while((i=fr.read())!=-1)    
                    string += (char)i;
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            try { 
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReviewBoardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(string[0]+" "+string[1]);
        return string;
    }
    
    public String[] viewProfile() {
        String[] string = new String[6];
        File f = null;
        Scanner s = null;
        try {
            
            f = new File("Profiles.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();
                String[] st = str.split("#");
                if(this.userID.equals(st[5])){
                    string[0] = st[4];
                    string[1] = st[0];
                    string[2] = st[1];
                    string[3] = st[2];
                    string[4] = st[3];
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }
    
    
    public void editProfile(){
        String string = "";
        File f = new File("Profiles.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();
                String[] st = str.split("#");
                if(this.userID.equals(st[5]))
                    string += this.fName+ "#" + this.lName + "#" + 
                            this.email + "#" + this.phone + "#" + 
                            st[4]+ "#" + st[5] + "\n";
                else
                    string += str + "\n";               
            }
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(f.delete()){}
        
        try {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(string);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
