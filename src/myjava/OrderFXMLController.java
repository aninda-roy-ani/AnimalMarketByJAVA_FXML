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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class OrderFXMLController implements Initializable {

    @FXML
    private ComboBox<String> supplierCB;
    @FXML
    private TextField prodIDTF;
    @FXML
    private TextField prodNameTF;
    @FXML
    private TextField noProdTF;
    @FXML
    private DatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = new File("Profiles.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            
            while(s.hasNext()){
                String str = s.nextLine();
                String[] st = str.split("#");
                if(st[4].equals("Supplier"))
                    supplierCB.getItems().add(st[5]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void saveBtnAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        Seller user = new Seller(userID);
        Product product = new Product(prodIDTF.getText(), prodNameTF.getText(), noProdTF.getText(), 
                                    datePicker.getValue().toString(), supplierCB.getValue(), userID);
        user.order(product);
        datePicker.setValue(null);
        
        prodIDTF.clear();
        prodNameTF.clear();
        noProdTF.clear();
    }
    
}
