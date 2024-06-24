


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField aadhar, pan;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox<String> religion, category, education, occupation, income;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM-Page 2:");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        String[] varReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox<>(varReligion);
        religion.setBounds(300, 140, 400, 30);
        add(religion);
        religion.setBackground(Color.WHITE);

        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String[] varCategory = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(varCategory);
        category.setBounds(300, 190, 400, 30);
        add(category);
        category.setBackground(Color.WHITE);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 400, 30);
        add(dob);

        String[] incomeCategory = {"null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        add(income);
        income.setBackground(Color.WHITE);

        JLabel educationLabel = new JLabel("Educational");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        JLabel qualificationLabel = new JLabel("Qualification: ");
        qualificationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        qualificationLabel.setBounds(100, 310, 200, 30);
        add(qualificationLabel);

        String[] educationValues = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 310, 400, 30);
        add(education);
        education.setBackground(Color.WHITE);

        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        occupationLabel.setBounds(100, 390, 200, 30);
        add(occupationLabel);

        String[] occupationValues = {"Salaried", "Self-Employed", "Student", "Retired", "Others"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);
        occupation.setBackground(Color.WHITE);

        JLabel panNumberLabel = new JLabel("Pan Number: ");
        panNumberLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        panNumberLabel.setBounds(100, 440, 200, 30);
        add(panNumberLabel);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel aadharNumberLabel = new JLabel("Aadhar Number: ");
        aadharNumberLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        aadharNumberLabel.setBounds(100, 490, 200, 30);
        add(aadharNumberLabel);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel seniorCitizenLabel = new JLabel("Senior Citizen: ");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorCitizenLabel.setBounds(100, 540, 200, 30);
        add(seniorCitizenLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel existingAccountLabel = new JLabel("Existing Account: ");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        existingAccountLabel.setBounds(100, 590, 200, 30);
        add(existingAccountLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = syes.isSelected() ? "Yes" : "No";
        String existingaccount = eyes.isSelected() ? "Yes" : "No";
        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, seniorcitizen, existingaccount) VALUES ('"
                    + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '"
                    + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Application Form2 Submitted Successfully");
            setVisible(false);
            new SignupThree(formno).setVisible(true);;


            // Assuming you have a SignupThree class for the next page
            // new SignupThree(formno).setVisible(true);
            // setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo(" ");
    }
}


// import javax.swing.*;
// import java.awt.*;

// import java.awt.event.*;
// import java.util.Random;

// public class SignupTwo extends JFrame implements ActionListener {
//     long random;
//     JTextField aadhar,pan;
//     JRadioButton syes, sno, eyes, eno;
//     JButton next;
   
//     JComboBox religion ,category,education,occupation,income;
//     String formno;

//     SignupTwo(String formno) {
//         this.formno = formno;
//         setLayout(null);
//         // Random ran = new Random();
//         // random = Math.abs((ran.nextLong() % 9000L) + 1000L);
//         setTitle("NEW ACCOUNT APPLICATION FORM-Page 2:");

    

//         JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
//         additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
//         additionalDetails.setBounds(290, 80, 400, 30);
//         add(additionalDetails);

//         JLabel name = new JLabel("Religion:");
//         name.setFont(new Font("Raleway", Font.BOLD, 22));
//         name.setBounds(100, 140, 100, 30);
//         add(name);
//         String[] varReligion ={"Hindu","Muslim","Sikh","Christian","Others"};
//         religion= new JComboBox(varReligion);
//         religion.setBounds(300, 140, 400, 30);
//         add(religion);
//         religion.setBackground(Color.WHITE);
        

//         JLabel fname = new JLabel("Category: ");
//         fname.setFont(new Font("Raleway", Font.BOLD, 22));
//         fname.setBounds(100, 190, 200, 30);
//         add(fname);

//         String[]varcategory={"General","OBC","SC","ST","Other"};
//         category= new JComboBox(varcategory);
//         category.setBounds(300, 190, 400, 30);
//         add(category);
//         category.setBackground(Color.WHITE);

//         JLabel dob = new JLabel("income: ");
//         dob.setFont(new Font("Raleway", Font.BOLD, 22));
//         dob.setBounds(100, 240, 400, 30);
//         add(dob);

//         String[]incomecategory={"null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
//         income= new JComboBox(incomecategory);
//         income.setBounds(300, 240, 400, 30);
//         add(income);
//         income.setBackground(Color.WHITE);

        
        

//         JLabel Education = new JLabel("Educational");
//         Education.setFont(new Font("Raleway", Font.BOLD, 22));
//         Education.setBounds(100, 290, 200, 30);
//         add(Education);

//         JLabel email = new JLabel("Qualification: ");
//         email.setFont(new Font("Raleway", Font.BOLD, 22));
//         email.setBounds(100, 310, 200, 30);
//         add(email);
        
//         String[]educationValues={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
//         education= new JComboBox(educationValues);
//         education.setBounds(300, 310, 400, 30);
//         add(education);
//         education.setBackground(Color.WHITE);        

       

//         JLabel marital = new JLabel("Occupation:");
//         marital.setFont(new Font("Raleway", Font.BOLD, 22));
//         marital.setBounds(100, 390, 200, 30);
//         add(marital);

//         String[]occupationValues={"Salaried","Self-Employed","Student","Retired","Others"};
//         occupation= new JComboBox(occupationValues);
//         occupation.setBounds(300, 390, 400, 30);
//         add(occupation);
//         occupation.setBackground(Color.WHITE); 

//         JLabel PanNumber = new JLabel("Pan Number: ");
//         PanNumber.setFont(new Font("Raleway", Font.BOLD, 22));
//         PanNumber.setBounds(100, 440, 200, 30);
//         add(PanNumber);

//         pan= new JTextField();
//         pan.setFont(new Font("Raleway", Font.BOLD, 14));
//         pan.setBounds(300, 440, 400, 30);
//         add(pan);

//         JLabel AadharNumber = new JLabel("Aadhar Number: ");
//         AadharNumber.setFont(new Font("Raleway", Font.BOLD, 22));
//         AadharNumber.setBounds(100, 490, 200, 30);
//         add(AadharNumber);

//         aadhar = new JTextField();
//         aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
//         aadhar.setBounds(300, 490, 400, 30);
//         add(aadhar);

//         JLabel SeniorCitizen = new JLabel("Senior Citizen: ");
//         SeniorCitizen.setFont(new Font("Raleway", Font.BOLD, 22));
//         SeniorCitizen.setBounds(100, 540, 200, 30);
//         add(SeniorCitizen);

//         syes = new JRadioButton("Yes");
//         syes.setBounds(300, 540, 100, 30);
//         syes.setBackground(Color.WHITE);
//         add(syes);

//         sno = new JRadioButton("No");
//         sno.setBounds(400, 540, 100, 30);
//         sno.setBackground(Color.WHITE);
//         add(sno);


//         ButtonGroup maritalGroup = new ButtonGroup();
//         maritalGroup.add(syes);
//         maritalGroup.add(sno);
        


        

//         JLabel existingaccount = new JLabel("Existing Account: ");
//         existingaccount.setFont(new Font("Raleway", Font.BOLD, 22));
//         existingaccount.setBounds(100, 590, 200, 30);
//         add(existingaccount);
//         eyes = new JRadioButton("Yes");
//         eyes.setBounds(300, 590, 100, 30);
//         eyes.setBackground(Color.WHITE);
//         add(eyes);

//         eno = new JRadioButton("No");
//         eno.setBounds(400, 590, 100, 30);
//         eno.setBackground(Color.WHITE);
//         add(eno);


//         ButtonGroup exitingaccount = new ButtonGroup();
//         exitingaccount.add(eyes);
//         exitingaccount.add(eno);
 

//         next = new JButton("Next");
//         next.setBackground(Color.BLACK);
//         next.setForeground(Color.WHITE);
//         next.setFont(new Font("Raleway", Font.BOLD, 14));
//         next.setBounds(620, 660, 80, 30);
//         next.addActionListener(this);
//         add(next);

//         getContentPane().setBackground(Color.WHITE);
//         setSize(850, 800);
//         setLocation(350, 200);
//         setVisible(true);
//     }

//     public void actionPerformed(ActionEvent ae) {
//         String formno = "" + random;
//         String sreligion = (String)religion.getSelectedItem();
//         String scategory = (String)category.getSelectedItem();
//         String sincome = (String)income.getSelectedItem();
//         String seducation = (String)education.getSelectedItem();
//         String soccupation = (String)occupation.getSelectedItem();
//         String seniorcitizen=null;
//         if (syes.isSelected()) {
//             seniorcitizen = "Yes";
//         } else if (sno.isSelected()) {
//             seniorcitizen = "No";
//         }
        
//         String existingaccount = null;
//         if (eyes.isSelected()) {
//             existingaccount = "Yes";
//         } else if (eno.isSelected()) {
//             existingaccount = "No";
//         } 
//         String span = pan.getText();
//         String saadhar = aadhar.getText();
        

//         try {
//             Conn c = new Conn();
//             String query = "INSERT INTO signuptwo VALUES ('" 
//                               + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" 
//                               + soccupation + "', '" + soccupation + "', '" +span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
//             c.s.executeQuery(query);
//             // Signupthree object; 
                
        
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }

//     public static void main(String[] args) {
//         new SignupTwo(" ");
//     }
// }