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
public class Payment {
    private String paymentID;
    private String orderID;
    private String methodID;
    private String amount;
    private String paymentStatus;
    private String virtualAcc;
    
    private Order order;
    private PaymentMethod paymentMethod;
    
    public Payment(ArrayList<String> allPaymentData, Order order, PaymentMethod paymentMethod) {
        this.paymentID = allPaymentData.get(0);
        this.orderID = allPaymentData.get(1);
        this.methodID = allPaymentData.get(2);
        this.amount = allPaymentData.get(3);
        this.paymentStatus = allPaymentData.get(4);
        virtualAcc = allPaymentData.get(5);
        
        this.order = order;
        this.paymentMethod = paymentMethod;
    }
    
    
    /**
     * @return the paymentID
     */
    public String getPaymentID() {
        return paymentID;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @return the methodID
     */
    public String getMethodID() {
        return methodID;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return the paymentStatus
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * @return the virtualAcc
     */
    public String getVirtualAcc() {
        return virtualAcc;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @return the paymentMethod
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
