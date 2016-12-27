/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import DA.Pay_ProdDA;
import domain.Pay_Prod;
import domain.Product;
import domain.Payment;


public class MaintainPay_ProdControl {
    private Pay_ProdDA pay_prodDA;
    
    public MaintainPay_ProdControl() {
        pay_prodDA = new Pay_ProdDA();
    }
    
    public Pay_Prod selectRecord(String pay_no) {
        return pay_prodDA.getPay_ProdRecord(pay_no);
    }
    
    public void addRecord(Pay_Prod pay_prod) {
         pay_prodDA.addPay_ProdRecord(pay_prod);
    }
    
    public void UpdateRecord(Pay_Prod pay_prod) {
        pay_prodDA.updatePay_ProdRecord(pay_prod);
    }
    
    public void DeleteRecord(String pay_no) {
        pay_prodDA.deletePay_ProdRecord(pay_no);
    }
    
}


