/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkingsystem;

/**
 *
 * @author Administrator
 */
public class ParkingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Vehicle car1 = new Vehicle();
//        System.out.println(car1.getLicPlate());
//        Vehicle car2 = new Vehicle();
//        System.out.println(car2.getLicPlate());
        Parking p = new Parking();
//        System.out.println(p.getSlot(10, 10).getSlotNumber());
        Vehicle car1 = new Vehicle();
        System.out.println(car1.getLicPlate());
        p.assignVehicleToSlot(car1);
        System.out.println(p.getCapacity() + " "
                            + p.getUsedSlot() + " "
                            + p.getRemainingSlot());
        Vehicle car2 = new Vehicle();
        System.out.println(car2.getLicPlate());
        p.assignVehicleToSlot(car2);
        System.out.println(p.getCapacity() + " "
                            + p.getUsedSlot() + " "
                            + p.getRemainingSlot());
    }
    
}
