package org.example.classes;

import org.example.classes.*;

public class Tractor extends Car{

    public boolean clearing;

    public Tractor(){
        super("Tractor");
        //this.name = "Tractor";
    }
    public String clearSnow(){
        clearing =true;
        return "> Чистим чистим снег.\n";
    }
}
