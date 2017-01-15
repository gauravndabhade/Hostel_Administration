import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import javax.swing.*;
@SuppressWarnings("serial")
public class DeleteS extends JFrame implements ActionListener{
	JLabel l1;
	JTextField jt1;
	JButton delete,show;
	public DeleteS() {
	
		addWindowListener(new WindowAdapter()
		 {
		 	public void windowClosing(WindowEvent e)
		 	{
		 		dispose();
		 	}
		 });
		l1=new JLabel("Enter Enrollment/Registration ID:");
		jt1=new JTextField("");
		
		delete=new JButton("OK");
		show=new JButton("SHOW");
		add(l1);
		add(jt1);
		add(delete);
		add(show);
		delete.addActionListener(this);
		show.addActionListener(this);
		setVisible(true);
		setLayout(null);
		
		l1.setBounds(50,10,220,20);
		jt1.setBounds(50,70,170,20);
		show.setBounds(60,140,80,20);
		delete.setBounds(160,140,80,20);
		jt1.requestFocus();
		setLocation(500, 150);
		setSize(300,250);
	}

	
	public static void main(String[] args) {
		
		new DeleteS();
	}
	public void actionPerformed(ActionEvent ae) {
		//Connection cn;
		//Statement st;
		//ResultSet rs;
		Connection con;
		try
		{
							/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							cn=DriverManager.getConnection("jdbc:odbc:Addmission");
							st=cn.createStatement();*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL="jdbc:oracle:thin:@localhost:1521:xe";

			System.out.println("i am here");
			String UserName="system";
			String Password="tiger"; 
			con = DriverManager.getConnection(URL,UserName,Password);
			Statement st=con.createStatement();
			Statement st1=con.createStatement();
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
					if(ae.getSource()==delete)
					{
						String sql1="Delete From first_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'";
						String sql2="Delete From second_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'";
						String sql3="Delete From third_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'";
						//int a;
						if(st.executeUpdate(sql1)==1)
						{
						//System.out.println(a);
							JOptionPane.showMessageDialog(this,"Delete Selected Recorde from 1st year :"+s);
						}
						else if(st.executeUpdate(sql2)==1)
						{
							JOptionPane.showMessageDialog(this,"Delete Selected Recorde from 2nd year :"+s);
						}
						else if(st.executeUpdate(sql3)==1)
						{
							JOptionPane.showMessageDialog(this,"Delete Selected Recorde from 3rd year :"+s);
						}
						else{
							JOptionPane.showMessageDialog(this,"Invalid Enrollment/Registration ID :"+s);
						}
						jt1.setText("");
						jt1.requestFocus();
					}
					else if(ae.getSource()==show)
					{
						
							
							System.out.println("i am here");
							ResultSet r1=st1.executeQuery("SELECT Acdamic_year,Name,Branch,Year,Marks FROM first_year where EnrollmentNo='"+s+"' OR RegistrationNo='"+s+"'");
							
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
							else if((b)==true)
							{
								JOptionPane.showMessageDialog(this,""+(r2.getString(1))+"  "+(r2.getString(2))+"  "+(r2.getString(3))+"  "+(r2.getString(4))+"  "+(r2.getString(5)));
							}
							else if((c)==true)
							{
								JOptionPane.showMessageDialog(this,""+(r3.getString(1))+"  "+(r3.getString(2))+"  "+(r3.getString(3))+"  "+(r3.getString(4))+"  "+(r3.getString(5)));
							}
							else
							{
								JOptionPane.showMessageDialog(this,""+"Invalid Enrollment/Registration ID");
							}
					}
					else{}
			}
			
				
		}
		catch(Exception e)
		{
		}
		
	}

}
