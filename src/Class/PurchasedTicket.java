/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import DA.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raysen
 */
public class PurchasedTicket {
    private String purchasedTicketID;
    private String orderDetailID;
    private Date expireDate;
    private String ticketStatus;
    
    private OrderDetail orderDetail;
    
    public PurchasedTicket(ArrayList<String> allPurchasedTicketData, OrderDetail orderDetail) {
        this.purchasedTicketID = allPurchasedTicketData.get(0);
        this.orderDetailID = allPurchasedTicketData.get(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.expireDate = Date.from(LocalDate.parse(allPurchasedTicketData.get(2), 
                          formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.orderDetailID = allPurchasedTicketData.get(3);
        this.orderDetail = orderDetail;
        System.out.println("this is in page purchasedticket line 33");
        orderDetail.addPurchasedTicket(this);
        
        System.out.println("this is in page purchasedticket line 36");
    }
    
    /**
     * @return the purchasedTicketID
     */
    public String getPurchasedTicketID() {
        return purchasedTicketID;
    }

    /**
     * @return the orderDetailID
     */
    public String getOrderDetailID() {
        return orderDetailID;
    }

    /**
     * @return the expireDate
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * @return the ticketStatus
     */
    public String getTicketStatus() {
        return ticketStatus;
    }

    /**
     * @return the orderDetail
     */
    public OrderDetail getOrderDetail() {
        return orderDetail;
    }
}
