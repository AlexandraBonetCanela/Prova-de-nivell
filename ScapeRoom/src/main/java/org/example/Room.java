package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String name;
    private int difficulyLevel;
    private BigDecimal totalEuros;
    private List<RoomElement> roomElements;

    public Room(int id, String name, int difficulyLevel) {
        this.id = id;
        this.name = name;
        this.difficulyLevel = difficulyLevel;
        this.roomElements = new ArrayList<>();
        this.totalEuros = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public void addRoomExtra(RoomElement roomElement){
        roomElements.add(roomElement);
    }

    public List<RoomElement> getRoomElements() {
        return roomElements;
    }

    public BigDecimal getTotalEuros() {
        return totalEuros;
    }

    public void setTotalEuros(BigDecimal totalEuros) {
        this.totalEuros = totalEuros;
    }

    @Override
    public String toString() {
        return name;
    }
}
