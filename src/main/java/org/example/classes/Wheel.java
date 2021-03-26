package org.example.classes;

public class Wheel extends Detail{

    boolean speen;

    Wheel(int weight){
        speen = false;
        this.weight = weight;
    }

    public void speen (){                       //
        if (!speen) speen = true;
        else speen = false;
    }

    public String status (){                    //
        if (speen) return "Крутятся";
        return "Не крутятся";
    }
}
