package org.example.classes;

import  org.example.classes.*;
public class Driver {
    private static Car car;
    private String name;

    public Driver(String nam, Tractor car) {
        this.name = name;
        this.car = car;
    }

    public static String drive(){
        String answer = "";
        answer += car.getBody().openDoors();
        answer += "> Водитель сел.\n";
        answer += car.getBody().closeDoors();
        car.go();
        if (car.flagGo) {
            answer += "> Водитель - водит.\n";
        }
        else {
            answer += "> Не едет\n";
            answer += stopDrive();
        }
        return answer;
    }
    public String clearSnow(){
        String answer = "";
        answer += car.getBody().openDoors();
        answer += "> Водитель сел.\n";
        answer += car.getBody().closeDoors();
        car.go();
        if (car.flagGo) {
            answer += ((Tractor)car).clearSnow();
        }
        else {
            answer += "> Не едет\n";
            answer += stopDrive();
        }
        return answer;
    }

    public static String stopDrive(){
        String answer = "";
        car.stop();
        answer += car.getBody().openDoors();
        answer += "> Водитель вышел.\n";
        answer += car.getBody().closeDoors();
        return answer;
    }
}
