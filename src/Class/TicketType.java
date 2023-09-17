/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author raysen
 */
public class TicketType {
    //Attributes based on diagram
    private String ticketTypeID;
    private String outletID;
    private String name;
    private String ticketDescription;
    private double pricePerTicket;
    private int giftPoint;
    
    //Additional Attributes
    private Outlet outlet;
    
    public TicketType(ArrayList<String> allTicketData, Outlet outlet) {
        this.ticketTypeID = allTicketData.get(0);
        
        this.outletID = allTicketData.get(1);
        //if outletID equals to outlet object paramater, then make it as the attributes
//        if(this.outletID == outlet.getOutletID()) {
            outlet.addTicketType(this);
            this.outlet = outlet;
//        }
        
        this.name = allTicketData.get(2);
        this.ticketDescription = allTicketData.get(3);
        this.pricePerTicket = Double.valueOf(allTicketData.get(4));
        this.giftPoint = Integer.valueOf(allTicketData.get(5));
    }
    
    public void printAll(){
        System.out.println(this.getTicketTypeID());
        System.out.println(this.getOutletID());
        System.out.println(this.getName());
    }
    
    /**
     * @return the outlet
     */
    public Outlet getOutlet() {
        return this.outlet;
    }
    
    /**
     * @return the ticketTypeID
     */
    public String getTicketTypeID() {
        return ticketTypeID;
    }

    /**
     * @return the outletID
     */
    public String getOutletID() {
        return outletID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ticketDescription
     */
    public String getTicketDescription() {
        return ticketDescription;
    }
    
    /**
     * @return the pricePerTicket
     */
    public double getPricePerTicket() {
        return pricePerTicket;
    }

    /**
     * @return the pricePerTicket
     */
    public String getPricePerTicketInRupiah() {
        return rupiahFormat(pricePerTicket);
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
    
    /**
     * @return the pricePerTicket
     */
    public String getPricePerTicketWithoutRupiah() {
        return withoutRupiahFormat(pricePerTicket);
    }
    
    public static String withoutRupiahFormat(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        decimalFormat.setMaximumFractionDigits(0);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        decimalFormat.setDecimalSeparatorAlwaysShown(false);

        String formattedAmount = decimalFormat.format(amount);

        return formattedAmount.replace(",", ".");
    }

    /**
     * @return the giftPoint
     */
    public int getGiftPoint() {
        return giftPoint;
    }
}
