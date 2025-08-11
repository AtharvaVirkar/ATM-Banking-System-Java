package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String PIN;

    Withdrawl(String PIN) {
        this.PIN = PIN;
        setLayout(null);


//        --------ATM BG setup--------------------------------------------------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

//-----------------Deposite functionalities---------------------------------------------------------------------------------------------------------------

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


//---------------------Frame Setup------------------------------------------------------------------------------------------------------------

        setSize(900, 900);
        setLocation(300, 100);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
            } else {

                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + PIN + "'");
                    int bal = 0;
                    while (rs.next()) {//re.next acts like just the ittration where it locates to the nxt row

                        if (rs.getString("type").equals("Deposite")) {
                            bal += Integer.parseInt(rs.getString("amount"));
                        } else {
                            bal -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != back && bal < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "! ! ! NOT SUFFICIENT BALANCE ! ! !\nYour current balance is "+bal);
                        return;
                    }
//                    Date date = new Date();
                    String query = "insert into bank values ('" + PIN + "' , '" + date + "' , 'WithDrawl', '" + number + "');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Sucessfully");

                    setVisible(false);
                    new Transactions(PIN).setVisible(true);
//                Conn conn = new Conn();
//                String query = "insert into bank values ('" + PIN + "', '" + date + "','Withdrawl','" + number + "')";
//
//                try {
//                    conn.s.executeUpdate(query);
//                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Successfully");
//                    setVisible(false);
//                    new Transactions(PIN).setVisible(true);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }

                } catch (Exception e) {
//                    System.out.println(e);
//                }
                }


            }
        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(PIN).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
