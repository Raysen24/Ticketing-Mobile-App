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

/**
 *
 * @author raysen
 */
public class DA_VirtualAccount {
    
    public static boolean checkingVirtualAccountAvailability(String customerID, String methodID) {
        Connection con = db.mycon();
        try {
             
            String sql = "SELECT * FROM virtualaccount WHERE customerID=? AND methodID=?";
            PreparedStatement pst = con.prepareCall(sql);
            
            pst.setString(1, customerID); // user name
            pst.setString(2, methodID); // password
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) { // if there is already virtual account for the customer and the selected method, then true
                return true;
            } else { // if it is not found, then return false
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public static ArrayList<String> getAllVirtualAccountData(String customerID, String methodID) {
        Connection con = db.mycon();
        ArrayList<String> allVirtualAccountData = new ArrayList<String>();
        
        String sql = "SELECT * FROM virtualaccount WHERE customerID = '" + customerID + 
                                "' AND methodID = '"+ methodID +"';";
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            allVirtualAccountData.add(rs.getString("customerID"));
            allVirtualAccountData.add(rs.getString("methodID"));
            allVirtualAccountData.add(rs.getString("virtualAcc"));
            allVirtualAccountData.add(rs.getString("bill"));
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }

        return allVirtualAccountData;
        
    }
    
    public static void insertNewVirtualAccount(String customerID, String methodID, String virtualAcc, String bill){
        Connection con = db.mycon();
       
        String sql = "INSERT INTO virtualaccount (customerID, methodID, virtualAcc, bill)"+
                     " VALUES (?, ?, ?, ?);";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            // Set parameter values for the insert statement
            statement.setString(1, customerID);
            statement.setString(2, methodID);
            statement.setString(3, virtualAcc);
            statement.setString(4, bill);
            
            statement.execute();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static void setVirtualAccountBill(String virtualAcc, String amount){
        Connection con = db.mycon();
        
        String sql = "UPDATE virtualaccount" +
                     " SET bill = '" + amount +
                     "' WHERE virtualAcc = '"+ virtualAcc +"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static double getVirtualAccountBill(String virtualAcc) {
        Connection con = db.mycon();
        
        double bill = 0;
        
        String sql = "SELECT * FROM virtualaccount WHERE virtualAcc = '" + virtualAcc + "';";
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            bill = Double.valueOf(rs.getString("bill"));
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }

        return bill;
        
    }
}
