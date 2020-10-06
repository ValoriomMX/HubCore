package com.company;

import java.awt.*;

public class Car {

    public String color;
    //Matricula
    public String id;
    public int weight;
    public int maxSpeed;
    // Aceleracio de Cotxo
    public int force;
    public int numDoors;

    public void brake() {

    }

    public void printCar() {
        System.out.println("----------------------");
        System.out.println(color);
        System.out.println(weight);
        System.out.println(maxSpeed);
        System.out.println(force);
        System.out.println(numDoors);
        System.out.println(id);
        System.out.println("----------------------");
    }

}
