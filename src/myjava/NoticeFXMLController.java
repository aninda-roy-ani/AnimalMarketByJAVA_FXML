/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import myjava.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class NoticeFXMLController implements Initializable {

    @FXML
    private Label noticeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        noticeLabel.setText(User.seeNotices());
    }    
    
}
