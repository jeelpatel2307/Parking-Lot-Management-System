import java.util.*;

class ParkingLot {
    private int capacity;
    private Queue<Integer> availableSlots;
    private Map<Integer, String> slotCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSlots = new PriorityQueue<>();
        for (int i = 1; i <= capacity; i++) {
            availableSlots.offer(i);
        }
        this.slotCarMap = new HashMap<>();
    }

    public int park(String car) {
        if (availableSlots.isEmpty()) {
            return -1; // Parking lot is full
        }
        int slot = availableSlots.poll();
        slotCarMap.put(slot, car);
        return slot;
    }

    public String leave(int slot) {
        if (!slotCarMap.containsKey(slot)) {
            return null; // No car found at the given slot
        }
        String car = slotCarMap.remove(slot);
        availableSlots.offer(slot);
        return car;
    }

    public void status() {
        System.out.println("Slot No.\tRegistration No");
        for (Map.Entry<Integer, String> entry : slotCarMap.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5); // Create a parking lot with capacity 5

        // Park some cars
        int slot1 = parkingLot.park("KA-01-HH-1234");
        int slot2 = parkingLot.park("KA-01-HH-9999");
        int slot3 = parkingLot.park("KA-01-BB-0001");

        // Leave a car
        parkingLot.leave(slot2);

        // Park another car
        int slot4 = parkingLot.park("KA-01-HH-7777");

        // Display current status
        parkingLot.status();
    }
}
