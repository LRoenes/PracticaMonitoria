/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.Vehicle.Vehicle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    
    public boolean addLogisticsCenter(String name, String city, String street, double latitude, double longitude){
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
    
    public Vehicle getVehicle(int index){
        return vehicles.get(index);
    }
    
    public LogisticsCenter getLogisticsCenter(int index){
        return centers.get(index);
    }

    public void packageSummary() {
        HashMap<Content,List<Double>> frecuencia = new HashMap<>();
        List<Double> values = new ArrayList<>(Arrays.asList(0.0,0.0,0.0));
        
        System.out.println("Package summary:");
        for(Client client : this.clients){
            for (Shipping shipping : client.getShippings()){
                for (Package pAckage : shipping.getPackages()){
                    Content content = pAckage.getType();
                    frecuencia.put(content, frecuencia.getOrDefault(frecuencia.get(content), new ArrayList<Double>(Arrays.asList(0.0,0.0,0.0))));
                    List<Double> accumulators = frecuencia.getOrDefault(content, new ArrayList<Double>(Arrays.asList(0.0,0.0,0.0)));
                    double currentNum = accumulators.get(0);
                    double currentWeight = accumulators.get(1);
                    double currentValue = accumulators.get(2);
                    accumulators.set(0, currentNum+1);
                    accumulators.set(0, currentWeight+pAckage.getWeight());
                    accumulators.set(0, currentValue+pAckage.getValue());
                    
                }
            }
        }
    }
//    Package summary:
//- DOCUMENTS
//  - Number of packages: 8
//  - Total weight of packages: 4,094 kg
//  - Total value of packages: $463,17
//- ELECTRONICS
//  - Number of packages: 8
//  - Total weight of packages: 287,399 kg
//  - Total value of packages: $18552,17
//- CLOTHING
//  - Number of packages: 7
//  - Total weight of packages: 78,126 kg
//  - Total value of packages: $3662,41
//- OTHERS
//  - Number of packages: 9
//  - Total weight of packages: 160,937 kg
//  - Total value of packages: $2804,08

}
