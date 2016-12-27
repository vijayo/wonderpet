/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import DA.PaymentDA;
import domain.Payment;


public class MaintainPaymentControl {
    private PaymentDA payDA;
    
    public MaintainPaymentControl() {
        payDA = new PaymentDA();
    }
    
    public Payment selectRecord(String Pay_No) {
        return payDA.getPaymentRecord(Pay_No);
    }

    public void addRecord(Payment payment) {
        payDA.addPaymentRecord(payment);
    }
    
    public void UpdateRecord(Payment payment) {
        payDA.updatePaymentRecord(payment);
    }
    
    public void DeleteRecord(String Pay_No) {
        payDA.deletePaymentRecord(Pay_No);
    }
    
}


