/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SupplierFXMLController implements Initializable {

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
    private void viewOrdersBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("OrderViewerFXML.fxml"));
        bp.setCenter(pane);
    }


    @FXML
    private void docSlipBtnAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        Supplier user = new Supplier(userID);
        user.downloadDocument();
    }

    @FXML
    private void seeNoticesBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("NoticeFXML.fxml"));
        bp.setCenter(pane);
    }


    @FXML
    private void viewProfileBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ProfileFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void editProfileBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EditProfileFXML.fxml"));
        bp.setCenter(pane);
    }
    
}
