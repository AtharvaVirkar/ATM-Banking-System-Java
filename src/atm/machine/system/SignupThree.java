package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton saveAcc, currAcc, recurrAcc, fdAcc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
String formNo;
    SignupThree(String formNo) {
        this.formNo = formNo;
//        -----------------------------Frame Setup---------------------------------------------------------------------------------
        setLayout(null);
        setSize(850, 1000);
        setLocation(300, 100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

//-------------------------------Contents Of Frames Starts From Here-----------------------------------------------------------------------------------------

        setTitle("ACCOUNT DETAILS FORM - PAGE 3");
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(290, 90, 300, 30);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 180, 200, 30);
        add(type);

//        Radio Buttons For Account details input

        saveAcc = new JRadioButton("Saving Account");
        saveAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        saveAcc.setBackground(Color.WHITE);
        saveAcc.setBounds(280, 190, 150, 20);
        add(saveAcc);

        currAcc = new JRadioButton("Current Account");
        currAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        currAcc.setBackground(Color.WHITE);
        currAcc.setBounds(550, 190, 160, 20);
        add(currAcc);

        recurrAcc = new JRadioButton("Recurring Deposite Account");
        recurrAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        recurrAcc.setBackground(Color.WHITE);
        recurrAcc.setBounds(280, 260, 250, 20);
        add(recurrAcc);

        fdAcc = new JRadioButton("Fixed Deposit Account");
        fdAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        fdAcc.setBackground(Color.WHITE);
        fdAcc.setBounds(550, 260, 250, 20);
        add(fdAcc);
//grouping all the radio buttons
        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(saveAcc);
        accGroup.add(currAcc);
        accGroup.add(fdAcc);
        accGroup.add(recurrAcc);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 320, 200, 30);
        add(card);

        JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-4185");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNo.setBounds(350, 320, 300, 30);
        add(cardNo);

        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 14));
        cardDetails.setBounds(100, 350, 300, 30);
        add(cardDetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 410, 200, 30);
        add(pin);

        JLabel pinDetails = new JLabel("Your 4 Digit PIN");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 14));
        pinDetails.setBounds(100, 430, 300, 30);
        add(pinDetails);

        JLabel pinNo = new JLabel("XXXX");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNo.setBounds(350, 410, 300, 30);
        add(pinNo);

        JLabel services = new JLabel("Service Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 490, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 18));
        c1.setBounds(180, 550, 150, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 18));
        c2.setBounds(450, 550, 250, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 18));
        c3.setBounds(180, 620, 250, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 18));
        c4.setBounds(450, 620, 250, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 18));
        c5.setBounds(180, 690, 150, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 18));
        c6.setBounds(450, 690, 150, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 18));
        c7.setBounds(100, 750, 600, 30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(180, 850, 150, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(480, 850, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (saveAcc.isSelected()) {
                accountType = "Saving Account";
            } else if (currAcc.isSelected()) {
                accountType = "Current Account";

            } else if (fdAcc.isSelected()) {
                accountType = "Fixed Deposit Account";

            } else if (recurrAcc.isSelected()) {
                accountType = "Recurring Deposite Account";

            }

            Random ran = new Random();
            String cardNumber = "" + (ran.nextLong(9000000) + 5040936000000000l);

            String pinNumber = "" + (ran.nextInt(9000) + 1000);

            String facility = "";
            if (c1.isSelected()) {
                facility = " " + facility + "ATM Card";
            } else if (c2.isSelected()) {
                facility = " " + facility + "Internet Banking";

            } else if (c3.isSelected()) {

                facility = " " + facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = " " + facility + "EMAIL & SMS Alerts";

            } else if (c5.isSelected()) {
                facility = " " + facility + "Cheque Book";

            } else if (c6.isSelected()) {
                facility = " " + facility + "E-Statement";

            }

            try {
                if(accountType==null){
                    JOptionPane.showMessageDialog(null, "Account Type is Required!!!!!");
                }
                else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values ('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values ('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

setVisible(false);
new Deposite(pinNumber).setVisible(true);
                    JOptionPane.showMessageDialog(null , "Card Number: " + cardNumber + "\n Pin: "+pinNumber);
                }

            }catch (Exception e)
            {
                System.out.println(e);
            }

//------------------------Exception ahndling for connecting with DB------------------------------------------------
        } else if (ae.getSource() == cancel) {

            setVisible(false);
            new Login().setVisible(true);
        }


    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
