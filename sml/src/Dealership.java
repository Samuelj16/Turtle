import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition of the Dealership class
public class Dealership {
    // Instance variables to store dealership information
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory; // ArrayList to store vehicles in the dealership's inventory

    // Constructor to initialize a Dealership object with name, address, and phone number
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList(); // Initialize the inventory ArrayList
    }

    // Method to get vehicles within a price range
    public List<Vehicle> getVehicleByPrice(double min, double max) {
        return null; // Placeholder, to be implemented
    }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        return null; // Placeholder, to be implemented
    }

    // Method to get vehicles within a certain year range
    public List<Vehicle> getVehicleByYear(int min, int max) {
        return null; // Placeholder, to be implemented
    }

    // Method to get vehicles by color
    public List<Vehicle> getVehicleByColor(String color) {
        return null; // Placeholder, to be implemented
    }

    // Method to get vehicles within a certain mileage range
    public List<Vehicle> getVehicleByMileage(int min, int max) {
        return null; // Placeholder, to be implemented
    }

    // Method to get vehicles by type (e.g., sedan, SUV, truck)
    public List<Vehicle> getVehicleByType(String vehicleType) {
        return null; // Placeholder, to be implemented
    }

    // Method to get all vehicles in the inventory (read-only)
    public List<Vehicle> getAllVehicles() {
        return Collections.unmodifiableList(this.inventory); // Return unmodifiable list to prevent direct modification
    }

    // Method to add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle); // Add vehicle to the inventory ArrayList
    }

    // Method to remove a vehicle from the inventory (not implemented yet)
    public void removeVehicle(Vehicle vehicle) {
        // Implementation pending
    }

    // Getter method for dealership name
    public String getName() {
        return this.name;
    }

    // Getter method for dealership address
    public String getAddress() {
        return this.address;
    }

    // Getter method for dealership phone number
    public String getPhone() {
        return this.phone;
    }

    // Setter method for dealership name
    public void setName(String name) {
        this.name = name;
    }

    // Setter method for dealership address
    public void setAddress(String address) {
        this.address = address;
    }

    // Setter method for dealership phone number
    public void setPhone(String phone) {
        this.phone = phone;
    }
}