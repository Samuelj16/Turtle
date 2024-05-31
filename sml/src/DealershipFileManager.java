import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Definition of the DealershipFileManager class
public class DealershipFileManager {
    // Method to read dealership information and vehicle inventory from a file and create a Dealership object
    public Dealership getDealership() {
        Dealership dealership = null; // Initialize dealership object
        try {
            // Create a Scanner to read from the file "inventory.csv"
            Scanner scanner = new Scanner(new File("inventory.csv"));
            if (scanner.hasNextLine()) {
                // Read the first line containing dealership information
                String dealerLine = scanner.nextLine();
                // Split the line into individual components using the pipe character as delimiter
                String[] items = dealerLine.split("\\|");
                // Extract dealership information
                String name = items[0];
                String address = items[1];
                String phone = items[2];
                // Create a new Dealership object using the extracted information
                dealership = new Dealership(name, address, phone);
            }
            // Read vehicle information from subsequent lines and add vehicles to the dealership's inventory
            while (scanner.hasNextLine()) {
                // Read a line containing vehicle information
                String vehicleLine = scanner.nextLine();
                // Split the line into individual components using the pipe character as delimiter
                String[] items = vehicleLine.split("\\|");
                // Extract vehicle details
                int vin = Integer.parseInt(items[0]);
                int year = Integer.parseInt(items[1]);
                String make = items[2];
                String model = items[3];
                String vehicleType = items[4];
                String color = items[5];
                int odometer = Integer.parseInt(items[6]);
                double price = Double.parseDouble(items[7]);
                // Create a new Vehicle object using the extracted information
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                // Add the vehicle to the dealership's inventory
                dealership.addVehicle(vehicle);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Print error trace if the file is not found
        }
        return dealership; // Return the created dealership object
    }

    // Method to save dealership information and vehicle inventory to a file (not implemented yet)
    public void saveDealership(Dealership dealership) {
        // Implementation pending
    }
}
