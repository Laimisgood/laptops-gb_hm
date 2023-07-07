public class Laptop {
    private String model;
    private int RAM;
    private int hardDriveCapacity;
    private String operatingSystem;
    private String color;

    public Laptop(String model, int RAM, int hardDriveCapacity, String operatingSystem, String color) {
        this.model = model;
        this.RAM = RAM;
        this.hardDriveCapacity = hardDriveCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}
