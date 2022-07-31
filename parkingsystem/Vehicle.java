/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingsystem;

/**
 *
 * @author Administrator
 */
public class Vehicle {
    protected String lic_Plate;
    protected Ticket ticket;

    public Vehicle(){
        lic_Plate = "36" + StringAlpha(1) + StringNumer(5);
    }
    
    public void setLicPlate(String a){
        lic_Plate = a;
    }
    
    public String getLicPlate(){
        return lic_Plate;
    }
    public void setTicket(Ticket t){
        ticket = t;
    }
    public Ticket getTicket(){
        return ticket;
    }
    
    public static String StringAlpha(int n) {
	String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	StringBuilder s = new StringBuilder(n);
	int y;
	for ( y = 0; y < n; y++) {
            int index = (int)(AlphaString.length() * Math.random());
            s.append(AlphaString.charAt(index));
	}
	return s.toString();
    }
    
    public static String StringNumer(int n) {
	String NumericString = "0123456789";
	StringBuilder s = new StringBuilder(n);
	int y;
	for ( y = 0; y < n; y++) {
            int index = (int)(NumericString.length() * Math.random());
            s.append(NumericString.charAt(index));
	}
	return s.toString();
    }
    
    
}
