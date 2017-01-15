import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
@SuppressWarnings("serial")
public class Information extends JFrame
{
	
	JPanel p;
	JScrollPane sp;
	JTable  tbl; 
//	Connection cn;
//	Statement st;
	ResultSet rs1;
	@SuppressWarnings("unchecked")
	Vector v1=new Vector();
	int cnt1=0;
	int cnt2=0;
	int cnt3=0;
	int cnt4=0;
	int cnt5=0;
	@SuppressWarnings("unchecked")
	Information(String a,String b,String c)
	{
		Vector data;
		Vector heads;
		
		data=new Vector();
		heads=new Vector();

		heads.addElement("EnrollmentNo");
		heads.addElement("Acdamic_year");
		heads.addElement("Name");
		heads.addElement("Branch");
		heads.addElement("Year");
		heads.addElement("Category");
		heads.addElement("DOB");
		heads.addElement("Marks");
		heads.addElement("Address");
		heads.addElement("Annual_income");
		heads.addElement("Parent_income");
		heads.addElement("Phone_no");
		Connection con;
		try
		{
									/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
									cn=DriverManager.getConnection("jdbc:odbc:Addmission");
									st=cn.createStatement();*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL="jdbc:oracle:thin:@localhost:1521:xe";
			String UserName="system";
			String Password="tiger";
			con = DriverManager.getConnection(URL,UserName,Password);
			Statement st=con.createStatement();

			/* 		For OPEN 	*/

			String Query1="SELECT * FROM "+a+" where Year='"+b+"' AND Acdamic_year='"+c+"' order by Marks DESC"; 
			rs1=st.executeQuery(Query1);
			System.out.println("Started Execution");
			@SuppressWarnings("unused")
			int scount=0;
			@SuppressWarnings("unused")
			int obccount=0;
			while(rs1.next())
			{

				if(cnt1<5)
				{
						System.out.println("1");
						Vector v=new Vector();
						v.addElement(rs1.getString("EnrollmentNo"));
						v.addElement(rs1.getString("Acdamic_year"));
						v.addElement(rs1.getString("Name"));
						v.addElement(rs1.getString("Branch"));
						v.addElement(rs1.getString("Year"));
						v.addElement(rs1.getString("Category"));
						v.addElement(rs1.getString("DOB"));
						v.addElement(rs1.getString("Marks"));
						v.addElement(rs1.getString("Address"));
						v.addElement(rs1.getString("Annual_income"));
						v.addElement(rs1.getString("Parent_income"));
						v.addElement(rs1.getString("Phone_no"));

						data.addElement(v);
						System.out.println("Privisional List");
					    System.out.println(data);
					    cnt1++;
				}
				else
				{
					String cast=rs1.getString("Category");	
					System.out.println(cast);
					if(cast.equals("OBC"))
					{
						if(cnt2<2)
						{
							Vector v=new Vector();
							v.addElement(rs1.getString("EnrollmentNo"));
							v.addElement(rs1.getString("Acdamic_year"));
							v.addElement(rs1.getString("Name"));
							v.addElement(rs1.getString("Branch"));
							v.addElement(rs1.getString("Year"));
							v.addElement(cast);
							v.addElement(rs1.getString("DOB"));
							v.addElement(rs1.getString("Marks"));
							v.addElement(rs1.getString("Address"));
							v.addElement(rs1.getString("Annual_income"));
							v.addElement(rs1.getString("Parent_income"));
							v.addElement(rs1.getString("Phone_no"));
							data.addElement(v);
							System.out.println("I am OBC");
							cnt2++;   
						}
						System.out.println("I am OBC");
					
					}
					else if(cast.equals("SC"))
					{
						if(cnt3<1)
						{
							Vector v=new Vector();
							v.addElement(rs1.getString("EnrollmentNo"));
							v.addElement(rs1.getString("Acdamic_year"));
							v.addElement(rs1.getString("Name"));
							v.addElement(rs1.getString("Branch"));
							v.addElement(rs1.getString("Year"));
							v.addElement(cast);
							v.addElement(rs1.getString("DOB"));
							v.addElement(rs1.getString("Marks"));
							v.addElement(rs1.getString("Address"));
							v.addElement(rs1.getString("Annual_income"));
							v.addElement(rs1.getString("Parent_income"));
							v.addElement(rs1.getString("Phone_no"));
							System.out.println("I am ST");
							data.addElement(v);
							cnt3++;   
						}			
					}
					else if(cast.equals("ST"))
					{
						if(cnt4<1)
						{
							Vector v=new Vector();
							v.addElement(rs1.getString("EnrollmentNo"));
							v.addElement(rs1.getString("Acdamic_year"));
							v.addElement(rs1.getString("Name"));
							v.addElement(rs1.getString("Branch"));
							v.addElement(rs1.getString("Year"));
							v.addElement(cast);
							v.addElement(rs1.getString("DOB"));
							v.addElement(rs1.getString("Marks"));
							v.addElement(rs1.getString("Address"));
							v.addElement(rs1.getString("Annual_income"));
							v.addElement(rs1.getString("Parent_income"));
							v.addElement(rs1.getString("Phone_no"));
							System.out.println("I am ST");		
							data.addElement(v);
							cnt4++;   
						}			
					}		
					else if(cast.equals("NT"))
					{
							if(cnt5<1)
							{
								Vector v=new Vector();
								v.addElement(rs1.getString("EnrollmentNo"));
								v.addElement(rs1.getString("Acdamic_year"));
								v.addElement(rs1.getString("Name"));
								v.addElement(rs1.getString("Branch"));
								v.addElement(rs1.getString("Year"));
								v.addElement(cast);
								v.addElement(rs1.getString("DOB"));
								v.addElement(rs1.getString("Marks"));
								v.addElement(rs1.getString("Address"));
								v.addElement(rs1.getString("Annual_income"));
								v.addElement(rs1.getString("Parent_income"));
								v.addElement(rs1.getString("Phone_no"));
								data.addElement(v);
								System.out.println("I am NT");
								cnt5++;   
							}			
							
					}
					else if(cast.equals("OPEN"))
					{
						System.out.println("I am OPEN");
					}
					else
					{
						System.out.println("I am Here");
					}
					}
			}		
			System.out.println("Finished");
			JFrame f=new JFrame("Final List Details");
			tbl=new JTable(data,heads);
			sp=new JScrollPane(tbl);
			
			f.getContentPane().add(sp, BorderLayout.CENTER);
			f.setSize(900,200);
			f.setVisible(true);
			f.setLocation(200, 100);
			
			
			
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JButton button = new JButton("Print");
			
			ActionListener printAction = new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        try {
			        	tbl.print();
			        } catch (PrinterException pe) {
			          System.err.println("Error printing: " + pe.getMessage());
			        }
			      }
			    };
			    button.addActionListener(printAction);
			    f.add(button, BorderLayout.SOUTH);
		}
		catch(Exception e)
		{}
	}
	public static void main(String [] args)
	{
		new Information("first_year","CM","2014-2015");
	}
}