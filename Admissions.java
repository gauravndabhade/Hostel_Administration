import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;


@SuppressWarnings("serial")
class Admissions extends JFrame implements ActionListener
{
	
	JLabel EnrollmentNo,Acdamic_year,name,branch,year,category,dob,marks,address,y_income,p_p_no,student_p_no;
	JTextField tEnrollmentNo,tfname,tmname,tlname,tmarks,ty_income,tp_p_no,tstudent_p_no;
	TextArea taddress;
	JButton bsubmit,bclear;
	JComboBox cyear,cbranch,ccategory,dd,mm,yy,tAcdamic_year;
	
	JLabel formname,note1,note2,note3;
	int reg=0,flag=0;;
	JLabel registration;
	JTextField tregistration;
	JButton badd;

	Connection cn;
	Statement st;
	ResultSet rs,temp;
	
	JPanel centralpanel;
	Container mycnt;
	
	@SuppressWarnings("deprecation")
	public Admissions()
	{
		super.setTitle("Admission Form");
		
		mycnt=getContentPane();
		
		addWindowListener(new WindowAdapter()
						 {
						 	public void windowClosing(WindowEvent e)
						 	{
						 		dispose();
						 	}
						 });
		setBounds(0,0,800,600);
		mycnt.setBackground(new Color(100,100,100));
		mycnt.setLayout(null);
		setLocation(270, 120);
		
		centralpanel = new JPanel();
		centralpanel.setBounds(0,70,1000,700);	
		centralpanel.setBorder(new EtchedBorder(1));
		mycnt.add(centralpanel);			
		centralpanel.setVisible(true);
		
		centralpanel.setBackground(new Color(245,245,220));

		EnrollmentNo=new JLabel("Enrollment No :");	
		Acdamic_year=new JLabel("Academic year :");	
		name=new JLabel("Student Name :");
		branch=new JLabel("Branch :");
		year=new JLabel("Year :");
		category=new JLabel("Category :");
		dob=new JLabel("Date Of Birth :");
		marks=new JLabel("Marks In Percentage :");
		address=new JLabel("Permanent Address :");
		y_income=new JLabel("Annual Income :");
		p_p_no=new JLabel("Parent Phone No :");
		student_p_no=new JLabel("Student Phone No :");
		bsubmit=new JButton("Submit");
		bclear=new JButton("Clear");
		badd=new JButton("Add");
		badd.setForeground(Color.RED);
		
		registration=new JLabel("Registration No");
		formname=new JLabel("Admission Form");
		
		
		note1= new JLabel("SURNAME");
		note2= new JLabel("FIRST NAME");
		note3= new JLabel("MIDDLE NAME");
		
		
		tEnrollmentNo=new JTextField();
		tfname=new JTextField();
		tmname=new JTextField();
		tlname=new JTextField();
		tmarks=new JTextField();
		taddress=new TextArea();
		ty_income=new JTextField();
		tp_p_no=new JTextField();
		tstudent_p_no=new JTextField();
		
		tregistration=new JTextField("Add Form");
		tregistration.disable();
	

		dd=new JComboBox();
		for(int i=1;i<=31;i++)
		{
			dd.addItem(Integer.toString(i));
		}
		mm=new JComboBox();
		for(int i=1;i<=12;i++)
		{
			mm.addItem(Integer.toString(i));
		}
		yy=new JComboBox();
		for(int i=1980;i<=2099;i++)
		{
			yy.addItem(Integer.toString(i));
		}
		tAcdamic_year=new JComboBox();
		for(int i=2008;i<=2099;i++)
		{
			tAcdamic_year.addItem(i+"-"+(i+1));
		}
	
		cyear=new JComboBox();
		cyear.addItem("First Year");
		cyear.addItem("Second Year");
		cyear.addItem("Third Year");
		cbranch=new JComboBox();
		cbranch.addItem("CM");
		cbranch.addItem("CE");
		cbranch.addItem("ME");
		cbranch.addItem("IS");
		cbranch.addItem("E&TC");
		cbranch.addItem("PD");
		
		ccategory=new JComboBox();
		ccategory.addItem("OPEN");
		ccategory.addItem("OBC");
		ccategory.addItem("NT");
		ccategory.addItem("SC");
		ccategory.addItem("ST");
		
		centralpanel.setLayout(null);
			add(formname);
			formname.setFont(new Font("Bookman Old Style",Font.BOLD,25));
			formname.setBackground(new Color(255,100,100));
			formname.setForeground(new Color(255,100,100));
			formname.setBounds(300,10,300,40);
			
			tfname.requestFocus();
			
			centralpanel.add(note1);
			note1.setFont(new Font("Bookman Old Style",Font.BOLD,10));
			note1.setForeground(new Color(255,100,100));
			note1.setBounds(270,120,600,20);
			
			centralpanel.add(note2);
			note2.setFont(new Font("Bookman Old Style",Font.BOLD,10));
			note2.setForeground(new Color(255,100,100));
			note2.setBounds(440,120,600,20);
			
			centralpanel.add(note3);
			note3.setFont(new Font("Bookman Old Style",Font.BOLD,10));
			note3.setForeground(new Color(255,100,100));
			note3.setBounds(610,120,600,20);
			
			centralpanel.add(registration);  			centralpanel.add(tregistration);
			registration.setBounds(100,20,100,20);		tregistration.setBounds(230,20,150,20);
			
			centralpanel.add(name);				centralpanel.add(tlname);			centralpanel.add(tfname);			centralpanel.add(tmname);			
			name.setBounds(100,100,100,20);		tlname.setBounds(230,100,150,20);   tfname.setBounds(400,100,150,20);	tmname.setBounds(570,100,160,20);	
			
			centralpanel.add(EnrollmentNo);				centralpanel.add(tEnrollmentNo);					centralpanel.add(Acdamic_year);						centralpanel.add(tAcdamic_year);
			EnrollmentNo.setBounds(100,60,100,20);		tEnrollmentNo.setBounds(230,60,150,20);					Acdamic_year.setBounds(450,60,120,20);			tAcdamic_year.setBounds(580,60,150,20);
	
			centralpanel.add(branch);		centralpanel.add(cbranch);
			branch.setBounds(450,140,120,20);	cbranch.setBounds(580,140,150,20);
		
		centralpanel.add(year);			centralpanel.add(cyear);							centralpanel.add(category);		centralpanel.add(ccategory);
		year.setBounds(100,260,100,20);		cyear.setBounds(230,260,150,20);				category.setBounds(450,180,120,20);	ccategory.setBounds(580,180,150,20);
		
		centralpanel.add(dob);			centralpanel.add(dd);								centralpanel.add(marks);		centralpanel.add(tmarks);
		dob.setBounds(100,220,100,20);		dd.setBounds(230,220,40,20);					marks.setBounds(450,220,120,20);	tmarks.setBounds(580,220,150,20);
		
		centralpanel.add(mm);			centralpanel.add(yy);
		mm.setBounds(280,220,40,20);		yy.setBounds(330,220,60,20);
		
		centralpanel.add(address);		centralpanel.add(taddress);							centralpanel.add(y_income);		centralpanel.add(ty_income);
		address.setBounds(100,140,120,20);	taddress.setBounds(250,140,150,60);				y_income.setBounds(450,260,120,20);	ty_income.setBounds(580,260,150,20);
		
		centralpanel.add(p_p_no);		centralpanel.add(tp_p_no);						centralpanel.add(student_p_no);		centralpanel.add(tstudent_p_no);
		p_p_no.setBounds(100,300,110,20);	tp_p_no.setBounds(230,300,150,20);			student_p_no.setBounds(450,300,120,20);	tstudent_p_no.setBounds(580,300,150,20);
		
		centralpanel.add(bsubmit);		centralpanel.add(bclear);					 		
		bsubmit.setBounds(300,400,130,40);	bclear.setBounds(500,400,130,40);				
		
		centralpanel.add(badd);
		badd.setBounds(100,400,130,40);
		
		badd.addActionListener(this);
		bclear.addActionListener(this);
		bsubmit.addActionListener(this);
				
		setVisible(true);
		reg=this.maxRegno();
	}
	
		public static void main(String[] args)
		{
			new Admissions();
		}
		int maxRegno()
		{
			Connection con;
			int m=0;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String URL="jdbc:oracle:thin:@localhost:1521:xe";
				String UserName="system";
				String Password="tiger";
				con = DriverManager.getConnection(URL,UserName,Password);
				Statement st=con.createStatement();
				Statement st1=con.createStatement();
				int a=0,b=0,c=0;
				
				ResultSet MAX1=st.executeQuery("SELECT max(RegistrationNo) FROM first_year");
				MAX1.next();
				System.out.println("i am gaurav1="+(MAX1.getString(1)));
				if((MAX1.getString(1)+"").equals("null"))
				{
					a=0;
				}
				else
				{
					a=Integer.parseInt((MAX1.getString(1)));
				}	
				System.out.println("i am a="+a);
				
				
				ResultSet MAX2=st1.executeQuery("SELECT max(RegistrationNo) FROM second_year");
				MAX2.next();
				System.out.println("i am gaurav2="+(MAX2.getString(1)));
				if((MAX2.getString(1)+"").equals("null"))
				{
					b=0;
				}
				else
				{
					b=Integer.parseInt((MAX2.getString(1)));
				}
				System.out.println("i am b="+b);
				
				
				ResultSet MAX3=st.executeQuery("SELECT max(RegistrationNo) FROM third_year");
				MAX3.next();
				System.out.println("i am gaurav3="+(MAX3.getString(1)));
				if((MAX3.getString(1)+"").equals("null"))
				{
					c=0;
				}
				else
				{
					c=Integer.parseInt(MAX3.getString(1));
				}
				System.out.println("i am c="+c);
				
				System.out.println("a="+a+"  b="+b+"  c="+c);
				
				if(a>b && a>c)
				{
					m=a;
				}
				else if(b>a && b>c)
				{
					m=b;
				}
				else if(c>a && c>b)
				{
					m=c;
				}
				else
				{}
			}
			catch(Exception e)
			{}
			return m;
		}
	
		@SuppressWarnings({ "unchecked", "unchecked" })
		public void actionPerformed(ActionEvent ae)
		{
			Connection con;
			try
			{
								/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						        cn=DriverManager.getConnection("jdbc:odbc:Addmission");
					        	st=cn.createStatement();
					        	
					        	System.out.println("Connection Successfull!!!");*/
								
				// load oracle driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// connect using Thin driver
				String URL="jdbc:oracle:thin:@localhost:1521:xe";
				String UserName="system";
				String Password="tiger";
				con = DriverManager.getConnection(URL,UserName,Password);
				Statement st=con.createStatement();
				
				if(ae.getSource()==bclear)
				{
					tEnrollmentNo.setText("");
					tfname.setText("");
					tmname.setText("");
					tlname.setText("");
					taddress.setText("");
					tmarks.setText("");
					taddress.setText("");				
					ty_income.setText("");
					tp_p_no.setText("");
					tstudent_p_no.setText("");
					if(flag==1)
					{
						reg--;
						flag=0;
					}
					tregistration.setText("");
					
				}		
				else if(ae.getSource()==bsubmit)
				{	
					if(flag==1)
					{
						if(tEnrollmentNo.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter EnrollmentNo","Error", JOptionPane.ERROR_MESSAGE);
							tEnrollmentNo.setText("");
							tEnrollmentNo.requestFocus();
						}
						
						else if(tfname.getText().equals ("")||tmname.getText().equals ("")||tlname.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Name","Error", JOptionPane.ERROR_MESSAGE);
							tfname.setText("");
							tmname.setText("");
							tlname.setText("");
							tlname.requestFocus();
						}
						else if(taddress.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Address","Error", JOptionPane.ERROR_MESSAGE);
							taddress.setText("");
							taddress.requestFocus();
						}
						else if(tmarks.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Marks In Percentage","Error", JOptionPane.ERROR_MESSAGE);
							tmarks.setText("");
							tmarks.requestFocus();
						}
						else if(ty_income.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Annual Income","Error", JOptionPane.ERROR_MESSAGE);
							ty_income.setText("");
							ty_income.requestFocus();
						}
						else if(tp_p_no.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Parent Phone Number","Error", JOptionPane.ERROR_MESSAGE);
							tp_p_no.setText("");
							tp_p_no.requestFocus();
						}
						else if(tstudent_p_no.getText().equals (""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Student Phone No","Error", JOptionPane.ERROR_MESSAGE);
							tstudent_p_no.setText("");
							tstudent_p_no.requestFocus();
						}
						else
						{
								System.out.println(cyear.getSelectedItem());
								if(cyear.getSelectedIndex()==0)
			        			{
										st.executeUpdate("insert into first_year(RegistrationNo,EnrollmentNo,Acdamic_year,Name,Branch,Year,Category,DOB,Marks,Address,Annual_income,Parent_income,Phone_no)values('"+tregistration.getText()+"','"+tEnrollmentNo.getText()+"','"+tAcdamic_year.getSelectedItem()+"','"+tlname.getText()+" "+tfname.getText()+" "+tmname.getText()+" ','"+cyear.getSelectedItem()+"','"+cbranch.getSelectedItem()+"','"+ccategory.getSelectedItem()+"','"+dd.getSelectedItem()+"/"+mm.getSelectedItem()+"/"+yy.getSelectedItem()+"','"+tmarks.getText()+"','"+taddress.getText()+"','"+ty_income.getText()+"','"+tp_p_no.getText()+"','"+tstudent_p_no.getText()+"')");         	
										flag=0;
										System.out.println(cyear.getSelectedItem());
										tEnrollmentNo.setText("");
										tfname.setText("");
										tmname.setText("");
										tlname.setText("");
										tmarks.setText("");
										taddress.setText("");				
										ty_income.setText("");
										tp_p_no.setText("");
										tstudent_p_no.setText("");
										JOptionPane.showMessageDialog(this,"Data added successfully.....!");
										tEnrollmentNo.requestFocus();
								}
								else if(cyear.getSelectedIndex()==1)
			        			{
										st.executeUpdate("insert into second_year(RegistrationNo,EnrollmentNo,Acdamic_year,Name,Branch,Year,Category,DOB,Marks,Address,Annual_income,Parent_income,Phone_no)values('"+tregistration.getText()+"','"+tEnrollmentNo.getText()+"','"+tAcdamic_year.getSelectedItem()+"','"+tlname.getText()+" "+tfname.getText()+" "+tmname.getText()+"','"+cyear.getSelectedItem()+"','"+cbranch.getSelectedItem()+"','"+ccategory.getSelectedItem()+"','"+dd.getSelectedItem()+"/"+mm.getSelectedItem()+"/"+yy.getSelectedItem()+"','"+tmarks.getText()+"','"+taddress.getText()+"','"+ty_income.getText()+"','"+tp_p_no.getText()+"','"+tstudent_p_no.getText()+"')");         	
										flag=0;
										tEnrollmentNo.setText("");
										tfname.setText("");
										tmname.setText("");
										tlname.setText("");
										tmarks.setText("");
										taddress.setText("");				
										ty_income.setText("");
										tp_p_no.setText("");
										tstudent_p_no.setText("");
										JOptionPane.showMessageDialog(this,"Data added successfully.....!");
										tEnrollmentNo.requestFocus();
								}
								else if(cyear.getSelectedIndex()==2)
								{
										st.executeUpdate("insert into third_year(RegistrationNo,EnrollmentNo,Acdamic_year,Name,Branch,Year,Category,DOB,Marks,Address,Annual_income,Parent_income,Phone_no)values('"+tregistration.getText()+"','"+tEnrollmentNo.getText()+"','"+tAcdamic_year.getSelectedItem()+"','"+tlname.getText()+" "+tfname.getText()+" "+tmname.getText()+" ','"+cyear.getSelectedItem()+"','"+cbranch.getSelectedItem()+"','"+ccategory.getSelectedItem()+"','"+dd.getSelectedItem()+"/"+mm.getSelectedItem()+"/"+yy.getSelectedItem()+"','"+tmarks.getText()+"','"+taddress.getText()+"','"+ty_income.getText()+"','"+tp_p_no.getText()+"','"+tstudent_p_no.getText()+"')");         	
										flag=0;
										tEnrollmentNo.setText("");
										tfname.setText("");
										tmname.setText("");
										tlname.setText("");
										tmarks.setText("");
										taddress.setText("");				
										ty_income.setText("");
										tp_p_no.setText("");
										tstudent_p_no.setText("");
										JOptionPane.showMessageDialog(this,"Data added successfully.....!");
										tEnrollmentNo.requestFocus();
								}
								else
								{
								}
						}
					}  		//close flag = 1
					
					else	//if form is Not add AND submit button is close
					{
						JOptionPane.showMessageDialog(this,"First add form");
					}
				}
				
				else if(ae.getSource()==badd)
				{
					if(flag==0)
					{
						System.out.println("i am in add");
						reg++;
						tregistration.setText(""+reg);
						System.out.println("reg="+reg);
						JOptionPane.showMessageDialog(this,"Form Added Successfully");
						flag++;					
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Form is Already Added");
					}
				}
				
				else 
				{
				}
				
			}
			catch(Exception e)
			{}
		}	
}