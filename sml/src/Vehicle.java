// Definition of the Vehicle class representing a vehicle object with various attributes such as VIN, year, make, model, etc.
public class Vehicle {
    // Instance variables representing different attributes of a vehicle
    private int vin; // Vehicle Identification Number (VIN)
    private int year; // Year of manufacture
    private String make; // Make of the vehicle (e.g., Toyota, Ford)
    private String model; // Model of the vehicle (e.g., Camry, F-150)
    private String vehicleType; // Type of vehicle (e.g., Sedan, SUV)
    private String color; // Color of the vehicle
    private int odometer; // Odometer reading (in miles or kilometers)
    private double price; // Price of the vehicle

    // Constructor to initialize a Vehicle object with specified attributes
    public Vehicle(int vin, int year, String make, String model,
                   String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getter methods to retrieve the values of instance variables
    public double getPrice() {
        return price;
    }

    public int getOdometer() {
        return odometer;
    }

    public String getColor() {
        return color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    // Setter methods to set the values of instance variables
    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
