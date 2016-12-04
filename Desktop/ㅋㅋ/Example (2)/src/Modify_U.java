import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Modify_U extends JFrame {

	private JPanel contentPane;
	private JTextField PW;
	private JTextField PW_C;
	private JTextField Nick;
	private JTextField id;
	private JTextField pw;
	public static boolean i = false;
	public static boolean p = false;
	private static String id_ = null;
	private static String pw_ = null;
	private static int modifyLine=0;
	private static boolean Nickname = false;

	/**
	 * Launch the application.
	 */
	public static void man(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify_U frame = new Modify_U();
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
	public Modify_U() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 25, 359, 164);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		id = new JTextField();
		id.setBounds(49, 47, 185, 21);
		panel_1.add(id);
		id.setColumns(10);
		
		pw = new JTextField();
		pw.setBounds(49, 92, 185, 21);
		panel_1.add(pw);
		pw.setColumns(10);
		
		JButton r_login = new JButton("\uD655\uC778");
		r_login.setBounds(251, 47, 70, 66);
		panel_1.add(r_login);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uD655\uC778\uC744 \uC704\uD574 \uC7AC\uB85C\uADF8\uC778\uC744 \uD574\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(60, 10, 249, 15);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 422, 221);
		contentPane.add(panel);
		panel.setVisible(false);
		
		PW = new JTextField();
		PW.setColumns(10);
		PW.setBounds(99, 52, 216, 21);
		panel.add(PW);
		
		PW_C = new JTextField();
		PW_C.setColumns(10);
		PW_C.setBounds(99, 83, 216, 21);
		panel.add(PW_C);
		
		Nick = new JTextField();
		Nick.setColumns(10);
		Nick.setBounds(99, 114, 216, 21);
		panel.add(Nick);
		
		JButton button_1 = new JButton("\uC911\uBCF5\uD655\uC778");
		button_1.addMouseListener(new MouseAdapter() {
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
						if(Nick.getText().equals(info[2])){
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
		button_1.setBounds(327, 114, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\uC218\uC815");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Nickname==false){
					JOptionPane.showMessageDialog(null, "닉네임 중복확인을 해 주십시오.");
				}
				else{
					if(PW.getText().equals(PW_C.getText())){
						try {
							Modify(PW.getText().toString(), Nick.getText().toString());
							Change();
							JOptionPane.showMessageDialog(null, "수정완료");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "비밀번호 확인을 해 주십시오.");
				}
			}
		});
		button_2.setBounds(211, 175, 116, 36);
		panel.add(button_2);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(12, 55, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Password \uD655\uC778");
		label_2.setBounds(12, 86, 89, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Nickname");
		label_3.setBounds(12, 117, 57, 15);
		panel.add(label_3);
		
		r_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				confirm(id.getText().toString(), pw.getText().toString());
				if(i==true){
					if(p==true){
						id_ = id.getText().toString();
						pw_ = pw.getText().toString();
						panel_1.setVisible(false);
						panel.setVisible(true);
					}
				}
			}
		});
	}
	private void confirm(String id, String pw){
		int count = 1;
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
						modifyLine = count;
					}
				}
				count++;
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
	private void Modify(String pw, String nickname) throws IOException{
		
	    BufferedReader in=new BufferedReader(new FileReader("out.txt"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out1.txt")));
	    String line;
	    int count=1;
	    while((line=in.readLine())!=null){
	    	if(count==modifyLine){
	    		out.println(line.replace(line, id_ + " " +pw + " " + nickname));
	    	}
	    	else{
	    		out.println(line);
	    	}
	            count++;
	    }
	    in.close();
	    out.close();
	}
	private void Change() throws IOException{
		
	    BufferedReader in=new BufferedReader(new FileReader("out1.txt"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
	    String line;
	    while((line=in.readLine())!=null){
	    	out.println(line);
	    }

	    File file=new File("out1.txt"); //원본파일부르기
	    file.renameTo(new File("out.txt")); //파일이름변경
	    in.close();
	    out.close();
	}
}
