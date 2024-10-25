import Plan.*;
import Plan.ObligatoryRisk;
import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class Main extends JFrame {
    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField subFName,subLName,subCity,subPhone;

    // Panel 2
    JTextField model,manufacture,plateNb,estimated;
    JRadioButton damageRadio1, damageRadio2, damageRadio3,damageRadio4;
    ButtonGroup G1;

    // Panel 3
    JCheckBox obligatoryCHKBX,allRiskCHKBX, vDamageCHKBX, dDamageCHKBX, assisCHKBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRiskList = new ArrayList<>();

    // Panel 4
    JRadioButton yearRadio, yearRadio2, yearRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validateYear=0;
    SimpleDateFormat df;
    Date currentDate;

    // Panel 5
    JButton saveBTN, loadBTN, newBTN, showBTN;
    JTextField searchText;
    JLabel spacer3,spacer4,spacer5,spacer6;

    // Panel 6
    JTextArea risksTXT;
    JTextField searchTXT;
    Map<Integer, Customer> customerMap = new TreeMap<>();

    // Panel 7
    JTextArea policyTXT;

    // Panel 8
    JTextArea customerTXT;

    // Panel 9
    JLabel claimingTXT, claimingTXT2;
    JTextField claimingCustomerField;

    // Panel 10
    JLabel claimingCustomerNameLBL,claimStatusLBL2,claimingCustomerValidDateLBL;
    JTextArea claimingCustomerRisksCoveredAREA;
    boolean cond1,cond2,cond3;

    // Panel 11
    JTextArea settlementArea;
    float totalPremium = 0f, totalCoverage = 0f, totalCeiling = 0f;

    // Panel 12
    JTextArea settlementArea2;

    // Constructor
    public Main(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
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

        p1.setBounds(15,15,300,200);
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
        p2.setBounds(15,230,300,400);
        p2.setLayout(new GridLayout(13,1));
        add(p2);
    }

    private void CustomizePanel3(){
        JPanel p3 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Plan", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL = new JLabel("Select your Plan");

        // Checkbox
        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risk");
        vDamageCHKBX = new JCheckBox("Vehicle Damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assisCHKBX = new JCheckBox("Assistance");

        // get all risks covered by plan
        GetRisksCoveredByPlan();

        // add component to p3
        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assisCHKBX);

        add(p3);
    }

    private void CustomizePanel4(){
        JPanel p4 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Validity Period", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p4.setBorder(titledBorder);
        p4.setBounds(330,230,300,200);
        p4.setLayout(new GridLayout(5,1));

        // Radio Button
        JLabel spacer2 = new JLabel(" ");
        spacer2.setOpaque(false);
        yearRadio = new JRadioButton();
        yearRadio.setText("1 Year");
        yearRadio2 = new JRadioButton();
        yearRadio2.setText("2 Year");
        yearRadio3 = new JRadioButton();
        yearRadio3.setText("3 Year");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateYear=1;
            }
        });

        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateYear=2;
            }
        });

        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateYear=3;
            }
        });

        // Button Group
        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearRadio2);
        G2.add(yearRadio3);

        // Time and Date
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/YYYY");
        currentDate = new Date();
        todayLBL.setText("Today: " +df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont(font.deriveFont(size));

        // adding component to p4
        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);

        // adding p4 to frame
        add(p4);
    }

    private void CustomizePanel5(){
        JPanel p5 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Actions", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p5.setBorder(titledBorder);
        p5.setBounds(330,450,300,230);
        p5.setLayout(new GridLayout(7,1));

        saveBTN = new JButton("Save Customer");
        showBTN = new JButton("Show Plan Details");
        loadBTN = new JButton("Load Customer");
        newBTN = new JButton("New Customer");

        searchText = new JTextField("Enter Car Plate No");
        searchText.setOpaque(false);

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add here the code be executed
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add here the code be executed
            }
        });

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add here the code be executed
            }
        });

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add here the code be executed
            }
        });

        spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

        spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);

        spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);

        spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchText);
        p5.add(loadBTN);
        p5.add(spacer6);

        add(p5);
    }

    private void CustomizePanel6(){
        JPanel p6 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Covered Risks", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p6.setBorder(titledBorder);
        p6.setBounds(645,15,300,200);

        risksTXT = new JTextArea(7,1);
        risksTXT.setEditable(false);
        risksTXT.setOpaque(false);
        risksTXT.setLineWrap(true);

        // Font
        Font font = risksTXT.getFont();
        float size = font.getSize() + 3.0f;
        risksTXT.setFont(font.deriveFont(size));

        p6.add(risksTXT);
        p6.setLayout(new GridLayout(1,1));
        add(p6);
    }

    private void CustomizePanel7(){
        JPanel p7 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Policy Details", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p7.setBorder(titledBorder);
        p7.setBounds(645,230,300,250);
        p7.setLayout(new GridLayout(6,1));

        policyTXT = new JTextArea(20,1);
        policyTXT.setEditable(false);
        policyTXT.setOpaque(false);
        policyTXT.setLineWrap(true);

        Font font = policyTXT.getFont();
        float size = font.getSize()+3.0f;
        policyTXT.setFont(font.deriveFont(size));

        p7.add(policyTXT);
        p7.setLayout(new GridLayout(1,1));
        add(p7);
    }

    private void CustomizePanel8(){
        JPanel p8 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "Customer Details", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p8.setBorder(titledBorder);
        p8.setBounds(645,500,300,200);
        p8.setLayout(new GridLayout(6,1));

        customerTXT = new JTextArea(20,1);
        customerTXT.setEditable(false);
        customerTXT.setOpaque(false);
        customerTXT.setLineWrap(true);

        Font font = customerTXT.getFont();
        float size = font.getSize()+3.0f;
        customerTXT.setFont(font.deriveFont(size));

        p8.add(customerTXT);
        p8.setLayout(new GridLayout(1,1));
        add(p8);
    }

    private void CustomizePanel9() {
        // Main Panel with Titled Border
        JPanel p9 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray, 1),
                "Claims", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont, myColor);
        p9.setBorder(titledBorder);
        p9.setLayout(new BoxLayout(p9, BoxLayout.Y_AXIS)); // Vertical layout for panel
        p9.setBounds(960, 15, 300, 485);

        // Label: Instruction for plate number input
        claimingTXT = new JLabel("Enter plate no. for the claiming:");
        claimingTXT.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align

        // TextField: For customer input
        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250, 30));
        claimingCustomerField.setMaximumSize(claimingCustomerField.getPreferredSize()); // Prevent stretching

        // Button: Search Customer
        JButton searchClaimer = new JButton("Search Customer");
        searchClaimer.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Spacer between sections
        JLabel spacer9 = new JLabel(" ");
        spacer9.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label: Instruction for damage selection
        claimingTXT2 = new JLabel("Select the type of Damage or Asset:");
        claimingTXT2.setAlignmentX(Component.CENTER_ALIGNMENT);

        // JList: For damage or asset selection
        String[] items = {
                "Fire", "Robbery", "Third Party Damage",
                "Vehicle Damage", "Driver Damage",
                "Transport", "Car Replacement"
        };
        JList<String> claimList = new JList<>(items);
        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        claimList.setPreferredSize(new Dimension(250, 150));
        claimList.setMaximumSize(claimList.getPreferredSize()); // Prevent stretching
        JScrollPane claimListScroll = new JScrollPane(claimList); // Add scroll for better UX

        // Button: Confirm Claim
        JButton confirmClaimBTN = new JButton("Confirm Claim");
        confirmClaimBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add Components to Main Panel (p9)
        p9.add(Box.createVerticalStrut(10));  // Spacer at the top
        p9.add(claimingTXT);
        p9.add(Box.createVerticalStrut(5));  // Small spacer
        p9.add(claimingCustomerField);
        p9.add(Box.createVerticalStrut(10));  // Spacer between sections
        p9.add(searchClaimer);
        p9.add(Box.createVerticalStrut(20));  // Larger spacer
        p9.add(claimingTXT2);
        p9.add(Box.createVerticalStrut(5));  // Small spacer
        p9.add(claimListScroll);  // Add the list with scroll pane
        p9.add(Box.createVerticalStrut(20));  // Spacer before the button
        p9.add(confirmClaimBTN);
        p9.add(Box.createVerticalStrut(10));  // Spacer at the bottom

        // Add Panel to JFrame
        setLayout(null);  // Use absolute layout for JFrame
        add(p9);
    }

    private void CustomizePanel10(){
        JPanel p10 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray, 1),
                "Claim Status", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont, myColor);
        p10.setBorder(titledBorder);
        p10.setBounds(960,520,300,230);
        p10.setLayout(new GridLayout(4,1));

        claimingCustomerNameLBL = new JLabel("Claiming Customer");
        claimingCustomerValidDateLBL = new JLabel("Date Validity of Policy");
        claimStatusLBL2 = new JLabel("Claiming Status");

        claimingCustomerRisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredAREA);
        claimingCustomerRisksCoveredAREA.setOpaque(false);

        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLBL2);

        add(p10);

    }

    private void CustomizePanel11(){
        JPanel p11 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray, 1),
                "Payment", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont, myColor);
        p11.setBorder(titledBorder);
        p11.setBounds(1275,15,250,230);
        p11.setLayout(new GridLayout(2,1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        Font font = settlementArea.getFont();
        float size = font.getSize()+4.0f;
        settlementArea.setFont(font.deriveFont(size));

        p11.add(settlementArea);
        add(p11);
    }

    private void CustomizePanel12(){
        JPanel p12 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray, 1),
                "Settlement", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont, myColor);
        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);

        p12.add(settlementArea2);

        Font font = settlementArea2.getFont();
        float size = font.getSize()+4.0f;
        settlementArea2.setFont(font.deriveFont(size));

        p12.add(settlementArea);
        add(p12);

    }



    private void GetRisksCoveredByPlan(){
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
        allRiskCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dDamageCHKBX.setEnabled(false);
                vDamageCHKBX.setEnabled(false);
                assisCHKBX.setEnabled(false);
                obligatoryCHKBX.setEnabled(false);

                coveredRisksList.addAll(Arrays.asList(allRisk.allRisksCovered));
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRiskList.add(allRisk.getCeiling());
            }
        });

        obligatoryCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
                premiumRisksList.add(obligatoryRisk.getPremium());
                coverageRisksList.add(obligatoryRisk.getCoverage());
                ceilingRiskList.add(obligatoryRisk.getCeiling());
            }
        });

        vDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRisk vehicleRisk = new VehicleRisk();
                coveredRisksList.add(vehicleRisk.vehicleRisksCovered[0]);
                premiumRisksList.add(vehicleRisk.getPremium());
                coverageRisksList.add(vehicleRisk.getCoverage());
                ceilingRiskList.add(vehicleRisk.getCeiling());
            }
        });

        dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk = new DriverRisk();
                coveredRisksList.add(driverRisk.driverRisksCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
                coverageRisksList.add(driverRisk.getCoverage());
                ceilingRiskList.add(driverRisk.getCeiling());
            }
        });

        assisCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistanceRisk assistanceRisk = new AssistanceRisk();
                coveredRisksList.addAll(Arrays.asList(assistanceRisk.assistanceRisksCovered));
                premiumRisksList.add(assistanceRisk.getPremium());
                coverageRisksList.add(assistanceRisk.getCoverage());
                ceilingRiskList.add(assistanceRisk.getCeiling());
            }
        });
    }

    public Customer GetCustomerData() {
        try {
            // Retrieve customer data from text fields
            String firstName = subFName.getText();
            String lastName = subLName.getText();
            String city = subCity.getText();
            int phone = Integer.parseInt(subPhone.getText());  // May throw NumberFormatException

            // Create and return a Customer object
            return new Customer(firstName, lastName, city, phone, GetPolicyData());
        } catch (NumberFormatException e) {
            // Handle invalid phone number input
            JOptionPane.showMessageDialog(null,
                    "Invalid phone number. Please enter a valid number.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;  // Return null if input is invalid
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Policy GetPolicyData() throws ParseException{
        currentDate = new Date();

        LocalDate now = LocalDate.now();
        Policy policy = new Policy(
                GetVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRiskList,
                validateYear,
                now
        );
        return policy;
    };

    public Vehicle GetVehicleData() throws ParseException{
        return new Vehicle(Integer.parseInt(plateNb.getText()),
                Integer.parseInt(model.getText()),
                manufacture.getText(),
                Integer.parseInt(estimated.getText()),
        GetDamageState()
        );
    }

    public int GetDamageState(){
    if(damageRadio1.isSelected()){
        return 1;
    } else if (damageRadio2.isSelected()) {
       return 2;
    } else if (damageRadio3.isSelected()) {
      return 3;
    }else if(damageRadio4.isSelected()){
       return 4;
    }else {
        return 0;
    }
    }

    private void NewCustomer(){
        coverageRisksList.clear();
        coveredRisksList.clear();
        premiumRisksList.clear();
        ceilingRiskList.clear();
        cond1 = false;
        cond2 = false;
        cond3 = false;

        subLName.setText("");
        subLName.setText("");
        subPhone.setText("");
        subCity.setText("");

        plateNb.setText("");
        model.setText("");
        manufacture.setText("");
        estimated.setText("");

        G1.clearSelection();
        G2.clearSelection();

        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        assisCHKBX.setSelected(false);

        obligatoryCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        dDamageCHKBX.setEnabled(true);
        assisCHKBX.setEnabled(true);


    }

    public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException {
        File file = new File("D:/myfile.date");
        int platenum = Integer.parseInt(plateNb.getText());
        if(!file.exists()){
            System.out.println("Not Exists");
            file.createNewFile();
            SaveCustomerMapToNewFile(platenum,file);
        }
        else {
             TreeMap<Integer,Customer> newMapToSave = new TreeMap<>();
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer,Customer>) ois.readObject();
            ois.close();
            is.close();

            newMapToSave.putAll(mapInFile);

            newMapToSave.put(platenum,GetCustomerData());

            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMapToSave);
            oos.flush();
            oos.close();
        }
    }

    private void SaveCustomerMapToNewFile(int platenum, File file) throws IOException {
        TreeMap<Integer,Customer> newMaptoSave = new TreeMap<Integer, Customer>();

        newMaptoSave.put(platenum,GetCustomerData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }

    private void SearchCustomerByMobileNo(){
        File file = new File("D:/myfile.dat");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            TreeMap<Integer,Customer> mapInFile =  (TreeMap<Integer, Customer>)ois.readObject();
            ois.close();
            is.close();

            Customer c_finded = mapInFile.get(Integer.parseInt(searchText.getText()));
            customerTXT.setText(c_finded.toString());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Customer ClaimsSearchCustomerByMobileNo(){
        Customer customer = new Customer();
        File file = new File("D:/myfile.dat");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer, Customer>)ois.readObject();
            ois.close();
            is.close();

            customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setTitle("Insurance Company System");
        main.setBounds(0,0,1920,1080);
    }
}