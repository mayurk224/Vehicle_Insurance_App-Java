import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Main extends JFrame {
    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField subFName,subLName,subCity,subPhone;

    // Panel 2
    JTextField model,manufacture,plateNb,estimated;
    JRadioButton damageRadio1, damageRadio2, damageRadio3,damageRadio4;
    ButtonGroup G1;

    // Constructor
    public Main(){
        CustomizePanel1();
        CustomizePanel2();
    }

    private void CustomizePanel1(){
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Customer", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p1.setBorder(titledBorder);

        JLabel fNameLBL = new JLabel("First Name");
        JLabel lNameLBL = new JLabel("Last Name");
        JLabel CityLBL = new JLabel("City");
        JLabel phoneLBL = new JLabel("Phone");

        subFName = new JTextField();    subFName.setOpaque(false);
        subLName = new JTextField();    subLName.setOpaque(false);
        subCity = new JTextField();     subCity.setOpaque(false);
        subPhone = new JTextField();    subPhone.setOpaque(false);

        p1.add(fNameLBL);   p1.add(subFName);
        p1.add(lNameLBL);   p1.add(subLName);
        p1.add(CityLBL);    p1.add(subCity);
        p1.add(phoneLBL);   p1.add(subPhone);

        p1.setBounds(15,15,300,180);
        p1.setLayout(new GridLayout(4,1));

        // Adding panel to jframe
        setLayout(null);
        add(p1);
    }


    private void CustomizePanel2(){
        JPanel p2 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Vehicle", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p2.setBorder(titledBorder);

        // Jlabel
        JLabel plateNbLBL = new JLabel("Plate Nb");
        JLabel modelLBL = new JLabel("Model Year");
        JLabel manufactureLBL = new JLabel("Manufacture");
        JLabel estimatedLBL = new JLabel("Estimated Value");
        JLabel damageLBL = new JLabel("Major Damage");

        // Jtextfields
        plateNb = new JTextField();      plateNb.setOpaque(false);
        model = new JTextField();        model.setOpaque(false);
        manufacture = new JTextField();  manufacture.setOpaque(false);
        estimated = new JTextField();    estimated.setOpaque(false);

        // Jradiobutton
        damageRadio1 = new JRadioButton();  damageRadio1.setText("Motor");
        damageRadio2 = new JRadioButton();  damageRadio2.setText("Wheel");
        damageRadio3 = new JRadioButton();  damageRadio3.setText("Body");
        damageRadio4 = new JRadioButton();  damageRadio4.setText("None");

        G1 = new ButtonGroup();
        G1.add(damageRadio1);
        G1.add(damageRadio2);
        G1.add(damageRadio3);
        G1.add(damageRadio4);

        // Adding component to p2
        p2.add(plateNbLBL);       p2.add(plateNb);
        p2.add(modelLBL);         p2.add(model);
        p2.add(manufactureLBL);   p2.add(manufacture);
        p2.add(estimatedLBL);     p2.add(estimated);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);

        // customize p2
        p2.setBounds(15,210,300,400);
        p2.setLayout(new GridLayout(13,1));
        add(p2);
    }





    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setTitle("Insurance Company System");
        main.setBounds(0,0,1920,1080);
    }
}