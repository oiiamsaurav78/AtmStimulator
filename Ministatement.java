import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;

public class Ministatement extends JFrame {
    JLabel mini, bank;
    String pinnumber;
    
    Ministatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        mini = new JLabel();
        add(mini);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(120, 400, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin ='" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Cardnumber " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Use StringBuilder to accumulate text for mini label and calculate balance
        StringBuilder miniText = new StringBuilder();
        int bal = 0;

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + 345 + "'");
            
            while (rs.next()) {
                miniText.append("<html>").append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").append(rs.getString("amount"))
                        .append("<br><br></html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            // Set accumulated text to mini JLabel
            mini.setText(miniText.toString());
            balance.setText("Your current balance is : " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        mini.setBounds(20, 140, 400, 200);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ministatement(""); // Provide a pin number here
    }
}

// import java.awt.Color;
// import java.sql.ResultSet;

// import javax.naming.spi.DirStateFactory.Result;
// import javax.swing.*;

// public class Ministatement extends JFrame {
//     JLabel mini,bank;
//     String pinnumber;
//     Ministatement(String pinnumber){
//         this.pinnumber= pinnumber;
//         setLayout(null);

//         mini= new JLabel();
//         add(mini);

//         bank= new JLabel("Indian Bank");
//         bank.setBounds(150,20,100,20);
//         add(bank);

//         JLabel card= new JLabel();
//         card.setBounds(20,80,300,20);
//         add(card);
//         JLabel balance= new JLabel();
//         balance.setBounds(120,400,300,20);
//         add(balance);

//         try {
//             Conn conn= new Conn();
//             ResultSet rs= conn.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
//             while (rs.next()) {
//                 card.setText("Cardnumber "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
                
//             }
            
//         } catch (Exception e) {
//             // TODO: handle exception
//             System.out.println(e);
//         }
//         try {
//             Conn conn= new Conn();
//             ResultSet rs= conn.s.executeQuery("select * from bank where pin='"+345+"'");
//             int bal=0;
//             while(rs.next()){
//                 mini.setText(mini.getText()+"<html>"+rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br></html>");
//                 if(rs.getString("type").equals("Deposit")){
//                     bal += Integer.parseInt(rs.getString("amount"));
//                 }else{
//                     bal-=Integer.parseInt(rs.getString("amount"));
//                 }

//             }
//             balance.setText("Your current balance is : ");
//         } catch (Exception e) {
//             // TODO: handle exception
//             System.out.println(e);
//         }
//         mini.setBounds(20,140,400,200);
//         setSize(400,600);
//         setLocation(20,20);
//         getContentPane().setBackground(Color.WHITE);
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         new Ministatement("");
//     }
// }

// // import java.awt.Color;
// // import java.sql.ResultSet;
// // import javax.swing.*;

// // public class Ministatement extends JFrame {
// //     JLabel mini, bank;
// //     String pinnumber;

// //     Ministatement(String pinnumber) {
// //         this.pinnumber = pinnumber;
// //         setLayout(null);

// //         mini = new JLabel();
// //         mini.setBounds(20, 120, 350, 400); // Set bounds for the mini statement display area
// //         add(mini);

// //         bank = new JLabel("Indian Bank");
// //         bank.setBounds(150, 20, 100, 20);
// //         add(bank);

// //         JLabel card = new JLabel();
// //         card.setBounds(20, 80, 300, 20);
// //         add(card);

// //         try {
// //             Conn conn = new Conn(); // Assuming Conn class handles database connection
// //             ResultSet rs = conn.s.executeQuery("select * from login where pin ='" + pinnumber + "'");
// //             if (rs.next()) {
// //                 card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4)
// //                         + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
// //             }

// //             rs = conn.s.executeQuery("select * from bank where pin='" + 345 + "'");
// //             while (rs.next()) {
// //                 mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
// //                         + rs.getString("type") + "<br>");
// //             }

// //             conn.s.close(); // Close ResultSet and Statement
// //             conn.c.close(); // Close Connection
// //         } catch (Exception e) {
// //             JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
// //             e.printStackTrace();
// //         }

// //         setSize(400, 600);
// //         setLocationRelativeTo(null); // Center window on screen
// //         getContentPane().setBackground(Color.WHITE);
// //         setVisible(true);
// //         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// //     }

// //     public static void main(String[] args) {
// //         new Ministatement("");
// //     }
// // }
