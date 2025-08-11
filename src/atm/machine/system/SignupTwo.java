package atm.machine.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JComboBox religion, category , income, education, occupation;
    JTextField panText, aadharText ;
    JButton next;
    JRadioButton sYes, sNo , eYes , eNo;
    String formNo;

    SignupTwo(String formNo) {

        this.formNo = formNo;

        setLayout(null);

        setSize(850, 1000);
        setLocation(300, 100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
//    --------------------------------------------------------------------------------------------------

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails =  new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,90,300,30);
        add(additionalDetails);

        JLabel religionLable = new JLabel("Religion:");
        religionLable.setBounds(100,150,100, 30);
        religionLable.setFont(new Font("Raleway",Font.BOLD, 20));
        add(religionLable);

        String valReligion[] = {"Hindu","Muslim","Cristian","Sikh","Other"};
        religion = new JComboBox(valReligion); // creates an Drop down
        religion.setFont(new Font("Raleway", Font.BOLD, 15));
        religion.setBackground(Color.white);
        religion.setBounds(300,150,400,30);
        add(religion);

        JLabel cate = new JLabel("Categroy:");
        cate.setFont(new Font("Raleway", Font.BOLD, 20));
        cate.setBounds(100, 222, 150, 30);
        add(cate);


        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Raleway", Font.BOLD, 15));
        category.setBackground(Color.white);
        category.setBounds(300, 222, 400, 30);
        add(category);


        JLabel incomeLable = new JLabel("Income:");
        incomeLable.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLable.setBounds(100, 294, 150, 30);
        add(incomeLable);

        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Raleway", Font.BOLD, 15));
        income.setBounds(300, 294, 400, 30);
        income.setBackground(Color.white);
        add(income);


        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 366, 150, 30);
        add(edu);

        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(100, 395, 150, 30);
        add(Qualification);

        String valEducation[] = {"Non-Graduation","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(valEducation);
        education.setFont(new Font("Raleway", Font.BOLD, 15));
        education.setBounds(300, 378, 400, 30);
        education.setBackground(Color.white);
        add(education);


        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 480, 150, 30);
        add(occ);

        String valOccupation[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setFont(new Font("Raleway", Font.BOLD, 15));
        occupation.setBounds(300, 480, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);


        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 565, 150, 30);
        add(pan);


        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        panText.setBounds(300, 565, 400, 30);
        add(panText);


        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 654, 180, 30);
        add(aadhar);


        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharText.setBounds(300, 654, 400, 30);
        add(aadharText);


        JLabel sCitizen = new JLabel("Senior Citizen:");
        sCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        sCitizen.setBounds(100, 726, 150, 30);
        add(sCitizen);

        sYes = new JRadioButton("YES");
        sYes.setBounds(300, 726, 120, 30);
        sYes.setFont(new Font("Raleway", Font.BOLD, 15));
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("NO");
        sNo.setBounds(470, 726, 120, 30);
        sNo.setFont(new Font("Raleway", Font.BOLD, 15));
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup sCitizenGroup = new ButtonGroup();
        sCitizenGroup.add(sYes);
        sCitizenGroup.add(sNo);



        JLabel extAccount = new JLabel("Exisiting Account:");
        extAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        extAccount.setBounds(100, 798, 180, 30);
        add(extAccount);

        eYes = new JRadioButton("YES");
        eYes.setBounds(300, 798, 120, 30);
        eYes.setFont(new Font("Raleway", Font.BOLD, 15));
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("NO");
        eNo.setBounds(470, 798, 120, 30);
        eNo.setFont(new Font("Raleway", Font.BOLD, 15));
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup extAccountGroup = new ButtonGroup();
        extAccountGroup.add(eYes);
        extAccountGroup.add(eNo);




        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 870, 100, 30);
        add(next);
        next.addActionListener(this);




    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//------------------------------------------JComboBox Taking Input -----------------------------------------------------------------------------
        // .getSelectedItem() returns obj of selected option so for that we are typecasting it to string
        String sReligion = (String) religion.getSelectedItem();
        String sCategory = (String) category.getSelectedItem() ;
        String sIncome = (String) income.getSelectedItem();
        String sEducation = (String) education.getSelectedItem();
        String sOccupation  = (String) occupation.getSelectedItem();
//------------------------------------------JRadio Button Taking Input------------------------------------------------------------------------------
        String sSeniorCitizen = null;
        if(sYes.isSelected())
        {
            sSeniorCitizen = "Yes";
        } else if ( sNo.isSelected()) {
            sSeniorCitizen = "No";
        }

        String sExixtingAccount = null;
        if(eYes.isSelected())
        {
            sExixtingAccount = "Yes";
        } else if ( eNo.isSelected()) {
            sExixtingAccount = "No";
        }

//     ------------------------------------------JTextField Taking Input-------------------------------------------------------------------------

        String sPan =  panText.getText();
        String sAadhar =  aadharText.getText();

        try {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES ('" + formNo + "', '" + sReligion + "', '" + sCategory + "', '" + sIncome + "', '" + sEducation + "', '" + sOccupation + "', '" + sPan + "', '" + sAadhar + "', '" + sSeniorCitizen + "', '" + sExixtingAccount + "')";

//                It will make the query like this
//            INSERT INTO signup VALUES ('1234', 'ABC', 'HIJ', '05-08-2004', 'Male', 'ava@gmail.com', 'Unmarried', 'Add', 'City', 'State', 'pincode');

                c.s.executeUpdate(query);

//                we will link signup page 3 here

            setVisible(false);
            new SignupThree(formNo);


        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        new SignupTwo("");
    }
}
