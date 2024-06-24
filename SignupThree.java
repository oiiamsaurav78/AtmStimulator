
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 150, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardDetails = new JLabel("This is your 16 Digit Card No.");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100, 330, 300, 30);
        add(cardDetails);

        JLabel pin = new JLabel("PIN Number");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinDetails = new JLabel("This is your 4 Digit PIN No.");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 400, 300, 22);
        add(pinDetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 250, 40);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("Hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(100, 680, 480, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber= ""+Math.abs((random.nextLong()%90000000L)+5040946000000000L);
            String pinnumber=""+Math.abs(random.nextLong()%9000L+1000L);

            StringBuilder facility = new StringBuilder();
            if (c1.isSelected()) {
                facility.append("ATM Card, ");
            }
            if (c2.isSelected()) {
                facility.append("Internet Banking, ");
            }
            if (c3.isSelected()) {
                facility.append("Mobile Banking, ");
            }
            if (c4.isSelected()) {
                facility.append("Email & SMS Alert, ");
            }
            if (c5.isSelected()) {
                facility.append("Cheque Book, ");
            }
            if (c6.isSelected()) {
                facility.append("E-Statement, ");
            }
            if (facility.length() > 0) {
                facility.setLength(facility.length() - 2); // remove trailing comma and space
            }

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Declaration is required");
                } else {
                    Conn conn = new Conn();
                    String query = "INSERT INTO signupthree (formno, accountType, cardnumber, pin, facility) VALUES ('"
                            + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility.toString() + "')";
                    conn.s.executeUpdate(query);
                    String query2="insert into login values('"+formno +"','"+ cardnumber +"','"+ pinnumber +"')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    JOptionPane.showMessageDialog(null,"Card Number "+ cardnumber +"\n Pin:"+ pinnumber);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.math.*;
// import java.util.Random;
// public class SignupThree extends JFrame implements ActionListener {
//     JRadioButton r1,r2,r3,r4;
//     JCheckBox c1,c2,c3,c4,c5,c6,c7;
//     JButton submit,cancel;
//     String formno;
//     SignupThree(String formno){
//         this.formno=formno;
//         setLayout(null);
//         JLabel l1= new JLabel("Page 3: Account Details");
//         l1.setFont(new Font("Raleway",Font.BOLD,22));
//         l1.setBounds(280,40,400,40);
//         add(l1);

//         JLabel type= new JLabel("Account type");
//         type.setFont(new Font("Raleway",Font.BOLD,22));
//         type.setBounds(100,140,200,30);
//         add(type);
        
//         r1= new JRadioButton("Saving Account");
//         r1.setFont(new Font("Raleway",Font.BOLD,16));
//         r1.setBackground(Color.WHITE);
//         r1.setBounds(100,180,150,20);
//         add(r1);

//         r2= new JRadioButton("Fixed Deposit Account");
//         r2.setFont(new Font("Raleway",Font.BOLD,16));
//         r2.setBackground(Color.WHITE);
//         r2.setBounds(350,180,250,20);
//         add(r2);

//         r3= new JRadioButton("Current Account");
//         r3.setFont(new Font("Raleway",Font.BOLD,16));
//         r3.setBackground(Color.WHITE);
//         r3.setBounds(100,220,150,20);
//         add(r3);
        
//         r4= new JRadioButton("Reccuring Deposit Account");
//         r4.setFont(new Font("Raleway",Font.BOLD,16));
//         r4.setBackground(Color.WHITE);
//         r4.setBounds(350,220,250,20);
//         add(r4);

//         ButtonGroup groupaccount= new ButtonGroup();
//         groupaccount.add(r1);
//         groupaccount.add(r2);
//         groupaccount.add(r3);
//         groupaccount.add(r4);

//         JLabel card= new JLabel("Card Number");
//         card.setFont(new Font("Raleway",Font.BOLD,22));
//         card.setBounds(100,300,200,30);
//         add(card);

//         JLabel number= new JLabel("XXXX-XXXX-XXXX-4184");
//         number.setFont(new Font("Raleway",Font.BOLD,22));
//         number.setBounds(330,300,300,30);
//         add(number);
//         JLabel carddetails= new JLabel("This is your 16 Digit Card No.");
//         carddetails.setFont(new Font("Raleway",Font.BOLD,12));
//         carddetails.setBounds(100,330,300,30);
//         add(carddetails);

//         JLabel pin= new JLabel("PIN Number");
//         pin.setFont(new Font("Raleway",Font.BOLD,22));
//         pin.setBounds(100,370,200,30);
//         add(pin);
//         JLabel pindetails= new JLabel("This is your 4 Digit PIN No.");
//         pindetails.setFont(new Font("Raleway",Font.BOLD,12));
//         pindetails.setBounds(100,400,300,22);
//         add(pindetails);

//         JLabel pnumber= new JLabel("XXXX");
//         pnumber.setFont(new Font("Raleway",Font.BOLD,22));
//         pnumber.setBounds(330,370,300,30);
//         add(pnumber);

//         JLabel services= new JLabel("Services Required: ");
//         services.setFont(new Font("Raleway",Font.BOLD,22));
//         services.setBounds(100,450,250,40);
//         add(services);

//         c1= new JCheckBox("ATM CARD");
//         c1.setBackground(Color.WHITE);
//         c1.setFont(new Font("Raleway",Font.BOLD,16));
//         c1.setBounds(100,500,200,30);
//         add(c1);

//         c2= new JCheckBox("Internet Banking");
//         c2.setBackground(Color.WHITE);
//         c2.setFont(new Font("Raleway",Font.BOLD,16));
//         c2.setBounds(350,500,200,30);
//         add(c2);

//         c3= new JCheckBox("Mobile Banking");
//         c3.setBackground(Color.WHITE);
//         c3.setFont(new Font("Raleway",Font.BOLD,16));
//         c3.setBounds(100,550,200,30);
//         add(c3);

//         c4= new JCheckBox("Email & Sms Alert");
//         c4.setBackground(Color.WHITE);
//         c4.setFont(new Font("Raleway",Font.BOLD,16));
//         c4.setBounds(350,550,200,30);
//         add(c4);

//         c5= new JCheckBox("Check Book");
//         c5.setBackground(Color.WHITE);
//         c5.setFont(new Font("Raleway",Font.BOLD,16));
//         c5.setBounds(100,600,200,30);
//         add(c5);


//         c6= new JCheckBox("E-Statment");
//         c6.setBackground(Color.WHITE);
//         c6.setFont(new Font("Raleway",Font.BOLD,16));
//         c6.setBounds(350,600,200,30);
//         add(c6);

//         c7= new JCheckBox("Hereby declares that the above entered details are correct to the best of my knowledge");
//         c7.setBackground(Color.WHITE);
//         c7.setFont(new Font("Raleway",Font.BOLD,10));
//         c7.setBounds(100,680,480,30);
//         add(c7);

//         submit= new JButton("Submit");
//         submit.setBackground(Color.BLACK);
//         submit.setForeground(Color.WHITE);
//         submit.setFont(new Font("Raleway",Font.BOLD,14));
//         submit.setBounds(250,720,100,30);
//         submit.addActionListener(this);
//         add(submit);

//         cancel= new JButton("Cancel");
//         cancel.setBackground(Color.BLACK);
//         cancel.setForeground(Color.WHITE);
//         cancel.setFont(new Font("Raleway",Font.BOLD,14));
//         cancel.setBounds(420,720,100,30);
//         cancel.addActionListener(this);
//         add(cancel);

//         getContentPane().setBackground(Color.WHITE);
        
        
       

//         setSize(850,820);
//         setLocation(350,0);
//         setVisible(true);

//     }
//     public void actionPerformed (ActionEvent ae){
//         if(ae.getSource()==submit){
//             String accountType=null;
//             if(r1.isSelected()){
//                 accountType="Saving Account";
//             }
//             else if( r2.isSelected()){
//                 accountType="Fixed Deposit";
//             }
//             else if(r3.isSelected()){
//                 accountType="Current Account";
//             }
//             else if(r4.isSelected()){
//                 accountType="Reccuring Desposit Account";
//             }
//             Random random = new Random();
//             String cardnumber= ""+Math.abs((random.nextLong()%90000000L))+5040946000000000L;
//             String pinnumber=""+Math.abs(random.nextLong()%9000L+1000L);
//             String facility="";
//             if(c1.isSelected()){
//                 facility+="ATM Card";
//             }
//             else if(c2.isSelected()){
//                 facility+=" Internet Banking";
//             }
//             else if(c3.isSelected()){
//                 facility+=" Mobile Banking";

//             }else if(c4.isSelected()){
//                 facility+=" Email & SMS Alert";
//             }
//             else if(c5.isSelected()){
//                 facility+=" Cheque Book";
//             }else if(c6.isSelected()){
//                 facility+=" E-Statement";
//             }
//             try{
//                 if(accountType.equals("")){
//                     JOptionPane.showMessageDialog(null, "Account Type is Required");
//                 }else {
//                     Conn conn= new Conn();
//                     String query= "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"'',"+facility+"')";
//                     conn.s.executeUpdate(query);
//                     JOptionPane.showMessageDialog(null, "Account Created Successfully");
//                 }

//             }
//             catch(Exception e){
//                 System.out.println(e);
//             }
           
//         } else if (ae.getSource() == cancel) {
//             setVisible(false);}
//     }
//     public static void main(String[] args) {
//         new SignupThree("");
//     }
// }