/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkingsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        Parking p = new Parking();
        Scanner inp = new Scanner(System.in);
        
        //tao object vehicle
        final int max_vehicle = 1000;
        Vehicle []car = new Vehicle[max_vehicle];
        //arr list de luu cac vehicle dang trong parkinglot
        ArrayList<Vehicle> currentVehicleInParkingLot = new ArrayList();
        
        //Luu ra file history toan bo cac xe
        FileOutputStream fileOutHistory = new FileOutputStream("history.txt");
        ObjectOutputStream outHistory = new ObjectOutputStream(fileOutHistory);
        FileOutputStream makeFile = new FileOutputStream("current.txt");
        
//        FileInputStream fileInHistory = new FileInputStream("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\ParkingSystem\\history.txt");
//        ObjectInputStream inHistory = new ObjectInputStream(fileInHistory);
//        FileInputStream fileInCurrent = new FileInputStream("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\ParkingSystem\\current.txt");
//        ObjectInputStream inCurrent = new ObjectInputStream(fileInCurrent);
        
        int []getParkingStatus = new int[101];
        int choice;
        
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
                    
                    //assign vehicle vua tao vao trong parking
                    if (choice == 1){
                        //parking kiem slot cho vehicle, in ve
                        p.assignVehicleToSlot(car[Vehicle.count-1]);
                        
                        //them vehicle vao array current 
                        currentVehicleInParkingLot.add(car[Vehicle.count-1]);
                        
                        //ghi ra file history va file current
                        outHistory.writeObject(car[Vehicle.count-1]);
                        updateCurrentFile(car[Vehicle.count-1]);
                    }
                    break;
                
                case 2:
                    int posCarUnParking = (int) (Math.random()*(p.getUsedSlot()-1)+1);
                    //lay thong tin ve xe muon unparking
                    System.out.println("Car "+ currentVehicleInParkingLot.get(posCarUnParking).getLicPlate()+" want to leave the parking lot.");
                    System.out.println("Checking ticket...");
                    System.out.println("Inserted ticket:");
                    System.out.println(currentVehicleInParkingLot.get(posCarUnParking).getTicket());
                    
                    //lay thong tin ve xe trong file
                    System.out.println("Database ticket:");
                    for(int i=0;i<p.getUsedSlot();i++){
                        //neu ID ve xe giong nhau thi cho ra
                        System.out.println(p.getTicket(i).getID());
                        if (p.getTicket(i).getID() == currentVehicleInParkingLot.get(posCarUnParking).getTicket().getID()){
                            System.out.println(p.getTicket(i));
                            p.freeSlot(currentVehicleInParkingLot.get(i).getTicket().getDeepSlot().getSlotNumber());
                            currentVehicleInParkingLot.remove(i);
                            break;
                        }
                    }
                    //update cac xe trong parking lot
                    updateCurrentFile(p, currentVehicleInParkingLot);
                    
                    
                    
//                    for(int i=0;i<p.getUsedSlot();i++){
//                        vehicleCheckInDB.add((Vehicle) in.readObject());
//                    }
//                    for(int i=0;i<p.getUsedSlot();i++){
//                        
//                        if (vehicleCheckInDB.get(i).getTicket().getID()==car[posCarUnParking].getTicket().getID()){
//                            System.out.println(vehicleCheckInDB.get(i).getTicket());
//                            p.freeSlot(vehicleCheckInDB.get(i).getTicket().getSlot());
//                            vehicleCheckInDB.remove(i);
//                            System.out.println("Update DB.");
//                            for(int k=0;k<p.getUsedSlot();k++){
//                                out.writeObject(vehicleCheckInDB.get(k));
//                            }
//                        }
//                    }
                    break;
                    
                case 3:
                    System.out.println("capacity: "+p.getCapacity()+
                                        "\nused slot: "+p.getUsedSlot()+
                                        "\nremaining slot: "+p.getRemainingSlot());
                    break;
                
                case 4:
                    manageParking(p, getParkingStatus);
                    break;
            }
        } while (choice != 5);
        makeFile.close();
        outHistory.close();
        fileOutHistory.close();
        
//        inHistory.close();
//        inCurrent.close();
//        fileInHistory.close();
//        fileInCurrent.close();
    }
    
    public static void Menu(){
        System.out.println("Parking system");
        System.out.println("1. add a car");
        System.out.println("2. remove a car");
        System.out.println("3. show parking status");
        System.out.println("4. parking view");
        System.out.println("5. exit");
    }
    
    public static void addcar(){
        System.out.println("add a car");
        System.out.println("1. print ticket and make a slot");
        System.out.println("2. back");
    }
    
    public static void manageParking(Parking p, int []a){
        int count = 0;
        for (int i = 1; i< p.getMaxRow()+1; i++){
            for (int j = 1; j< p.getMaxColumn()+1; j++){
                if(p.getSlot(i, j).getStatus()==true){
                    a[(i-1)*10+j] = 0;
                }
                else
                    a[(i-1)*10+j] = 1;
                count++;
                System.out.print(a[(i-1)*10+j]+"  ");
                if(count ==10){
                    count=0;
                    System.out.println();
                }
            }
	}
        System.out.println();
    }
    public static void updateCurrentFile(Parking p, ArrayList c) throws IOException{
        FileOutputStream fileOutCurrentVehicle = new FileOutputStream("current.txt");
        ObjectOutputStream outCurrent = new ObjectOutputStream(fileOutCurrentVehicle);
        for(int i=0;i<p.getUsedSlot();i++){
            outCurrent.writeObject(c.get(i));
        }
        outCurrent.close();
        fileOutCurrentVehicle.close();
        System.out.println("Write file successfully.");
    }
    public static void updateCurrentFile(Vehicle v) throws IOException{
        FileOutputStream fileOutCurrentVehicle = new FileOutputStream("current.txt");
        ObjectOutputStream outCurrent = new ObjectOutputStream(fileOutCurrentVehicle);
        outCurrent.writeObject(v);
        outCurrent.close();
        fileOutCurrentVehicle.close();
        System.out.println("Write file successfully.");
    }
}