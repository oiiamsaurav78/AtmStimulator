import javax.swing.*;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Date;
public class fastCash extends JFrame implements  ActionListener {
    JButton hundred,twoHundred,fiveHundred,thousand,fiveThousand,tenThousand,Back;
    String pinnumber;
    fastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
       
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel(" Select WithDrawl Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        hundred= new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        twoHundred= new JButton("Rs 200");
        twoHundred.setBounds(355,415,150,30);
        twoHundred.addActionListener(this);
        image.add(twoHundred);

        fiveHundred= new JButton("Rs 500");
        fiveHundred.setBounds(170,450,150,30);
        fiveHundred.addActionListener(this);

        image.add(fiveHundred);

        thousand= new JButton("Rs 1000");
        thousand.setBounds(355,450,150,30);
        thousand.addActionListener(this);

        image.add(thousand);

        fiveThousand= new JButton("Rs 5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.addActionListener(this);

        image.add(fiveThousand);

        JButton tenThousand= new JButton("Rs 10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.addActionListener(this);

        image.add(tenThousand);
        
        Back= new JButton("Back");
        Back.setBounds(355,520,150,30);
        Back.addActionListener(this);

        image.add(Back);
        
        

      
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
            // System.exit(0);
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else{
            String amount= (((JButton) ae.getSource()).getText().substring(3));
            Conn c= new Conn();
            try {
                ResultSet rs= c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }


                }
                if(ae.getSource()!=Back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficent balance");
                    return;
                }
                Date date= new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawl Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
                // TODO: handle exception
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("");
        
    }
}
