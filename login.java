import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.DropMode;

public class login implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnAout;
	private JLabel lblLoginicon;
	private JLabel label;
	public String username;
	public String password;
	private JPanel panel;
	private JLabel usr;
	

	ClockLabel dayLabel;
    ClockLabel timeLabel;
    ClockLabel dateLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 50, 120));
		frame.setBounds(100, 100, 882, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 878, 119);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setToolTipText("Enter User Name");
		textField.setBounds(400, 248, 246, 32);
		//this.username=textField.getText();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setToolTipText("Enter Password");
	//	this.password=textField.getText();
		passwordField.setBounds(400, 316, 246, 32);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setIcon(null);
		lblUserName.setBounds(83, 238, 246, 48);
		lblUserName.setFont (new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblUserName.setForeground(Color.BLACK);
		frame.getContentPane().add(lblUserName);
		
				
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(83, 296, 233, 52);
		lblPassword.setFont (new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblPassword.setForeground(Color.BLACK);
		frame.getContentPane().add(lblPassword);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(null);
		btnSubmit.setBounds(274, 415, 170, 48);
		btnSubmit.setFont (btnSubmit.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(btnSubmit);
		
		btnAout = new JButton("About");
		
		btnAout.setBackground(SystemColor.activeCaption);
		btnAout.setBounds(793, 520, 75, 40);
		frame.getContentPane().add(btnAout);
		
		lblLoginicon = new JLabel("");
		lblLoginicon.setIcon(new ImageIcon("E:\\Project_batch\\frontEnd\\icons8-customer-64.png"));
		lblLoginicon.setBounds(656, 232, 75, 48);
		frame.getContentPane().add(lblLoginicon);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Project_batch\\frontEnd\\icons8-password-64.png"));
		label.setBounds(659, 312, 58, 52);
		frame.getContentPane().add(label);
	
			Clock();
		btnSubmit.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("in action performed");
		username=textField.getText();
		password=passwordField.getText();
		
		if(username.equals("abcd")&&password.equals("abcd"))
		{
			secondFrame sobj=new secondFrame(username);
			frame.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"wrong usrname and pasword!");
			textField.setText(null);
			passwordField.setText(null);
		}
		
	}

	void Clock()
    {
       dateLabel=new ClockLabel("date");
       timeLabel=new ClockLabel("time");
       dayLabel=new ClockLabel("day");

       dateLabel.setForeground(Color.blue);
       timeLabel.setForeground(Color.blue);
       dayLabel.setForeground(Color.blue);

       dayLabel.setFont(new Font("Century",Font.BOLD,15));

       dayLabel.setBounds(45,10,200,100);

       dateLabel.setFont(new Font("Century",Font.BOLD,15));

       dateLabel.setBounds(100,-40,200,100);

       timeLabel.setFont(new Font("Century",Font.BOLD,15));

       timeLabel.setBounds(95,-15,200,100);
		
	   panel.add(timeLabel);
	   panel.add(dateLabel);
	   panel.add(dayLabel);
	   
    }
}

/*class Demo implements ActionListener
{
	login lobj;
	
	public Demo(login obj)
	{
		lobj=obj;
		if((lobj.username.equals("shubham"))&&(lobj.password.equals("shubham"))==false)
		{
		login nobj=new login();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		secondFrame sobj=new secondFrame();
	
	}
	
}
*/