import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Main extends JFrame {
    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField subFName,subLName,subCity,subPhone;

    // Constructor
    public Main(){
        CustomizePanel1();
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

        p1.setBounds(15,15,300,300);
        p1.setLayout(new GridLayout(4,2));

        // Adding panel to jframe
        setLayout(null);
        add(p1);

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setTitle("Insurance Company System");
        main.setBounds(0,0,1920,1080);
    }
}