import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - UseCase14TrainConsistMgmt
 * ============================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity
 *
 * Description:
 * Prevents creation of passenger bogies with invalid capacity
 * using a custom exception.
 *
 * @author Developer
 * @version 14.0
 */

public class TrainConsistManagementApp {

    // ----- CUSTOM EXCEPTION -----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ----- PASSENGER BOGIE CLASS -----
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        // Header
        System.out.println("======================================");
        System.out.println("   UC14 - Handle Invalid Bogie Capacity");
        System.out.println("======================================\n");

        try {
            // Valid bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1.type + " -> " + b1.capacity);

            // Invalid bogie (will throw exception)
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}