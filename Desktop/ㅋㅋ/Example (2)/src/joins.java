import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.*;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class joins extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField PW;
	private JTextField identifyPW;
	private JTextField nickname;
	
	private static boolean id;
	private static boolean Nickname;

	/**
	 * Launch the application.
	 */
	public static void nn(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					joins frame = new joins();
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
	public joins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 422, 221);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ID = new JTextField();
		ID.setBounds(99, 30, 216, 21);
		panel.add(ID);
		ID.setColumns(10);
		
		PW = new JTextField();
		PW.setBounds(99, 63, 216, 21);
		panel.add(PW);
		PW.setColumns(10);
		
		identifyPW = new JTextField();
		identifyPW.setBounds(99, 94, 216, 21);
		panel.add(identifyPW);
		identifyPW.setColumns(10);
		
		nickname = new JTextField();
		nickname.setBounds(99, 125, 216, 21);
		panel.add(nickname);
		nickname.setColumns(10);
		
		JButton identifyID = new JButton("\uC911\uBCF5\uD655\uC778");
		identifyID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id=true;
				File a =  new File("out.txt");
				try {
					FileReader fileReader = new FileReader(a);
					BufferedReader reader = new BufferedReader(fileReader);
					String line = null;
					
					while((line = reader.readLine()) != null){
						String info[] = line.split(" ");
						if(ID.getText().equals(info[0])){
							JOptionPane.showMessageDialog(null, "id가 중복됩니다.");
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		identifyID.setBounds(327, 30, 89, 23);
		panel.add(identifyID);
		
		JButton identifyNick = new JButton("\uC911\uBCF5\uD655\uC778");
		identifyNick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Nickname=true;
				File a =  new File("out.txt");
				try {
					FileReader fileReader = new FileReader(a);
					BufferedReader reader = new BufferedReader(fileReader);
					String line = null;
					
					while((line = reader.readLine()) != null){
						String info[] = line.split(" ");
						if(nickname.getText().equals(info[2])){
							JOptionPane.showMessageDialog(null, "닉네임이 중복됩니다.");
							Nickname=false;
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
		});
		identifyNick.setBounds(327, 125, 89, 23);
		panel.add(identifyNick);
		
		JButton joinbtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(id==false){
					JOptionPane.showMessageDialog(null, "ID 중복확인을 해 주십시오.");
				}
				else{
					int idLength = ID.getText().toString().length();
					for(int i=0; i<idLength; i++){
						char character = ID.getText().toString().charAt(i);
						int ascii = (int)character;
						if(ascii<48){
							JOptionPane.showMessageDialog(null, "ID에 숫자나 문자를 입력해주세요.");
							id=false;
						}
						else if(ascii<58){
							
						}
						else if(ascii<65){
							JOptionPane.showMessageDialog(null, "ID에 숫자나 문자를 입력해주세요.");
							id=false;
						}
						else if(ascii<91){
							
						}
						else if(ascii<97){
							JOptionPane.showMessageDialog(null, "ID에 숫자나 문자를 입력해주세요.");
							id=false;
						}
						else if(ascii>122){
							JOptionPane.showMessageDialog(null, "ID에 숫자나 문자를 입력해주세요.");
							id=false;
						}
					}
					if(PW.getText().equals(identifyPW.getText())==false){
						JOptionPane.showMessageDialog(null, "패스워드의 값이 일치하지 않습니다.");
					}
					else{
						if(Nickname==false){
							JOptionPane.showMessageDialog(null, "닉네임 중복확인을 해 주십시오.");
						}
						else{
							String[] s = new String[3];
							
							s[0] = ID.getText().toString() + " ";
							s[1] = PW.getText().toString() + " ";
							s[2] = nickname.getText().toString() + " ";
							
							try {
								save(s[0],s[1],s[2]);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "회원가입 완료");
							id=false;
							Nickname=false;
						}
					}
				}
			}
		});
		joinbtn.setBounds(211, 175, 116, 36);
		panel.add(joinbtn);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 33, 57, 15);
		panel.add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 66, 57, 15);
		panel.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Password \uD655\uC778");
		lblPassword_1.setBounds(12, 97, 89, 15);
		panel.add(lblPassword_1);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(12, 128, 57, 15);
		panel.add(lblNickname);
	}
	protected static void EXIT_ON_CLOSE() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	public void save(String ID, String PW, String Nickname) throws IOException{
		FileOutputStream out = null;
		out = new FileOutputStream("out.txt", true);
		
		out.write(ID.getBytes());
		out.write(PW.getBytes());
		out.write(Nickname.getBytes());
		out.write(System.getProperty("line.separator").getBytes());
		
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BufferedWriter Filewriter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
