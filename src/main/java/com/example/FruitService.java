package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FruitService {
    
    Database database;

    public FruitService(Database database) {
        this.database = database;
    }

    public List<Fruit> findAll() {
        try {
            return tryFindAll();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private List<Fruit> tryFindAll() throws SQLException {
        Connection con = database.connect();
        String sql = "select * from products";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Fruit> fruitList = new ArrayList<>();
        while(rs.next()) {
            Fruit fruit = new Fruit();
            fruitList.add(setFruit(rs, fruit));
        } 

        con.close();
        return fruitList;
        
        
    }

    private Fruit setFruit(ResultSet rs, Fruit fruit) {
        try {
            return trySetFruit(rs, fruit);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Fruit trySetFruit(ResultSet rs, Fruit fruit) throws SQLException {
        fruit.setId(rs.getInt("id"));
        fruit.setName(rs.getString("name"));
        fruit.setPrice(rs.getInt("price"));
        fruit.setQuantity(rs.getInt("quantity"));
        fruit.setDescription(rs.getString("description"));
        return fruit;
    }
    
    


}
