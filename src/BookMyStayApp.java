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

        System.out.println("=================================");
        System.out.println(" Welcome to Hotel Booking System ");
        System.out.println(" Version: 1.6 ");
        System.out.println("=================================\n");

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        rooms.add(new Room("Single Room", 2000, 5));
        rooms.add(new Room("Double Room", 3500, 3));
        rooms.add(new Room("Suite", 5000, 2));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter room type to book: ");
        String searchType = sc.nextLine();

        boolean found = false;
        int bookingCounter = 1001;

        for (Room room : rooms) {

            if (room.type.equalsIgnoreCase(searchType)) {
                found = true;

                System.out.println("\nAvailable Rooms: " + room.availableRooms);
                System.out.print("Enter number of rooms to book: ");
                int requestedRooms = sc.nextInt();
                sc.nextLine();

                if (requestedRooms <= room.availableRooms) {

                    room.availableRooms -= requestedRooms;

                    Booking booking = new Booking(bookingCounter, room.type, requestedRooms);

                    double totalCost = requestedRooms * room.price;

                    System.out.println("\nSelect Add-On Services:");
                    System.out.println("1. WiFi (₹500)");
                    System.out.println("2. Breakfast (₹800)");
                    System.out.println("3. Parking (₹300)");
                    System.out.println("4. No Add-On");

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
                        default:
                            break;
                    }

                    booking.totalCost = totalCost;
                    bookings.add(booking);

                    System.out.println("\nBooking Confirmed ✅");
                    System.out.println("Booking ID: " + booking.bookingId);
                    System.out.println("Room Type: " + booking.roomType);
                    System.out.println("Rooms Booked: " + booking.roomsBooked);
                    System.out.println("Services: " + booking.services);
                    System.out.println("Total Cost: ₹" + booking.totalCost);
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