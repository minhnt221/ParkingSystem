/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Parking {
    private int max_row = 10;
    private int max_column = 10;
    private Slots [][]slots = new Slots[max_row][max_column];
    private int used_slot = 0;
    private int capacity = max_row*max_column;
    private ArrayList<Vehicle> currentVehicleInParkingLot = new ArrayList();
    
    public Parking(){
        //tao slot khi parking duoc tao
        for (int i = 0; i< max_row; i++){
            for (int j = 0; j< max_column; j++){
		slots[i][j] = new Slots(i*10+(j+1));
            }
	}
    }
    public void setMaxRow(int r){
        max_row = r;
    }
    public int getMaxRow(){
        return max_row;
    }
    public void setMaxColumn(int c){
        max_column = c;
    }
    public int getMaxColumn(){
        return max_column;
    }
    
    public int getUsedSlot(){
        return used_slot;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public int getRemainingSlot(){
        return capacity - used_slot;
    }
    
    public Slots getSlot(int i,int j){
        if (i<1||i>max_row||j<1||j>max_column){
            throw new ArithmeticException("Access denied - The x-axis must int range 1 to" 
                    + max_row + " and y-axis must in range 1 to " + max_column);
        }
        else{
            return slots[i-1][j-1];
        }      
    }
    public ArrayList getListCurrentVehicle(){
        return currentVehicleInParkingLot;
    }
    public void addVehicleToCurrentVehicle(Vehicle v){
        currentVehicleInParkingLot.add(v);
    }
    public void removeVehicleByID(int i){
        if (i<0 )
            throw new ArithmeticException("ID must be positive.");
        else{
            for (int a=0;a<currentVehicleInParkingLot.size();a++){
                if(currentVehicleInParkingLot.get(a).getTicket().getID()==i){
                    currentVehicleInParkingLot.remove(a);
                    break;
                }
                if(a == currentVehicleInParkingLot.size()-1 &&
                        currentVehicleInParkingLot.get(a).getTicket().getID()!=i){
                    System.out.println("No vehicle with such ID to remove");
                }
            }
        }  
    }
    public Vehicle getVehicleInCurrentVehicle(int i){
        if (i<0 || i>currentVehicleInParkingLot.size())
            throw new ArithmeticException("Only " + currentVehicleInParkingLot.size() 
                                            + "vehicle in the parking lot.");
        else
            return currentVehicleInParkingLot.get(i);
    }
    
    public void assignVehicleToSlot(Vehicle v){
        for (int i = 0; i< max_row; i++){
            for (int j = 0; j< max_column; j++){
		if (slots[i][j].isAvai()==true){
                    slots[i][j].assignVehicle(v);
                    used_slot++;
                    return;
                }    
                if (used_slot == getCapacity())
                    System.out.println("The Parking Lot is full.");
            }
	}
    }
    
    public void freeSlot(Slots s){
        if (used_slot<1){
            System.out.println("There is no vehicle in Parking Lot");
        }
        else{
            if (s.isAvai()==true){
                System.out.println("This slot has no vehicle.");
            }
            else {
                s.removeVehicle();
                System.out.println("Slot "+s.getSlotNumber()+" is available.");
                used_slot--;
            }
        }
        
    }
}
