import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

//(관리자)문제 추가
public class Question_add extends Question_M{

	private JPanel contentPane;
	private JTextField question;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;
	private JTextField answer4;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void ain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_add frame = new Question_add();
					frame.setVisible(true);
					//frame.setVisible(true);
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
	public Question_add() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBB38\uC81C");
		lblNewLabel.setBounds(12, 44, 57, 15);
		contentPane.add(lblNewLabel);
		
		question = new JTextField();
		question.setBounds(81, 41, 328, 21);
		contentPane.add(question);
		question.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC815\uB2F5");
		lblNewLabel_1.setBounds(12, 72, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		answer1 = new JTextField();
		answer1.setBounds(81, 69, 328, 21);
		contentPane.add(answer1);
		answer1.setColumns(10);
		
		answer2 = new JTextField();
		answer2.setBounds(81, 98, 328, 21);
		contentPane.add(answer2);
		answer2.setColumns(10);
		
		answer3 = new JTextField();
		answer3.setBounds(81, 129, 328, 21);
		contentPane.add(answer3);
		answer3.setColumns(10);
		//an3 = answer3.getText().toString();
		
		answer4 = new JTextField();
		answer4.setBounds(81, 160, 328, 21);
		contentPane.add(answer4);
		answer4.setColumns(10);
		//an4 = answer4.getText().toString();
		
		JLabel lblNewLabel_2 = new JLabel("\uC815\uB2F5 = ");
		lblNewLabel_2.setBounds(12, 194, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		String j = new String();
		answer = new JTextField();
		answer.setBounds(81, 191, 116, 21);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JButton btnNewButton = new JButton("\uCD94\uAC00\uD558\uAE30");
		btnNewButton.addMouseListener(new MouseAdapter() {
			Question q = new Question();
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String i=null;
				System.out.println(i);
				ques = question.getText().toString();
				System.out.println(ques);
				an1 = answer1.getText().toString();
				an2 = answer2.getText().toString();
				an3 = answer3.getText().toString();
				an4 = answer4.getText().toString();
				System.out.println(an1+an2+an3+an4);
				i = answer.getText().toString();
				ans = Integer.parseInt(i);
				System.out.println(i);
				try {
					/* 문제를 서버에 추가시키는 부분입니다. 
					 * Question Class의 addd 메소드를 확인해주세요!!
					 */
					q.addd(ques, an1, an2, an3, an4, ans);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.print(i);
			}
		});
		btnNewButton.setBounds(325, 226, 97, 23);
		contentPane.add(btnNewButton);
	}
}
