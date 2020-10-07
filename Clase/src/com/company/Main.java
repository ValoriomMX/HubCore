package com.company;

public class Main {

    public static void main(String[] args) {

        Car ferrari = new Car();

        ferrari.color = "RED";
        ferrari.weight = 200;
        ferrari.force = 10;
        ferrari.maxSpeed = 300;
        ferrari.numDoors = 2;
        ferrari.id = "Hola";

        if (ferrari.color == "RED") {

        }

        ferrari.printCar();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.maxSpeed = 200;
        dog1.race = "Mussamban1";
        dog1.weight = 30;

        dog2.race = "FliPiN";
        dog2.weight = 40;
        dog2.maxSpeed = 400;

        if (dog1.race == null) {
            System.out.println("----------------------");
            System.out.println("Dog1 race is empty.");
            System.out.println("----------------------");
        } else {
            System.out.println("----------------------");
            System.out.println("Team Liquid = Bots");
            System.out.println(" ");
            dog1.printDog();
            System.out.println("----------------------");
        }

        if (dog2.race == "FliPiN") {
            System.out.println("----------------------");
            System.out.println("Si o noooooooooo");
            System.out.println("Vamos es TGDs por el chat");
            System.out.println(" ");
            dog2.alternative();
            System.out.println("----------------------");
        } else {
            dog2.printDog();
        }

    }
}