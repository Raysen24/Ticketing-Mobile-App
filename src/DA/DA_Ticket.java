/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author raysen
 */
public class DA_Ticket {
    public static ArrayList<String> getAllTicketData(String ticketID){
        Connection con = db.mycon();
        
        String sql = "SELECT * FROM tickettype WHERE ticketTypeID = '"+ticketID+"'";
        
        HashMap<Integer, String> hashMapTicketData = new HashMap<>();
        
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            hashMapTicketData.put(1, rs.getString("ticketTypeID"));
            hashMapTicketData.put(2, rs.getString("outletID"));
            hashMapTicketData.put(3, rs.getString("name"));
            hashMapTicketData.put(4, rs.getString("ticketDescription"));
            hashMapTicketData.put(5, rs.getString("pricePerTicket"));
            hashMapTicketData.put(6, rs.getString("giftPoint"));
            
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
        ArrayList<String> allTicketData = new ArrayList<String>();
        for (String value : hashMapTicketData.values()) {
            allTicketData.add(value.toString());
        }

        return allTicketData;
        
    }
    
//    public static ArrayList<String> getAllTicketData(String ticketID){
//        Connection con = db.mycon();
//        
//        String sql = "SELECT * FROM tickettype WHERE ticketTypeID = '"+ticketID+"'";
//        
//        ArrayList<String> allTicketData = new ArrayList<String>();
//        
//        try{
//
//            PreparedStatement statement =  con.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            rs.next();
//            allTicketData.add(rs.getString("ticketTypeID"));
//            allTicketData.add(rs.getString("outletID"));
//            allTicketData.add(rs.getString("name"));
//            allTicketData.add(rs.getString("ticketDescription"));
//            allTicketData.add(rs.getString("pricePerTicket"));
//            allTicketData.add(rs.getString("giftPoint"));
//            
//            
//        } catch(Exception exc){
//            System.out.println(exc.getMessage());
//        }
//        
////        String[] allTicketData = {customerID, firstName, lastName, address, email, phoneNumber, points};
//
//        return allTicketData;
//        
//    }
}
