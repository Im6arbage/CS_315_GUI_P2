import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class FinanceCalculator extends JFrame {
    
    
    
    private JTextField name;
    private JLabel clientname;
    private JLabel whatpercent;
    private JLabel testblank;
    private JLabel grossincome;
    private JTextField gross;
    private JLabel expenses;
    private JLabel inputstyle;

    private JTextField gasex;
    private JTextField foodex;
    private JTextField billsex;
    private JTextField entex;
    
    private JLabel gas;
    private JLabel food;
    private JLabel bills;
    private JLabel entertainment;
    
    private JRadioButton tenpercent;
    private JRadioButton fifteenpercent;
    private JRadioButton twentypercent;
    
    ButtonGroup group;
    
    private JButton submit;
    
    ImageIcon icon;
    JLabel iconlabel;

    
    static String ten = "10%";
    static String fifteen = "15%";
    static String twenty = "20%";
    
    
    public FinanceCalculator()
    {
        super("Herrbrum Financial Calculator");
        setResizable(false);

        
        Border purpline, raisedetched;
        purpline = BorderFactory.createLineBorder(Color.MAGENTA);
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        
        JPanel p1 = new JPanel();
        p1.setBorder(raisedetched);

        
        JPanel p1a = new JPanel();
        p1a.add(clientname = new JLabel("Client Name: "));
        name = new JTextField(20);
        name.setText("ex: Marion Morrison");
        p1a.add(name);
        
        
        JPanel p1b = new JPanel();
        p1b.setLayout(new GridLayout(3,0));
        
        JPanel p1ba = new JPanel();
        p1ba.setLayout(new GridLayout(1,0));
        
        p1b.add(whatpercent = new JLabel("What % of your income would you like to save?"));
       
        group = new ButtonGroup();
        
        tenpercent = new JRadioButton(ten);
        group.add(tenpercent);
        p1ba.add(tenpercent);
       
        fifteenpercent = new JRadioButton(fifteen);
        group.add(fifteenpercent);
        p1ba.add(fifteenpercent);
       
        twentypercent = new JRadioButton(twenty);
        group.add(twentypercent);
        p1ba.add(twentypercent);
        
        icon = new ImageIcon("/Users/codyherring/Downloads/money_icon.png");
        
        iconlabel = new JLabel(icon);
 
        p1b.add(p1ba);
        p1b.add(iconlabel);

        
        
        p1.add(p1a);
        p1.add(p1b);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1));
        p2.setBorder(purpline);
        
        JPanel p2a = new JPanel();
        
        JPanel p2b = new JPanel();
        p2b.setLayout(new GridLayout(3,1));
        
        
        
        p2a.add(grossincome = new JLabel("Gross Income (Monthly): "));
        gross = new JTextField(10);
        gross.setText("ex: 10000.00");
        p2a.add(gross);
        
        JPanel p2ba = new JPanel();
        
        JPanel p2bb = new JPanel();
        JPanel p2bc = new JPanel();
        
        p2ba.add(expenses = new JLabel("EXPENSES:"));
        
        p2bb.add(bills = new JLabel("Bills: "));
        billsex = new JTextField(6);
        billsex.setText("ex: 200.00");
        p2bb.add(billsex);
        p2bb.add(gas = new JLabel("Gas: "));
        gasex = new JTextField(6);
        gasex.setText("ex: 200.00");
        p2bb.add(gasex);
        p2bb.add(food = new JLabel("Food: "));
        foodex = new JTextField(6);
        foodex.setText("ex: 200.00");
        p2bb.add(foodex);
        p2bb.add(entertainment = new JLabel("Entertainment: "));
        entex = new JTextField(6);
        entex.setText("ex: 200.00");
        p2bb.add(entex);
        
        
        
        submit = new JButton("Submit");
        submit.setSize(50,50);
        p2bc.add(submit);
        p2b.add(p2ba);
        p2b.add(p2bb);
        p2b.add(p2bc);
        
        p2.add(p2a);
        p2.add(p2b);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        
        panel.add(p1, BorderLayout.NORTH);
        panel.add(p2, BorderLayout.SOUTH);
        
        

        add(panel);
        

        
    }

    public static void main(String[] args)
    {

    FinanceCalculator fcalc = new FinanceCalculator();
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dim = toolkit.getScreenSize();
    
    fcalc.setPreferredSize(new Dimension(600, 625));
    fcalc.setBounds(200,200,dim.width-100,dim.height-100);
    fcalc.setBackground(Color.ORANGE);
    fcalc.setLocationRelativeTo(null);
    fcalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fcalc.setVisible(true);
    fcalc.pack();

    }






}