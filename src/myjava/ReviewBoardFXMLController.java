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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ReviewBoardFXMLController implements Initializable {

    @FXML
    private Label reviews;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reviews.setText(User.reviews());
    }    

    @FXML
    private void backBtnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }
    
}
