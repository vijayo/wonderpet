/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import DA.ProductDA;
import domain.Product;


public class MaintainProductControl {
    private ProductDA ProdDA;
    
    public MaintainProductControl() {
       ProdDA = new ProductDA();
    }
    
    public Product selectRecordWithCode(String Prod_Code) {
        return ProdDA.getProductRecordWithCode(Prod_Code);
    }
    
    public Product selectRecordWithName(String Prod_Name) {
        return ProdDA.getProductRecordWithName(Prod_Name);
    }

    public void addRecord(Product product) {
        ProdDA.addOnNewProductRecord(product);
    }
    
    public void UpdateRecord(Product product) {
        ProdDA.updateProductRecord(product);
    }
    
    public void DeleteRecord(Product product) {
        ProdDA.deleteProductRecordWithCode(product);
    }
    
    public void DeleteRecord(String Prod_Code) {
        ProdDA.deleteProductRecordWithCode(Prod_Code);
    }
   
}


