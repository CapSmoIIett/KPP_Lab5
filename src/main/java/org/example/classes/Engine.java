package org.example.classes;

import java.util.ArrayList;

public class Engine extends Detail{

    boolean start;                      // Завелись мы или нет

    Engine(int weight){
        start = false;
        this.weight = weight;

    }
    public void work(ArrayList<Detail> details){                     // Мотору работать
        if (!start) start = true;                                       // Завелись
        ((FuelTank)details.get(1)).wasteFuel(10 * FuelTank.L);            // - 10 литров
        ((Wheel)details.get(2)).speen();                                         // Крутим колеса
        ((Wheel)details.get(3)).speen();
        ((Wheel)details.get(4)).speen();
        ((Wheel)details.get(5)).speen();
    }
    public void stop(ArrayList<Detail> details){                            // Останавливаемся
        start = false;                                                      // Глохнем
        ((Wheel)details.get(2)).speen();                                    // Останавливаем колеса
        ((Wheel)details.get(3)).speen();
        ((Wheel)details.get(4)).speen();
        ((Wheel)details.get(5)).speen();
    }
}
