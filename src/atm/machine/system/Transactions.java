package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposite, withdraw, fastCash, miniStatement, pinChange, balEnquiry, exit;
    String PIN;

    Transactions(String PIN) {
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

        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        text.setBounds(210, 300, 700, 35);
        image.add(text);

//------------Creating Buttons so that we can display on the ATM Machine and access the functionalities-----------------------------------------------------------------------------------------------------------

//-----------------Functionalities -> Buttons-------------------------------------------------------------------------------------

        deposite = new JButton("Deposite");
        deposite.setBounds(165, 417, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350, 417, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(165, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("mini Statement");
        miniStatement.setBounds(350, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);


        pinChange = new JButton("PIN Chnage");
        pinChange.setBounds(165, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);


        balEnquiry = new JButton("Balance Enquiry");
        balEnquiry.setBounds(350, 485, 150, 30);
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);

        exit = new JButton("EXIT");
        exit.setBounds(350, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);


        setUndecorated(true);
        setVisible(true); // should always be written at the end of constructor
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposite) {
            setVisible(false);
            new Deposite(PIN).setVisible(true);

        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(PIN).setVisible(true);

        } else if (ae.getSource() == fastCash) {
            setVisible(false);

            new FastCash(PIN).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(PIN).setVisible(true);

        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(PIN).setVisible(true);

        } else if (ae.getSource() == balEnquiry) {
            setVisible(false);
            new BalanceEnquiry(PIN).setVisible(true);

        } else if (ae.getSource() == exit) {
            // setVisible(false);     // hides current window
            System.exit(0);           // closes whole app

        }

    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
