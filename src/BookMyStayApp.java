import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Room {
    String type;
    int availableRooms;

    Room(String type, int availableRooms) {
        this.type = type;
        this.availableRooms = availableRooms;
    }
}

class Booking {
    int bookingId;
    String roomType;
    int roomsBooked;

    Booking(int bookingId, String roomType, int roomsBooked) {
        this.bookingId = bookingId;
        this.roomType = roomType;
        this.roomsBooked = roomsBooked;
    }
}

public class BookMyStayApp {

    static final String FILE_NAME = "bookings.txt";

    public static void main(String[] args) {

        ArrayList<Booking> bookings = loadBookings();

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Single Room", 5));
        rooms.add(new Room("Double Room", 3));
        rooms.add(new Room("Suite", 2));

        Scanner sc = new Scanner(System.in);

        int bookingCounter = bookings.size() + 1001;

        System.out.print("Enter room type to book: ");
        String type = sc.nextLine();

        for (Room room : rooms) {

            if (room.type.equalsIgnoreCase(type)) {

                System.out.print("Enter number of rooms: ");
                int num = sc.nextInt();

                if (num <= room.availableRooms) {

                    room.availableRooms -= num;

                    Booking booking = new Booking(bookingCounter++, room.type, num);
                    bookings.add(booking);

                    saveBookings(bookings);

                    System.out.println("Booking Confirmed ✅");
                    System.out.println("Booking ID: " + booking.bookingId);
                } else {
                    System.out.println("Not enough rooms ❌");
                }
            }
        }

        System.out.println("\nRecovered Booking History:");

        for (Booking b : bookings) {
            System.out.println(b.bookingId + " | " + b.roomType + " | " + b.roomsBooked);
        }

        sc.close();
    }

    static void saveBookings(ArrayList<Booking> bookings) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME);

            for (Booking b : bookings) {
                fw.write(b.bookingId + "," + b.roomType + "," + b.roomsBooked + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Error saving data ❌");
        }
    }

    static ArrayList<Booking> loadBookings() {
        ArrayList<Booking> bookings = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String type = data[1];
                int rooms = Integer.parseInt(data[2]);

                bookings.add(new Booking(id, type, rooms));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No previous data found (fresh start)");
        }

        return bookings;
    }
}