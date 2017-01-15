import java.awt.*;  
import java.awt.event.*;  
import java.text.*;  
import java.util.Date;  
import javax.swing.*;   
@SuppressWarnings("serial")
public class DeteDemo extends JPanel  
{  
    public DeteDemo()  
    {  
    	//this.setLayout(null);
        final JLabel timeLabel = new JLabel();  
        add(timeLabel);  
       // timeLabel.setBounds(1100,10,200,20);
        final DateFormat timeFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        //("HH:mm:ss");  
        ActionListener timerListener = new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                Date date = new Date();  
                String time = timeFormat.format(date);  
                timeLabel.setText(time);  
            }  
        };  
        Timer timer = new Timer(1000, timerListener);  
        // to make sure it doesn't wait one second at the start  
        timer.setInitialDelay(0);  
        timer.start();  
    }  
   
    public static void main(String[] args) throws Exception  
    {  
        JFrame frame = new JFrame();
        	frame.add(new DeteDemo());  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.pack();  
        frame.setVisible(true);  
    }  
}  