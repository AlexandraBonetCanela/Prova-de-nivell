package org.example;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int roomQuantity = 0;
    private static int hintQuantity = 0;
    private static int decorationObjectQuantity = 0;
    private static List<Room> rooms =new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        roomQuantity++;
        rooms.add(new Room(roomQuantity, "ItAcademy room", 7));

        roomQuantity++;
        rooms.add(new Room(roomQuantity, "Hostel room", 7));

        boolean finish = false;

        System.out.println("Welcome to the ScapeRoom");
        while (!finish){
            System.out.println("Please type the number of what you want to do next:");

            System.out.println("1. Create New Room");
            System.out.println("2. Add hints to a room");
            System.out.println("3. Add Decoration Object to a room");
            System.out.println("4. Show Inventory");
            System.out.println("5. Finish");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 5){
                finish = true;
            } else if (choice == 1){
                createRoom();
            } else if (choice == 2){
                addRoomHints();
            } else if (choice == 3){
                addRoomDecorationObjects();
            } else if (choice == 4){
                showInventory();
            }
        }
        System.out.println("Thank you for taking your time, see you again soon!");
    }

    // 1. Create a new room
    public static void createRoom(){
        System.out.println("Welcome to the ScapeRoom, please introduce the name of the new room:");
        String newRoomName = scanner.nextLine();

        System.out.println("Introduce the difficulty level (between 1 to 10):");
        int newRoomDifficultyLevel = scanner.nextInt();

        roomQuantity++;

        Room newRoom =  new Room(roomQuantity, newRoomName, newRoomDifficultyLevel);
        rooms.add(newRoom);
        System.out.println("Room created successfully!");
    }

    // 2.Add hints to a room
    public static void addRoomHints(){
        System.out.println("Here are the room available. Introduce the name of the room you want to add hints:");
        rooms.forEach(System.out::println);

        String selectedRoom = scanner.nextLine();

        boolean found = false;
        for (Room room : rooms) {
            if (room.getName().equals(selectedRoom)) {
                found = true;
                addHint(room);
                break;
            }
        }
        if (found) {

        } else {
            System.out.println("Room with name '" + selectedRoom + "' not found. Try again!");
            addRoomHints();
        }
    }

    // 3. Add Decoration Objects
    public static void addRoomDecorationObjects(){
        System.out.println("Here are the room available. Introduce the name of the room you want to add the Decoration Objects:");
        rooms.forEach(System.out::println);

        String selectedRoom = scanner.nextLine();

        boolean found = false;
        for (Room room : rooms) {
            if (room.getName().equals(selectedRoom)) {
                found = true;
                addDecorationObject(room);
                break;
            }
        }
        if (found) {

        } else {
            System.out.println("Room with name '" + selectedRoom + "' not found. Try again!");
            addRoomDecorationObjects();
        }
    }

    // 4. Inventory
    public static void showInventory(){
        for (Room room : rooms){
            Field[] fields = room.getClass().getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                try {
                    // Print the field name and value
                    System.out.println(field.getName() + ": " + field.get(room));
                } catch (IllegalAccessException e) {
                    System.out.println("An error while reading the inventory has been produced");
                }

          }
            BigDecimal totalRoomPrice = BigDecimal.ZERO;
            for (RoomElement roomElement : room.getRoomElements()) {
                if (roomElement.getPrice() != null) {
                    totalRoomPrice = totalRoomPrice.add(roomElement.getPrice());
                }
            }
            room.setTotalEuros(totalRoomPrice);
            System.out.println("Total price: "+ room.getTotalEuros());// Set the calculated total price

        }
    }

    public static void addHint(Room room){

        System.out.println("Introduce the name of the hint:");
        String newHintName = scanner.nextLine();

        System.out.println("Introduce the price:");
        String input = scanner.nextLine();
        BigDecimal newHintPrice = new BigDecimal(input);

        System.out.println("Introduce the duration:");
        String newHintEstimatedTime = scanner.nextLine();

        hintQuantity++;
        Hint newHint = new Hint(hintQuantity, newHintPrice, newHintName, newHintEstimatedTime);

        room.addRoomExtra(newHint);
        System.out.println("Hint successfully added to room"+ room.toString());
        System.out.println("Do you want to add another hint to this room? YES or NO");

        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("YES")){
            addHint(room);
        }
    }

    public static void addDecorationObject(Room room){
        System.out.println("Introduce the name of the Decoration Object: ");
        String newDecorationObjectName = scanner.nextLine();

        System.out.println("Introduce the price:");
        String input = scanner.nextLine();
        BigDecimal newDecorationObjectPrice = new BigDecimal(input);

        System.out.println("Introduce the type:");
        String newDecorationObjectType = scanner.nextLine();

        decorationObjectQuantity++;
        DecorationObject newDecorationObject = new DecorationObject(decorationObjectQuantity, newDecorationObjectPrice, newDecorationObjectName, newDecorationObjectType);

        room.addRoomExtra(newDecorationObject);
        System.out.println("Decoration Object successfully added to room"+ room.toString());
        System.out.println("Do you want to add another decoration object to this room? YES or NO");

        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("YES")){
            addDecorationObject(room);
        }
    }
}