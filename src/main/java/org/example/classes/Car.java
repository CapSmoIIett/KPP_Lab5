package org.example.classes;

import java.util.*;
import java.math.*;
//import org.example.classes.Detail;

public class Car {                      // Класс машины

    private String name;
    public boolean flagGo;
    private ArrayList<Detail> details;

    public Car(String str){
        flagGo = false;
        details = new ArrayList<Detail>();        // 4 - колеса, двигатель и топливный бак
        details.add(0, new Engine(0));
        details.add(1, new FuelTank(0));
        details.add(2, new Wheel(0));
        details.add(3, new Wheel(0));
        details.add(4, new Wheel(0));
        details.add(5, new Wheel(0));
        details.add(6, new Body(0, 1));
        name = str;
    }

    public void go(){                          // Метод ехать
        if (((FuelTank)getTank()).fuel > 0 && getWheel1().pump && getWheel2().pump && getWheel3().pump && getWheel4().pump){            // Если есть топливо
            ((Engine) details.get(0)).work(details);
            flagGo = true;                                // Мы едем
            return;
        }
        flagGo = false;                                   // Мы не завелись
    }

    public void stop(){
        ((Engine)details.get(0)).stop(details);
        Random r = new Random();
        if (r.nextInt(10) == 1){
            ((Wheel)details.get(r.nextInt(4) + 2)).makeHole();      // make hole in random wheel
        }
        flagGo = false;
    }

    public void fixWheels (){
        getWheel1().pumpIt();
        getWheel2().pumpIt();
        getWheel3().pumpIt();
        getWheel4().pumpIt();
    }

    public FuelTank getTank(){ return (FuelTank)details.get(1);}
    public Engine getEngine(){ return (Engine)details.get(0);}
    public Wheel getWheel1() { return (Wheel)details.get(2);}
    public Wheel getWheel2() { return (Wheel)details.get(3);}
    public Wheel getWheel3() { return (Wheel)details.get(4);}
    public Wheel getWheel4() { return (Wheel)details.get(5);}
    public Body getBody()    { return (Body)details.get(6);}
}
