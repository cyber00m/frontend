package view.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;

public class ChartsController {
    @FXML public LineChart lineChart;
    @FXML public BarChart barChart;
    @FXML public PieChart pieChart;
    @FXML public NumberAxis lineX;
    @FXML public NumberAxis lineY;
    @FXML public NumberAxis barX;
    @FXML public NumberAxis barY;
    @FXML public NumberAxis pieX;
    @FXML public NumberAxis pieY;
}
