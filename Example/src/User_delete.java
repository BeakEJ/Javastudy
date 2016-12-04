import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class User_delete extends JFrame {
	private JPanel contentPane;
	private JTextField text;
	//private ArrayList<String> lists = new ArrayList<String>();
	private DefaultListModel l = new DefaultListModel();
	private int modifyLine = 0;
	public static boolean i = false;
	public static boolean p = false;

	/**
	 * Launch the application.
	 */
	public static void mai(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_delete frame = new User_delete();
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
	public User_delete() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 65, 410, 186);
		contentPane.add(scrollPane);
		
		
		JLabel lblNewLabel = new JLabel("\uC0AD\uC81C\uD560 \uD68C\uC6D0 ID");
		lblNewLabel.setBounds(12, 24, 95, 15);
		contentPane.add(lblNewLabel);
		
		text = new JTextField();
		text.setBounds(116, 21, 197, 21);
		contentPane.add(text);
		text.setColumns(10);
		
		BufferedReader in=new BufferedReader(new FileReader("out.txt"));
	    String line;
	    int count = 0;
	    
	    /* 서버에 존재하는 모든 사용자의 정보를
	     * 리스트에 출력시켜줍니다.
	     * info[0]은 ID, info[1]은 PW, info[2]은 Nickname입니다.
	     */
	    while((line=in.readLine())!=null){
	    	String info[] = line.split(" ");
	    	l.addElement("ID = " + info[0] + "        PW = " + info[1] + "        Nickname = " + info[2]);
	    }
	    JList<String> list = new JList(l.toArray());
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C\uD558\uAE30");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//삭제버튼 누를시
			public void mouseClicked(MouseEvent e){
				//밑의 confirm, Modify, Change 메소드로 가주세요.
				confirm(text.getText().toString());
				if(i==false){
					JOptionPane.showMessageDialog(null, "입력하신 회원이 존재하지 않습니다.");
				}
				else{
					try {
						Modify();
						Change();
						//리스트에서 사용자를 삭제 not 서버에서 삭제
						l.remove(modifyLine-1);
						list.setModel(l);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "삭제완료");
				}
			}
		});
		btnNewButton.setBounds(325, 20, 97, 23);
		contentPane.add(btnNewButton);
	}
	private void confirm(String id){
		/* 사용자 삭제시 관리자는 텍스트박스에 
		 * 사용자의 ID를 입력하고 확인을 누른 후 삭제합니다.
		 * 여기서 사용자의 ID 가 서버에 없을 경우 i=true로 값을 설정해줍니다.
		 */
		int count = 1;
		File a =  new File("out.txt");
		try {
			FileReader fileReader = new FileReader(a);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			
			while((line = reader.readLine()) != null){
				String info[] = line.split(" ");
				if(id.equals(info[0])==true){
					i=true;
					modifyLine=count;
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
	
	/* 수정하는 메소드 입니다. 만약 수정라인에 도달한다면
	 * 그 줄은 파일입출력을 생략한다. 서버에서 사용자 하나만 삭제하는 기능을
	 * 구현해주세요! 구현이 완료되면 Change 메소드는 함께 삭제 부탁드려요~
	 */
	private void Modify() throws IOException{
	    BufferedReader in=new BufferedReader(new FileReader("out.txt"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out1.txt")));
	    String line;
	    int count=1;
	    while((line=in.readLine())!=null){
	    	if(count!=modifyLine){
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
	    in.close();
	    out.close();
	}
}