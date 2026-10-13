/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

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
    
    public boolean addClient(Client client){
        this.clients.add(client);
        return true;
    }
    
    public boolean addLogisticsCenter(String name, String city, String street, float latitude, float longitude){
        LogisticsCenter center = new LogisticsCenter(name, city, street, latitude, longitude);
        this.centers.add(center);
        return true;
    }
    
    public boolean addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
        return true;
    }
    
    public Client getClient(int clientId){
        for(Client client: this.clients){
            if(client.getId() == clientId){
                return client;
            }
        }
        return null;
    }
}
