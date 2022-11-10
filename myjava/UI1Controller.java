
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class UI1Controller implements Initializable {

    @FXML private PieChart pieChart;
    @FXML private Label statusLabel;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList <Data> list = FXCollections.observableArrayList();
        File f = new File("AnimalDetails.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();           
                String[] st = str.split(",");
                Data d = new Data(st[0], Integer.parseInt(st[3]));
                list.add(d);
            }
        } catch (FileNotFoundException ex) {
            
        }
        pieChart.setData(list);
        
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statusLabel.setText(String.valueOf(data.getPieValue()));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    }    

   

    
}
