import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


@SuppressWarnings("serial")
class Login extends JFrame implements ActionListener 
{  
	 private JTextField t1;
     private JPasswordField t2;
	 JLabel lbl;
	 JLabel name,passwd;
	 Container mycnt;
	 JButton btnSubmit,btnclear,btncancel; 
	 public Login()
	{
		super("Login");
		
		mycnt=getContentPane();
		setBounds(295,197,427,257);
		//setBackground(new Color(138, 43,226));
		
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
						 {
						 	public void windowClosing(WindowEvent e)
						 	{
						 		dispose();
						 	}
						 });
						 
		name=new JLabel("User Name");
		passwd=new JLabel("Password");
	
		t1=new JTextField(40);
		t2=new JPasswordField(40);
		
		setLayout(null);
		
		name.setBounds(40,40,75,25);
		mycnt.add(name);
		t1.setBounds(180,40,125,25);
		mycnt.add(t1);
		
		passwd.setBounds(40,80,75,25);
		mycnt.add(passwd);
		
		t2.setBounds(180,80,125,25);
		mycnt.add(t2);
		
	
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(50,130,80,25);
		mycnt.add(btnSubmit);
		
		btnclear = new JButton("CLEAR");
		btnclear.addActionListener(this);	
		btnclear.setBounds(200,130,80,25);
		mycnt.add(btnclear);
		mycnt.setBackground(new Color(245,245,220));
		/*btncancel = new JButton("HOME");
		btncancel.addActionListener(this);	
		btncancel.setBounds(200,125,80,25);
		mycnt.add(btncancel);*/
		setVisible(true);
	}


	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		Connection con;
		if(e.getSource()==btnSubmit)
		{

			try
			{
							/*String UserName=t1.getText();
							String Password=t2.getText();
							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection con =
							DriverManager.getConnection("jdbc:odbc:Hostelproject");
							System.out.println("Driver establised");
*/					
					
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String URL="jdbc:oracle:thin:@localhost:1521:xe";

					String U1=t1.getText();
					String P1=t2.getText();
					System.out.println("i am here");
					String UserName="system";
					String Password="tiger"; 
					con = DriverManager.getConnection(URL,UserName,Password);
					@SuppressWarnings("unused")
					Statement st=con.createStatement();
					System.out.println("Connection Successfull!!!");
					
					
					String sql = "select UserName,Password from Login where UserName='"+U1+"' and Password = '"+P1+"'";

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery( sql );
					int count=0;
				
					while(rs.next())
					{	
						count = count +1;
					}
					if(t1.getText().equals ("") && t2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter UserName & Password","Error", JOptionPane.ERROR_MESSAGE);
						t1.setText("");
						t2.setText("");
						t1.requestFocus();
					}
					else if(t1.getText().equals (""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter UserName","Error", JOptionPane.ERROR_MESSAGE);
						t1.setText("");
						t2.setText("");
						t1.requestFocus();
						}
					else if(t2.getText().equals (""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter Password","Error", JOptionPane.ERROR_MESSAGE);
						t1.setText("");
						t2.setText("");
						t1.requestFocus();
					}
					else if(count == 1)
					{
						//JOptionPane.showMessageDialog(null, " You have successfully logged in!");
						dispose();
						
						this.setVisible(false);
						//Home ds=new Home();
						TabbedDemo t=new TabbedDemo();
						t.setSize(900,600);
						t.setLocationRelativeTo(null);
						t.setVisible(true);
					}
					else if (count > 1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate User, Access Denied! Please contact administrator.");
						t1.setText("");
						t2.setText("");
						t1.requestFocus();
						//System.exit(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and password are incorrect. Please try to enter your username and password.");
						t1.setText("");
						t2.setText("");
						t1.requestFocus();
					}

			}
			catch (SQLException ex) 
			{
				System.out.println("SQL Exception: "+ ex.getMessage());
			}
			catch (ClassNotFoundException cE) {
				System.out.println("Class Not Found Exception: "+
						cE.toString());
				}
	}
		else if(e.getSource()==btnclear)
		{
			t1.setText("");
			t2.setText("");
			t1.requestFocus();
		}
		else if(e.getSource()==btncancel)
		{
			new Home();
		}
	//System.exit(0);

}
	public static void main(String[] args)
	{
		new Login();
	}
}
