import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// (관리자) 문제관리
public class Question extends JFrame {

	private JPanel contentPane;
	private DefaultListModel l = new DefaultListModel();
	private DefaultListModel l1 = new DefaultListModel();
	private DefaultListModel l2 = new DefaultListModel();
	private DefaultListModel l3 = new DefaultListModel();
	private int modifyLine = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question frame = new Question();
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
	public Question() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 52, 42, 225);
		contentPane.add(scrollPane);
		
		BufferedReader in=new BufferedReader(new FileReader("number.txt"));
	    String line;
		
	    //각각의 문제번호, 문제, 문제답, 최종답 리스트에 서버에 존재하는 모든 값들을 출력시켜줍니다.
		while((line=in.readLine())!=null){
			//서버에 존재하는 모든 문제 번호를 출력
	    	l.addElement(line);
	    	l.addElement(" ");
	    	l.addElement(" ");
	    	l.addElement(" ");
	    }
		in.close();
		
		JList n_list = new JList(l.toArray());
		scrollPane.setViewportView(n_list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 52, 148, 225);
		contentPane.add(scrollPane_1);
		
		BufferedReader in1=new BufferedReader(new FileReader("question.txt"));
	    String line1;
		
		while((line1=in1.readLine())!=null){
	    	//서버에 존재하는 모든 문제를 출력
	    	l1.addElement(line1);
	    	l1.addElement(" ");
	    	l1.addElement(" ");
	    	l1.addElement(" ");
	    }
		in1.close();
		
		JList q_list = new JList(l1.toArray());
		scrollPane_1.setViewportView(q_list);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(189, 52, 148, 225);
		contentPane.add(scrollPane_2);
		
		BufferedReader in2=new BufferedReader(new FileReader("answer.txt"));
	    String line2 = null;
		
		while((line2=in2.readLine())!=null){
	    	//서버에 존재하는 모든 문제의 답4개를 출력
	    	l2.addElement(line2); 	
	    }
		in2.close();
		
		JList a_list = new JList(l2.toArray());
		scrollPane_2.setViewportView(a_list);
		
		BufferedReader in3=new BufferedReader(new FileReader("f_answer.txt"));
	    String line3 = null;
		
		while((line3=in3.readLine())!=null){
	    	//서버에 존재하는 모든 최종답을 출력
	    	l3.addElement(line3);
	    	l3.addElement(" ");
	    	l3.addElement(" ");
	    	l3.addElement(" ");
	    }
		in3.close();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(337, 52, 42, 225);
		contentPane.add(scrollPane_3);
		
		JList f_list = new JList(l3.toArray());
		scrollPane_3.setViewportView(f_list);
		
		JButton add = new JButton("\uCD94\uAC00");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Question_add a;
				try {
					a = new Question_add();
					a.setVisible(true);
					a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		add.setBounds(391, 52, 67, 50);
		contentPane.add(add);
		
		JButton modify = new JButton("\uC218\uC815");
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Question_modify m = new Question_modify();
				m.setVisible(true);
				m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		modify.setBounds(391, 135, 67, 50);
		contentPane.add(modify);
		
		JButton delete = new JButton("\uC0AD\uC81C");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Question_remove q = new Question_remove();
				q.setVisible(true);
				q.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		delete.setBounds(391, 221, 67, 50);
		contentPane.add(delete);
		
		JButton f5 = new JButton("\uB9AC\uC2A4\uD2B8 \uC0C8\uB85C\uACE0\uCE68");
		f5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*문제를 추가, 삭제, 수정 후 문제리스트 새로고침
				 * 위와 같이 해주시면 됩니다.
				 * 리스트 새로고침입니다.
				 */
				BufferedReader in;
				try {
					in = new BufferedReader(new FileReader("number.txt"));
					String line;
					
					while((line=in.readLine())!=null){
				    	//String info[] = line.split("\r\n");
				    	l.addElement(line);
				    	l.addElement(" ");
				    	l.addElement(" ");
				    	l.addElement(" ");
				    	System.out.println(line);
				    }
					in.close();
					n_list.setModel(l);
					
					BufferedReader in1=new BufferedReader(new FileReader("question.txt"));
				    String line1;
					
					while((line1=in1.readLine())!=null){
				    	//String info[] = line.split("\r\n");
				    	l1.addElement(line1);
				    	l1.addElement(" ");
				    	l1.addElement(" ");
				    	l1.addElement(" ");
				    }
					in1.close();
					q_list.setModel(l1);
					
					BufferedReader in2=new BufferedReader(new FileReader("answer.txt"));
				    String line2 = null;
					
					while((line2=in2.readLine())!=null){
				    	//String info[] = line.split("\r\n");
				    	l2.addElement(line2); 	
				    }
					in2.close();
					a_list.setModel(l2);
					
					BufferedReader in3=new BufferedReader(new FileReader("f_answer.txt"));
				    String line3 = null;
					
					while((line3=in3.readLine())!=null){
				    	//String info[] = line.split("\r\n");
				    	l3.addElement(line3);
				    	l3.addElement(" ");
				    	l3.addElement(" ");
				    	l3.addElement(" ");
				    }
					in3.close();
					f_list.setModel(l3);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		f5.setBounds(259, 10, 178, 23);
		contentPane.add(f5);
	}
	
	public void addd(String q, String a1, String a2, String a3, String a4, int ans) throws IOException{
		//문제추가 클래스에서 사용되는 메소드
		/* q = 문제, a1~4 = 정답, ans = 최종답
		 * 문제 번호에는 서버에 있는 마지막 문제번호에서 카운트를시켜주시고 저장시켜주세요
		 * 그리고 각각의 문제, 정답, 최종답은 위에 보이시는 변수를 넣어주면 됩니다.
		 * 이 변수는 Question_add 에서 메소드 호출시에 초기값이 설정됩니다. 
		 */
		int n = 0;
		FileOutputStream out = null;
		FileOutputStream out1 = null;
		FileOutputStream out2 = null;
		FileOutputStream out3 = null;
		out = new FileOutputStream("number.txt", true);
		out1 = new FileOutputStream("question.txt", true);
		out2 = new FileOutputStream("answer.txt", true);
		out3 = new FileOutputStream("f_answer.txt", true);
		
		int um=0;
		BufferedReader in = new BufferedReader(new FileReader("number.txt"));
		String line;
		
		while((line=in.readLine())!=null){
	    	//String info[] = line.split("\r\n");
	    	um++;
	    }
		n = um+1;
		in.close();
		System.out.println(n);
		String a = Integer.toString(n);
		String b = Integer.toString(ans);
		out.write(a.getBytes());
		out.write(System.getProperty("line.separator").getBytes());
		out1.write(q.getBytes());
		out1.write(System.getProperty("line.separator").getBytes());
		out2.write(a1.getBytes());
		out2.write(System.getProperty("line.separator").getBytes());
		out2.write(a2.getBytes());
		out2.write(System.getProperty("line.separator").getBytes());
		out2.write(a3.getBytes());
		out2.write(System.getProperty("line.separator").getBytes());
		out2.write(a4.getBytes());
		out2.write(System.getProperty("line.separator").getBytes());
		out3.write(b.getBytes());
		out3.write(System.getProperty("line.separator").getBytes());
		
		try {
			out.close();
			out1.close();
			out2.close();
			out3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
