 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.StartBusiness;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import domain.Pay_Prod;
import domain.Product;
import domain.Payment;
import DA.Pay_ProdDA;
import DA.ProductDA;
import DA.PaymentDA;
import DA.MemberDA;



public class StartBA extends JFrame{

    private Pay_ProdDA _pay_prodDA;
    private ProductDA _productDA;
    private PaymentDA _paymentDA;
    private MemberDA _memberDA;
    private JPanel p0 = new JPanel(new BorderLayout());
    private JPanel p1 = new JPanel(new BorderLayout());
    private JPanel p2 = new JPanel(new GridLayout(4,2));
    private JPanel p3 = new JPanel(new BorderLayout());
    private JPanel p4 = new JPanel(new GridLayout(2,1));
    private JPanel p5 = new JPanel(new BorderLayout());
    private JPanel p6 = new JPanel(new GridLayout(1,3));
    private JPanel p8 = new JPanel(new BorderLayout());
    private JPanel p9 = new JPanel(new BorderLayout());
    private JPanel p10 = new JPanel(new FlowLayout());
    private JPanel p11 = new JPanel(new BorderLayout());
    private JTextField Show_total_quantity = new JTextField("");
    private JTextField Show_total_Amount = new JTextField("");
    private JTextField Show_GST_amount = new JTextField("");
    private JTextField Show_member_discount = new JTextField("0");
    
    
    private JLabel j1 = new JLabel("Total items = ");
    private JLabel j3 = new JLabel("Total GST(RM) = ");
    private JLabel j4 = new JLabel("Total Member Discount = ");
    private JLabel j2 = new JLabel("Total Amount(RM) = ");
    private JLabel welcome = new JLabel("WELCOME TO BOBO SYSTEM");
     private JTextField show_option = new JTextField("");

     private JTextArea show_list_of_product = new JTextArea("");
     private JTextArea show_Table_and_Pay_no = new JTextArea("");
     private JTextArea show_User_id = new JTextArea("");
   
    
    //////categories list//////////
    private JPanel categoriesButton = new JPanel(new GridLayout(0,5));
    private JButton  BeverageButton = new JButton("Drink");
    private JButton SnackButton = new JButton("Snack");
    private JButton OtherButton = new JButton("Other");
    
    ////////product list/////////
    private JPanel ProductList = new JPanel(new FlowLayout(FlowLayout.LEFT,0,20));
    private JButton[] ProductListButton = new JButton[60];
    private JButton[] ProductDrinkListButton = new JButton[60];
    private JButton[] ProductOtherListButton = new JButton[60];
    ///funstion keys/////
    private JPanel funtionsKey_Panel = new JPanel(new GridLayout(2,2));
    private JPanel Pay_Panel = new JPanel(new GridLayout(1,1));
    private JPanel funtions_Panel = new JPanel(new GridLayout(1,1));
    private JButton PayButton = new JButton("Pay");
    private JButton DeleteButton = new JButton("Delete");
    private JButton FreeButton = new JButton("Free");
    private JButton Open_CashierButton = new JButton("Open Cashier");
    private JButton ViewButton = new JButton("View");
    private JButton MemberButton = new JButton("Member");
    private JButton ExitButton = new JButton("Exit");
    private JButton HoldButton = new JButton("Hold");
    private JButton DiscountButton = new JButton("Discount"); 
    
     private ArrayList<domain.Product> productArray;
     private ArrayList<domain.Product> productArray2;
     private ArrayList<domain.Product> tmpproductArray;
     private ArrayList<domain.Pay_Prod> tmppay_prod;
     private ArrayList<Product> product;
     private String show;
     private Double show1;
     private int show2;
     private String User_id;
     private Payment payment;
     private double total=0;
     private int discountp=0;
     private double discounta=0;
     
     private Font largeFont;
     private Font smallFont;
     
    public StartBA(Payment payment1){
         this.payment=payment1;
         this.total= payment.getP_Amount();
         this.User_id=payment.getUserID();

        
         tmppay_prod = new ArrayList<Pay_Prod>();
        tmpproductArray=new ArrayList<domain.Product>();
         _productDA = new ProductDA();
        _paymentDA = new PaymentDA();
        _pay_prodDA =new Pay_ProdDA();
         largeFont = new Font("TimesRoman", Font.BOLD, 30);
         smallFont = new Font("TimesRoman", Font.BOLD, 15);
         setLayout(new GridLayout(1,2));
         p1.add(p2,BorderLayout.SOUTH);
         p1.add(show_option,BorderLayout.NORTH);
         p1.add(p11,BorderLayout.CENTER);
         p2.setBackground(new Color(245, 245, 220));
        ProductList.setBackground(new Color(245, 245, 220));
        categoriesButton.setBackground(new Color(245, 245, 220));
        show_Table_and_Pay_no.setBackground(new Color(245, 245, 220));
        p11.add(show_list_of_product);
        
         show_list_of_product.setBackground(Color.WHITE);
         show_option.setEditable(false);
         show_list_of_product.setEditable(false);
         Show_total_quantity.setEditable(false);
         Show_total_Amount.setEditable(false);
         Show_GST_amount.setEditable(false);
         Show_member_discount.setEditable(false);
         show_Table_and_Pay_no.setEditable(false);
         DiscountButton.setFont(smallFont);
         HoldButton.setFont(smallFont);
         ExitButton.setFont(smallFont);
         MemberButton.setFont(smallFont);
         ViewButton.setFont(smallFont);
         Open_CashierButton.setFont(smallFont);
         FreeButton.setFont(smallFont);
         DeleteButton.setFont(smallFont);
         PayButton.setFont(largeFont);
        OtherButton.setFont(largeFont);
        SnackButton.setFont(largeFont);
        BeverageButton.setFont(largeFont); 
         show_list_of_product.setFont(largeFont);
         show_option.setFont(largeFont);
         show_Table_and_Pay_no.setFont(largeFont);
         j1.setFont(largeFont);
         j2.setFont(largeFont);
         j3.setFont(largeFont);
         j4.setFont(largeFont);
         welcome.setFont(largeFont);
         Show_total_quantity.setFont(largeFont);
         Show_total_Amount.setFont(largeFont);
         Show_GST_amount.setFont(largeFont);
         Show_member_discount.setFont(largeFont);
         ProductList.setFont(largeFont);
         productArray2 =_productDA.getProductArray(payment.getP_NO());
         show2 = setTextFieldsTotalItem(productArray2);
         Show_total_quantity.setText(String.format("%d",show2));
         Show_total_Amount.setText(String.valueOf(payment.getP_Amount()));
         show = ListOutChosedProduct(productArray2);
         show_list_of_product.setText(show);
         show_Table_and_Pay_no.setText(String.format("Table-%s-\tPayment NO :%s",payment.getSitTable(),payment.getP_NO()));
         p0.add(show_Table_and_Pay_no,BorderLayout.NORTH);
         p0.add(p1,BorderLayout.CENTER);
         
         p2.add(j1);
         p2.add(Show_total_quantity);
         p2.add(j3);
         p2.add(Show_GST_amount);
         p2.add(j4);
         p2.add(Show_member_discount);
         p2.add(j2);
         p2.add(Show_total_Amount);
         
         
         p3.add(p4,BorderLayout.NORTH);
         p3.add(p5,BorderLayout.CENTER);
         p4.add(welcome);
         p5.add(ProductList,BorderLayout.CENTER);
        //////funtions of next table or receipt
        show_User_id.setText(payment.getUserID());
        show_User_id.setFont(largeFont);
         //////categories list//////////
        categoriesButton.add(SnackButton);
        categoriesButton.add(BeverageButton);
        categoriesButton.add(OtherButton);
        p4.add(categoriesButton);
        
        
        Pay_Panel.add(PayButton);
        funtionsKey_Panel.add(DiscountButton);
        funtionsKey_Panel.add(ViewButton);
        funtionsKey_Panel.add(Open_CashierButton);
        funtionsKey_Panel.add(MemberButton);
        funtionsKey_Panel.add(DeleteButton);
        funtionsKey_Panel.add(ExitButton);
        funtions_Panel.add(Pay_Panel,BorderLayout.WEST);
        funtions_Panel.add(funtionsKey_Panel,BorderLayout.CENTER);
        p3.add(funtions_Panel,BorderLayout.SOUTH);
        add(p0);
        add(p3);
        
   
       
    BeverageButton.addActionListener(new Drink());
    SnackButton.addActionListener(new Snack());
    OtherButton.addActionListener(new Other());
    MemberButton.addActionListener(new Member());
      DeleteButton.addActionListener(new DeletePayment());
    PayButton.addActionListener(new PayPayment());
    DiscountButton.addActionListener(new Discount());
    ExitButton.addActionListener(new Exit());
    ViewButton.addActionListener(new view());
    Open_CashierButton.addActionListener(new OpenCashier());
    
    ////////product list/////////
    setTitle("Start Business");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        
         
     
     }
     
    private class DeletePayment implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              
              String removelist = JOptionPane.showInputDialog("Which no u wan delete");
              int i = Integer.parseInt(removelist);
              tmppay_prod.remove(i-1);
              tmpproductArray.remove(i-1);
              show = ListOutChosedProduct(tmpproductArray);
                show1 = setTextFieldsTotalAmount(tmpproductArray);
                show2 = setTextFieldsTotalItem(tmpproductArray);
                show_list_of_product.setText(show);
                Show_total_quantity.setText(String.format("%d",show2));
                Show_total_Amount.setText(String.format("%.2f",show1));
                Show_GST_amount.setText(String.format("%.2f",show1*0.06));
                p5.revalidate();
                p5.repaint();
     }
     }
     
    private class Discount implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              
              String i = JOptionPane.showInputDialog(null,"Enter password(only for high level)","Enter password",JOptionPane.OK_CANCEL_OPTION);
              if(!i.equals("321")){
              JOptionPane.showMessageDialog(null, "Wrong Password","Wrong Password",JOptionPane.WARNING_MESSAGE);
              }else{
              String discount = JOptionPane.showInputDialog("how many % discount");
              
              
              String amount = Show_total_Amount.getText();
              double amounta = Double.parseDouble(amount);
              int discountamount = Integer.parseInt(discount);
              discounta=amounta;
              discountp=discountamount;
              amounta = amounta * (100-discountamount)/100;
              Show_total_Amount.setText(String.format("%.2f",amounta));
              Show_GST_amount.setText(String.format("%.2f",amounta*0.06));
                p5.revalidate();
                p5.repaint();
              }
     }
     }
    
    private class Exit implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              int i = JOptionPane.showConfirmDialog(null,"Record will no save","EXIT",JOptionPane.WARNING_MESSAGE);
              if (i==JOptionPane.OK_OPTION){
              dispose();
               new SeatsArea(User_id);
              
              }
              
     }
     }
    
    
     private class OpenCashier implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              String i = JOptionPane.showInputDialog(null,"Enter password(only for high level)","Enter password",JOptionPane.OK_CANCEL_OPTION);
              if(!i.equals("321")){
              JOptionPane.showMessageDialog(null, "Wrong Password","Wrong Password",JOptionPane.WARNING_MESSAGE);
              }
              
     }
     }
    
    private class view implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              
              new View_payment_record();
              
              }
              
     }
     
    
    private class PayPayment implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              total = setTextFieldsTotalAmount(tmpproductArray);
              int quan = Integer.parseInt(Show_total_quantity.getText());
              double gst = Double.parseDouble(Show_GST_amount.getText());
              double memdis = Double.parseDouble(Show_member_discount.getText());
              double finaltotal = Double.parseDouble(Show_total_Amount.getText());

              
              _paymentDA = new PaymentDA();
              Payment payment1 = new Payment (payment.getP_NO(),payment.getP_Date(),finaltotal,payment.getUserID(),payment.getMemberID(),payment.getSitTable());
              _pay_prodDA.addPay_ProdRecord(tmppay_prod);
              new CashOrCard(total,quan,gst,memdis,finaltotal,payment1,tmpproductArray);

              _paymentDA.addPaymentRecord(payment1);
              //dispose();
              
     }
     }
    
    
    private class Member implements ActionListener{
          public void actionPerformed(ActionEvent e) {
              
              _memberDA = new MemberDA();
              String memberid = JOptionPane.showInputDialog("Enter Meber ID");
               int i = _memberDA.verifyMember(memberid);             
                if(i == 1){
                  //  paymentmemberid
                    String amount = Show_total_Amount.getText();
                    double amounta = Double.parseDouble(amount);
                    Show_member_discount.setText(String.format("-%.2f",amounta*0.1));
                    Show_total_Amount.setText(String.format("%.2f",amounta*0.9));
                   
                }else{
                    JOptionPane.showMessageDialog(null,"NO this Member","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                  
     }
     }
    
    private class Drink implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                 _productDA = new ProductDA();
                productArray =_productDA.getProductArray();
                _paymentDA = new PaymentDA();
                ProductList.removeAll();
                p5.revalidate();
                for (int i = 0; i < productArray.size(); i++) {
                if(productArray.get(i).getPro_Type().equalsIgnoreCase("Drink")){
                ProductDrinkListButton[i] = new JButton(productArray.get(i).getPro_Name());
                ProductDrinkListButton[i].setFont(smallFont);
                ProductList.add(ProductDrinkListButton[i]);
                int z =i;
                ProductDrinkListButton[z].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                 show_option.setText(productArray.get(z).getPro_Name());
                Product pr = _productDA.getProductRecordWithCode(productArray.get(z).getPro_Code());
                Payment pa = payment;///////////////
                Pay_Prod pay_prod = new Pay_Prod(pr,pa);
                tmppay_prod.add(pay_prod);

                tmpproductArray.add(_productDA.getProductRecordWithCode(productArray.get(z).getPro_Code()));  
                show = ListOutChosedProduct(tmpproductArray);
                show1 = setTextFieldsTotalAmount(tmpproductArray);
                show2 = setTextFieldsTotalItem(tmpproductArray);
                show_list_of_product.setText(show);
                Show_total_quantity.setText(String.format("%d",show2));
                Show_total_Amount.setText(String.format("%.2f",show1*1.06));
                Show_GST_amount.setText(String.format("%.2f",show1*0.06));
                p5.revalidate();
                p5.repaint();
                }
                });
           }
               
                }
            }
    }
    
    private class Snack implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                _productDA = new ProductDA();
                productArray =_productDA.getProductArray();
                _paymentDA = new PaymentDA();
                p5.revalidate();
                p5.repaint();
                ProductList.removeAll();
                for (int i = 0; i < productArray.size(); i++) {
                if(productArray.get(i).getPro_Type().equalsIgnoreCase("Snack")){
                ProductDrinkListButton[i] = new JButton(productArray.get(i).getPro_Name());
                ProductDrinkListButton[i].setFont(smallFont);
                ProductList.add(ProductDrinkListButton[i]);
                int z =i;
                ProductDrinkListButton[z].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                show_option.setText(productArray.get(z).getPro_Name());
                Product pr = _productDA.getProductRecordWithCode(productArray.get(z).getPro_Code());
                Payment pa = payment;///////////////
                Pay_Prod pay_prod = new Pay_Prod(pr,pa);
                tmppay_prod.add(pay_prod);

                tmpproductArray.add(_productDA.getProductRecordWithCode(productArray.get(z).getPro_Code()));  
                show = ListOutChosedProduct(tmpproductArray);
                show1 = setTextFieldsTotalAmount(tmpproductArray);
                show2 = setTextFieldsTotalItem(tmpproductArray);
                show_list_of_product.setText(show);
                Show_total_quantity.setText(String.format("%d",show2));
                Show_total_Amount.setText(String.format("%.2f",show1*1.06));
                Show_GST_amount.setText(String.format("%.2f",show1*0.06));
                p5.revalidate();
                p5.repaint();
                }
                });
           }
               
                }
            }
    }
      
    private class Other implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                  _productDA = new ProductDA();
                productArray =_productDA.getProductArray();
                _paymentDA = new PaymentDA();
                p5.revalidate();
                p5.repaint();
                ProductList.removeAll();
                for (int i = 0; i < productArray.size(); i++) {
                if(productArray.get(i).getPro_Type().equalsIgnoreCase("Other")){
                ProductDrinkListButton[i] = new JButton(productArray.get(i).getPro_Name());
                ProductDrinkListButton[i].setFont(smallFont);
                ProductList.add(ProductDrinkListButton[i]);
                int z =i;
                ProductDrinkListButton[z].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                show_option.setText(productArray.get(z).getPro_Name());
                Product pr = _productDA.getProductRecordWithCode(productArray.get(z).getPro_Code());
                Payment pa = payment;///////////////
                Pay_Prod pay_prod = new Pay_Prod(pr,pa);
                tmppay_prod.add(pay_prod);

                tmpproductArray.add(_productDA.getProductRecordWithCode(productArray.get(z).getPro_Code()));  
                show = ListOutChosedProduct(tmpproductArray);
                show1 = setTextFieldsTotalAmount(tmpproductArray);
                show2 = setTextFieldsTotalItem(tmpproductArray);
                show_list_of_product.setText(show);
                Show_total_quantity.setText(String.format("%d",show2));
                Show_total_Amount.setText(String.format("%.2f",show1*1.06));
                Show_GST_amount.setText(String.format("%.2f",show1*0.06));
                p5.revalidate();
                p5.repaint();
                }
                });
           }
               
                }
            }
    }
    
    private String ListOutChosedProduct(ArrayList<domain.Product> lol) {
        String showlist="";
        String tmp="";
        for(int i =0;i <lol.size();i++){
            tmp= String.format("%-5d%-40s%-50.2f\n",i+1,lol.get(i).getPro_Name(),lol.get(i).getPro_Price());
        showlist += tmp;
        }
        return showlist;
    }
    
    private double setTextFieldsTotalAmount(ArrayList<domain.Product> lol) {
        double totala=0;
        for(int i =0;i <lol.size();i++){
        totala += lol.get(i).getPro_Price();
        }
       
        return totala;
    }
    
    private int setTextFieldsTotalItem(ArrayList<domain.Product> lol) {
        int total=0;
        for(int i =0;i <lol.size();i++){
        total++;
        }
        return total;
    }
    
}