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
        System.out.println(" Version: 1.4 ");
        System.out.println("=================================\n");

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Single Room", 2000, 5));
        rooms.add(new Room("Double Room", 3500, 3));
        rooms.add(new Room("Suite", 5000, 2));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter room type to book: ");
        String searchType = sc.nextLine();

        boolean found = false;

        for (Room room : rooms) {

            if (room.type.equalsIgnoreCase(searchType)) {
                found = true;

                System.out.println("\nRoom Found!");
                System.out.println("Available Rooms: " + room.availableRooms);

                System.out.print("Enter number of rooms to book: ");
                int requestedRooms = sc.nextInt();

                if (requestedRooms <= room.availableRooms) {
                    room.availableRooms -= requestedRooms;

                    System.out.println("\nBooking Successful ✅");
                    System.out.println("Rooms Booked: " + requestedRooms);
                    System.out.println("Remaining Rooms: " + room.availableRooms);
                } else {
                    System.out.println("\nBooking Failed ❌");
                    System.out.println("Not enough rooms available");
                }
            }
        }

        if (!found) {
            System.out.println("\nRoom type not found ❌");
        }

        sc.close();
    }
}