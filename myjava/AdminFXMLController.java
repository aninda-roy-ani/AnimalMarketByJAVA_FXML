/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AdminFXMLController implements Initializable {

    @FXML
    private Button signOutBtn;
    @FXML
    private BorderPane bp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signOutBtnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) signOutBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void createReportBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("CreateReportFXML.fxml"));        
        bp.setCenter(pane);
    }

    @FXML
    private void updateDiscriptionBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("UpdateDiscriptionFXML.fxml"));        
        bp.setCenter(pane);
    }

    @FXML
    private void updateContactBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("UpdateContactFXML.fxml"));        
        bp.setCenter(pane);
    }
    
}
