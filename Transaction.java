import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Transaction extends JFrame implements  ActionListener {
    JButton deposit,withdrawl,miniStatement,balanceEnquiry,Fastcash,pinchange,Exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
       
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit= new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl= new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        Fastcash= new JButton("Fast Cash");
        Fastcash.setBounds(170,450,150,30);
        Fastcash.addActionListener(this);

        image.add(Fastcash);

        miniStatement= new JButton("MiniStatement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);

        image.add(miniStatement);

        pinchange= new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);

        image.add(pinchange);

        balanceEnquiry= new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.addActionListener(this);

        image.add(balanceEnquiry);
        
        Exit= new JButton("Exit");
        Exit.setBounds(355,520,150,30);
        Exit.addActionListener(this);

        image.add(Exit);
        
        

      
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==Fastcash){
            setVisible(false);
            new fastCash(pinnumber).setVisible(true);

        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==miniStatement){
            // setVisible(false);
            new Ministatement(pinnumber);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
        
    }
}
