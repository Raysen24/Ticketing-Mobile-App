/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author raysen
 */
public class DA_Payment {
    public static void insertNewPayment(String orderID, String methodID, String totalPrice, String virtualAcc){
        Connection con = db.mycon();
       
        String sql = "INSERT INTO payment (paymentID, orderID, methodID, totalPrice, paymentStatus, virtualAcc)"+
                     " VALUES (NULL, ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            // Set parameter values for the insert statement
            statement.setString(1, orderID);
            statement.setString(2, methodID);
            statement.setString(3, totalPrice);
            statement.setString(4, "waiting");
            statement.setString(5, virtualAcc);
            
            statement.execute();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static ArrayList<String> getAllPaymentData(String orderID, String paymentStatus) {
        Connection con = db.mycon();
        ArrayList<String> allPaymentData = new ArrayList<String>();
        
        String sql = "SELECT * FROM payment WHERE orderID = '" + orderID + 
                                "' AND paymentStatus = '"+ paymentStatus +"';";
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            allPaymentData.add(rs.getString("paymentID"));
            allPaymentData.add(rs.getString("orderID"));
            allPaymentData.add(rs.getString("methodID"));
            allPaymentData.add(rs.getString("totalPrice"));
            allPaymentData.add(rs.getString("paymentStatus"));
            allPaymentData.add(rs.getString("virtualAcc"));
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }

        return allPaymentData;
        
    }
    
    public static void setPaymentStatus(String paymentID, String paymentStatus){
        Connection con = db.mycon();
        
        String sql = "UPDATE payment" +
                     " SET paymentStatus = '" + paymentStatus +
                     "' WHERE paymentID = '"+ paymentID +"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static void deletPayment(String orderID){
        Connection con = db.mycon();
        
        String sql = "DELETE FROM payment WHERE orderID = '"+orderID+"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
