package org.example;

import java.math.BigDecimal;
import java.time.Duration;

public class IntriguingClues extends RoomElement{

    private Duration estimatedTime;
    private static final Integer TAX = 10;

    public IntriguingClues(int id, BigDecimal price, String name, Duration estimatedTime){
        super(id, price, name);
        this.estimatedTime = estimatedTime;
    }

}
