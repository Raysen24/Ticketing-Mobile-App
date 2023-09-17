/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raysen
 */
public class DA_OrderDetail {
    public static void insertNewOrderDetail(String orderID, String[] ticketTypeDataForOrderDetail){
        Connection con = db.mycon();
        
        //Data for subtotal (ticketPrice * quantity)
        double subTotal = Double.valueOf(ticketTypeDataForOrderDetail[1])*Integer.valueOf(ticketTypeDataForOrderDetail[2]);
       
        String sql = "INSERT INTO orderdetail (orderDetailID, orderID, ticketTypeID, ticketPrice, quantity, subTotal)"+
                     " VALUES (NULL, ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            // Set parameter values for the insert statement
            statement.setString(1, orderID);
            statement.setString(2, ticketTypeDataForOrderDetail[0]);
            statement.setString(3, ticketTypeDataForOrderDetail[1]);
            statement.setString(4, ticketTypeDataForOrderDetail[2]);
            statement.setString(5, String.valueOf(subTotal));
            
            statement.execute();
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static ArrayList<ArrayList<String>> getAllOrderDetailsData(String orderID) {
        Connection con = db.mycon();
        ArrayList<ArrayList<String>> allOrderDetailsData = new ArrayList<ArrayList<String>>();
        
        String sql = "SELECT * FROM orderdetail WHERE orderID = '"+ orderID +"';";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
                allOrderDetailsData.add(new ArrayList<String>());
                allOrderDetailsData.get(i).add(rs.getString("orderDetailID"));
                allOrderDetailsData.get(i).add(rs.getString("orderID"));
                allOrderDetailsData.get(i).add(rs.getString("ticketTypeID"));
                allOrderDetailsData.get(i).add(rs.getString("ticketPrice"));
                allOrderDetailsData.get(i).add(rs.getString("quantity"));
                allOrderDetailsData.get(i).add(rs.getString("subTotal"));
                i++;    
            }
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
//        String[] allOrderDetailData = {customerID, firstName, lastName, address, email, phoneNumber, points};

        return allOrderDetailsData;
    }
    
    
    
    public static ArrayList<ArrayList<String>> getAllPaidOrderDetailsData(String orderID) {
        Connection con = db.mycon();
        
        ArrayList<ArrayList<String>> allPaidOrderDetailsData = new ArrayList<ArrayList<String>>();
        
        String sql = "SELECT * FROM orderDetail WHERE orderID = '" + orderID + "';";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
                allPaidOrderDetailsData.add(new ArrayList<String>());
                allPaidOrderDetailsData.get(i).add(rs.getString("orderDetailID"));
                allPaidOrderDetailsData.get(i).add(rs.getString("orderID"));
                allPaidOrderDetailsData.get(i).add(rs.getString("ticketTypeID"));
                allPaidOrderDetailsData.get(i).add(rs.getString("ticketPrice"));
                allPaidOrderDetailsData.get(i).add(rs.getString("quantity"));
                allPaidOrderDetailsData.get(i).add(rs.getString("subTotal"));
                i++;    
            }

        } catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println("getAllPaidOrderDetailsData executed");
        return allPaidOrderDetailsData;
    }
    
    public static void deleteOrderDetail(String orderID){
        Connection con = db.mycon();
        
        String sql = "DELETE FROM orderDetail WHERE orderID = '"+orderID+"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
