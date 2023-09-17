/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import UI.A1Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author raysen
 */
public class DA_Customer {
    
    public static boolean validatingCustomer(String email, String password) {
        Connection con = db.mycon();
        
        // login code here
        try {
             
            String sql = "SELECT * FROM customer WHERE email=? AND password=?";
            PreparedStatement pst = con.prepareCall(sql);
            
            pst.setString(1, email); // user name
            pst.setString(2, password); // password
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                return true;
                
            } else { // its false DO this
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }

    public static ArrayList<String> getAllCustomerData(String email, String password) {
        Connection con = db.mycon();
        
        
        String sql = "SELECT * FROM customer WHERE email = '" + email + 
                                "' AND password = '"+ password +"';";
        
        Queue<String> queueCustomerData = new LinkedList<>();
        
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            queueCustomerData.add(rs.getString("customerID"));
            queueCustomerData.add(rs.getString("firstName"));
            queueCustomerData.add(rs.getString("lastName"));
            queueCustomerData.add(rs.getString("address"));
            queueCustomerData.add(rs.getString("dob"));
            queueCustomerData.add(email);
            queueCustomerData.add(rs.getString("phoneNumber"));
            queueCustomerData.add(rs.getString("points"));
            
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
        // Convert queue to ArrayList
        ArrayList<String> allCustomerData = new ArrayList<>(queueCustomerData);
        
//        String[] allCustomerData = {customerID, firstName, lastName, address, email, phoneNumber, points};
//        System.out.println(allCustomerData);
        return allCustomerData;
        
    }
    
//    public static ArrayList<String> getAllCustomerData(String email, String password) {
//        Connection con = db.mycon();
//        ArrayList<String> allCustomerData = new ArrayList<String>();
//        
//        String sql = "SELECT * FROM customer WHERE email = '" + email + 
//                                "' AND password = '"+ password +"';";
//        
//        try{
//
//            PreparedStatement statement =  con.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            rs.next();
//            allCustomerData.add(rs.getString("customerID"));
//            allCustomerData.add(rs.getString("firstName"));
//            allCustomerData.add(rs.getString("lastName"));
//            allCustomerData.add(rs.getString("address"));
//            allCustomerData.add(rs.getString("dob"));
//            allCustomerData.add(email);
//            allCustomerData.add(rs.getString("phoneNumber"));
//            allCustomerData.add(rs.getString("points"));
//            
//            
//        } catch(Exception exc){
//            System.out.println(exc.getMessage());
//        }
//        
////        String[] allCustomerData = {customerID, firstName, lastName, address, email, phoneNumber, points};
//        System.out.println(allCustomerData);
//        return allCustomerData;
//        
//    }
    
    public static void setPoints(String customerID, String points){
        Connection con = db.mycon();
        
        String sql = "UPDATE customer" +
                     " SET points = '" + points +
                     "' WHERE customerID = '"+ customerID +"';";
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.executeUpdate();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public static boolean validatingEmail(String email) {
        Connection con = db.mycon();
        
        // login code here
        try {
             
            String sql = "SELECT * FROM customer WHERE email=?";
            PreparedStatement pst = con.prepareCall(sql);
            
            pst.setString(1, email); // user name
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            } else { // its false DO this
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void insertNewCustomer(String firstName, String lastName, String email, String dateOfBirth, String password){
        Connection con = db.mycon();
       
        String sql = "INSERT INTO customer (customerID, firstName, lastName, email, dob, password)"+
                     " VALUES (NULL, ?, ?, ?, ?, ?);";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Date dateOfBirthInDate = Date.from(LocalDate.parse(dateOfBirth, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        Date date = new Date();

        // Define the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Convert the Date to a string using the specified format
        String dateString = dateFormat.format(date);

        // Output the converted string
        System.out.println("Formatted Date: " + dateString);
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            // Set parameter values for the insert statement
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, dateString);
            statement.setString(5, password);
            
            statement.execute();
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
