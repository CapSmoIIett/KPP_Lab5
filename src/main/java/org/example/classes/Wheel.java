package org.example.classes;

public class Wheel extends Detail{

    boolean speen;
    boolean pump;

    Wheel(int weight){
        speen = false;
        pump = true;
        this.weight = weight;
    }

    public void speen (){                       //
        speen = true;
    }
    public void stopSpeen(){
        speen = false;
    }

    public String status (){                    //
        if (speen) return "Крутится";
        return "Не крутится";
    }

    public String statusPump(){
        if (pump) return "Надуто";
        return "Сдут";
    }
    public void makeHole(){
        pump = false;
    }
    public void pumpIt(){
        pump = true;
    }
}
