/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Slots implements Serializable {
    private Vehicle v;
    private int slotNumber;
    private boolean is_avai;
    
    public Slots(Slots s){
        v = s.v;
        slotNumber = s.slotNumber;
        is_avai = s.is_avai;
    }
    
    public Slots(int i){
        slotNumber = i;
        is_avai = true;
    }
    
    public int getSlotNumber(){
        return slotNumber;
    }
    
    public Vehicle getVehicle(){
        return new Vehicle(v);
    }
    
    public boolean getStatus(){
        return is_avai;
    }
    public void assignVehicle(Vehicle vehicle){
        v = vehicle;
        is_avai = false;
        v.setTicket(new Ticket(v,this));
        System.out.println("Slot "+ getSlotNumber() + " is assign to vehicle " + v.getLicPlate());
        System.out.println(v.getTicket());
    }
    public void removeVehicle(){
        v = null;
        is_avai = true;
        System.out.println("Slot "+getSlotNumber()+" is available.");
    }
    
    public String getVehicleInformation(){
        return v.getLicPlate();
    }
}
