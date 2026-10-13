/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Revan
 */
public class Client {
    private int id;
    private String name;
    private String address;
    private String email;
    private List<Shipping> shippings;
    //link.addClient(new Client(2000501, "John Doe", "123 Main St", "john.doe@example.com"));
    
    public Client(int id, String name, String address, String email){
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }
    
    
//    makeShipping(
//                "S00011", link.getLogisticsCenter(0), link.getLogisticsCenter(2), 
//                LocalDate.of(2024, 1, 10), LocalDate.of(2024, 5, 5), 
//                Status.DELIVERED, link.getVehicle(4));

    public int getId() {
        return id;
    }

}
