import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Education extends JFrame {

	private JPanel contentPane;
	private int[] a = new int[]{0,0,0,0,0};

	/**
	 * Launch the application.
	 */
	public static void md(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Education frame = new Education();
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
	public Education() throws IOException {
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
		
		JButton chap1 = new JButton("Chapter 1");
		chap1.setBounds(12, 81, 124, 41);
		panel.add(chap1);
		
		JButton chap2 = new JButton("Chapter 2");
		chap2.setBounds(152, 81, 124, 41);
		panel.add(chap2);
		
		JButton chap3 = new JButton("Chapter 3");
		chap3.setBounds(296, 81, 126, 41);
		panel.add(chap3);
		
		JButton chap4 = new JButton("Chapter 4");
		chap4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		chap4.setBounds(85, 145, 124, 39);
		panel.add(chap4);
		
		JButton chap5 = new JButton("Chapter 5");
		chap5.setBounds(233, 145, 133, 39);
		panel.add(chap5);
		
		JButton back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chap1.setText("Chapter 1");
				chap2.setText("Chapter 2");
				chap3.setText("Chapter 3");
				chap4.setText("Chapter 4");
				chap5.setText("Chapter 5");
				for(int i=0; i<5; i++){
					a[i]=0;
				}
			}
		});
		back.setBounds(260, 228, 162, 23);
		panel.add(back);
		
		chap1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(a[0]==0){
				//s.setVisible(true);
				//s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					chap1.setText("1. 변수란");
					chap2.setText("2. 정수형 변수");
					chap3.setText("3. 실수형 변수");
					chap4.setText("4. 문자형  변수");
					chap5.setText("5. 기타 변수타입");
					for(int i=0; i<5; i++){
						a[i]++;
					}
				} else
					try {
						set();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		chap2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(a[1]==0){
					chap1.setText("1. 조건문");
					chap2.setText("2. ");
					chap3.setText("3. ");
					chap4.setText("4. ");
					chap5.setText("5. ");
					for(int i=0; i<5; i++){
						a[i]++;
					}
				} else
					try {
						set();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		chap3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(a[2]==0){
					chap1.setText("1. 반복문");
					chap2.setText("2. ");
					chap3.setText("3. ");
					chap4.setText("4. ");
					chap5.setText("5. ");
					for(int i=0; i<5; i++){
						a[i]++;
					}
				} else
					try {
						set();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		chap4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(a[3]==0){
					chap1.setText("1. 클래스");
					chap2.setText("2. ");
					chap3.setText("3. ");
					chap4.setText("4. ");
					chap5.setText("5. ");
					for(int i=0; i<5; i++){
						a[i]++;
					}
				} else
					try {
						set();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		chap5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(a[4]==0){
					chap1.setText("1. 객체지향");
					chap2.setText("2. ");
					chap3.setText("3. ");
					chap4.setText("4. ");
					chap5.setText("5. ");
					for(int i=0; i<5; i++){
						a[i]++;
					}
				} else
					try {
						set();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
	}
	public void set() throws IOException{
		Study s = new Study();
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.getContentPane().disable();
	}
}
