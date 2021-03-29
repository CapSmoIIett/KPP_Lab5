package org.example.classes;

public class Body extends Detail{
    private int amountDoors;

    Body(int weight, int amount){
        this.weight = weight;
        this.amountDoors = amount;
    }
    public String openDoors(){
        return "> Дверь открыта\n";
    }

    public String closeDoors(){
        return "> Дверь закрыта\n";
    }
}
