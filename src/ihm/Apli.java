package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class Apli extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apli frame = new Apli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Apli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrezVotreEmail = new JLabel("Entrez votre e-mail : ");
		lblEntrezVotreEmail.setBounds(45, 31, 108, 14);
		contentPane.add(lblEntrezVotreEmail);
		
		JLabel lblEntrezVotreMdp = new JLabel("Entrez votre mdp :");
		lblEntrezVotreMdp.setBounds(45, 68, 96, 14);
		contentPane.add(lblEntrezVotreMdp);
		
		textField = new JTextField();
		textField.setBounds(171, 28, 197, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 65, 197, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		
	
	}
}
