/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author raysen
 */
public class Outlet {
    //Attributes from diagram
    private String outletID;
    private String employeeID;
    private String name;
    private String address;
    private String contactNumber;
    private int currentCapacity;
    private double overallRatings;
    
    //Additional attributes
    private ArrayList<TicketType> ticketTypes;
    
    public Outlet(ArrayList<String> allOutletData) {
        this.outletID = allOutletData.get(0);
        this.employeeID = allOutletData.get(1);
        this.name = allOutletData.get(2);
        this.address = allOutletData.get(3);
        this.contactNumber = allOutletData.get(4);
        this.currentCapacity = Integer.valueOf(allOutletData.get(5));
        this.overallRatings = Double.valueOf(allOutletData.get(6));
        
        ticketTypes = new ArrayList<TicketType>();
    }
    
    public void addTicketType(TicketType ticketType) {
        if (getTicketTypes().size() < 2) {
            this.ticketTypes.add(ticketType);
        }
    }
    
    public void printAll(){
        System.out.println(this.outletID);
        System.out.println(this.employeeID);
        System.out.println(this.name);
        System.out.println(this.address);
        System.out.println(this.contactNumber);
        System.out.println(this.currentCapacity);
        System.out.println(this.overallRatings);
    }
    
    
    /**
     * @return the ticketTypes
     */
    public ArrayList<TicketType> getTicketTypes() {
        return ticketTypes;
    }
    
    /**
     * @return the outletID
     */
    public String getOutletID() {
        return outletID;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the name
     */
    public String getNameWithHOORAY() {
        return "HOORAY " + name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @return the currentCapacity
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * @return the overallRatings
     */
    public double getOverallRatings() {
        return overallRatings;
    }
}
