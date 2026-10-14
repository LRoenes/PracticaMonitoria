/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Revan
 */
public class Package {
    private double weight;
    private Content type;
    private double value;

    public Package(double weight, Content type, double value) {
        this.weight = weight;
        this.type = type;
        this.value = value;
    }

    public Content getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }
    
    
    
}
