import java.awt.EventQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class jensonButton {
	
	private JFrame frame;

	public static void main(String[] args) {
					jensonButton window = new jensonButton();
					window.frame.setVisible(true);
					
					
	}
	public static void test() {
		System.out.println("---");
	}
	
	public jensonButton() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 1366, 768);
		frame.setUndecorated(true);
		frame.setBackground(new Color(0,0,0,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnClickMe = new JButton("Click me!");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int randomNumX = ThreadLocalRandom.current().nextInt(1, 1200 + 1);
				int randomNumY = ThreadLocalRandom.current().nextInt(1, 600 + 1);
				int xOld = btnClickMe.getBounds().x;
				int yOld = btnClickMe.getBounds().y;
				
				Timer timer=new Timer();
				TimerTask timerTask=new TimerTask() {
					public void run() {
						int x = btnClickMe.getBounds().x;
						int y = btnClickMe.getBounds().y;
						
						if(randomNumX>=xOld) {
							if(x<randomNumX)
								btnClickMe.setBounds(x+=1,y,100,25);
						}
						else 
						{
							if(x>randomNumX)
								btnClickMe.setBounds(x-=1,y,100,25);
						}
						
						if(randomNumY>=yOld) {
							if(y<randomNumY)
								btnClickMe.setBounds(x,y+=1,100,25);
						}
						else 
						{
							if(y>randomNumY)
								btnClickMe.setBounds(x,y-=1,100,25);
						}
					    
						if(x==randomNumX && y==randomNumY)
							timer.cancel();
					}
				};
				timer.schedule(timerTask, 0,1);
				
			}	
		});
		btnClickMe.setBounds(600, 300, 100, 25);
		frame.getContentPane().add(btnClickMe);	
	}	
}	

