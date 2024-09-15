package company;

public class Device {
    private String name;
    private int releaseYear;
    private double price;
    private String color;
    private String type;

    public Device(String name, int releaseYear, double price, String color, String type) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Device: " + name + ", Release year: " + releaseYear + ", Price: " + price + ", Color: " + color + ", Type: " + type;
    }
}
