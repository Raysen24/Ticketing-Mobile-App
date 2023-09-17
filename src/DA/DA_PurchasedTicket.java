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
public class DA_PurchasedTicket {
    public static void insertNewPurchasedTicket(String orderDetailID) {
        Connection con = db.mycon();
       
        String sql = "INSERT INTO purchasedticket (purchasedTicketID, orderDetailID, expireDate, ticketStatus)"+
                     " VALUES (NULL, ?, ?, ?);";
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();//date today
        LocalDate expirationDate = currentDate.plusDays(7);//1 week after ticket purchased inserted
        Date oneWeekFromToday = Date.from(expirationDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");
        String dateExpire = st.format(oneWeekFromToday);
        
        try{
            PreparedStatement statement =  con.prepareStatement(sql);
            
            // Set parameter values for the insert statement
            statement.setString(1, orderDetailID);
            statement.setString(2, dateExpire);
            statement.setString(3, "ACTIVE"); //Automatically set status active when inserting new purchasedTicket
            
            statement.execute();
            
        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    
    //get all purchased ticket that have "ACTIVE" status
    public static ArrayList<ArrayList<String>> getAllActiveTicketsData(String orderDetailID) {
        Connection con = db.mycon();
        
        ArrayList<ArrayList<String>> allActiveTicketsData = new ArrayList<ArrayList<String>>();
        
        String sql = "SELECT * FROM purchasedTicket WHERE orderDetailID = '" + orderDetailID + 
                     "' AND ticketStatus = 'ACTIVE';";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
                allActiveTicketsData.add(new ArrayList<String>());
                allActiveTicketsData.get(i).add(rs.getString("purchasedTicketID"));
                allActiveTicketsData.get(i).add(rs.getString("orderDetailID"));
                allActiveTicketsData.get(i).add(rs.getString("expireDate"));
                allActiveTicketsData.get(i).add(rs.getString("ticketStatus"));
                i++;
            }

        } catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println("getAllActiveTicketsData executed");
        return allActiveTicketsData;
    }
}
