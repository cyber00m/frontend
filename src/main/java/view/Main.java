package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;
import view_model.ViewModel;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
  //  private TabPane tabPane;
    final static String aircraftOne = "Aircraft I";
    final static String aircraftTwo = "Aircraft II";
    final static String aircraftThree = "Aircraft III";
    final static String aircraftFour = "Aircraft IV";
    final static String aircraftFive = "Aircraft V";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        BorderPane root = (BorderPane)fxmlLoader.load();

//        tabPane = new TabPane();
//        Tab tab1 = new Tab("Joystick");
//        tabPane.getTabs().add(tab1);
//        Tab tab2 = new Tab("Online Aircrafts");
//        tabPane.getTabs().add(tab2);
//        Tab tab3 = new Tab("Milage");
//        tabPane.getTabs().add(tab3);
//        Tab tab4 = new Tab("Fleet Size");
//        tabPane.getTabs().add(tab4);
//        root.setCenter(tabPane);
        Scene scene = new Scene(root, 300, 300);

        int onlinePlanes = 4, offlinePlanes = 10;
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Online", onlinePlanes),
                        new PieChart.Data("Offline", offlinePlanes));
        final PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Online Aircrafts");

        stage.setTitle("Nautical Miles");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barChart =
                new BarChart<String,Number>(xAxis,yAxis);
        barChart.setTitle("Nautical Miles");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(aircraftOne, 25601.34));
        series1.getData().add(new XYChart.Data(aircraftTwo, 20148.82));
        series1.getData().add(new XYChart.Data(aircraftThree, 10000));
        series1.getData().add(new XYChart.Data(aircraftFour, 35407.15));
        series1.getData().add(new XYChart.Data(aircraftFive, 12000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(aircraftOne, 57401.85));
        series2.getData().add(new XYChart.Data(aircraftTwo, 41941.19));
        series2.getData().add(new XYChart.Data(aircraftThree, 45263.37));
        series2.getData().add(new XYChart.Data(aircraftFour, 117320.16));
        series2.getData().add(new XYChart.Data(aircraftFive, 14845.27));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(aircraftOne, 45000.65));
        series3.getData().add(new XYChart.Data(aircraftTwo, 44835.76));
        series3.getData().add(new XYChart.Data(aircraftThree, 18722.18));
        series3.getData().add(new XYChart.Data(aircraftFour, 17557.31));
        series3.getData().add(new XYChart.Data(aircraftFive, 92633.68));
        barChart.getData().addAll(series1, series2, series3);

        stage.setTitle("Fleet Size");
        yAxis.setLabel("Miles");
        //defining the axes
        final NumberAxis xAxisLine = new NumberAxis();
        final NumberAxis yAxisLine = new NumberAxis();
        xAxis.setLabel("Aircraft");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxisLine,yAxisLine);

        lineChart.setTitle("Fleet Size");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));

        lineChart.getData().add(series);

        Model m = new Model("properties.txt");
        OldWindowController wc = (OldWindowController) fxmlLoader.getController();
        ViewModel vm = new ViewModel(m);
        wc.init(vm);
        wc.paint();

//        tab1.setContent(wc.joystick);
//        tab2.setContent(chart);
//        tab3.setContent(barChart);
//        tab4.setContent(lineChart);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}