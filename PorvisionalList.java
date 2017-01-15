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
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class PorvisionalList {
	JFrame f;
	JScrollPane sp;
	JTable  tbl; 
	//Connection cn;
	//Statement st;
	ResultSet rs;
	Connection con;
	@SuppressWarnings("unchecked")
	PorvisionalList(String a,String b,String c)
	{
	
		try
		{
								/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								cn=DriverManager.getConnection("jdbc:odbc:Addmission");
								st=cn.createStatement();*/
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL="jdbc:oracle:thin:@localhost:1521:xe";
			String UserName="system";
			String Password="tiger"; //Password Specified at Oracle Installation Time
			con = DriverManager.getConnection(URL,UserName,Password);
			Statement st=con.createStatement();
			
			
			System.out.println("i am here");
			Vector data,heads;
			System.out.println("Privisional List");
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
				   
			String Query="SELECT * FROM "+a+" where Year='"+b+"' AND Acdamic_year='"+c+"' order by Marks DESC";  
			rs=st.executeQuery(Query); 
					
			while(rs.next())
			{
			    System.out.println("Privisional List");
			    Vector v1=new Vector();
			    v1.addElement(rs.getString("EnrollmentNo"));
				v1.addElement(rs.getString("Acdamic_year"));
				v1.addElement(rs.getString("Name"));
				v1.addElement(rs.getString("Branch"));
				v1.addElement(rs.getString("Year"));
				v1.addElement(rs.getString("Category"));
				v1.addElement(rs.getString("DOB"));
				v1.addElement(rs.getString("Marks"));
				v1.addElement(rs.getString("Address"));
				v1.addElement(rs.getString("Annual_income"));
				v1.addElement(rs.getString("Parent_income"));
				v1.addElement(rs.getString("Phone_no"));
				
				data.addElement(v1);
			}
			f=new JFrame("Privisional List");
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
			          //new Panel().print() ;
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
		 System.out.println("Privisional List");
		new PorvisionalList("third_year","CM","2013-2014");
	}
}
