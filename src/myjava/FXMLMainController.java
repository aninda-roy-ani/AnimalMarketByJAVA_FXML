/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class FXMLMainController implements Initializable {
    
    ObservableList<String> types = FXCollections.observableArrayList("Admin", "Seller", "Authority", "Supplier", "Customer");
    
    private Label label;
    @FXML
    private TextField userId;
    @FXML
    private TextField password;
    @FXML
    private ComboBox<String> type;
    @FXML
    private BorderPane bp;
    @FXML
    private Button signInBtn;
    @FXML
    private Button chartsBtn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.setItems(types);
    }    

    @FXML
    private void descriptionBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("DescriptionFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void chartsBtnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) chartsBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("ChartsFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void contactBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ContactFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void exitBtnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) chartsBtn.getScene().getWindow();  
        stage.close();
    }

    @FXML
    private void signInBtnAction(ActionEvent event) throws IOException {
        Seller seller = null;
        Customer customer = null;
        Authority authority = null;
        Supplier supplier = null;
        Admin admin = null;
        if(type.getValue().equals("Admin") && userId.getText().equals("admin") && password.getText().equals("admin")){
            admin = new Admin(userId.getText(), password.getText(), type.getValue());
            admin.saveInLoggedInBinFile();
            Stage stage = (Stage) signInBtn.getScene().getWindow();  
            stage.close();
            Parent pane = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
            Scene scene = new Scene(pane);       
            stage.setScene(scene);
            stage.show();
        }
        else if(User.checkIdPasswordMatch(userId.getText(), password.getText(), type.getValue())){
            if(type.getValue().equals("Seller")){
                
                seller = new Seller(userId.getText(), password.getText(), type.getValue());
                seller.saveInLoggedInBinFile();
                Stage stage = (Stage) signInBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("SellerFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(type.getValue().equals("Supplier")){
                supplier = new Supplier(userId.getText(), password.getText(), type.getValue());                
                supplier.saveInLoggedInBinFile();
                Stage stage = (Stage) signInBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("SupplierFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(type.getValue().equals("Authority")){
                authority = new Authority(userId.getText(), password.getText(), type.getValue());
                authority.saveInLoggedInBinFile();
                Stage stage = (Stage) signInBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("AuthorityFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(type.getValue().equals("Customer")){
                customer = new Customer(userId.getText(), password.getText(), type.getValue());
                customer.saveInLoggedInBinFile();
                Stage stage = (Stage) signInBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("CustomerFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            
            
            userId.setText("");
            password.setText("");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("UserID or Password or User type doesn't match!!");
            alert.showAndWait();
        }
    
    }

    @FXML
    private void regBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));        
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void reviewBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ReviewBoardFXML.fxml"));
        bp.setCenter(pane);
        
    }
    
}
