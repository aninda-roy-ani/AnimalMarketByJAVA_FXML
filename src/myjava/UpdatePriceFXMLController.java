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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class UpdatePriceFXMLController implements Initializable {

    @FXML
    private ComboBox<String> animalCB;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField priceTA;

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
            Logger.getLogger(UpdatePriceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void updateBtnAction(ActionEvent event) throws IOException {
        String[] str = animalCB.getValue().split("->BDT");
        Authority.updateAnimalPrice(str[0], priceTA.getText());
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Price updated.");
        a.showAndWait();
        priceTA.setText("");
    }
    
}
