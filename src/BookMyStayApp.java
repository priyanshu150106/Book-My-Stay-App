import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(" Version: 1.3 ");
        System.out.println("=================================\n");

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Single Room", 2000, 5));
        rooms.add(new Room("Double Room", 3500, 3));
        rooms.add(new Room("Suite", 5000, 2));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter room type to search: ");
        String searchType = sc.nextLine();

        boolean found = false;

        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(searchType)) {
                found = true;

                System.out.println("\nRoom Found!");
                System.out.println("Room Type: " + room.type);
                System.out.println("Price: ₹" + room.price);
                System.out.println("Available Rooms: " + room.availableRooms);

                if (room.availableRooms > 0) {
                    System.out.println("Status: Available ✅");
                } else {
                    System.out.println("Status: Not Available ❌");
                }
            }
        }

        if (!found) {
            System.out.println("\nRoom type not found ❌");
        }

        sc.close();
    }
}