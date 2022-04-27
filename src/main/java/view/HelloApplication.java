package view;

//import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import viewmodel.ViewModel;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Model m = new Model("properties.txt");
        View v = fxmlLoader.getController();
        ViewModel vm = new ViewModel(m);
        v.init(vm);
        v.paint();
        m.setAileron(1);
        m.setRudder(-1);
        m.setElevators(1);
        //Controller c = new Controller(m, v);
        stage.setTitle("Stage Title");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}