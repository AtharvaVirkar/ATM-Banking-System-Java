package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String PIN;

    BalanceEnquiry(String PIN){
        this.PIN = PIN;



//-----------------------ATM Image loading-----------------------------------------------------------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

//        ------------------------Adding Labels-------------------------------------------------------------

        int bal = 0;
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + PIN + "'");

            while (rs.next()) {//re.next acts like just the ittration where it locates to the nxt row

                if (rs.getString("type").equals("Deposite")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        JLabel text = new JLabel("Account balance is \nRs " +bal);
        text.setForeground(Color.WHITE);
        text.setBounds(200,350,400,60);
        text.setFont(new Font("System" , Font.BOLD, 16));
        image.add(text);

        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);




        //        ---------Frame Setup---------------------------------------------------------------------------------------------------------------
        setSize(900, 900);
        setLocation(300, 100);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(PIN).setVisible(true);



    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
