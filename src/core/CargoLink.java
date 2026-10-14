/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.Vehicle.Plane;
import core.Vehicle.Truck;
import core.Vehicle.Ship;
import core.Vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

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
                    shipPackageCounter += shipping.getPackages().size();
                }
            }
        }
        System.out.println("Vehicle Summary: \n-TRUCK\n-Quantity: " + truckCounter + "\n-Number of shippings: " + truckShippingCounter + "\n-Number of packages: " + truckPackageCounter);
        System.out.println("Vehicle Summary: \n-PLANE\n-Quantity: " + planeCounter + "\n-Number of shippings: " + planeShippingCounter + "\n-Number of packages: " + planePackageCounter);
        System.out.println("Vehicle Summary: \n-SHIP\n-Quantity: " + shipCounter + "\n-Number of shippings: " + shipShippingCounter + "\n-Number of packages: " + shipPackageCounter);
    }
}
