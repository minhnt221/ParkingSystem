/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

/**
 *
 * @author Administrator
 */
public class Slots {
    private Vehicle v;
    private int slotNumber;
    private boolean is_avai;
    
    public Slots(int s){
        slotNumber = s;
        is_avai = true;
    }
    
    public int getSlotNumber(){
        return slotNumber;
    }
    
    public Vehicle getVehicle(){
        return v;
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
    }
    
    public String getVehicleInformation(){
        return v.getLicPlate();
    }
}
