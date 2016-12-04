import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//(������) ���� ����
// ��ȣ �Űܳ��ڽ��ϴ�. ������� ������ �ּ���.
public class Question_modify extends Question_M {

	private JPanel contentPane;
	private JTextField question;
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextField ans4;
	private JTextField f_ans;
	private JTextField num;
	
	private int modifyLine = 0;

	/**
	 * Launch the application.
	 */
	public static void mai(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_modify frame = new Question_modify();
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
	public Question_modify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 434, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setVisible(false);
		
		num = new JTextField();
		num.setBounds(151, 106, 116, 21);
		panel_1.add(num);
		num.setColumns(10);
		
		ans4 = new JTextField();
		ans4.setColumns(10);
		ans4.setBounds(81, 160, 328, 21);
		panel.add(ans4);
		
		f_ans = new JTextField();
		f_ans.setColumns(10);
		f_ans.setBounds(81, 191, 116, 21);
		panel.add(f_ans);
		
		question = new JTextField();
		question.setColumns(10);
		question.setBounds(81, 41, 328, 21);
		panel.add(question);
		
		ans1 = new JTextField();
		ans1.setColumns(10);
		ans1.setBounds(81, 69, 328, 21);
		panel.add(ans1);
		
		ans3 = new JTextField();
		ans3.setColumns(10);
		ans3.setBounds(81, 129, 328, 21);
		panel.add(ans3);
		
		ans2 = new JTextField();
		ans2.setColumns(10);
		ans2.setBounds(81, 98, 328, 21);
		panel.add(ans2);
		
		JButton button = new JButton("\uC218\uC815\uD558\uAE30");
		button.addMouseListener(new MouseAdapter() {
			@Override
			//2. �����ϱ� ��ư Ŭ����
			public void mouseClicked(MouseEvent e) {
				ques = question.getText();
				an1 = ans1.getText();
				an2 = ans2.getText();
				an3 = ans3.getText();
				an4 = ans4.getText();
				ans = Integer.parseInt(f_ans.getText());
				try {
					//���� Modify, Change �޼ҵ带 ���ּ���.
					Modify(ques, ans, an1, an2, an3, an4);
					Change();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(325, 226, 97, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("\uBB38\uC81C");
		label_1.setBounds(12, 44, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\uC815\uB2F5");
		label_2.setBounds(12, 72, 57, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\uC815\uB2F5 = ");
		label_3.setBounds(12, 194, 57, 15);
		panel.add(label_3);
		
		JLabel lblNewLabel = new JLabel("\uC218\uC815\uD560 \uBB38\uC81C\uBC88\uD638");
		lblNewLabel.setBounds(165, 81, 134, 15);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//1. ������ ������ȣ �Է¹ޱ�
			public void mouseClicked(MouseEvent e) {
				int i=1;
				String line;
				String line1;
				String line2;
				BufferedReader in;
				/* �� ��� ������ �ִ���
				 * ���� ��ȣ ���ڸ� ���Ƹ��� �κ��Դϴ�.
				 * �ҷ��ü� �ִٸ� i ���� �� ������ ������ȣ�� ���� �־��ִ°�
				 * ���Ұ� ���ƿ�!!
				 */
				try {
					in = new BufferedReader(new FileReader("number.txt"));
					while((line=in.readLine())!=null){
						i++;
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/* �� ���� ���ڸ� �޾ƿ����� �� ���� ���ں��� �����ڰ� �Է��� ������ ������ȣ��
				 * i���� ũ�� �ʴٸ� ���� �г��� �ݰ� ���� �г��� �����!
				 */
				int j=0;
				j=Integer.parseInt(num.getText());
				if(j>i){
					JOptionPane.showMessageDialog(null, "���� ��ȣ ���� ���� �Է����ֽʽÿ�.");
				}
				/* �׸��� �� panel�� ������ �� �� �ִ� â�Դϴ�.
				 * ������ �ؽ�Ʈ �ڽ��� ���� �����ϰ��� �ϴ� ������ �� 4�� �������� ���� ������ִ� �ڵ��Դϴ�.
				 * ���⼭ ��������� ��� question.setText(������ ����)
				 * ansn.setText(������ ���� 4��), f_ans.setTest(������ ������)�� 
				 * �ҷ����ø� �˴ϴ�! �����Ǹ� else ���� ��� try catch�� �� ����ø� �ſ�!!
				 */
				else{
					panel_1.setVisible(false);
					panel.setVisible(true);
					BufferedReader in1;
					try {
						i=1;
						int i1=0;
						in1 = new BufferedReader(new FileReader("question.txt"));
						BufferedReader in2 = new BufferedReader(new FileReader("answer.txt"));
						BufferedReader in3 = new BufferedReader(new FileReader("f_answer.txt"));
						while((line=in1.readLine())!=null&&(line2=in3.readLine())!=null){
							if(i==j){
								question.setText(line);
								while((line1=in2.readLine())!=null){
									if(i1==j*4)
										ans1.setText(line1);
									else if(i1==j*4+1)
										ans2.setText(line1);
									else if(i1==j*4+2)
										ans3.setText(line1);
									else if(i1==j*4+3)
										ans4.setText(line1);
									i1++;
								}
								f_ans.setText(line2);
							}
							i++;
							in1.close();
							in2.close();
							in3.close();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modifyLine=j;
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(172, 138, 78, 23);
		panel_1.add(btnNewButton);
	}
	private void Modify(String q, int a, String a1, String a2, String a3, String a4) throws IOException{
		System.out.println(modifyLine);
		String line;
	    String line1;
	    String line2;
	    int i=1;
		int i1=0;
		BufferedReader in1 = new BufferedReader(new FileReader("question.txt"));
		PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("question_out.txt")));
		BufferedReader in2 = new BufferedReader(new FileReader("answer.txt"));
		PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("answer_out.txt")));
		BufferedReader in3 = new BufferedReader(new FileReader("f_answer.txt"));
		PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter("f_answer_out.txt")));
		while((line=in1.readLine())!=null&&(line2=in3.readLine())!=null){
			if(i!=modifyLine){
				out1.println(line);
				out3.println(line2);
			}
			else{
				out1.println(q);
				out3.println(a);
			}
			i++;
		}
		in1.close();
		out1.close();
		in3.close();
		out3.close();
		while((line1=in2.readLine())!=null){
			System.out.println(modifyLine);
			if(i1==modifyLine*4)
				out2.println(a1);
			else if(i1==modifyLine*4+1)
				out2.println(a2);
			else if(i1==modifyLine*4+2)
				out2.println(a3);
			else if(i1==modifyLine*4+3)
				out2.println(a4);
			else
				out2.println(line1);
			i1++;
		}
		in2.close();
		out2.close();
	}
	private void Change() throws IOException{
	    BufferedReader in=new BufferedReader(new FileReader("question_out.txt"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("question.txt")));
	    String line;
	    while((line=in.readLine())!=null){
	    	out.println(line);
	    }
	    in.close();
	    out.close();
	    BufferedReader in1=new BufferedReader(new FileReader("answer_out.txt"));
	    PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("answer.txt")));
	    while((line=in1.readLine())!=null){
	    	out1.println(line);
	    }
	    in1.close();
	    out1.close();
	    BufferedReader in2=new BufferedReader(new FileReader("f_answer_out.txt"));
	    PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("f_answer.txt")));
	    while((line=in2.readLine())!=null){
	    	out2.println(line);
	    }
	    in2.close();
	    out2.close();
	}
}
