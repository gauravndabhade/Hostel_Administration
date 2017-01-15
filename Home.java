import java.awt.*;
import java.awt.event.*;
//import java.lang.*;
import java.awt.event.WindowEvent;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.text.SimpleDateFormat;

import javax.swing.*;
//import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class Home extends JFrame implements  ActionListener,WindowListener
{
	JLabel l1,l2,l3,l4;
	JTextArea t1,t2;
	JTextField t3,t4;
	JButton login; 
	JScrollPane sc;
	JScrollPane scg;
	Home()
	{
		try
		{
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;	
	
		
						 	
		setVisible(true);
		setSize(1350,750);
		
		JPanel p=new DeteDemo();
		//p.setBorder(new EtchedBorder(1));
		p.setBounds(1170,05,200,30);
		this.add(p);
		
		
		Font f1=new Font("Copperplate Gothic",Font.BOLD,20);

		setLayout(null);
		@SuppressWarnings("unused")
		Color c1=new Color(221,160,221);
		t1=new JTextArea("1.I-card must be compulsory.\n\n2.Students are not allowed to \n  stay at hostel in college time.\n\n3.Hostel gate opened at 6 am &\n closed at 10 pm\n\n4.Permission is compulsory from \nrector for leave\n ");//,10,20,Scrollbar.HORIZONTAL);
		sc=new JScrollPane(t1,v,h);
		
		//add(t1);
		//t1.setBounds(0,200,350,500);
		//t1.setBackground(c1);
		t1.setForeground(new Color(138, 43,226));
		t1.setBackground(new Color(245,245,220));
		t1.setFont(f1);
		sc.setBounds(0,240,350,500);
		this.add(sc);

		
		t2=new JTextArea("1.Student should admitted in respective\n institute.\n\n2.Student should follow all rules.\n\n3.For any query contact rector.\n\n4.Student relatives are not allowed\n to stay in hostel.\n\n5.Smoking & Drinking are not allowed\n in hostel.");//,10,20,Scrollbar.HORIZONTAL);
		add(t2);
		scg=new JScrollPane(t2,v,h);
		t2.setBackground(new Color(245,245,220));
		t2.setForeground(new Color(138, 43,226));
		t2.setFont(f1);
		scg.setBounds(959,240,400,500);
		this.add(scg);
		
		login=new JButton("LOG IN");
		login.setBounds(1100,120,100,50);
		login.addActionListener(this);
		add(login);
		

		/*blogout=new JButton("LOG OUT");
		add(blogout);
		blogout.addActionListener(this);
		blogout.setBounds(1120,120,100,50);
		*/
		//Container contentPane=getContentPane();
		
		Font f=new Font("Algerian",Font.BOLD,60);

		ImageIcon i1=new ImageIcon("D:\\bbb.jpg");
		l1=new JLabel(i1);
		this.add(l1);
		l1.setBounds(350,200,700,500);

		ImageIcon i2=new ImageIcon("D:\\MSBTE_LOG.gif");
		l2=new JLabel(i2);
		this.add(l2);
		l2.setBounds(15,10,210,195);
		l3=new JLabel("GOVERNMENT POLYTECHNIC ,");
		//l3.setForeground(Color.RED);
		l3.setForeground(Color.PINK);
		l3.setFont(f);
		l3.setBounds(250,30,1100,40);
		this.add(l3);
		
		l4=new JLabel("AHMEDNAGAR");
		l4.setForeground(Color.PINK);	
		l4.setFont(f);
		l4.setBounds(410,100,500,40);
		this.add(l4);
		t4=new JTextField("RULES :");
		t4.setForeground(Color.RED);
			
		t4.setFont(f1);
		t4.setBounds(0,200,350,40);
		t4.setBackground(new Color(0,255,255));
		t3=new JTextField("TERMS & CONDITIONS:");
		t3.setForeground(Color.RED);
			
		t3.setFont(f1);
		t3.setBounds(959,200,400,40);
		t3.setBackground(new Color(0,255,255));
		this.add(t3);
	
		//t4.setBackground(new Color(139,69,19));
		
		this.add(t4);
		
		getContentPane().setBackground(new Color(160, 82, 45));
				
		//addWindowListener(this);
		}
		catch(Exception e)
		{}
	}	
	
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent we)
			{
			}
			public void windowClosed(WindowEvent we)
			{
			}
			public void windowActivated(WindowEvent we)
			{
			}			
			public void windowIconified(WindowEvent we)
			{
			}
			public void windowDeiconified(WindowEvent we)
			{
			}
			public void windowOpened(WindowEvent we)
			{
			}
			
	public static void main(String args[])
	{
		new Home();
	}

	public void actionPerformed(ActionEvent ae)
	{
	/*	if(ae.getSource()==blogout)
		{
			System.exit(0);
			//dispose();
			//new Login();
		}*/
		 if(ae.getSource()==login)
		{
			new Login();
			
		}
	}
}


