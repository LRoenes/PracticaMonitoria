import java.time.LocalDate;

public class MainParcial2038 {
    
    public static void main(String[] args) {
        // Create CargoLink
        CargoLink link = new CargoLink();
        
        // Add clients
        link.addClient(new Client(2000501, "John Doe", "123 Main St", "john.doe@example.com"));
        link.addClient(new Client(2000502, "Jane Smith", "456 Elm St", "jane.smith@example.com"));
        link.addClient(new Client(2000503, "Alice Johnson", "789 Oak St", "alice.johnson@example.com"));
        link.addClient(new Client(2000504, "Bob Brown", "321 Pine St", "bob.brown@example.com"));
        link.addClient(new Client(2000505, "Charlie Davis", "654 Maple St", "charlie.davis@example.com"));

        // Add logistics centers
        link.addLogisticsCenter("Central Hub", "New York", "USA", 40.7128, -74.0060);
        link.addLogisticsCenter("West Coast Hub", "Los Angeles", "USA", 34.0522, -118.2437);
        link.addLogisticsCenter("European Hub", "Berlin", "Germany", 52.5200, 13.4050);
        link.addLogisticsCenter("Asian Hub", "Tokyo", "Japan", 35.6895, 139.6917);
        link.addLogisticsCenter("South American Hub", "Sao Paulo", "Brazil", -23.5505, -46.6333);
        link.addLogisticsCenter("African Hub", "Johannesburg", "South Africa", -26.2041, 28.0473);
        link.addLogisticsCenter("Australian Hub", "Sydney", "Australia", -33.8688, 151.2093);
        link.addLogisticsCenter("Middle East Hub", "Dubai", "UAE", 25.2048, 55.2708);
        link.addLogisticsCenter("Central America Hub", "Mexico City", "Mexico", 19.4326, -99.1332);
        link.addLogisticsCenter("Eastern Europe Hub", "Warsaw", "Poland", 52.2297, 21.0122);

        // Add vehicles
        link.addVehicle(new Truck(10000.0, "ABC-1234"));
        link.addVehicle(new Ship(50000.0, "SS Cargo"));
        link.addVehicle(new Plane(20000.0, "PL-5678"));
        link.addVehicle(new Truck(15000.0, "DEF-5678"));
        link.addVehicle(new Ship(75000.0, "SS Freight"));
        link.addVehicle(new Plane(30000.0, "PL-9012"));
        
        // Create shippings
        // Shipping 1
        link.getClient(2000501).makeShipping(
                "S00001", link.getLogisticsCenter(0), link.getLogisticsCenter(1), 
                LocalDate.of(2025, 3, 11), LocalDate.of(2024, 7, 5), 
                Status.IN_TRANSIT, link.getVehicle(0));
        link.getClient(2000501).getShipping("S00001").addPackage(25.471, Content.ELECTRONICS, 150.64);
        link.getClient(2000501).getShipping("S00001").addPackage(0.698, Content.DOCUMENTS, 20.15);
        link.getClient(2000501).getShipping("S00001").addPackage(15.407, Content.OTHERS, 67.30);
        link.getClient(2000501).getShipping("S00001").addPackage(5.712, Content.CLOTHING, 207.99);
        
        // Shipping 2
        link.getClient(2000502).makeShipping(
                "S00002", link.getLogisticsCenter(2), link.getLogisticsCenter(3), 
                LocalDate.of(2024, 4, 15), LocalDate.of(2024, 8, 10), 
                Status.DELIVERED, link.getVehicle(1));
        link.getClient(2000502).getShipping("S00002").addPackage(50.158, Content.ELECTRONICS, 5020.99);
        link.getClient(2000502).getShipping("S00002").addPackage(0.500, Content.DOCUMENTS, 100.84);
        link.getClient(2000502).getShipping("S00002").addPackage(10.874, Content.OTHERS, 300.15);

        // Shipping 3
        link.getClient(2000503).makeShipping(
                "S00003", link.getLogisticsCenter(4), link.getLogisticsCenter(5), 
                LocalDate.of(2024, 5, 20), LocalDate.of(2024, 9, 15), 
                Status.CANCELED, link.getVehicle(2));
        link.getClient(2000503).getShipping("S00003").addPackage(20.174, Content.CLOTHING, 1018.47);
        link.getClient(2000503).getShipping("S00003").addPackage(5.695, Content.OTHERS, 200.69);
        
        // Shipping 4
        link.getClient(2000504).makeShipping(
                "S00004", link.getLogisticsCenter(6), link.getLogisticsCenter(7), 
                LocalDate.of(2024, 6, 25), LocalDate.of(2024, 10, 20), 
                Status.IN_TRANSIT, link.getVehicle(3));
        link.getClient(2000504).getShipping("S00004").addPackage(30.256, Content.ELECTRONICS, 1518.64);

        // Shipping 5
        link.getClient(2000505).makeShipping(
                "S00005", link.getLogisticsCenter(8), link.getLogisticsCenter(9), 
                LocalDate.of(2024, 7, 30), LocalDate.of(2024, 11, 25), 
                Status.DELIVERED, link.getVehicle(4));
        link.getClient(2000505).getShipping("S00005").addPackage(40.789, Content.OTHERS, 800.25);
        link.getClient(2000505).getShipping("S00005").addPackage(10.321, Content.CLOTHING, 500.75);
        link.getClient(2000505).getShipping("S00005").addPackage(0.250, Content.DOCUMENTS, 50.10);

        // Shipping 6
        link.getClient(2000501).makeShipping(
                "S00006", link.getLogisticsCenter(1), link.getLogisticsCenter(2), 
                LocalDate.of(2024, 8, 5), LocalDate.of(2024, 12, 30), 
                Status.IN_TRANSIT, link.getVehicle(5));
        link.getClient(2000501).getShipping("S00006").addPackage(25.471, Content.ELECTRONICS, 150.64);
        link.getClient(2000501).getShipping("S00006").addPackage(0.698, Content.DOCUMENTS, 20.15);

        // Shipping 7
        link.getClient(2000502).makeShipping(
                "S00007", link.getLogisticsCenter(3), link.getLogisticsCenter(4), 
                LocalDate.of(2024, 9, 10), LocalDate.of(2025, 1, 5), 
                Status.DELIVERED, link.getVehicle(0));
        link.getClient(2000502).getShipping("S00007").addPackage(15.407, Content.OTHERS, 67.30);
        link.getClient(2000502).getShipping("S00007").addPackage(5.712, Content.CLOTHING, 207.99);
        link.getClient(2000502).getShipping("S00007").addPackage(50.158, Content.ELECTRONICS, 5020.99);

        // Shipping 8
        link.getClient(2000503).makeShipping(
                "S00008", link.getLogisticsCenter(5), link.getLogisticsCenter(6), 
                LocalDate.of(2024, 10, 15), LocalDate.of(2025, 2, 10), 
                Status.IN_TRANSIT, link.getVehicle(1));
        link.getClient(2000503).getShipping("S00008").addPackage(0.500, Content.DOCUMENTS, 100.84);

        // Shipping 9
        link.getClient(2000504).makeShipping(
                "S00009", link.getLogisticsCenter(7), link.getLogisticsCenter(8), 
                LocalDate.of(2024, 11, 20), LocalDate.of(2025, 3, 15), 
                Status.IN_TRANSIT, link.getVehicle(2));
        link.getClient(2000504).getShipping("S00009").addPackage(10.874, Content.OTHERS, 300.15);
        link.getClient(2000504).getShipping("S00009").addPackage(20.174, Content.CLOTHING, 1018.47);
        link.getClient(2000504).getShipping("S00009").addPackage(5.695, Content.OTHERS, 200.69);

        // Shipping 10
        link.getClient(2000505).makeShipping(   
                "S00010", link.getLogisticsCenter(9), link.getLogisticsCenter(0), 
                LocalDate.of(2024, 12, 25), LocalDate.of(2025, 4, 20), 
                Status.CANCELED, link.getVehicle(3));
        link.getClient(2000505).getShipping("S00010").addPackage(30.256, Content.ELECTRONICS, 1518.64);
        link.getClient(2000505).getShipping("S00010").addPackage(40.789, Content.OTHERS, 800.25);
        
        // Shipping 11
        link.getClient(2000501).makeShipping(
                "S00011", link.getLogisticsCenter(0), link.getLogisticsCenter(2), 
                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 5, 5), 
                Status.DELIVERED, link.getVehicle(4));
        link.getClient(2000501).getShipping("S00011").addPackage(10.321, Content.CLOTHING, 500.75);
        link.getClient(2000501).getShipping("S00011").addPackage(0.250, Content.DOCUMENTS, 50.10);
        link.getClient(2000501).getShipping("S00011").addPackage(25.471, Content.ELECTRONICS, 150.64);
        link.getClient(2000501).getShipping("S00011").addPackage(0.698, Content.DOCUMENTS, 20.15);
        link.getClient(2000501).getShipping("S00011").addPackage(15.407, Content.OTHERS, 67.30);

        // Shipping 12
        link.getClient(2000502).makeShipping(
                "S00012", link.getLogisticsCenter(1), link.getLogisticsCenter(3), 
                LocalDate.of(2024, 2, 15), LocalDate.of(2024, 6, 10), 
                Status.IN_TRANSIT, link.getVehicle(3));
        link.getClient(2000502).getShipping("S00012").addPackage(5.712, Content.CLOTHING, 207.99);
        link.getClient(2000502).getShipping("S00012").addPackage(50.158, Content.ELECTRONICS, 5020.99);
        link.getClient(2000502).getShipping("S00012").addPackage(0.500, Content.DOCUMENTS, 100.84);

        // Execute methods
        link.packageSummary();
        link.vehicleSummary();
        
        System.out.println("The client with highest total declared value is: " + link.getClientHighestDeclaredValue().getName());
        System.out.println("The highest total declared value among all clients is: $" + String.format("%.2f", link.getHighestDeclaredValue()));
        
        LogisticsCenter center = link.getCenterHighestWeight();
        System.out.println("The logistics center with highest total weight in its shippings is " + center.getName() + " at " + center.getCity() + ", " + center.getCountry());
        
        LocalDate start = LocalDate.of(2024, 9, 15);
        LocalDate end = LocalDate.of(2025, 3, 15);
        System.out.println("The client with most packages between " + start + " and " + end + " is: " + link.getClientMaxPackages(start, end).getName());
    }
    
}

/**
------------- Resultados -------------

Package summary:
- DOCUMENTS
  - Number of packages: 8
  - Total weight of packages: 4,094 kg
  - Total value of packages: $463,17
- ELECTRONICS
  - Number of packages: 8
  - Total weight of packages: 287,399 kg
  - Total value of packages: $18552,17
- CLOTHING
  - Number of packages: 7
  - Total weight of packages: 78,126 kg
  - Total value of packages: $3662,41
- OTHERS
  - Number of packages: 9
  - Total weight of packages: 160,937 kg
  - Total value of packages: $2804,08

Vehicle summary:
- TRUCK
  - Quantity: 2
  - Number of shippings: 5
  - Number of packages: 13
- PLANE
  - Quantity: 2
  - Number of shippings: 3
  - Number of packages: 7
- SHIP
  - Quantity: 2
  - Number of shippings: 4
  - Number of packages: 12

The client with highest total declared value is: Jane Smith
The highest total declared value among all clients is: $16048,08
The logistics center with highest total weight in its shippings is Asian Hub at Tokyo, Japan
The client with most packages between 2024-09-15 and 2025-03-15 is: John Doe
*/