/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raysen
 */
public class Order {
    private String orderID;
    private String customerID;
    private Date orderDate;
    private String orderStatus;
    private String usePointsStatus;
    private double totalPrice;
    
    private ArrayList<OrderDetail> orderDetails;
    
    public Order(ArrayList<String> allOrderData) {
        this.orderID = allOrderData.get(0);
        this.customerID = allOrderData.get(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.orderDate = Date.from(LocalDate.parse(allOrderData.get(2), 
                         formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.orderStatus = allOrderData.get(3);
        this.usePointsStatus = allOrderData.get(4);
        this.totalPrice = Double.valueOf(allOrderData.get(5));
        
        this.orderDetails = new ArrayList<OrderDetail>();
    }
    
    public void addOrderDetail(OrderDetail orderDetail) {
            this.orderDetails.add(orderDetail);
    }
    
    /**
     * @return the orderDetails
     */
    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    
    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @return the usePointsStatus
     */
    public String getUsePointsStatus() {
        return usePointsStatus;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }
    
    /**
     * @return the pricePerTicket
     */
    public String getTotalPriceInRupiah() {
        return rupiahFormat(totalPrice);
    }
    
    public static String rupiahFormat(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        decimalFormat.setMaximumFractionDigits(0);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        decimalFormat.setDecimalSeparatorAlwaysShown(false);

        String rupiahSymbol = "Rp ";
        String formattedAmount = decimalFormat.format(amount);

        return rupiahSymbol + formattedAmount.replace(",", ".");
    }
}
