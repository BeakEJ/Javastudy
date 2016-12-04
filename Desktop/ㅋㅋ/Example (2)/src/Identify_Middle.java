import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Identify_Middle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void mn(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identify_Middle frame = new Identify_Middle();
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
	public Identify_Middle() throws IOException {
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
		Main e1 = new Main();
		
		JButton home = new JButton("\uD648\uC73C\uB85C");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				e1.setVisible(true);
				e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Education e2 = new Education();
		home.setBounds(45, 90, 144, 75);
		panel.add(home);
		
		JButton next = new JButton("\uD559\uC2B5\uD558\uAE30");
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				e2.setVisible(true);
				e2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		next.setBounds(244, 90, 144, 75);
		panel.add(next);
	}
}
