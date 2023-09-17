/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raysen
 */
public class DA_Order {
    public static void insertNewOrder(String customerID, String usePointsStatus, double totalPrice){
        Connection con = db.mycon();
       
        String sql = "INSERT INTO orders (orderID, customerID, orderDate, orderStatus, usePointsStatus, totalPrice)"+
                     " VALUES (NULL, ?, ?, ?, ?, ?);";
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        Date today = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = st.format(today);
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            // Set parameter values for the insert statement
            statement.setString(1, customerID);
            statement.setString(2, dateToday);
            statement.setString(3, "pending");
            statement.setString(4, usePointsStatus);
            statement.setString(5, String.valueOf(totalPrice));
            
            statement.execute();
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static ArrayList<String> getAllOrderData(String customerID, String orderDate, String orderStatus) {
        Connection con = db.mycon();
        ArrayList<String> allOrderData = new ArrayList<String>();
        
        String sql = "SELECT * FROM orders WHERE customerID = '" + customerID + 
                                "' AND orderDate = '"+ orderDate +
                                "' AND orderStatus = '"+ orderStatus +"';";
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            allOrderData.add(rs.getString("orderID"));
            allOrderData.add(rs.getString("customerID"));
            allOrderData.add(rs.getString("orderDate"));
            allOrderData.add(rs.getString("orderStatus"));
            allOrderData.add(rs.getString("usePointsStatus"));
            allOrderData.add(rs.getString("totalPrice"));
                        
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        return allOrderData;
    }
    
    public static void setOrderStatus(String orderID, String orderStatus){
        Connection con = db.mycon();
        
        String sql = "UPDATE orders" +
                     " SET orderStatus = '" + orderStatus +
                     "' WHERE orderID = '"+ orderID +"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static String getUsePointsStatus(String orderID) {
        Connection con = db.mycon();
        
        String usePointsStatus = "";
        
        String sql = "SELECT usePointsStatus FROM orders WHERE orderID = '" + orderID +"';";
        
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            usePointsStatus = rs.getString("usePointsStatus");
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
        return usePointsStatus;
    }
    
    public static ArrayList<ArrayList<String>> getAllPaidOrdersData(String customerID) {
        Connection con = db.mycon();
        
        ArrayList<ArrayList<String>> allPaidOrdersData = new ArrayList<ArrayList<String>>();
        
//        int orderListIndex = 0;
        
        String sql = "SELECT * FROM orders WHERE customerID = '" + customerID +
                                "' AND orderStatus = 'paid';";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
                allPaidOrdersData.add(new ArrayList<String>());
                allPaidOrdersData.get(i).add(rs.getString("orderID"));
                allPaidOrdersData.get(i).add(rs.getString("customerID"));
                allPaidOrdersData.get(i).add(rs.getString("orderDate"));
                allPaidOrdersData.get(i).add(rs.getString("orderStatus"));
                allPaidOrdersData.get(i).add(rs.getString("usePointsStatus"));
                allPaidOrdersData.get(i).add(rs.getString("totalPrice"));
                i++;    
            }

        } catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
        return allPaidOrdersData;
    }
    
    public static void deleteOrder(String orderID){
        Connection con = db.mycon();
        
        String sql = "DELETE FROM orders WHERE orderID = '"+orderID+"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
