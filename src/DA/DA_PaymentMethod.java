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
public class DA_PaymentMethod {
    public static ArrayList<String> getAllPaymentMethodData(String methodID) {
        Connection con = db.mycon();
        ArrayList<String> allPaymentMethodData = new ArrayList<String>();
        
        String sql = "SELECT * FROM paymentMethod WHERE methodID = '"+ methodID +"';";
        try{

            PreparedStatement statement =  con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            allPaymentMethodData.add(rs.getString("methodID"));
            allPaymentMethodData.add(rs.getString("bankName"));
            allPaymentMethodData.add(rs.getString("bankCode"));
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }

        return allPaymentMethodData;
    }
}
