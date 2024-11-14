package org.example;

import java.math.BigDecimal;

public class DecorationObject extends RoomElement{

    private String material;
    private static final Integer TAX = 21;

    public DecorationObject(int id, BigDecimal price, String name, String material) {
        super(id, price, name);
        this.material = material;
    }
}
