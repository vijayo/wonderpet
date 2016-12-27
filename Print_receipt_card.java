/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.StartBusiness;



import domain.Payment;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class Print_receipt_card extends JFrame{
    JTextArea  L1= new JTextArea();
    
    private String produtlist ="";
    public Print_receipt_card(double total,int quan,double gst,double memdis,double finaltotal,
            Payment payment,ArrayList<domain.Product> tmpproductArray,int card){
        
        setLayout(new BorderLayout());
        for(int z=0 ;z<tmpproductArray.size();z++){
            String tmp="";
            tmp =String.format("\t%-3d%-30s\t\t%-5.2f\n",z+1,tmpproductArray.get(z).getPro_Name(),
                    tmpproductArray.get(z).getPro_Price());
            produtlist +=tmp;
        }
        
        
       double round = (Math.ceil(((payment.getP_Amount()-0.05)*20)))/20;
        L1.setEditable(false);
        L1.setText("\t\t           BOBO Bistro\t\t\n"
                + "\t\t    25107 FM 3230 Road\t\t\n"
                + "\t\t             Huffman\t\t\n "
                + "\t\t TX 77336, United States\t\t\n"
                + "\t\t(GST ID No: 001401782235)\t\t\n"
                + "\t\t Tel No. +1 281-324-9899\t\t\n"
                + "\t\t         TAX INVOICE\t\t\n\n"
                + "\t\t     Payment_NO#"+payment.getP_NO()  + "\t\t\n"
                +"\n\t\t   ORD #69 -RED #"+payment.getP_Date() +"\t\t\n"
                + "\t\t       user:"+payment.getUserID()+"\t\t\n"
                + "\t*********************************************************\t\t\n"
                + produtlist+"\n"
                + "\tAMOUNT EXCL\t\t\t= RM"+String.format("%.2f",total) +"\t\t\n"
                + "\tGST\t\t\t= RM"+ gst +"\t\t\n"
                + "\tMEMBER DISC\t\t\t= -RM"+memdis +"\t\t\n"
                + "\tTOTAL\t\t\t= RM"+String.format("%.2f",payment.getP_Amount())+"\t\t\n"
                + "\tROUND\t\t\t= RM"+String.format("%.2f",round-payment.getP_Amount())+"\t\t\n"
                + "\tTL\t\t\t= RM"+String.format("%.2f",round)+"\t\t\n"
                + "\tCard number\t\t\t= RM"+String.format("%.2f",card)+"\t\t\n"
                + "\t**********************************************************\t\t\n"
                + "\tThank You and Please Come Again.\t\t\n"
                + "\tCustomer Service Hotline : 03-2726-5600\t\t\n"
        );
        
         add(L1);
        setTitle("Businees On");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    
    }

}
