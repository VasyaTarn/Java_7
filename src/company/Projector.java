package company;

public class Projector {
    private String name;
    private int releaseYear;
    private double price;
    private String manufacturer;

    public Projector(String name, int releaseYear, double price, String manufacturer) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.price = price;
        this.manufacturer = manufacturer;
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

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Projector: " + name + ", Release year: " + releaseYear + ", Price: " + price + ", Manufacturer: " + manufacturer;
    }
}
