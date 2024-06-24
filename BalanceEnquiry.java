import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;



public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    int balance;
    JLabel text;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        image.add(back);
        Conn c= new Conn();
        try {
            ResultSet rs= c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }


            }
        }
        catch(Exception e){
            System.out.println(e);
        }   
        text= new JLabel("Your current account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
