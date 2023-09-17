package Class;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raysen
 */
public abstract class User implements PrintUserInfo{
    private String firstName;
    private String lastName;
    private String address;
    private Date dob;
    private String email;
    private String phoneNumber;
    
    User(String firstName, String lastName, String address, String dob, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dob = Date.from(LocalDate.parse(dob, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public void printAllAttributes(){
        System.out.println(this.getFirstName());
        System.out.println(this.getLastName());
        System.out.println(this.getAddress());
        System.out.println(this.getDob());
        System.out.println(this.getEmail());
        System.out.println(this.getPhoneNumber());
    }
    
    public abstract String getCustomerID();
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    
    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
