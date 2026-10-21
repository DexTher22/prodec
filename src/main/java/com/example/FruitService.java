package com.example;

import java.sql.Connection;

public class FruitService {
    
    Database database;

    public FruitService(Database database) {
        this.database = database;
    }

    public List<Fruit> findAll() {
        try {
            return tryFindAll()
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private List<Fruit> tryFindAll() {
        
    }
    
    


}
