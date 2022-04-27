package view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import viewmodel.ViewModel;

import java.util.Observable;

public class View{

    @FXML
    Canvas joystick;
    @FXML
    Slider throttle;
    @FXML
    Slider rudder;
    ViewModel vm;
    DoubleProperty aileron, elevators;
    boolean mousePressed;
    double jx, jy, mx, my;

    public double getAileron(){
        return aileron.doubleValue();
    }

    public double getElevator(){
        return elevators.doubleValue();
    }


    public View(){
        mousePressed = false;
        jx = 0;
        jy = 0;
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();
    }

    void init(ViewModel vm){
        this.vm = vm;
        vm.throttle.bind(throttle.valueProperty());
        vm.rudder.bind(rudder.valueProperty());
        vm.aileron.bind(aileron);
        vm.elevators.bind(elevators);
    }


    void paint(){
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth()/2;
        my = joystick.getHeight()/2;

        gc.clearRect(0,0,joystick.getWidth(),joystick.getHeight());
        gc.strokeOval(jx-50,jy-50,100,100);
        aileron.set((jx-mx)/mx);
        elevators.set((my-jy)/my);
    }

    public void mouseDown(MouseEvent me){
        if (!mousePressed){
            mousePressed = true;
        }
    }

    public void mouseUp(MouseEvent me){
        if (mousePressed){
            jx = mx;
            jy = my;
            paint();
        }
    }

    public void mouseDrag(MouseEvent me){
        if (mousePressed){
            jx = me.getX();
            jy = me.getY();
            paint();
        }
    }

    @FXML
    private Label resultLabel;


    public void funcName(){
        resultLabel.setText("Wow... You've done something on your own...");
        paint();
//        setChanged();
//        notifyObservers();
    }

    public void display(int result) {
        resultLabel.textProperty().set("Result: "+result);
    }
}