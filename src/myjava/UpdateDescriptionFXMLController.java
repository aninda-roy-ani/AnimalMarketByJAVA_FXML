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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class UpdateDescriptionFXMLController implements Initializable {

    @FXML
    private TextArea txtEditor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = new File("Discription.txt");
        Scanner s = null;
        String str = "";
        try {
            s = new Scanner(f);
            while(s.hasNext()){
                str+= s.nextLine()+"\n";
            }
        } catch (FileNotFoundException ex) {
        
        }
        txtEditor.setText(str);
    }    

    @FXML
    private void saveTextBtnAction(ActionEvent event) throws IOException {
        String userID = User.findLoggedInID();
        Admin user = new Admin(userID);
        user.updateDiscription(txtEditor.getText());
        
        txtEditor.clear();
    }
    
}
