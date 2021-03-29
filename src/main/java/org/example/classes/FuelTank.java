package org.example.classes;

public class FuelTank extends Detail{
    private long maxFuel = 50000;
    public long fuel;

    public static int L = 1000;            // Литр

    FuelTank(int weight){
        this.weight = weight;
        fuel = 0;
    }

    public void wasteFuel(int amount){     // Тратим топливо
        fuel -= amount;
        if (fuel < 0) fuel = 0;
    }

    public void addFuel(int amount){    // Добавляем топливо
        fuel += amount;
        if (fuel > maxFuel) fuel = maxFuel;
    }
}
