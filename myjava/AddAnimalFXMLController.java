/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AddAnimalFXMLController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField type;
    @FXML
    private TextField colour;
    @FXML
    private TextField price;
    @FXML
    private TextField weight;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveBtnAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        Seller seller = new Seller(userID);
        Animal animal = new Animal(name.getText(), type.getText(), colour.getText(), price.getText(), weight.getText());
        seller.addAnimal(animal);
        name.setText("");
        type.setText("");
        colour.setText("");
        price.setText("");
        weight.setText("");
    }
    
}
