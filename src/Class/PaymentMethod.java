/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author raysen
 */
public class PaymentMethod {
    private String methodID;
    private String bankName;
    private String bankCode;
    
    public PaymentMethod(ArrayList<String> allPaymentMethodData) {
        this.methodID = allPaymentMethodData.get(0);
        this.bankName = allPaymentMethodData.get(1);
        this.bankCode = allPaymentMethodData.get(2);
    }
    
    /**
     * @return the methodID
     */
    public String getMethodID() {
        return methodID;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the bankCode
     */
    public String getBankCode() {
        return bankCode;
    }
}
