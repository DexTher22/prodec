package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gyümölcsök...");
        FruitService fruitService = new FruitService(new Sqlite());
        FruitView fruitView = new FruitView();
        new FruitController(fruitService, fruitView);

    }
}