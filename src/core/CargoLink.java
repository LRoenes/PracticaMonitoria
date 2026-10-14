/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.Vehicle.Plane;
import core.Vehicle.Truck;
import core.Vehicle.Ship;
import core.Vehicle.Vehicle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author Luis
 */
public class CargoLink {

    private List<Client> clients;
    private List<LogisticsCenter> centers;
    private List<Vehicle> vehicles;

    public CargoLink() {
        this.clients = new ArrayList<>();
        this.centers = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    public boolean addClient(Client client) {
        this.clients.add(client);
        return true;
    }

    public boolean addLogisticsCenter(String name, String city, String street, double latitude, double longitude) {
        LogisticsCenter center = new LogisticsCenter(name, city, street, latitude, longitude);
        this.centers.add(center);
        return true;
    }

    public boolean addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        return true;
    }

    public Client getClient(int clientId) {
        for (Client client : this.clients) {
            if (client.getId() == clientId) {
                return client;
            }
        }
        return null;
    }

    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    public LogisticsCenter getLogisticsCenter(int index) {
        return centers.get(index);
    }

    public void packageSummary() {
        HashMap<Content, List<Double>> frecuencia = new HashMap<>();
        List<Double> values = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));

        System.out.println("Package summary:");
        for (Client client : this.clients) {
            for (Shipping shipping : client.getShippings()) {
                for (Package pAckage : shipping.getPackages()) {
                    Content content = pAckage.getType();
                    List<Double> accumulators = frecuencia.getOrDefault(content,
                            new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0)));
                    double currentNum = accumulators.get(0);
                    double currentWeight = accumulators.get(1);
                    double currentValue = accumulators.get(2);
                    accumulators.set(0, currentNum + 1);
                    accumulators.set(1, currentWeight + pAckage.getWeight());
                    accumulators.set(2, currentValue + pAckage.getValue());
                    frecuencia.put(content, accumulators);

                }
            }
        }
        for (Content key : Content.values()) {
            if (frecuencia.containsKey(key)) {
                System.out.println("- " + key);
                System.out.println("  - Number of packages: " + frecuencia.get(key).get(0).intValue());
                System.out.println("  - Total weight of packages: " + String.format(Locale.forLanguageTag("es-ES"), "%.3f kg", frecuencia.get(key).get(1)));
                System.out.println("  - Total value of packages: " + String.format(Locale.forLanguageTag("es-ES"), "$%.2f", frecuencia.get(key).get(2)));
            }
        }
    }
    // Package summary:
    // - DOCUMENTS
    // - Number of packages: 8
    // - Total weight of packages: 4,094 kg
    // - Total value of packages: $463,17
    // - ELECTRONICS
    // - Number of packages: 8
    // - Total weight of packages: 287,399 kg
    // - Total value of packages: $18552,17
    // - CLOTHING
    // - Number of packages: 7
    // - Total weight of packages: 78,126 kg
    // - Total value of packages: $3662,41
    // - OTHERS
    // - Number of packages: 9
    // - Total weight of packages: 160,937 kg
    // - Total value of packages: $2804,08

    public void vehicleSummary() {
        int truckCounter = 0, planeCounter = 0, shipCounter = 0;
        int truckShippingCounter = 0, planeShippingCounter = 0, shipShippingCounter = 0;
        int truckPackageCounter = 0, planePackageCounter = 0, shipPackageCounter = 0;

        for (Vehicle vehicle : this.vehicles) {
            if (vehicle instanceof Truck) {
                truckCounter++;
                truckShippingCounter += vehicle.getShippings().size();
                for (Shipping shipping : vehicle.getShippings()) {
                    truckPackageCounter += shipping.getPackages().size();
                }
            }
            if (vehicle instanceof Ship) {
                shipCounter++;
                shipShippingCounter += vehicle.getShippings().size();
                for (Shipping shipping : vehicle.getShippings()) {
                    shipPackageCounter += shipping.getPackages().size();
                }
            }
            if (vehicle instanceof Plane) {
                planeCounter++;
                planeShippingCounter += vehicle.getShippings().size();
                for (Shipping shipping : vehicle.getShippings()) {
                    planePackageCounter += shipping.getPackages().size();
                }
            }
        }
        System.out.println("Vehicle summary:");
        System.out.println("- TRUCK\n  - Quantity: " + truckCounter + "\n  - Number of shippings: "
                + truckShippingCounter + "\n  - Number of packages: " + truckPackageCounter);
        System.out.println("- PLANE\n  - Quantity: " + planeCounter + "\n  - Number of shippings: "
                + planeShippingCounter + "\n  - Number of packages: " + planePackageCounter);
        System.out.println("- SHIP\n  - Quantity: " + shipCounter + "\n  - Number of shippings: "
                + shipShippingCounter + "\n  - Number of packages: " + shipPackageCounter);
    }

    public Client getClientHighestDeclaredValue() {
        double value = 0, highestValue = 0;
        int index = 0, indexFound = 0;
        for (Client client : this.clients) {
            value = 0;
            for (Shipping shipping : client.getShippings()) {
                for (Package pack : shipping.getPackages()) {
                    value += pack.getValue();
                }
            }
            if (value > highestValue) {
                highestValue = value;
                indexFound = index;
            }
            index++;
        }
        return clients.get(indexFound);
    }

    public double getHighestDeclaredValue() {
        Client client = this.getClientHighestDeclaredValue();
        double value = 0;
        for (Shipping shipping : client.getShippings()) {
            for (Package pack : shipping.getPackages()) {
                value += pack.getValue();
            }
        }
        return value;
    }

    public Client getClientMaxPackages(LocalDate start, LocalDate end) {
        HashMap<Client, Integer> frecuencia = new HashMap<>();

        for (Client client : this.clients) {
            int num = client.getNumPackagesBetweenDates(start, end);
            frecuencia.put(client, num);
        }

        return Collections.max(frecuencia.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public LogisticsCenter getCenterHighestWeight() {
        double weight = 0, highestWeight = 0;
        int index = 0, indexFound = 0;
        for (LogisticsCenter center : this.centers) {
            weight = 0;
            for (Shipping shipping : center.getShippings()) {
                for (Package pack : shipping.getPackages()) {
                    weight += pack.getWeight();
                }
            }
            if (weight > highestWeight) {
                highestWeight = weight;
                indexFound = index;
            }
            index++;
        }
        return centers.get(indexFound);
    }
}
