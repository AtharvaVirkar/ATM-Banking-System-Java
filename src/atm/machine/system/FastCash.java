package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener {
    JButton deposite, withdraw, fastCash, miniStatement, pinChange, balEnquiry, back;
    String PIN;

    FastCash(String PIN) {
        this.PIN = PIN;
//        -----------------Basic Setup of Frame------------------------------------------------------------------------------------------------------
        setSize(900, 900);
        setLocation(300, 100);
        setLayout(null);


//-----------------------ATM Image loading-----------------------------------------------------------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

//        ------------------------Adding Labels-------------------------------------------------------------

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        text.setBounds(210, 300, 700, 35);
        image.add(text);

//------------Creating Buttons so that we can display on the ATM Machine and access the functionalities-----------------------------------------------------------------------------------------------------------

//-----------------Functionalities -> Buttons-------------------------------------------------------------------------------------

        deposite = new JButton("Rs 100");
        deposite.setBounds(165, 417, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(350, 417, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(165, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(350, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);


        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(165, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);


        balEnquiry = new JButton("10000");
        balEnquiry.setBounds(350, 485, 150, 30);
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);

        back = new JButton("BACK");
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setUndecorated(true);
        setVisible(true); // should always be written at the end of constructor
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);     // hides current window
            new Transactions(PIN).setVisible(true);

        } else {
            String amt = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + PIN + "'");
                int bal = 0;
                while (rs.next()) {

                    if (rs.getString("type").equals("Deposite"))
                    {
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && bal < Integer.parseInt(amt))
                {
                    JOptionPane.showMessageDialog(null, "! ! ! NOT SUFFICIENT BALANCE ! ! !\nYour current balance is "+bal);
                    return;
                }

                Date date = new Date();
                String query =  "insert into bank values ('"+PIN+"' , '"+date+"' , 'WithDrawl', '"+amt+"');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amt+" Debited Sucessfully");

                setVisible(false);
                new Transactions(PIN).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
