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

//회원가입
//번호 매겨놓을게요. 번호 따라가주세요.
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
		
		//1. ID 중복확인
		JButton identifyID = new JButton("\uC911\uBCF5\uD655\uC778");
		identifyID.addMouseListener(new MouseAdapter() {
			@Override
			//현재 텍스트박스인 ID.getText()와 서버에 있는 사용자들의 ID를 비교하는 부분입니다.
			public void mouseClicked(MouseEvent e) {
				File a =  new File("out.txt");
				try {
					FileReader fileReader = new FileReader(a);
					BufferedReader reader = new BufferedReader(fileReader);
					String line = null;
					
					while((line = reader.readLine()) != null){
						String info[] = line.split(" ");
						//ID 중복
						if(ID.getText().equals(info[0])){
							JOptionPane.showMessageDialog(null, "id가 중복됩니다.");
						}
						//중복이 아니라면 id 중복확인을 했다는 id boolean 변수를 true로 변경시켜줍니다. 
						else
							id=true;
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
		
		//2. Nickname 중복확인
		JButton identifyNick = new JButton("\uC911\uBCF5\uD655\uC778");
		identifyNick.addMouseListener(new MouseAdapter() {
			@Override
			//ID와 마찬가지로 현재 텍스트박스인 Nickname.getText()와 서버의 Nickname 값들을 비교하는 부분입니다.
			public void mouseClicked(MouseEvent e) {
				Nickname=true;
				File a =  new File("out.txt");
				try {
					FileReader fileReader = new FileReader(a);
					BufferedReader reader = new BufferedReader(fileReader);
					String line = null;
					
					while((line = reader.readLine()) != null){
						String info[] = line.split(" ");
						//비교하는 부분
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
		//3. 회원가입 버튼 클릭시
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
						//서버에 회원의 정보를 저장하는 부분입니다.
						else{
							String[] s = new String[3];
							
							s[0] = ID.getText().toString() + " ";
							s[1] = PW.getText().toString() + " ";
							s[2] = nickname.getText().toString() + " ";
							
							try {
								//아래 save 메소드로 가주세요.
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

	//4. 회원 정보 저장
	public void save(String ID, String PW, String Nickname) throws IOException{
		FileOutputStream out = null;
		out = new FileOutputStream("out.txt", true);
		
		//서버에 회원의 ID, PW, Nickname을 저장시켜주세요.
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
