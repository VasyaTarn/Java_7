package company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // -------- 1 --------

        List<Integer> numbers = new Random().ints(100, -1000, 1000)
                .boxed()
                .collect(Collectors.toList());

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();

        long twoDigitCount = numbers.stream()
                .filter(n -> Math.abs(n) >= 10 && Math.abs(n) < 100)
                .count();

        long mirrorNumberCount = numbers.stream()
                .filter(Main::isMirrorNumber)
                .count();

        System.out.println("Number of positive numbers: " + positiveCount);
        System.out.println("Number of negative numbers: " + negativeCount);
        System.out.println("Number of two-digit numbers: " + twoDigitCount);
        System.out.println("Number of mirror numbers: " + mirrorNumberCount);

        // -------- 2 --------
        System.out.println();

        List<String> products = Arrays.asList(
                "Молоко", "Хлеб", "Сыр", "Яблоко", "Молоко", "Кефир", "Масло", "Молоко", "Йогурт", "Сок", "Чай", "Молоко"
        );

        System.out.println("All products:");
        for(String product : products)
        {
            System.out.print(product + " ");
        }

        System.out.println("\nProducts with a name less than five characters:");
        products.stream()
                .filter(p -> p.length() < 5)
                .forEach(System.out::println);

        System.out.println("\nEnter product name to search:");
        String searchProduct = scanner.nextLine();

        long count = products.stream()
                .filter(p -> p.equalsIgnoreCase(searchProduct))
                .count();
        System.out.println("Product " + searchProduct + " meets " + count + " times.");

        System.out.println("\nEnter the starting letter to filter products:");
        String startLetter = scanner.nextLine();

        System.out.println("Products starting with letter " + startLetter + ":");
        products.stream()
                .filter(p -> p.startsWith(startLetter))
                .forEach(System.out::println);

        System.out.println("\nПродукты из категории Молоко:");
        products.stream()
                .filter(p -> p.equalsIgnoreCase("Молоко"))
                .forEach(System.out::println);

        // -------- 3 --------
        System.out.println();

        List<Device> devices = Arrays.asList(
                new Device("Smartphone", 2021, 1000.0, "Black", "Mobile device"),
                new Device("Laptop", 2019, 1500.0, "Grey", "Computer"),
                new Device("Tablet", 2020, 800.0, "White", "Mobile device"),
                new Device("Smart watch", 2022, 400.0, "Black", "Wearable device"),
                new Device("TV", 2018, 1200.0, "Black", "Electronics")
        );

        System.out.println("All devices:");
        devices.forEach(System.out::println);

        System.out.println("\nEnter a color to filter devices:");
        String color = scanner.nextLine();
        System.out.println("Color devices " + color + ":");
        devices.stream()
                .filter(d -> d.getColor().equalsIgnoreCase(color))
                .forEach(System.out::println);

        System.out.println("\nEnter the year of manufacture to filter devices:");
        int year = scanner.nextInt();
        System.out.println("Devices released in " + year + " year:");
        devices.stream()
                .filter(d -> d.getReleaseYear() == year)
                .forEach(System.out::println);

        System.out.println("\nEnter minimum price:");
        double minPrice = scanner.nextDouble();
        System.out.println("Devices are more expensive " + minPrice + ":");
        devices.stream()
                .filter(d -> d.getPrice() > minPrice)
                .forEach(System.out::println);

        scanner.nextLine();

        System.out.println("\nEnter the type of device to filter:");
        String type = scanner.nextLine();
        System.out.println("Device type \"" + type + "\":");
        devices.stream()
                .filter(d -> d.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);

        System.out.println("\nEnter starting year of issue:");
        int startYear = scanner.nextInt();
        System.out.println("Enter final year of issue:");
        int endYear = scanner.nextInt();
        System.out.println("Devices released from " + startYear + " to " + endYear + " year:");
        devices.stream()
                .filter(d -> d.getReleaseYear() >= startYear && d.getReleaseYear() <= endYear)
                .forEach(System.out::println);

        // -------- 4 --------
        System.out.println();

        List<Projector> projectors = Arrays.asList(
                new Projector("proj1", 2023, 1500.0, "Sony"),
                new Projector("proj2", 2021, 1200.0, "Epson"),
                new Projector("proj3", 2023, 2000.0, "BenQ"),
                new Projector("proj4", 2022, 1000.0, "Sony"),
                new Projector("proj5", 2024, 1300.0, "Epson")
        );

        System.out.println("All projectors:");
        projectors.forEach(System.out::println);

        System.out.println("\nEnter manufacturer to filter:");
        String manufacturer = scanner.nextLine();
        System.out.println("Manufacturer projectors " + manufacturer + ":");
        projectors.stream()
                .filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(System.out::println);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("\nProjectors of the current year (" + currentYear + "):");
        projectors.stream()
                .filter(p -> p.getReleaseYear() == currentYear)
                .forEach(System.out::println);

        System.out.println("\nEnter minimum price:");
        double minPrice_4 = scanner.nextDouble();
        System.out.println("Projectors are more expensive " + minPrice_4 + ":");
        projectors.stream()
                .filter(p -> p.getPrice() > minPrice_4)
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by price ascending:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by price, descending:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by year of manufacture in ascending order:");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getReleaseYear))
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by year of manufacture in descending order:");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getReleaseYear).reversed())
                .forEach(System.out::println);
    }

    private static boolean isMirrorNumber(int number) {
        String str = String.valueOf(Math.abs(number));
        return str.contentEquals(new StringBuilder(str).reverse());
    }
}