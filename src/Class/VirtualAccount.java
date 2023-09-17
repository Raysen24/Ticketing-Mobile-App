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
public class VirtualAccount {
    private String customerID;
    private String methodID;
    private String virtualAcc;
    private double bill;
    
    private PaymentMethod paymentMethod;
    
    public VirtualAccount(ArrayList<String> allVirtualAccountData, PaymentMethod paymentMethod) {
        this.customerID = allVirtualAccountData.get(0);
        this.methodID = allVirtualAccountData.get(1);
        this.virtualAcc = allVirtualAccountData.get(2);
        this.bill = Double.valueOf(allVirtualAccountData.get(3));
    }
    
    
    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @return the methodID
     */
    public String getMethodID() {
        return methodID;
    }

    /**
     * @return the virtualAcc
     */
    public String getVirtualAcc() {
        return virtualAcc;
    }

    /**
     * @return the bill
     */
    public double getBill() {
        return bill;
    }

    /**
     * @return the paymentMethod
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
