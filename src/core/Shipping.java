/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.Vehicle.Vehicle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Revan
 */
public class Shipping {
    private String code;
    private Client client;
    private LogisticsCenter originCenter;
    private LogisticsCenter destinationCenter;
    private LocalDate registrationDate;
    private LocalDate deliveryDate;
    private Status status;
    private List<Package> packages;

   

    public Shipping(String code, Client client, LogisticsCenter originCenter, LogisticsCenter destinationCenter, LocalDate registrationDate, LocalDate deliveryDate, Status status, Vehicle vehicle) {
        this.code = code;
        this.client = client;
        this.originCenter = originCenter;
        this.destinationCenter = destinationCenter;
        this.registrationDate = registrationDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }
    
    public String getCode(){
        return this.code;
    }
    //addPackage(30.256, Content.ELECTRONICS, 1518.64);
    public void addPackage(double weight, Content type, double value){
        Package pAckage = new Package(weight,type,value);
        this.packages.add(pAckage);
    }
    
    public List<Package> getPackages(){
        return this.packages;
    }
    
    
    

    
}
