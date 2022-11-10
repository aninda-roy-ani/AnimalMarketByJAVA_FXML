/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PricingFXMLController implements Initializable {

    ObservableList<Animal> animal = FXCollections.observableArrayList();
    @FXML
    private TableView<Animal> animalTable;
    @FXML
    private TableColumn<Animal, String> name;
    @FXML
    private TableColumn<Animal, String> type;
    @FXML
    private TableColumn<Animal, String> price;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        Authority user = new Authority(userID);
        Animal[] ani = new Animal[99];
        try {
            ani = user.checkAllPricing();
            
        } catch (IOException ex) {
            Logger.getLogger(PricingFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        animal.addAll(Arrays.asList(ani));
        
        name.setCellValueFactory(new PropertyValueFactory<Animal,String>("name"));
        type.setCellValueFactory(new PropertyValueFactory<Animal,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Animal,String>("price"));
        
        animalTable.setItems(animal);
    }    
    
}