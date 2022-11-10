package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class UI2Controller implements Initializable {

    @FXML private BarChart<String, Number> barChart;
    @FXML private NumberAxis yAxis;
    @FXML private CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
            File f = new File("AnimalDetails.txt");
            Scanner s = new Scanner(f);
            
            while(s.hasNext()){
                
                String str = s.nextLine();
                String[] st = str.split(",");
                series.getData().add(new XYChart.Data<String,Number>(st[0],Integer.parseInt(st[3])));
            }
            series.setName("Animal Prices");
            barChart.getData().add(series);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UI2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
