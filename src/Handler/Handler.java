/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handler;

import Class.*;
import UI.*;
import static UI.A4OrderSummary.rupiahFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author raysen
 */
public class Handler {
    public static void validateCustomer(String email, String password, JFrame A1Login) {
        if(DA.DA_Customer.validatingCustomer(email, password)) {
            Customer customer = new Customer(DA.DA_Customer.getAllCustomerData(email, password));

            Outlet[] outlets = new Outlet[2];
            TicketType[] ticketTypes = new TicketType[4];
            createOutlet(outlets, ticketTypes, 0, A1Login);
            
            new A2Home(customer, outlets).setVisible(true);
            A1Login.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Check your email & password", "Failed to login...", JOptionPane.INFORMATION_MESSAGE);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void createOutlet(Outlet[] outlets, TicketType[] ticketTypes, int index, JFrame A1Login) {
        if (index >= outlets.length) {
            return;
        }

        outlets[index] = new Outlet(DA.DA_Outlet.getAllOutletData(String.valueOf(index+1)));

        if(index==0) {
            createTicketTypes(ticketTypes, 0, outlets[index]);
            System.out.println("create ticket type from outlet 1");
        } else {
            createTicketTypes(ticketTypes, 2, outlets[index]);
            System.out.println("create ticket type from outlet 2");
        }

        createOutlet(outlets, ticketTypes, index + 1, A1Login);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void createTicketTypes(TicketType[] ticketTypes, int index, Outlet outlet) {
        if (index >= ticketTypes.length) {
            return;
        }

        ticketTypes[index] = new TicketType(DA.DA_Ticket.getAllTicketData(String.valueOf(index+1)), outlet);
        createTicketTypes(ticketTypes, index + 1, outlet);
        System.out.println("create ticketType " + index);
    }

//    public static void validateCustomer(String email, String password, JFrame A1Login) {
//        if(DA.DA_Customer.validatingCustomer(email, password)) {
//            Customer customer = new Customer(DA.DA_Customer.getAllCustomerData(email, password));
//            
//            Outlet[] outlets = new Outlet[2];
//            TicketType[] ticketTypes = new TicketType[4];
//            for(int i = 0; i < outlets.length; i++) {
//                outlets[i] = new Outlet(DA.DA_Outlet.getAllOutletData(String.valueOf(i+1)));
//                if(i==0) {
//                    for(int j = 0; j < outlets.length; j++) {
//                        ticketTypes[j] = new TicketType(DA.DA_Ticket.getAllTicketData(String.valueOf(j+1)), outlets[i]);
//                    } 
//                } else {
//                    for(int j = 2; j < ticketTypes.length; j++) {
//                        ticketTypes[j] = new TicketType(DA.DA_Ticket.getAllTicketData(String.valueOf(j+1)), outlets[i]);
//                    }
//                }
//            }
//            
//            A1Login.setVisible(false);
//            new A2Home(customer, outlets).setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Check your email & password", "Failed to login...", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
    
    public static void signUp(String firstName, String lastName, String email, String dob, String pass, String pass2, JFrame A1SignUp) {
        if(firstName.equals("") || lastName.equals("") || email.equals("") || dob.equals("") || pass.equals("") || pass2.equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill all the data needed", "Something is missing", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(pass.equals(pass2)) {
                if(!(DA.DA_Customer.validatingEmail(email))) { //if email is not registered yet
                    DA.DA_Customer.insertNewCustomer(firstName, lastName, email, dob,  pass);
                    JOptionPane.showMessageDialog(null, "Account created! You can login now!", "New account has signed up", JOptionPane.INFORMATION_MESSAGE);
                    
                    new A1Login().setVisible(true);
                    A1SignUp.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Account already exist!", "Notification", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Your passwords not matched!", "Wrong password", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        
        
    }
    
    public static void openTicketDetailsPage(Customer customer, Outlet[] outlets, int selectedOutletIndicator, JFrame A2Home) {
        new A3TicketDetails(customer, outlets,  selectedOutletIndicator).setVisible(true);
        A2Home.setVisible(false);
    }
    
    public static void openMyTicketPage(Customer customer, Outlet[] outlets, JFrame A2Home) {
        new A2MyTicketPage(customer, outlets).setVisible(true);
        A2Home.setVisible(false);
    }
    
    public static void displayAllActiveTicket(Customer customer, Outlet[] outlets, ArrayList<Order> orders, ArrayList<OrderDetail> orderDetails, ArrayList<PurchasedTicket> purchasedTickets) {
        ArrayList<ArrayList<String>> allPaidOrdersData = DA.DA_Order.getAllPaidOrdersData(customer.getCustomerID());

        if(!allPaidOrdersData.isEmpty()) {
            //Create Order that have been paid (Status == paid) object from Order class
            for(int i = 0; i < allPaidOrdersData.size(); i++) {
                orders.add(new Order(allPaidOrdersData.get(i)));
            }
            
            //Get and create all order detail related to the order
            for(int i = 0; i < orders.size(); i++) {
                ArrayList<ArrayList<String>> allPaidOrderDetailsData = DA.DA_OrderDetail.getAllPaidOrderDetailsData(orders.get(i).getOrderID());

                for(int j = 0; j < allPaidOrderDetailsData.size(); j++) {
                    String ticketTypeID = allPaidOrderDetailsData.get(j).get(2);
                    Outlet outlet;
                    if(ticketTypeID.equals("1") || ticketTypeID.equals("2")) {
                        outlet = outlets[0];
                    } else {
                        outlet = outlets[1];
                    }
    //                
                    int ticketTypeIndicator = Integer.valueOf(ticketTypeID);

                    if(ticketTypeIndicator == 1 || ticketTypeIndicator == 3) {
                        ticketTypeIndicator = 0;
                    } else {
                        ticketTypeIndicator = 1;
                    }

                    orderDetails.add(new OrderDetail(allPaidOrderDetailsData.get(j), orders.get(i), outlet.getTicketTypes().get(ticketTypeIndicator)));
                }
            }



            //Get all purchased ticket that have  the orderDetailID above
            for(int i = 0; i < orderDetails.size(); i++) {
                ArrayList<ArrayList<String>> allActiveTicketsData = DA.DA_PurchasedTicket.getAllActiveTicketsData(orderDetails.get(i).getOrderDetailID());
                for(int j = 0; j < allActiveTicketsData.size(); j++) {
                    purchasedTickets.add(new PurchasedTicket(allActiveTicketsData.get(j), orderDetails.get(i)));
                }
            }
        }
    }
    
    public static void backToHomePage(Customer customer, Outlet[] outlets, JFrame jFrameToClose) {
        new A2Home(customer, outlets).setVisible(true);
        jFrameToClose.setVisible(false);
    }
    
    public static void openOrderSummary(Customer customer, Outlet[] outlets, int selectedOutletIndicator, JFrame jFrameToClose) {
        new A4OrderSummary(customer, outlets, selectedOutletIndicator).setVisible(true);
        jFrameToClose.setVisible(false);
    }
    
    public static void openPaymentPage(Customer customer, Outlet[] outlets, int selectedOutletIndicator, String usePointsStatus, double totalPrice, Order order, String dateToday,
                                       String jChildTicketAmount, int childAmount, String jGuardianTicketAmount, int guardianAmount, JFrame A4OrderSummary, JLabel jSubTotal) {
        
        if(jSubTotal.getText().equals("Rp 000.000")) {
            JOptionPane.showMessageDialog(null, "Please select a ticket", "No ticket has been selected", JOptionPane.INFORMATION_MESSAGE); 
        } else {
            //Inserting new order to database
            DA.DA_Order.insertNewOrder(customer.getCustomerID(), usePointsStatus, totalPrice);

            //Create Order that havent been paid object from Order class
            order = new Order(DA.DA_Order.getAllOrderData(customer.getCustomerID(), dateToday, "pending"));

            //if there is Child Ticket that customer wants to buy
            if(Integer.valueOf(jChildTicketAmount)!=0) {
                //Inserting new orderDetail of Child Ticket to database
                String[] ticketTypeDataForOrderDetail = {outlets[selectedOutletIndicator].getTicketTypes().get(0).getTicketTypeID(),
                                                       String.valueOf(outlets[selectedOutletIndicator].getTicketTypes().get(0).getPricePerTicket()),
                                                       String.valueOf(childAmount)};
                DA.DA_OrderDetail.insertNewOrderDetail(order.getOrderID(), ticketTypeDataForOrderDetail);
            }

            //if there is Guardian Ticket that customer wants to buy
            if(Integer.valueOf(jGuardianTicketAmount)!=0) {
                //Inserting new orderDetail of Guardian Ticket to database
                String[] ticketTypeDataForOrderDetail = {outlets[selectedOutletIndicator].getTicketTypes().get(1).getTicketTypeID(),
                                                       String.valueOf(outlets[selectedOutletIndicator].getTicketTypes().get(1).getPricePerTicket()),
                                                       String.valueOf(guardianAmount)};
                DA.DA_OrderDetail.insertNewOrderDetail(order.getOrderID(), ticketTypeDataForOrderDetail);
            }

            ArrayList<ArrayList<String>> allOrderDetails = DA.DA_OrderDetail.getAllOrderDetailsData(order.getOrderID());
            for(int i = 0; i < allOrderDetails.size(); i++) {
                OrderDetail orderDetail1 = new OrderDetail(allOrderDetails.get(i), 
                                                           order, 
                                                           outlets[selectedOutletIndicator].getTicketTypes().get(i));
            }
            
            new A5Payment(customer, outlets, selectedOutletIndicator, order).setVisible(true);
            A4OrderSummary.setVisible(false);
        }
    }
    
    public static void addBackTotalPrice(Customer customer, double totalPrice, JLabel jTotalPrice, JTabbedPane jUsePointsStatus) {
        //if customer disactivate point, the total price will be added back
       
        jTotalPrice.setText(rupiahFormat(totalPrice));
            
        jUsePointsStatus.setSelectedIndex(0);
    }
    
    public static void usingPoints(Customer customer, JLabel jSubTotal, double totalPrice, JLabel jTotalPrice, JTabbedPane jUsePointsStatus) {
        //if customer doesn't have points or no ticket is selected, they cannot activate "use points" button and notification will pop up
        if(customer.getPoints()==0){
            JOptionPane.showMessageDialog(null, "You dont have enough points", "Points not enough notification", JOptionPane.INFORMATION_MESSAGE);
        } else if(jSubTotal.getText().equals("Rp 000.000")) {
            JOptionPane.showMessageDialog(null, "Please select a ticket", "No ticket has been selected", JOptionPane.INFORMATION_MESSAGE); 
        } else {
            //if they activate point, the total price will be subtracted
            totalPrice -= customer.getPoints();
            jTotalPrice.setText(rupiahFormat(totalPrice));
            
            jUsePointsStatus.setSelectedIndex(1);
        }
    }
    
    public static void proceedPayment(Customer customer, Outlet[] outlets, int selectedOutletIndicator, Order order, JTabbedPane jTabbedPane1,
                                      String methodID, PaymentMethod paymentMethod, VirtualAccount virtualAccount, Payment payment, JFrame jFrameToClose) {
        //if customer already choose one of payment method
        if(jTabbedPane1.getSelectedIndex()!=0) {
            //getAllPaymentMathodData based on the methodID which is indicated by selected TabedPane
            methodID = String.valueOf(jTabbedPane1.getSelectedIndex());
            
            //Get all payment method data needed from database and save all data from paymentmethod to obj
            paymentMethod = new PaymentMethod(DA.DA_PaymentMethod.getAllPaymentMethodData(methodID));
            
            //if there is already virtualAccount of payment selected
            //Get all virtual account data from database and save all data from virtualaccount to obj
            if(DA.DA_VirtualAccount.checkingVirtualAccountAvailability(customer.getCustomerID(), paymentMethod.getMethodID())) {
                virtualAccount = new VirtualAccount(DA.DA_VirtualAccount.getAllVirtualAccountData(customer.getCustomerID(), paymentMethod.getMethodID()), paymentMethod);
            } else { //if there is no virtualAccount yet, then insert a new one, get all the data, and save to obj virtualAccount
                String virtualAcc = paymentMethod.getBankCode()+customer.getCustomerID();
                DA.DA_VirtualAccount.insertNewVirtualAccount(customer.getCustomerID(), paymentMethod.getMethodID(), virtualAcc, "0");
                virtualAccount = new VirtualAccount(DA.DA_VirtualAccount.getAllVirtualAccountData(customer.getCustomerID(), paymentMethod.getMethodID()), paymentMethod);
            }
            
            //Insert new payment to database and save also to obj Payment
            DA.DA_Payment.insertNewPayment(order.getOrderID(), methodID, String.valueOf(order.getTotalPrice()), virtualAccount.getVirtualAcc());
            payment = new Payment(DA.DA_Payment.getAllPaymentData(order.getOrderID(), "waiting"), order, paymentMethod);
            
            //Set bill for virtualAccount
            DA.DA_VirtualAccount.setVirtualAccountBill(virtualAccount.getVirtualAcc(), String.valueOf(order.getTotalPrice()));
            
            if(jTabbedPane1.getSelectedIndex()==1) {
                new A6BCAPayment(customer, outlets, selectedOutletIndicator, payment).setVisible(true);
                jFrameToClose.setVisible(false);
                new OA2BCALogin().setVisible(true);
            } else {
                new A6BNIPayment(customer, outlets, selectedOutletIndicator, payment).setVisible(true);
                jFrameToClose.setVisible(false);
                new OA2BCALogin().setVisible(true);
            }
        }
    }
    
    public static void cancelOrder(Order order, JFrame jFrameToClose, Customer customer, Outlet[] outlets, int selectedOutletIndicator) {
        //Delete order and orderDetail from database
        DA.DA_OrderDetail.deleteOrderDetail(order.getOrderID()); //remove orderDetail from database
        DA.DA_Order.deleteOrder(order.getOrderID()); //remove orderDetail from database

        //Back to page ordersummary
        new A4OrderSummary(customer, outlets, selectedOutletIndicator).setVisible(true);
        jFrameToClose.setVisible(false);
    }
    
    public static void paymentCanceled(Order order, JFrame jFrameToClose, Customer customer, Outlet[] outlets, int selectedOutletIndicator, Payment payment) {
        //Delete payment, order and orderDetail from database and set bill of virtual account back
        DA.DA_VirtualAccount.setVirtualAccountBill(payment.getVirtualAcc(), "0");
        DA.DA_Payment.deletPayment(payment.getOrder().getOrderID());
        
        cancelOrder(order, jFrameToClose, customer, outlets, selectedOutletIndicator);
    }
    
    public static boolean validatePayment(Customer customer, Payment payment) {
        double bill = DA.DA_VirtualAccount.getVirtualAccountBill(payment.getVirtualAcc());
        
        if(bill == 0) {
            DA.DA_Payment.setPaymentStatus(payment.getPaymentID(), "paid");
            
            DA.DA_Order.setOrderStatus(payment.getOrderID(), "paid");
            
            //if customer use points, then make points 0 in database
            if(payment.getOrder().getUsePointsStatus().equals("use")) {
                DA.DA_Customer.setPoints(customer.getCustomerID(), "0");
                customer.setPoints(0);
            }
            
            //loop to know how much points the customer should get
            int totalGiftPoint = 0;
            for(int orderDetailIndex = 0; orderDetailIndex < payment.getOrder().getOrderDetails().size(); orderDetailIndex++) {
                totalGiftPoint += payment.getOrder().getOrderDetails().get(orderDetailIndex).getQuantity()*
                                  payment.getOrder().getOrderDetails().get(orderDetailIndex).getTicketType().getGiftPoint();
            }
            
            //this is updated points of customer which should be updated in database
            int customerUpdatedPoints = customer.getPoints() + totalGiftPoint;
            DA.DA_Customer.setPoints(customer.getCustomerID(), String.valueOf(customerUpdatedPoints));
            customer.setPoints(customerUpdatedPoints);
            
            //insert new purchasedTicket to database based on how many orderDetails in order, and how many quantity per orderDetail
            int orderDetailsAmount = payment.getOrder().getOrderDetails().size(); //how many orderDetails in order
            for(int i = 0; i < orderDetailsAmount; i++) {
                int ticketQuantity = payment.getOrder().getOrderDetails().get(i).getQuantity(); //how many quantity of ticket should be inserted
                for(int j = 0; j < ticketQuantity; j++) {
                    DA.DA_PurchasedTicket.insertNewPurchasedTicket(payment.getOrder().getOrderDetails().get(i).getOrderDetailID());
                }
            }
            
            return true;
            
        }
        return false;
                
    }
    
    
}
