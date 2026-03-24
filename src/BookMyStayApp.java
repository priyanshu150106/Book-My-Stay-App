import java.util.ArrayList;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Hotel Booking System ");
        System.out.println(" Version: 1.1 ");
        System.out.println("=================================\n");

        ArrayList<String> roomTypes = new ArrayList<>();
        roomTypes.add("Single Room");
        roomTypes.add("Double Room");
        roomTypes.add("Suite");

        int[] availability = {5, 3, 2};

        System.out.println("Available Room Types:\n");

        for (int i = 0; i < roomTypes.size(); i++) {
            System.out.println("Room Type: " + roomTypes.get(i));
            System.out.println("Available Rooms: " + availability[i]);
            System.out.println("-----------------------------");
        }
    }
}