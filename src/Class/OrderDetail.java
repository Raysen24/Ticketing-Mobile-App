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
public class OrderDetail {
    private String orderDetailID;
    private String orderID;
    private String ticketTypeID;
    private double ticketPrice;
    private int quantity;
    private double subTotal;
    
    private Order order;
    private TicketType ticketType;
    
    private ArrayList<PurchasedTicket> purchasedTickets = new ArrayList<PurchasedTicket>();
    
    public OrderDetail(ArrayList<String> allOrderDetailData, Order order, TicketType ticketType) {
        this.orderDetailID = allOrderDetailData.get(0);
        this.orderID = allOrderDetailData.get(1);
        this.ticketTypeID = allOrderDetailData.get(2);
        this.ticketPrice = Double.valueOf(allOrderDetailData.get(3));
        this.quantity = Integer.valueOf(allOrderDetailData.get(4));
        this.subTotal = Double.valueOf(allOrderDetailData.get(5));
        order.addOrderDetail(this);
        this.order = order;
        
        this.ticketType = ticketType;
    }
    
    public void addPurchasedTicket(PurchasedTicket purchasedTicket) {
            this.purchasedTickets.add(purchasedTicket);
    }
    
    
    /**
     * @return the orderDetailID
     */
    public String getOrderDetailID() {
        return orderDetailID;
    }
    
    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @return the ticketTypeID
     */
    public String getTicketTypeID() {
        return ticketTypeID;
    }

    /**
     * @return the ticketPrice
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }
    
    /**
     * @return the ticketType
     */
    public TicketType getTicketType() {
        return ticketType;
    }
}
