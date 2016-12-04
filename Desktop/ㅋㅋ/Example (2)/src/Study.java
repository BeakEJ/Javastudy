import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Study extends JFrame {

	private JPanel contentPane;
	private JTextField answer;
	private static boolean Answer;
	private String p[] = new String[5];
	

	/**
	 * Launch the application.
	 */
	public static void mdd(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Study frame = new Study();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static int w;
	public static String One = null;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Study() throws IOException {
		//Education e=new Education();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 128, 131);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel explain = new JLabel("New label");
		explain.setBounds(0, 0, 128, 131);
		panel.add(explain);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 131, 128, 131);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel question = new JLabel("New label");
		question.setBounds(0, 0, 128, 131);
		panel_1.add(question);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(128, 0, 188, 196);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel code = new JLabel("New label");
		code.setBounds(0, 0, 188, 196);
		panel_2.add(code);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(128, 196, 188, 66);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(316, 0, 118, 262);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel result = new JLabel(" ");
		result.setBounds(0, 0, 118, 262);
		panel_4.add(result);
		Identify_A aaa= new Identify_A();
		
		JButton identify = new JButton("\uC0C1\uC138\uD655\uC778");
		identify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aaa.setVisible(true);
				aaa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		identify.setBounds(12, 229, 97, 23);
		panel_4.add(identify);
		
		//String[] p = new String[]{};
		File a = new File("1.txt");
		int aa = 0;
		try {
			FileReader fileReader = new FileReader(a);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			int i=0;
			
			while((line = reader.readLine()) != null) {
				p[i] = line;
				//System.out.println(p[i]);
				i++;
			}
			reader.close();
		}
		 catch(IOException ioe) {
			 ioe.printStackTrace();
			 }
		explain.setText(p[4]);
		question.setText(p[3]);
		code.setText(p[2]);
		
		
		answer = new JTextField();
		answer.setBounds(5, 23, 105, 21);
		panel_3.add(answer);
		answer.setColumns(10);

		Middle m = new Middle();
		//Study s = new Study();
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(answer.getText().equals(p[1])){
					JOptionPane.showMessageDialog(null, "정답입니다!");
					result.setText(p[0]);
					m.setVisible(true);
					m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else
					JOptionPane.showMessageDialog(null, "정답이 아닙니다!");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(118, 16, 66, 34);
		panel_3.add(btnNewButton);
	}
}
