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
import java.io.*;

public class UnpackFrame  extends JFrame  implements ActionListener  {

	private JFrame frame;
	JButton btnUnPack;
	JButton choose;
	JButton btnBack;
	String selected_file=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnpackFrame window = new UnpackFrame();
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
	public UnpackFrame() {
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
		
		btnUnPack = new JButton("Unpack");
		btnUnPack.setBackground(new Color(204, 255, 153));
		btnUnPack.setBounds(585, 195, 124, 39);
		btnUnPack.setFont (btnUnPack.getFont ().deriveFont (25.0f));
		frame.getContentPane().add(btnUnPack);
		
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
		btnUnPack.addActionListener(this);
		btnBack.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnUnPack)
			{
				if(selected_file==null)
				{
					JOptionPane.showMessageDialog(this, "No File Selected!!","ERROR", JOptionPane.ERROR_MESSAGE); 
				} 
				else
				{
					try{
						System.out.println("try"); 		
						UnPacker uobj=new UnPacker(selected_file);
					}catch(Exception eobj){}
				}		
			}
			else if(e.getSource()==btnBack)
			{
				secondFrame sobj=new secondFrame("Shubham");
				frame.dispose();
			}
			else if(e.getSource()==choose)
			{
				JFrame framechoose = new JFrame();
				File temp=null;
				JFileChooser chooser = new JFileChooser(); 
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Select Folder for Packing");
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (chooser.showOpenDialog(framechoose) == JFileChooser.APPROVE_OPTION) { 
				 selected_file= chooser.getSelectedFile().toString();
					temp=new File(selected_file);
					System.out.println(selected_file+"inside UnPackFrame"); 	
				}
					else{
						JOptionPane.showMessageDialog(this, "File Not selected !",  
						"ERROR", JOptionPane.ERROR_MESSAGE); 
					}
				 if((temp.isFile()==true)&&(selected_file.endsWith(".txt")==false))
					{
						JOptionPane.showMessageDialog(this, "Wrong File Selected !",  
						"ERROR", JOptionPane.ERROR_MESSAGE);
						selected_file=null;	
					}
		}
	}
}