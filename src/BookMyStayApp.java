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

class Booking {
    int bookingId;
    String roomType;
    int roomsBooked;
    ArrayList<String> services;
    double totalCost;

    Booking(int bookingId, String roomType, int roomsBooked) {
        this.bookingId = bookingId;
        this.roomType = roomType;
        this.roomsBooked = roomsBooked;
        this.services = new ArrayList<>();
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        rooms.add(new Room("Single Room", 2000, 5));
        rooms.add(new Room("Double Room", 3500, 3));
        rooms.add(new Room("Suite", 5000, 2));

        Scanner sc = new Scanner(System.in);
        int bookingCounter = 1001;

        System.out.print("Enter room type to book: ");
        String searchType = sc.nextLine();

        for (Room room : rooms) {

            if (room.type.equalsIgnoreCase(searchType)) {

                System.out.print("Enter number of rooms: ");
                int requestedRooms = sc.nextInt();

                if (requestedRooms <= room.availableRooms) {

                    room.availableRooms -= requestedRooms;

                    Booking booking = new Booking(bookingCounter++, room.type, requestedRooms);
                    bookings.add(booking);

                    System.out.println("Booking Confirmed ✅");
                    System.out.println("Booking ID: " + booking.bookingId);
                }
            }
        }

        System.out.print("\nEnter Booking ID to cancel: ");
        int cancelId = sc.nextInt();

        boolean cancelled = false;

        for (int i = 0; i < bookings.size(); i++) {

            Booking b = bookings.get(i);

            if (b.bookingId == cancelId) {

                for (Room room : rooms) {
                    if (room.type.equalsIgnoreCase(b.roomType)) {
                        room.availableRooms += b.roomsBooked;
                    }
                }

                bookings.remove(i);
                cancelled = true;

                System.out.println("Booking Cancelled ✅");
                break;
            }
        }

        if (!cancelled) {
            System.out.println("Invalid Booking ID ❌");
        }

        sc.close();
    }
}