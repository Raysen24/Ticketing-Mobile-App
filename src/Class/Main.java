package Class;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DA.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author raysen
 */
public class Main {
    

    public static void main(String[] args) {
        Customer customer = new Customer(DA.DA_Customer.getAllCustomerData("raysensusanto@gmail.com", "raysen123"));
//        customer.printAllAttribute();
    }
}
