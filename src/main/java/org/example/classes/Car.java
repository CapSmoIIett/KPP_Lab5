package org.example.classes;

import java.util.*;
//import org.example.classes.Detail;

public class Car {                      // Класс машины

    String name;
    public boolean flagGo;
    ArrayList<Detail> details;

    public Car(String str){
        flagGo = false;
        details = new ArrayList<Detail>(6);        // 4 - колеса, двигатель и топливный бак
        details.add(0, new Engine(0));
        details.add(1, new FuelTank(0));
        details.add(2, new Wheel(0));
        details.add(3, new Wheel(0));
        details.add(4, new Wheel(0));
        details.add(5, new Wheel(0));
        name = str;
    }

    public void go(){                          // Метод ехать
        if (((FuelTank)getTank()).fuel > 0){            // Если есть топливо
            ((Engine) details.get(0)).work(details);
            flagGo = true;                                // Мы едем
            return;
        }
        flagGo = false;                                   // Мы не завелись
    }

    public void stop(){
        ((Engine)details.get(0)).stop(details);
        flagGo = false;
    }

    public Detail getTank(){return details.get(1);}
    public Detail getEngine(){ return details.get(0);}
    public Detail getWheel1() {return details.get(2);}
    public Detail getWheel2() {return details.get(3);}
    public Detail getWheel3() {return details.get(4);}
    public Detail getWheel4() {return details.get(5);}
}
