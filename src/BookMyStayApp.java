import java.util.ArrayList;

class Room {
    String type;
    double price;
    int availableRooms;

    Room(String type, double price, int availableRooms) {
        this.type = type;
        this.price = price;
        this.availableRooms = availableRooms;
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Hotel Booking System ");
        System.out.println(" Version: 1.2 ");
        System.out.println("=================================\n");

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Single Room", 2000, 5));
        rooms.add(new Room("Double Room", 3500, 3));
        rooms.add(new Room("Suite", 5000, 2));

        System.out.println("Room Inventory:\n");

        for (Room room : rooms) {
            System.out.println("Room Type: " + room.type);
            System.out.println("Price: ₹" + room.price);
            System.out.println("Available Rooms: " + room.availableRooms);
            System.out.println("-----------------------------");
        }
    }
}