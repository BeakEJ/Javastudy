import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class Question_remove extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private int modifyLine = 0;

	/**
	 * Launch the application.
	 */
	public static void min(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_remove frame = new Question_remove();
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
	public Question_remove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC0AD\uC81C\uD560 \uBB38\uC81C\uBC88\uD638");
		lblNewLabel.setBounds(169, 88, 168, 15);
		contentPane.add(lblNewLabel);
		
		text = new JTextField();
		text.setBounds(157, 118, 116, 21);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton button = new JButton("\uC0AD\uC81C\uD558\uAE30");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=0;
				i=Integer.parseInt(text.getText());
				//�����ϴ� �ڵ� �־��ּ���
				//�������� ������ ���� ��ȣ(i)�� �ش��ϴ� �κ��� ��� �����ֽø� �˴ϴ�.
			}
		});
		button.setBounds(169, 149, 90, 23);
		contentPane.add(button);
	}

}
