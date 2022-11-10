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
public class OrderViewerFXMLController implements Initializable {

    ObservableList<Product> product = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> ordersTable;
    @FXML
    private TableColumn<Product, String> pID;
    @FXML
    private TableColumn<Product, String> pName;
    @FXML
    private TableColumn<Product, String> pNum;
    @FXML
    private TableColumn<Product, String> lastDate;
    @FXML
    private TableColumn<Product, String> orderer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        Supplier user = new Supplier(userID);
        Product[] products = new Product[99];
        try {
            products = user.viewOrders();
            System.out.println(products[0]);
        } catch (IOException ex) {
            Logger.getLogger(OrderViewerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        product.addAll(Arrays.asList(products));
        
        pID.setCellValueFactory(new PropertyValueFactory<Product,String>("prodID"));
        pName.setCellValueFactory(new PropertyValueFactory<Product,String>("prodName"));
        pNum.setCellValueFactory(new PropertyValueFactory<Product,String>("noProd"));
        lastDate.setCellValueFactory(new PropertyValueFactory<Product,String>("issueDate"));
        orderer.setCellValueFactory(new PropertyValueFactory<Product,String>("seller"));
        
        ordersTable.setItems(product);
    }    
    
}
