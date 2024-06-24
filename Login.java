import java.awt.Image;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame implements ActionListener{
    JButton login,clear ,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Teller MAchine ");
        // if we set the setLayout null then only we can set the custom layout.
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        // to write somethine we use jlabel
        JLabel text = new JLabel("Welcome to ATM ");
        // to make it visible
        text.setBounds(180,40,400,40);
        text.setFont(new Font("Osward", Font.BOLD,38));
        add(text);
        // next text card no input from user 
        JLabel Cardno = new JLabel("Enter Your Card No ");
        
        Cardno.setBounds(200,150,200,40);
        Cardno.setFont(new Font("Raleway", Font.BOLD,15));
        add(Cardno);
        // to make a box to enter card no 
        cardTextField= new JTextField();
        cardTextField.setBounds(380,160,250,30);
        add(cardTextField);
        // next text to take input of pin
        JLabel pin = new JLabel("Enter Your Secret PIN ");
        
        pin.setBounds(200,220 ,200,40);
        pin.setFont(new Font("Raleway", Font.BOLD,15));
        add(pin);
        pinTextField= new JPasswordField();
        pinTextField.setBounds(380,225,250,30);
        add(pinTextField);

        // Sign in Button
        login= new JButton("SIGN IN");
        login.setBounds(380,300,100,30);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        // clear button
        clear= new JButton("CLEAR");
        clear.setBounds(500,300,100,30);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        // sign up button 
        signup= new JButton("SIGN UP");
        signup.setBounds(380,340,220,30);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);


        getContentPane().setBackground(Color.white);

        setSize(800,400);
        setVisible(true);
        setLocation(350,200);   




    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource()==login){
            Conn conn= new Conn();
            String cardnumber= cardTextField.getText();
            String pinnumber= pinTextField.getText();
            String query ="select * from login where cardnumber='"+ cardnumber+"' and pin='"+pinnumber+"'";
            try {
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect CardNumber or Pin");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signupone().setVisible(true);
        }
        
        

    }
    public static void main(String[] args) {
        new Login();
    }
}
