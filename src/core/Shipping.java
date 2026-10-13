/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

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
    private Date registrationDate;
    private Date deliveryDate;
    private Status status;
    private List<Package> packages;
}
