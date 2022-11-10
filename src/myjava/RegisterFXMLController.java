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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Dell
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private RadioButton sellerRB;
    @FXML
    private RadioButton customerRB;
    @FXML
    private RadioButton authorityRB;
    @FXML
    private RadioButton supplierRB;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField id;
    @FXML
    private TextField password;
    @FXML
    private Button homepageBtn;
    //private RadioButton adminRB;
    @FXML
    private CheckBox agreeCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup group = new ToggleGroup();
        sellerRB.setToggleGroup(group);
        customerRB.setToggleGroup(group);
        authorityRB.setToggleGroup(group);
        supplierRB.setToggleGroup(group);
        //adminRB.setToggleGroup(group);
        LoginData emp=null;
        //emp = new Employee(123,"asif","foreman",15000f);
        try{
            System.out.println("Salary="+emp.getId());
        }
        catch(Exception e){System.out.println(e);}
        System.out.println("Good by...");
    }    

    @FXML
    private void registerDoneAction(ActionEvent event) {
        String type = "";
        if(!agreeCheck.isSelected()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("First agree to the terms and conditions!");
            a.showAndWait();
        }else if(!User.checkUserIdExistence(id.getText())){
            if(sellerRB.isSelected()){
                type = sellerRB.getText();
            }
            else if(customerRB.isSelected()){
                type = customerRB.getText();
            }
            else if(authorityRB.isSelected()){
                type = authorityRB.getText();
            }
            else if(supplierRB.isSelected()){
                type = supplierRB.getText();
            }
            User user = new User(firstName.getText(), lastName.getText(), email.getText(), phone.getText(), type, id.getText(), password.getText());
            user.saveInUserBinFile();
            user.saveInProfilesTextFile();
            id.setText("");
            password.setText("");
            firstName.setText("");
            lastName.setText("");
            email.setText("");
            phone.setText("");
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Registration is complete!");
            a.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("UserID already exists!!");
            alert.showAndWait();
        
        }        
    }

    @FXML
    private void homepageAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) homepageBtn.getScene().getWindow();  
        stage.close();
    }
    
}
