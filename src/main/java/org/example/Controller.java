package org.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import org.example.classes.Driver;
import org.example.classes.FuelTank;
import org.example.classes.Tractor;
import org.example.classes.Wheel;

public class Controller {

    Tractor car;
    Driver driver;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonDrive;

    @FXML
    private Button buttonRemoveSnow;

    @FXML
    private TextArea textEvents;

    @FXML
    private Label labelEngineGo;

    @FXML
    private Label labelWheel1Speen;

    @FXML
    private Label labelWheel2Speen;

    @FXML
    private Label labelWheel3Speen;

    @FXML
    private Label labelWheel4Speen;

    @FXML
    private Button buttonAddFuel;

    @FXML
    private Button buttonPumpUp;

    @FXML
    private Label labelWheel1Inflated;

    @FXML
    private Label labelWheel2Inflated;

    @FXML
    private Label labelWheel3Inflated;

    @FXML
    private Label labelWheel4Inflated;

    @FXML
    private Label labelFuelInTank;

    @FXML
    void ClearWindow(ActionEvent event) {
        textEvents.clear();
    }

    @FXML
    void initialize () {
        //textEvents.setDisable(true);            // Only read

        car = new Tractor();
        driver = new Driver("Misha", car);
        car.clearing = false;

        buttonDrive.setOnAction(event->{
            if(!car.flagGo) {
                printEvent(Driver.drive());
                updateCar(car.flagGo, car.clearing);
            }
            else {
                printEvent(Driver.stopDrive());
                updateCar(car.flagGo, car.clearing);
            }
        });
        buttonRemoveSnow.setOnAction(event->{
            if (!car.clearing){
                printEvent(driver.clearSnow());
                updateCar(car.flagGo, car.clearing);
            }
            else{
                car.clearing = false;
                printEvent(driver.stopDrive());
                updateCar(car.flagGo, car.clearing);
            }
        });
        buttonAddFuel.setOnAction(event->{
            car.getTank().addFuel(10 * FuelTank.L);
            printEvent("> Заправка\n");
            updateCar(car.flagGo, car.clearing);
        });
        buttonPumpUp.setOnAction(event->{
            car.fixWheels();
            updateCar(car.flagGo, car.clearing);
        });

    }

    void updateCar(boolean flag, boolean clearing) {
        if (flag){
            labelEngineGo.setText("Заведен");
            buttonDrive.setText("Стоп");
        }
        else{
            labelEngineGo.setText("Не заведен");
            buttonDrive.setText("Ехать");
        }
        if(clearing){
            buttonRemoveSnow.setText("Хватит чистить");
        }
        else {
            buttonRemoveSnow.setText("Убирать снег");
        }
        labelWheel1Speen.setText(car.getWheel1().status());
        labelWheel2Speen.setText(car.getWheel2().status());
        labelWheel3Speen.setText(car.getWheel3().status());
        labelWheel4Speen.setText(car.getWheel4().status());

        labelWheel1Inflated.setText(car.getWheel1().statusPump());
        labelWheel2Inflated.setText(car.getWheel2().statusPump());
        labelWheel3Inflated.setText(car.getWheel3().statusPump());
        labelWheel4Inflated.setText(car.getWheel4().statusPump());

        labelFuelInTank.setText(String.valueOf(car.getTank().fuel));
    }

    void printEvent(String str){
        textEvents.setText(textEvents.getText() + str);
    }
}