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

        try {

            System.out.print("Enter room type to book: ");
            String searchType = sc.nextLine();

            boolean found = false;

            for (Room room : rooms) {

                if (room.type.equalsIgnoreCase(searchType)) {
                    found = true;

                    System.out.println("Available Rooms: " + room.availableRooms);
                    System.out.print("Enter number of rooms to book: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input ❌ (Enter numbers only)");
                        return;
                    }

                    int requestedRooms = sc.nextInt();

                    if (requestedRooms <= 0) {
                        System.out.println("Invalid number of rooms ❌");
                        return;
                    }

                    if (requestedRooms > room.availableRooms) {
                        System.out.println("Not enough rooms available ❌");
                        return;
                    }

                    room.availableRooms -= requestedRooms;

                    Booking booking = new Booking(bookingCounter++, room.type, requestedRooms);

                    double totalCost = requestedRooms * room.price;

                    System.out.println("Select Add-On Service:");
                    System.out.println("1. WiFi (₹500)");
                    System.out.println("2. Breakfast (₹800)");
                    System.out.println("3. Parking (₹300)");
                    System.out.println("4. None");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid service choice ❌");
                        return;
                    }

                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            booking.services.add("WiFi");
                            totalCost += 500;
                            break;
                        case 2:
                            booking.services.add("Breakfast");
                            totalCost += 800;
                            break;
                        case 3:
                            booking.services.add("Parking");
                            totalCost += 300;
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice ❌");
                            return;
                    }

                    booking.totalCost = totalCost;
                    bookings.add(booking);

                    System.out.println("Booking Confirmed ✅");
                    System.out.println("Booking ID: " + booking.bookingId);
                }
            }

            if (!found) {
                System.out.println("Room type not found ❌");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error occurred ❌");
        }

        sc.close();
    }
}