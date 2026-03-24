import java.util.ArrayList;

class Room {
    String type;
    int availableRooms;

    Room(String type, int availableRooms) {
        this.type = type;
        this.availableRooms = availableRooms;
    }

    synchronized void bookRoom(String user, int roomsRequested) {

        System.out.println(user + " trying to book " + roomsRequested + " rooms");

        if (roomsRequested <= availableRooms) {

            System.out.println(user + " booking in progress...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }

            availableRooms -= roomsRequested;

            System.out.println(user + " booking successful ✅");
            System.out.println("Remaining Rooms: " + availableRooms);
        } else {
            System.out.println(user + " booking failed ❌ (Not enough rooms)");
        }

        System.out.println("----------------------------------");
    }
}

class BookingThread extends Thread {

    Room room;
    String user;
    int roomsRequested;

    BookingThread(Room room, String user, int roomsRequested) {
        this.room = room;
        this.user = user;
        this.roomsRequested = roomsRequested;
    }

    public void run() {
        room.bookRoom(user, roomsRequested);
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        Room room = new Room("Suite", 2);

        Thread user1 = new BookingThread(room, "User A", 2);
        Thread user2 = new BookingThread(room, "User B", 2);

        user1.start();
        user2.start();
    }
}