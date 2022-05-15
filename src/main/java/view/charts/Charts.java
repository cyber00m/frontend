package view.charts;

import javafx.fxml.FXMLLoader;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Charts extends AnchorPane {
    public final ChartsController chartsController;
    public LineChart lineFleetSize;
    public BarChart barNauticalMiles;
    public PieChart pieOnlineAircrafts;
    public NumberAxis fleetSizeX;
    public NumberAxis fleetSizeY;
    public NumberAxis nauticalMilesX;
    public NumberAxis nauticalMilesY;
    public NumberAxis onlineAircraftsX;
    public NumberAxis onlineAircraftsY;

    public Charts(){
        FXMLLoader fxl = new FXMLLoader();
        AnchorPane ap = null;
        try {
            ap = fxl.load(getClass().getResource("Graphs.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ap != null){
            chartsController = fxl.getController();
            lineFleetSize = chartsController.lineChart;
            barNauticalMiles = chartsController.barChart;
            pieOnlineAircrafts = chartsController.pieChart;
            fleetSizeX = chartsController.lineX;
            fleetSizeY = chartsController.lineY;
            nauticalMilesX = chartsController.barX;
            nauticalMilesY = chartsController.barY;
            onlineAircraftsX = chartsController.pieX;
            onlineAircraftsY = chartsController.pieY;
        }
        else
            chartsController = null;
    }

}
