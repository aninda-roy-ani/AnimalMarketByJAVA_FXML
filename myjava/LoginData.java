/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

/**
 *
 * @author Dell
 */
public class LoginData {
    private String id;
    private String password;
    private String type;

    public LoginData(String id, String password, String type) {
        this.id = id;
        this.password = password;
        this.type = type;
    }

    
    public String idToString() {
        return id + "";
    }

    public LoginData(){
        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
