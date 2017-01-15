import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

//import com.sun.org.apache.regexp.internal.RE;
@SuppressWarnings("serial")
public class TabbedDemo extends JFrame 
{
	
	
	public TabbedDemo()
	{	
		this.setVisible(true);
		this.setSize(1350, 1200);
		//Contener getContentPane = new ContentPane();
		javax.swing.JTabbedPane jp=new JTabbedPane();
		jp.addTab("Admission",new Add());
		jp.addTab("Student Info",new StudentInfo());
		jp.addTab("Merit List",new MYList());
		jp.addTab("Help",new Help());
		jp.addTab("Exit",new Exit());
		getContentPane().add(jp);
	
	}
	public static void main(String[] args)
	{
		new TabbedDemo();
	}
}

@SuppressWarnings("serial")
class Help extends JPanel implements ActionListener
{
	
	public Help()
	{
		
	setBackground(new Color(245,245,220));
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		
	}
}
@SuppressWarnings("serial")
class Exit extends JPanel implements ActionListener
{
	JButton log;
	public Exit()
	{
	
		log=new JButton("LOGOUT ");
		add(log);
		log.addActionListener(this);	
	setBackground(new Color(245,245,220));
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==log)
		{
			
			System.exit(0);
			
		}
		
	}
}

@SuppressWarnings("serial")
class Add extends JPanel implements ActionListener
{
	JButton admision,delete;
	
	public Add()
	{
		admision=new JButton("New Admision");
		delete=new JButton("Delete Admision");
		add(admision);
		add(delete);
		admision.addActionListener(this);
		setBackground(new Color(245,245,220));
		delete.addActionListener(this);
		
		}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==admision)
		{
			new Admissions();
			
		}
		else if(ae.getSource()==delete)
		{
			new DeleteS();
		}
	}
}
@SuppressWarnings("serial")
class StudentInfo extends JPanel implements ActionListener,ItemListener
{
	JComboBox chyear,chbranch,cacadmic;
	JPanel panel1,panel2;
	Container mycnt;
	JRadioButton jb1,jb2;
	ButtonGroup bg;
	JButton list,print;
	String s=new String();
	JTextField jt1;
	JLabel l1,info1,info2;
	JButton show;
	StudentInfo()
	{
		this.setLayout(null);
		jb1=new JRadioButton("Provisional List",true);
		jb2=new JRadioButton("Final List");
		info1=new JLabel("Display All List :");
		info2=new JLabel("Display For a Student :");
		bg=new ButtonGroup();
		panel1 = new JPanel();
		panel2 = new JPanel();
		list=new JButton("LIST");
		chyear=new JComboBox();
		chyear.addItem("first_year");
		chyear.addItem("second_year");
		chyear.addItem("third_year");
		chbranch=new JComboBox();
		chbranch.addItem("CM");
		chbranch.addItem("CE");
		chbranch.addItem("ME");
		chbranch.addItem("IS");
		chbranch.addItem("E&TC");
		chbranch.addItem("PD");
		cacadmic=new JComboBox();
		for(int i=2008;i<=2099;i++)
		{
			cacadmic.addItem(i+"-"+(i+1));
		}
		setBackground(new Color(245,245,220));
		//info1.setBackground(new Color(245,245,220));
		//info2.setBackground(new Color(245,245,220));
		info1.setBounds(120,150,200,20);
		info2.setBounds(570, 150, 200, 20);
		Font f=new Font("Times New Roman",Font.BOLD,18);
		info1.setFont(f);
		info2.setFont(f);
		add(info1);
		add(info2);
		//add(jb1);
		//jb1.setBounds(100,50,130,40);
		//jb2.setBounds(250,50,100,40);
		chyear.setBounds(350,50,100,30);
		chbranch.setBounds(500,50,100,30);
		cacadmic.setBounds(650,50,100,30);
		list.setBounds(500,200,100,40);
		//panel1.add(jb2);
		panel1.add(chyear);
		panel1.add(chbranch);
		panel1.add(cacadmic);
		panel1.add(list);
		
		
		list.addActionListener(this);
		
		
		panel1.setBounds(50,200,350,150);	
		panel1.setBorder(new EtchedBorder(1));
		add(panel1);
		panel1.setVisible(true);
		
		panel2.setBounds(500,200,350,150);
		panel2.setLayout(null);
		l1=new JLabel("Enter Enrollment/Registration ID:");
		jt1=new JTextField("");
		show=new JButton("SHOW");
			
		panel2.setBorder(new EtchedBorder(1));
		
		l1.setBounds(80,20,250,20);
		panel2.add(l1);
		jt1.setBounds(40,60,270,30);
		panel2.add(jt1);
		show.setBounds(100,100,100,30);
		panel2.add(show);
		
		add(panel2);
		panel2.setVisible(true);
		
		jb1.addItemListener(this);
		jb2.addItemListener(this);
		show.addActionListener(this);
	}	
	/*public static void main(String[] args)
	{
		new TabbedDemo();
	}*/
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==jb1)
			s=jb1.getActionCommand();
		else
			s=jb2.getActionCommand();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String p,q,r;
		
		p=(String) chyear.getSelectedItem();
		//System.out.println(p);
		q=(String)chbranch.getSelectedItem();
		//System.out.println(q);
		r=(String)cacadmic.getSelectedItem();
		//System.out.println(r);
		
		if(ae.getSource()==list)
		{
			if(s.equals("Provisional List"))
			{
			   System.out.println("i am hear1");
			   new PorvisionalInformation(p,q,r);
			}
			else
			{
				System.out.println("i am hear2");
				new Information(p,q,r);
				
			}
		}
		else if(ae.getSource()==show)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String URL="jdbc:oracle:thin:@localhost:1521:xe";
				
				System.out.println("i am here");
				String UserName="system";
				String Password="tiger"; 
				Connection con = DriverManager.getConnection(URL,UserName,Password);
				Statement st=con.createStatement();
				Statement st2=con.createStatement();
				Statement st3=con.createStatement();
				System.out.println("Connection Successfull!!!");
				
				String s=""+jt1.getText();
				if(s.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Enrollment/Registration ID: ","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					System.out.println("i am here");
					ResultSet r1=st.executeQuery("SELECT Acdamic_year,Name,Branch,Year,Marks FROM first_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'");
					
					ResultSet r2=st2.executeQuery("SELECT Acdamic_year,Name,Branch,Year,Marks FROM second_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'");
					
					ResultSet r3=st3.executeQuery("SELECT Acdamic_year,Name,Branch,Year,Marks FROM third_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'");
					boolean a=r1.next();
					System.out.println("i am here"+a);
					boolean b=r2.next();
					System.out.println("i am here"+b);
					boolean c=r3.next();
					System.out.println("i am here"+c);
				
					if((a)==true)
					{
						//System.out.println("i am here");
						JOptionPane.showMessageDialog(this,""+(r1.getString(1))+"  "+(r1.getString(2))+"  "+(r1.getString(3))+"  "+(r1.getString(4))+"  "+(r1.getString(5)));
					}
					if((b)==true)
					{
						JOptionPane.showMessageDialog(this,""+(r2.getString(1))+"  "+(r2.getString(2))+"  "+(r2.getString(3))+"  "+(r2.getString(4))+"  "+(r2.getString(5)));
					}
					if((c)==true)
					{
						JOptionPane.showMessageDialog(this,""+(r3.getString(1))+"  "+(r3.getString(2))+"  "+(r3.getString(3))+"  "+(r3.getString(4))+"  "+(r3.getString(5)));
					}
					else
					{}
				}
			}
			catch(Exception e)
			{}
		}
	}
}

@SuppressWarnings("serial")
class MYList extends JPanel implements ActionListener,ItemListener
{
	JComboBox chyear,chbranch,cacadmic;
	JPanel panel1;
	Container mycnt;
	JRadioButton jb1,jb2;
	ButtonGroup bg;
	JButton list;
	String s=new String();
	MYList()
	{
		this.setLayout(null);
		jb1=new JRadioButton("Provisional List");
		jb2=new JRadioButton("Final List",true);
		bg=new ButtonGroup();
		panel1=new JPanel();
		panel1.setBorder(new EtchedBorder(1));
		bg.add(jb1);
		bg.add(jb2);
		setBackground(new Color(245,245,220));
		list=new JButton("LIST");
		chyear=new JComboBox();
		chyear.addItem("first_year");
		chyear.addItem("second_year");
		chyear.addItem("third_year");
		chbranch=new JComboBox();
		chbranch.addItem("CM");
		chbranch.addItem("CE");
		chbranch.addItem("ME");
		chbranch.addItem("IS");
		chbranch.addItem("E&TC");
		chbranch.addItem("PD");
		add(jb1);
		cacadmic=new JComboBox();
		for(int i=2008;i<=2099;i++)
		{
			cacadmic.addItem(i+"-"+(i+1));
		}
		jb1.setBounds(100,50,130,40);
		jb2.setBounds(250,50,100,40);
		chyear.setBounds(350,50,100,30);
		chbranch.setBounds(500,50,100,30);
		cacadmic.setBounds(650,50,100,30);
		list.setBounds(400,200,100,40);
		panel1.setBounds(70,30,750,300);
		add(jb2);
		add(chyear);
		add(chbranch);
		add(cacadmic);
		add(list);
		add(panel1);
		
		
		list.addActionListener(this);
		jb1.addItemListener(this);
		jb2.addItemListener(this);
	}	
	/*public static void main(String[] args)
	{
		new TabbedDemo();
	}*/
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==jb1)
			s=jb1.getActionCommand();
		else
			s=jb2.getActionCommand();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String p,q,r;
		
		p=(String) chyear.getSelectedItem();
		System.out.println(p);
		q=(String)chbranch.getSelectedItem();
		System.out.println(q);
		r=(String)cacadmic.getSelectedItem();
		System.out.println(r);
		
		if(ae.getSource()==list)
		{
			//System.out.println("1234");
			if(s.equals("Provisional List"))
			{
			   System.out.println("i am hear1");
			   new PorvisionalList(p,q,r);
			}
			else
			{
				System.out.println("i am hear2");
				new FinalList(p,q,r);
				
			}
		}
	}
}


	

