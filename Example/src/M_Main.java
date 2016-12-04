import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class M_Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void min(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_Main frame = new M_Main();
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
	public M_Main() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		User_delete u = new User_delete();
		JButton button = new JButton("\uD68C\uC6D0 \uAD00\uB9AC");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				u.setVisible(true);
				u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setBounds(36, 10, 162, 241);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uBB38\uC81C\uAD00\uB9AC");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Question q;
				try {
					q = new Question();
					q.setVisible(true);
					q.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(232, 10, 162, 241);
		contentPane.add(button_1);
	}
}
