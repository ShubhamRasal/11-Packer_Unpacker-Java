import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager; 
public class packFrame extends JFrame  implements ActionListener {

	private JFrame frame;
	private JButton btnPack ;
	private JButton choose;
	private JButton btnBack;
	public String selected_file=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					packFrame window = new packFrame();
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
	public packFrame() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 868, 114);
		frame.getContentPane().add(panel);
		
		btnPack = new JButton("Pack");
		btnPack.setBackground(new Color(204, 255, 153));
		btnPack.setBounds(585, 195, 124, 39);
		btnPack.setFont (btnPack.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(btnPack);
		
		choose = new JButton("choose File");
		choose.setBackground(new Color(210, 255, 153));
		choose.setBounds(155, 195, 205, 39);
		choose.setFont (choose.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(choose);
		
	    btnBack = new JButton("Back");
		btnBack.setBackground(new Color(204, 255, 153));
		btnBack.setBounds(140, 447, 137, 39);
		btnBack.setFont (btnBack.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(btnBack);
		frame.setVisible(true);

		choose.addActionListener(this);
		btnPack.addActionListener(this);
		btnBack.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==btnPack)
		{
			if(selected_file==null)
			{
				JOptionPane.showMessageDialog(this, "No File Selected!!","ERROR", JOptionPane.ERROR_MESSAGE); 
			} 
			else
			{
				try{	
					Packer packobj=new Packer(selected_file,"packedonfend.txt");
				}catch(Exception eobj){}
			}		
		}
		else if(e.getSource()==btnBack)
		{
			secondFrame sobj=new secondFrame("shubham");
			frame.dispose();
		}
		else if(e.getSource()==choose)
		{
			JFrame framechoose = new JFrame();

			JFileChooser chooser = new JFileChooser(); 
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle("Select Folder for Packing");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (chooser.showOpenDialog(framechoose) == JFileChooser.APPROVE_OPTION) { 
				 selected_file= chooser.getSelectedFile().toString();
				}
			  else {
				System.out.println("No Selection ");
				}
		   
			//framechoose.getContentPane().add(chooser,"Center");
			//framechoose.setSize(chooser.getPreferredSize());
			//framechoose.setVisible(true);
		}

}

}