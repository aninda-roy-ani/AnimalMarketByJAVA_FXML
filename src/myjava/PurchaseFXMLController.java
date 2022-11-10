/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PurchaseFXMLController implements Initializable {

    @FXML
    private ComboBox<String> animalCB;
    @FXML
    private Button buyBtn;
    
    //private String priceOfSelectedAnimal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = new File("AnimalDetails.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            
            while(s.hasNext()){
                String str = s.nextLine();
                String[] st = str.split(",");
                animalCB.getItems().add(st[0]+"->BDT"+st[3]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PurchaseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void buyBtnAction(ActionEvent event) {
        String[] str = animalCB.getValue().split("->BDT");
        Customer.purchase(str[1]);
    }
    
}
