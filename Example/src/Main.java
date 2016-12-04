import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Main() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		Education e1 = new Education();
		
		JButton btnNewButton = new JButton("\uD559\uC2B5\uD558\uAE30");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				e1.setVisible(true);
				e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(28, 30, 97, 205);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uAE30\uB9D0\uD3C9\uAC00");
		btnNewButton_1.setBounds(169, 30, 97, 205);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uD68C\uC6D0\uC218\uC815");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Modify_U e1 = new Modify_U();
				e1.setVisible(true);
				e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(307, 30, 97, 205);
		panel.add(btnNewButton_2);
	}

}
