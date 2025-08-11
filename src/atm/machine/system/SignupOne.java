package atm.machine.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    JButton next;
    JTextField nameText, fatherNameText, emailText, addressText, cityText, pinCodeText, stateText;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;
    int randomApplicationNumber;

    SignupOne() {
//        removing the byDefault border layout
        setLayout(null);

//        Frame setup
        setSize(850, 1000);
        setLocation(300, 100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

//        Frame Label with random application number
        Random ran = new Random();
        randomApplicationNumber = ran.nextInt(9000) + 1000; // generates random number between 1000 - 9999

        JLabel formno = new JLabel("Application Form No. ".toUpperCase() + randomApplicationNumber);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

//        Personal Details Label

        JLabel personalDerails = new JLabel("Page 1: Personal Details");
        personalDerails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDerails.setBounds(290, 90, 300, 30);
        add(personalDerails);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 150, 100, 30);
        add(name);


        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 150, 400, 30);
        add(nameText);


        JLabel fatherName = new JLabel("Fathers Name:");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherName.setBounds(100, 222, 150, 30);
        add(fatherName);


        fatherNameText = new JTextField();
        fatherNameText.setFont(new Font("Raleway", Font.BOLD, 14));
        fatherNameText.setBounds(300, 222, 400, 30);
        add(fatherNameText);


        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 294, 150, 30);
        add(dob);


        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 294, 400, 30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 366, 150, 30);
        add(gender);


        male = new JRadioButton("Male");
        male.setBounds(300, 366, 60, 30);
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(470, 366, 120, 30);
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 438, 150, 30);
        add(email);


        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 438, 400, 30);
        add(emailText);


        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 510, 150, 30);
        add(maritalStatus);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(300, 510, 120, 30);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        married = new JRadioButton("Married");
        married.setBounds(470, 510, 120, 30);
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        married.setBackground(Color.WHITE);
        add(married);

        other = new JRadioButton("Other");
        other.setBounds(630, 510, 120, 30);
        other.setFont(new Font("Raleway", Font.BOLD, 15));
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup MaritalStatusGroup = new ButtonGroup();
        MaritalStatusGroup.add(unmarried);
        MaritalStatusGroup.add(married);
        MaritalStatusGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 582, 150, 30);
        add(address);


        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(300, 582, 400, 30);
        add(addressText);


        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 654, 150, 30);
        add(city);


        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 654, 400, 30);
        add(cityText);


        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 726, 150, 30);
        add(pinCode);


        pinCodeText = new JTextField();
        pinCodeText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCodeText.setBounds(300, 726, 400, 30);
        add(pinCodeText);


        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 798, 150, 30);
        add(state);


        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 798, 400, 30);
        add(stateText);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 870, 100, 30);
        add(next);
        next.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String formNo = "" + randomApplicationNumber;


//        ----------------------------------Normal Text-----------------------------------------------------------
        String name = nameText.getText();
        String fatherName = fatherNameText.getText();
        String email = emailText.getText();
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinCodeText.getText();


//        --------------------------------------------Date----------------------------------------------------------


        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        /*
        we can write this code too for getting the date toh but in yt the above is used thats why m using that

        Date date  = dateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dob = sdf.format(date);
    */

//        --------------------------------Radio Button----------------------------------------------------------
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

//        -----------------------------------------Due to DB- to avoid run time error we weill use exception handleing
//        -----------------------------------------As well as we will write some blocs for empty inputs

        try {
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (fatherName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            } else if (dob.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            } else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } else if (email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Marital Status is Required");
            } else if (address.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            } else if (city.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } else if (state.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "State is Required");
            } else if (pin.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pin Code is Required");
            }
            else
            {
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES ('" + formNo + "', '" + name + "', '" + fatherName + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";

//                It will make the query like this
//            INSERT INTO signup VALUES ('1234', 'ABC', 'HIJ', '05-08-2004', 'Male', 'ava@gmail.com', 'Unmarried', 'Add', 'City', 'State', 'pincode');

                c.s.executeUpdate(query);

//                linking signup Page two
                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }


    public static void main(String[] args) {
        SignupOne signupOne = new SignupOne();
    }


}
