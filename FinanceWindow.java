import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
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
import java.awt.Graphics;


public class FinanceWindow extends JFrame implements ActionListener{
	
	ClientManager clientmanager = new ClientManager();
	
	JTabbedPane m_tabbedPane;
	ArrayList<JPanel> m_panels = new ArrayList<JPanel>();
	JButton m_tabbutton = new JButton("Add Client");
	JButton m_closebutton = new JButton("Close");
	
	JMenuBar m_menubar = new JMenuBar();
	JMenu m_fileMenu;
	JMenuItem m_newClient;
	JMenuItem m_saveClientList;
	JMenuItem m_loadClientList;
	JMenuItem m_exit;
	
	private JTextField name;
	
	private JPanel panel;

	private JLabel clientname; //ADDED ****
	private JLabel whatpercent; //ADDED ****
	private JLabel testblank; //ADDED ****
	private JLabel grossincome; //ADDED ****
	private JTextField gross; //ADDED ****
	private JLabel expenses; //ADDED ****
	private JLabel inputstyle; //ADDED ****
    
	private JTextField gasex; //ADDED ****
	private JTextField foodex; //ADDED ****
	private JTextField billsex; //ADDED ****
	private JTextField entex; //ADDED ****
	
	private JLabel gas; //ADDED ****
	private JLabel food; //ADDED ****
	private JLabel bills; //ADDED ****
	private JLabel entertainment; //ADDED ****
	
	private JRadioButton tenpercent; //ADDED ****
	private JRadioButton fifteenpercent; //ADDED ****
	private JRadioButton twentypercent; //ADDED ****
	
	ButtonGroup group; //ADDED ****
	
	private JButton submit; //ADDED ****
	
	ImageIcon icon; //ADDED ****
	JLabel iconlabel; //ADDED ****
	
	ImageIcon starticon;

    
	static String ten = "10%";	//ADDED ****
	static String fifteen = "15%";	//ADDED ****
	static String twenty = "20%"; 	//ADDED ****

	
	// Client Panel Subjects
	private JLabel subclientname;
	private JLabel subclient;
	private JLabel subgrossincome;
	private JLabel subgross;
	private JLabel subexpenses;
	private JLabel subexp;
	private JLabel subfood;
	private JLabel subent;
	private JLabel subgas;
	private JLabel subbills;
	private JLabel subgoal;
	private JLabel subactualsav;
	
	private JPanel subclientpanel;
	
	private JLabel startuptitle;
	
	private Image image;
	
	public FinanceWindow() 
	{
		super("HerrBrum Finance Calculator");
		
		
		m_tabbedPane = new JTabbedPane();
		
		m_newClient = new JMenuItem("New Client");
		m_newClient.setActionCommand("New Client");
		m_newClient.addActionListener(this);
		m_saveClientList = new JMenuItem("Save");
		m_loadClientList = new JMenuItem("Load");
		m_exit = new JMenuItem("Exit");
		m_exit.setActionCommand("Exit");
		m_exit.addActionListener(this);
		
		m_fileMenu = new JMenu("File");
		m_fileMenu.add(m_newClient);
		m_fileMenu.add(m_saveClientList);
		m_fileMenu.add(m_loadClientList);
		m_fileMenu.add(m_exit);
		m_fileMenu.setBackground(Color.GRAY);
		
		m_menubar.setBackground(Color.GRAY);
		m_menubar.add(m_fileMenu);
		m_menubar.add(m_tabbutton);// added to menubar due to graphics confliction with multiple tabs open
		m_menubar.add(m_closebutton);
		
		
		setJMenuBar(m_menubar);
		
		starticon = new ImageIcon("/Users/codyherring/Desktop/Final_Project_Source_2/Startup_Image.jpg");
		
		//startuptitle = new JLabel(starticon);
		
		image = Toolkit.getDefaultToolkit().createImage("/Users/codyherring/Desktop/Final_Project_Source_2/Startup_Image.jpg");

		m_tabbutton.setSize(80, 20);
		m_tabbutton.addActionListener(this);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		super.setBounds(200,200,dim.width-600,dim.height-100);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.add(m_tabbedPane);
		super.setVisible(true);
		super.setBackground(Color.ORANGE);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(image, 20, 150, null);
	}


	/************************************************
	 *Class: FinanceWindow
	 *Method: addTab
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This method creates a new tab upon selecting
	 * the new tab button, that displays
	 * the default startup for inputting information
	 * for a new client.
	 ************************************************/
	private void addTab(String title)
	{
		
		
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
		
		icon = new ImageIcon("/Users/codyherring/Desktop/Final_Project_Source_2/money_icon.png");
		
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
		submit.addActionListener(this);
		p2bc.add(submit);
		p2b.add(p2ba);
		p2b.add(p2bb);
		p2b.add(p2bc);
		
		p2.add(p2a);
		p2.add(p2b);
		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		panel.add(p1, BorderLayout.NORTH);
		panel.add(p2, BorderLayout.SOUTH);
		
		
		m_tabbedPane.addTab(title, panel);
		
	}
	/************************************************
	 *Class: FinanceWindow
	 *Method: addClientTab
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This method is called upon once the submit
	 * button is activated. It takes in the values
	 * of the client name, gross income, percentage
	 * of desired savings, and all expenses to output
	 * to new tab.
	 ************************************************/
	private void addClientTab(String c)
	{
		//super.setLayout(new GridLayout(2, 1));
		//super.add();
		
		subclientname = new JLabel("Client Name: ");
		subclientname.setForeground(Color.WHITE);
		
		subgrossincome = new JLabel("Gross Income: ");
		subgrossincome.setForeground(Color.WHITE);
		//gross = c.getGrossIncome();
		
		
		
		subfood = new JLabel("Food Expense(%): ");
		subfood.setForeground(Color.WHITE);
		subent = new JLabel("Entertainment Expense(%): ");
		subent.setForeground(Color.WHITE);
		subgas = new JLabel("Gas Expense(%): ");
		subgas.setForeground(Color.WHITE);
		subbills = new JLabel("Bills Expense(%): ");
		subbills.setForeground(Color.WHITE);
		subgoal = new JLabel("Your target goal savings was (blank) percent of your total income"); //+ c.getTargetPercentage());
		subgoal.setForeground(Color.WHITE);
		subactualsav = new JLabel("You actually saved (%):"); // + c.getActualSavingsPercentage() + " percent of your gross income");
		subactualsav.setForeground(Color.WHITE);
		
		subclientpanel = new JPanel();
		subclientpanel.setLayout(new GridLayout(0,1));
		
		subclientpanel.add(subclientname, BorderLayout.CENTER);
		subclientpanel.add(subgrossincome);
		subclientpanel.add(subbills);
		subclientpanel.add(subfood);
		subclientpanel.add(subent);
		subclientpanel.add(subgas);
		subclientpanel.add(subbills);
		subclientpanel.add(subgoal);
		subclientpanel.add(subactualsav);
		
		subclientpanel.setBackground(Color.GRAY);
		m_tabbedPane.addTab(c, subclientpanel);
		
	}
	/************************************************
	 *Class: FinanceWindow
	 *Method: actionPerformed
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This method manages what happens when certain
	 * events are executed.
	 * 
	 ************************************************/
	public void actionPerformed(ActionEvent arg) {
		Object ev = arg.getSource();
		
		if(ev == m_tabbutton)
		{
			addTab("New Client!");
		}
		if(ev == submit)
		{
			
			addClientTab("Submitted Client");
		}
		if("Exit".equals(arg.getActionCommand()))
		{
			System.exit(0);
		}
		if("New Client".equals(arg.getActionCommand()))
		{
			addTab("New Client!");
		}
		


	}
}