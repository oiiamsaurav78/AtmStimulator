
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    JButton change,back;
    JLabel text,repintext;
    JPasswordField  pin,repin;
    String pinnumber;
    pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text= new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(280,300,500,32);
        image.add(text);

        JLabel pintext= new JLabel("Change your PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(165,330,500,32);
        image.add(pintext);

        repintext= new JLabel("Re-Enter your PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        repintext.setBounds(165,370,500,32);
        image.add(repintext);

        pin= new JPasswordField();
        pin.setBounds(350,340,100,20);
        image.add(pin);

        repin= new JPasswordField();
        repin.setBounds(350,375,100,20);
        image.add(repin);

        change= new JButton("Change");
        change.setBounds(400,490,120,30);
        change.addActionListener(this);
        image.add(change);

        back= new JButton("Back");
        back.setBounds(400,520,120,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
            
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change) {
            try {
                String npin=pin.getText();
                String rpin= repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter your pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter your repin");
                    return;
                }
                Conn conn= new Conn();
                String query1 = "update bank set pin='" + rpin + "' where pin='" + pinnumber + "'";
                String query2 = "update signupthree set pin='" + rpin + "' where pin='" + pinnumber + "'";
                String query3 = "update login set pin='" + rpin + "' where pin='" + pinnumber + "'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin change successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
                // TODO: handle exception
            }            
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
       

    }
    public static void main(String[] args) {
        new pinchange("").setVisible(true);;
    }
}
