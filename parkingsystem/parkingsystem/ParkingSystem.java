/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkingsystem;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ParkingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        final int max_vehicle = 1000;
        Parking p = new Parking();
        Scanner inp = new Scanner(System.in);
        int choice;
        Vehicle []car = new Vehicle[max_vehicle];
        Vehicle vehicleCheckInDB = null;
        FileOutputStream fileOut = new FileOutputStream("text.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        FileInputStream fileIn = new FileInputStream("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\ParkingSystem\\text.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        
        do{
            Menu();
            choice = inp.nextInt();
            switch (choice){
                case 1: 
                    car[Vehicle.count] = new Vehicle();
                    System.out.println(Vehicle.count);
                    System.out.println("car "+car[Vehicle.count-1].getLicPlate()+" is added");
                    addcar();
                    choice = inp.nextInt();
                    if (choice == 1){
                        p.assignVehicleToSlot(car[Vehicle.count-1]);
                        out.writeObject(car[Vehicle.count-1]);
                        System.out.println("Write file successfully.");
                    }
                    break;
                
                case 2:
                    int posCarUnParking = (int) (Math.random()*p.getUsedSlot()-1);
                    System.out.println("Car "+ car[posCarUnParking].getLicPlate()+" want to leave the parking lot.");
                    System.out.println("Checking ticket...");
                    System.out.println("Inserted ticket:");
                    System.out.println(car[posCarUnParking].getTicket());
                    System.out.println("Database ticket:");
                    for(int i=0;i<p.getUsedSlot();i++){
                        vehicleCheckInDB = (Vehicle) in.readObject();
                        if (vehicleCheckInDB.getTicket().getID()==car[posCarUnParking].getTicket().getID()){
                            System.out.println(vehicleCheckInDB.getTicket());
                            p.freeSlot(vehicleCheckInDB.getTicket().getSlot());
                            break;
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("capacity: "+p.getCapacity()+
                                        "\nused slot: "+p.getUsedSlot()+
                                        "\nremaining slot: "+p.getRemainingSlot());
                    break;
            }
        } while (choice != 4);
        out.close();
        fileOut.close();
        in.close();
        fileIn.close();
    }
    
    public static void Menu(){
        System.out.println("Parking system");
        System.out.println("1. add a car");
        System.out.println("2. remove a car");
        System.out.println("3. show parking status");
        System.out.println("4. exit");
    }
    
    public static void addcar(){
        System.out.println("add a car");
        System.out.println("1. print ticket and make a slot");
        System.out.println("2. back");
    }
}
