/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

/**
 *
 * @author Administrator
 */
public class Parking {
    private final int max_row = 10;
    private final int max_column = 10;
    private Slots [][]slots = new Slots[max_row][max_column];
    private int used_slot = 0;
    private int capacity = max_row*max_column;
    
    public Parking(){
        for (int i = 0; i< max_row; i++){
            for (int j = 0; j< max_column; j++){
		slots[i][j] = new Slots(i*10+(j+1));
            }
	}
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
    
    public void assignVehicleToSlot(Vehicle v){
        for (int i = 0; i< max_row; i++){
            for (int j = 0; j< max_column; j++){
		if (slots[i][j].getStatus()==true){
                    slots[i][j].assignVehicle(v);
                    used_slot++;
                    return;
                }    
            }
	}
    }
    
    public void freeSlot(Slots s){
        if (s.getVehicleInformation() == )
    }
}
