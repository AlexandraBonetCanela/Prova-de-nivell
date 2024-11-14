package org.example;

import java.math.BigDecimal;

public class Hint extends RoomElement{

    private String estimatedTime;
    private static final Integer TAX = 10;

    public Hint(int id, BigDecimal price, String name, String estimatedTime){
        super(id, price, name);
        this.estimatedTime = estimatedTime;
    }

}
