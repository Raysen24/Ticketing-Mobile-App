/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raysen
 */
public class DA_Outlet {
    public static ArrayList<String> getAllOutletData(String outletID){
        Connection con = db.mycon();
        
        String sql = "SELECT * FROM outlet WHERE outletID = '"+outletID+"'";
        
        Stack<String> stackOutletData = new Stack<>();
        
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            stackOutletData.add(rs.getString("outletID"));
            stackOutletData.add(rs.getString("employeeID"));
            stackOutletData.add(rs.getString("name"));
            stackOutletData.add(rs.getString("address"));
            stackOutletData.add(rs.getString("contactNumber"));
            stackOutletData.add(rs.getString("currentCapacity"));
            stackOutletData.add(rs.getString("overallRatings"));
            
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
        ArrayList<String> allOutletData = new ArrayList<>(stackOutletData);
        
//        String[] allOutletData = {customerID, firstName, lastName, address, email, phoneNumber, points};

        return allOutletData;
        
    }
    
//    public static ArrayList<String> getAllOutletData(String outletID){
//        Connection con = db.mycon();
//        
//        String sql = "SELECT * FROM outlet WHERE outletID = '"+outletID+"'";
//        
//        ArrayList<String> allOutletData = new ArrayList<String>();
//        
//        try{
//
//            PreparedStatement statement =  con.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            rs.next();
//            allOutletData.add(rs.getString("outletID"));
//            allOutletData.add(rs.getString("employeeID"));
//            allOutletData.add(rs.getString("name"));
//            allOutletData.add(rs.getString("address"));
//            allOutletData.add(rs.getString("contactNumber"));
//            allOutletData.add(rs.getString("currentCapacity"));
//            allOutletData.add(rs.getString("overallRatings"));
//            
//            
//        } catch(Exception exc){
//            System.out.println(exc.getMessage());
//        }
//        
////        String[] allOutletData = {customerID, firstName, lastName, address, email, phoneNumber, points};
//
//        return allOutletData;
//        
//    }
}
