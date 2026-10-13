/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.Vehicle;

/**
 *
 * @author Luis
 */
public class Plane extends Vehicle{
    private String code;

    public Plane(float cargoCapacity, String code) {
        super(cargoCapacity);
        this.code = code;
    }
    
}
