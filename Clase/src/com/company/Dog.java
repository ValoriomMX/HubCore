package com.company;

public class Dog {
    // Raza de perro
    public String race;
    public int weight;
    public int maxSpeed;
    public int years;
    public int genre;

    public void printDog() {
        System.out.println(race);
        System.out.println(weight + " Kg");
        System.out.println(maxSpeed + " Km/h");
    }

    public void alternative() {
        System.out.println(weight + " Kg");
        System.out.println(maxSpeed + " Km/h");

        int suma = weight+maxSpeed;
        System.out.println(" ");

        System.out.println("Suma de Peso y velocidad » " + suma);
        int resta = suma-maxSpeed;
        System.out.println("Una resta » " + resta);
    }

}
