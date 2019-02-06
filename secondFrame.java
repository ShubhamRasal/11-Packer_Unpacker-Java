
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class secondFrame implements ActionListener {

	private JFrame frame;
	private JButton btnUnpack;
	private JButton btnPack;
	private String username;
	private JPanel panel;
	private JLabel usr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondFrame window = new secondFrame("shubham");
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
	public secondFrame(String username) 
	{
		System.out.println(username);
		this.username=username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 102, 255));
		frame.setBounds(100, 100, 882, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usr= new JLabel("Welcome:"+username+"\n to PACKER UNPACKER");

		 panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 868, 100);
	//	panel.setLayout(null);
		panel.add(usr);
		frame.getContentPane().add(panel);
		
		panel.add(usr);

		btnPack = new JButton("Pack");
		btnPack.setBackground(new Color(204, 255, 153));
		btnPack.setBounds(140, 210, 124, 39);
		btnPack.setFont (btnPack.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(btnPack);
		
		 btnUnpack = new JButton("Unpack");
		btnUnpack.setBackground(new Color(204, 255, 153));
		btnUnpack.setBounds(566, 210, 137, 39);
		btnUnpack.setFont (btnUnpack.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(btnUnpack);

		frame.setVisible(true);

		btnPack.addActionListener(this);
		btnUnpack.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnPack)
		{
		packFrame pobj=new packFrame();
		frame.dispose();
				
		}
		else if(e.getSource()==btnUnpack)
		{
			UnpackFrame uobj = new UnpackFrame();
			frame.dispose();
		}

	}
}
