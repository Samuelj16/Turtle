import java.util.List;
import java.util.Scanner;

// Definition of the UserInterface class
public class UserInterface {

    private Dealership dealership; // Instance variable to store the dealership object

    // Constructor for UserInterface class
    public UserInterface(){

    }

    // Method to initialize the dealership object by reading data from a file
    private void init(){
        // Create a DealershipFileManager object to manage file operations
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        // Retrieve dealership information and inventory from the file
        dealership =  dealershipFileManager.getDealership();
    }

    // Method to display the user interface and handle user interactions
    public void display(){
        // Initialize the dealership object
        init();
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true; // Flag to control loop execution
        int choice = -1; // Variable to store user choice
        // Display menu and process user input until the user chooses to exit
        while(shouldContinue){
            printMenu(); // Display menu options
            choice = scanner.nextInt(); // Read user choice
            // Process user choice using a switch statement
            switch (choice){
                case 1: processGetByPriceRequest(); break;
                case 2: processGetByMakeModelRequest(); break;
                case 3: processGetByYearRequest(); break;
                case 4: processGetByColorRequest(); break;
                case 5: processGetByMileageRequest(); break;
                case 6: processGetByVehicleTypeRequest(); break;
                case 7: processGetAllVehiclesRequest(); break;
                case 8: processAddVehicleRequest(); break;
                case 9: processRemoveVehicleRequest(); break;
            }
        }
    }

    // Method to display a list of vehicles
    private void displayVehicles(List<Vehicle> vehicles){
        // Display header for vehicle data
        System.out.printf("%-10s%-10s%-15s%-15s%-10s%-10s%-10s%-10s%n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        // Display vehicle data row by row
        for (Vehicle vehicle: vehicles) {
            System.out.printf("%-10d%-10d%-15s%-15s%-10s%-10s%-10d%-10.2f%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }

    }

    // Method to print the menu options
    private void printMenu() {
        System.out.println("1. Get vehicle by price");
        System.out.println("2. Get vehicle by make and model");
        System.out.println("3. Get vehicle by year");
        System.out.println("4. Get vehicle by color");
        System.out.println("5. Get vehicle by mileage");
        System.out.println("6. Get vehicle by type");
        System.out.println("7. Get all vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
    }

    // Methods to process various user requests (placeholders for now)
    private void processGetByPriceRequest(){

    }

    private void processGetByMakeModelRequest(){

    }

    private void processGetByYearRequest(){

    }

    private void processGetByColorRequest(){

    }

    private void processGetByMileageRequest(){

    }

    private void processGetByVehicleTypeRequest(){

    }

    private void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles); // Display all vehicles
    }

    private void processAddVehicleRequest(){

    }

    private void processRemoveVehicleRequest(){

    }
}
