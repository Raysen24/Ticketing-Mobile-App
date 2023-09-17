
package Class;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raysen
 */
public class Customer extends User{
    private String customerID;
    private int points;
    
    public Customer(ArrayList<String> allCustomerData) {
        super(allCustomerData.get(1), allCustomerData.get(2), allCustomerData.get(3), 
                allCustomerData.get(4), allCustomerData.get(5), allCustomerData.get(6));
        this.customerID = allCustomerData.get(0);
        this.points = Integer.valueOf(allCustomerData.get(7));
    }
    
    public void printAllAttributes(){
        System.out.println(this.getCustomerID());
        super.printAllAttributes();
        System.out.println(this.getPoints());
    }
    
    
    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }
    
    
    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }
}
