package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String PIN;

    MiniStatement(String PIN) {

        this.PIN = PIN;


        setTitle("Mini Statement");

        setSize(400, 600);
        setLocation(300, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);


//---------------Labels------------------------------------------------------------------------------------------------------

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        try {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + PIN + "';");
//            ResultSet rs = c.s.executeQuery("select * from login where pin = '6740';");
            while (rs.next()) {

                card.setText("Card Number: " + rs.getString("CARDNUMBER").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("CARDNUMBER").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + PIN + "';");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><    html>");//with help of &nbsp(= 1 space) we get spaces in that its present in html
            }

        } catch (Exception e) {
            System.out.println(e);
        }

//        --------------------------balance-----------------
        try {
            int bal = 0;
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + PIN + "'");

            while (rs.next()) {//re.next acts like just the ittration where it locates to the nxt row

                if (rs.getString("type").equals("Deposite")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+bal);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
