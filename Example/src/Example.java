import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Example extends JFrame {

	private JPanel contentPane;
	private JTextField IDtext;
	private JTextField PWtext;
	private JTextField text;
	public static boolean i = false;
	public static boolean p = false;
	public static boolean m = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example frame = new Example();
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
	public Example() throws IOException {
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
		
		IDtext = new JTextField();
		IDtext.setBounds(94, 92, 228, 26);
		panel.add(IDtext);
		IDtext.setColumns(10);
		
		PWtext = new JTextField();
		PWtext.setBounds(94, 133, 228, 26);
		panel.add(PWtext);
		PWtext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("I D");
		lblNewLabel.setFont(new Font("1훈점보맘보 B", Font.PLAIN, 21));
		lblNewLabel.setBounds(47, 96, 42, 22);
		panel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("1훈점보맘보 B", Font.PLAIN, 21));
		lblPw.setBounds(47, 138, 42, 21);
		panel.add(lblPw);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Main e = new Main();
		M_Main e1 = new M_Main();
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				confirm(IDtext.getText().toString(), PWtext.getText().toString());
				if(IDtext.getText().equals("")==true){
					JOptionPane.showMessageDialog(null, "ID를 입력해 주세요!");
				}
				else if(PWtext.getText().equals("")==true){
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요!");
				}
				else{
					text.setText("ID는 " + IDtext.getText() + "  비밀번호는 " + PWtext.getText() + "입니다.");
					if(i==true){
						if(p==false){
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다!");
						}
						else{
							JOptionPane.showMessageDialog(null, "로그인성공!");
							if(m==true){
								e1.setVisible(true);
								e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							}
							else{
								//Main e = new Main();
								e.setVisible(true);
								e.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "ID가 존재하지 않습니다!");
					}
				}
			}
		});
		btnLogin.setBounds(334, 92, 76, 67);
		panel.add(btnLogin);
		
		JButton btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				joins js = new joins();
				js.setVisible(true);
				js.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnJoin.setBounds(237, 212, 173, 39);
		panel.add(btnJoin);
		
		text = new JTextField();
		text.setBounds(0, 0, 434, 21);
		panel.add(text);
		text.setColumns(10);
	}
	private void confirm(String id, String pw){
		File a =  new File("out.txt");
		try {
			FileReader fileReader = new FileReader(a);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			//String info[] = new String[]{null,};
			
			while((line = reader.readLine()) != null){
				String info[] = line.split(" ");
				if(id.equals(info[0])==true){
					i=true;
					if(pw.equals(info[1])==true){
						p=true;
						if(id.equals("egbegb")){
							m=true;
						}
					}
				}
			}
			reader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
