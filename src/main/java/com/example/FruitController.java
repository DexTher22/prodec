package com.example;

import java.util.List;

public class FruitController {
    FruitService fruitService;
    FruitView fruitView;

    public FruitController(FruitService fruitService, FruitView fruitView) {
        this.fruitService = fruitService;
        this.fruitView = fruitView;
        initApplication();
    }

    private void initApplication() {
        List<Fruit> fruitList = fruitService.findAll();
        fruitView.printFruits(fruitList);
    }
}
