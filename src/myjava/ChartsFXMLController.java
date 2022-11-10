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
public class ChartsFXMLController implements Initializable {

    @FXML
    private Button homeBtn;
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
    private void pieChart(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("UI1.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void barChart(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("UI2.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void homepageAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) homeBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }
    
}
