package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber;
    JTextField rPIN;
    JPasswordField PIN;
    JButton change, back;

    public PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
//        ---------BG Image Setup---------------------------------------------------------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        //  ---------Labels Setup----------------------------------------------------------------------------------------

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(250, 280, 500, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165, 320, 180, 25);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        PIN = new JPasswordField();
        PIN.setFont(new Font("Raleway", Font.BOLD, 25));
        PIN.setBounds(330, 320, 180, 25);
        image.add(PIN);

        JLabel rePin = new JLabel("RE-ENTER NEW PIN");
        rePin.setForeground(Color.WHITE);
        rePin.setBounds(165, 360, 180, 25);
        rePin.setFont(new Font("System", Font.BOLD, 16));
        image.add(rePin);

        rPIN = new JTextField();
        rPIN.setFont(new Font("Raleway", Font.BOLD, 25));
        rPIN.setBounds(330, 360, 180, 25);
        image.add(rPIN);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("CHANGE");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


//        ---------Frame Setup---------------------------------------------------------------------------------------------------------------
        setSize(900, 900);
        setLocation(300, 100);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String pin = PIN.getText();
                String rpin = rPIN.getText();

                if (!pin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "!!!! PIN DOES NOT MATCH !!!!");
                    return;
                }
                if (pin.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "!!!! NEW PIN / RE-ENTER PIN IS EMPTY !!!!");
                    return;
                }
                Conn c = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinNumber + "';";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinNumber + "';";
                String query3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pinNumber + "';";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "### SUCCESSFULLY PIN CHANGED ###");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);

        }


    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}



