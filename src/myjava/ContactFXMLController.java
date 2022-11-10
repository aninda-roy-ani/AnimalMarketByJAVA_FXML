/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ContactFXMLController implements Initializable {

    @FXML
    private Label contactLabel;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File file = new File("Contact.txt");
        Scanner s;
        String text = "";
        try {
            s = new Scanner(file);
            while(s.hasNextLine()){
            text+=s.nextLine()+"\n";
            }
        //System.out.println(entryRule);
            contactLabel.setText(text);
        } catch (FileNotFoundException ex) {
            
        }
    }    

    @FXML
    private void backBtnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    
}
