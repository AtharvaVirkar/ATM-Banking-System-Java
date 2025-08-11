package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {


    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login, clear, signUp;

    public Login() {
        setLayout(null);
        setSize(800, 580);
        setVisible(true);
        setLocation(500, 200);

        setTitle("Automated Teller Machine".toUpperCase());

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image I2 = I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(70, 10, 100, 100);
        add(label);


        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 35);
        add(text);

        JLabel cardNo = new JLabel("Card No: ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 35);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 35);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 35);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 35);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("Login".toUpperCase());
        login.setBounds(300, 300, 100, 35);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        clear = new JButton("Clear".toUpperCase());
        clear.setBounds(450, 300, 100, 35);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


        signUp = new JButton("Sign Up".toUpperCase());
        signUp.setBounds(300, 370, 250, 35);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login) {
            Conn conn = new Conn();

            String cNumber = cardTextField.getText();
            String pNumber = pinTextField.getText();

            String query = "select * from login where CARDNUMBER = '" + cNumber + "' and pin = '" + pNumber + "'";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next())// rs.next() is empty == false
                                // Meaning: No user found with that card number & pin
                {
                    setVisible((false));
                    new Transactions(pNumber ).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } else if (ae.getSource() == signUp) {

            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
