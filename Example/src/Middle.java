import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;

public class Middle extends JFrame {

	private JPanel contentPane;
	private int clickx=0;
	private int clicky=0;
	private int o1 = 0;
	private int[] o = new int[3];

	/**
	 * Launch the application.
	 */
	public static void min(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Middle frame = new Middle();
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
	public Middle() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 448, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String c = new String();

		/*서버에 저장된 모든 중간평가의 문제-정답 쌍을
		 * 배열에 저장시켜 주세요.
		 * 예를 들어 a[n] q[n] 값에 각각을 저장시켜 주시면 감사하겠습니다.
		 */
		File a =  new File("text.txt");
		try {
			FileReader fileReader = new FileReader(a);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			//String add = null;
			
			while((line = reader.readLine()) != null){
				c = c+line;
			}
			reader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		String info[] = c.split(" ");
		/* o1은 서버에 저장된 문제와 정답 값의 총 갯수입니다.
		 * 만약에 문제 정답 쌍을 각 챕터마다 일정 숫자로 뒀다면
		 * o1을 상수로 넣어주세요.
		 * 예를들어 서버에 5쌍이 있다면 o1=5 만 넣어주십시오!!
		 */
		o1=info.length;
		o1=o1/2;
		
		int[] ran = new int[3];
		int[] ran_1 = new int[3]; 
		
		Random rand = new Random();
		for(int i=0; i<3; i++){
			ran[i] = rand.nextInt(o1);
			ran_1[i] = rand.nextInt(3);
			for(int j=0; j<i; j++){
				if(ran[i]==ran[j]&i!=j){
					ran[i]=rand.nextInt(o1);
					i--;
					break;
				}
				if(ran_1[i]==ran_1[j]&i!=j){
					ran_1[i] = rand.nextInt(3);
					i--;
					break;
				}
			}
		}
		
		JLabel three = new JLabel("New label");
		three.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(e.getSource()==three){
					JComponent jc= (JComponent)e.getSource();
					jc.setLocation(jc.getX()+e.getX()-clickx, jc.getY()+e.getY()-clicky);
				}
			}
		});
		three.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()==three){
					if(o[2]>0)
						o[2]--;
					clickx=e.getX();
					clicky=e.getY();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				clickx=three.getX();
				clicky=three.getY();
				
				if(clickx<150&clicky<142){
					if(three.getText()==info[ran[0]+o1]){
						o[2]++;
					}
				}
				else if(clickx<300&clicky<142){
					if(three.getText()==info[ran[1]+o1]){
						o[2]++;
					}
				}
				else{
					if(three.getText()==info[ran[2]+o1]){
						o[2]++;
					}
				}
			}
		});
		three.setBounds(345, 190, 57, 15);
		panel.add(three);
		
		JLabel two = new JLabel("New label");
		two.setBounds(195, 190, 57, 15);
		panel.add(two);
		
		JLabel one = new JLabel("New label");
		one.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(e.getSource()==one){
					JComponent jc= (JComponent)e.getSource();
					jc.setLocation(jc.getX()+e.getX()-clickx, jc.getY()+e.getY()-clicky);
				}
			}
		});
		one.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()==one){
					if(o[0]>0)
						o[0]--;
					clickx=e.getX();
					clicky=e.getY();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				clickx=one.getX();
				clicky=one.getY();
				
				if(clickx<150&clicky<142){
					if(one.getText()==info[ran[0]+o1]){
						o[0]++;
					}
				}
				else if(clickx<300&clicky<142){
					if(one.getText()==info[ran[1]+o1]){
						o[0]++;
					}
				}
				else{
					if(one.getText()==info[ran[2]+o1]){
						o[0]++;
					}
				}
			}
		});
		one.setBounds(45, 190, 57, 15);
		panel.add(one);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 150, 261);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 150, 142);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel one_1 = new JLabel("New label");
		one_1.setBounds(45, 60, 57, 15);
		panel_4.add(one_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(150, 0, 150, 261);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 150, 142);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel two_ = new JLabel("New label");
		two.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(e.getSource()==two){
					JComponent jc= (JComponent)e.getSource();
					jc.setLocation(jc.getX()+e.getX()-clickx, jc.getY()+e.getY()-clicky);
				}
			}
		});
		two.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()==two){
					if(o[1]>0)
						o[1]--;
					clickx=e.getX();
					clicky=e.getY();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				clickx=two.getX();
				clicky=two.getY();
				
				if(clickx<150&clicky<142){
					if(two.getText()==info[ran[0]+o1]){
						o[1]++;
					}
				}
				else if(clickx<300&clicky<142){
					if(two.getText()==info[ran[1]+o1]){
						o[1]++;
					}
				}
				else{
					if(two.getText()==info[ran[2]+o1]){
						o[1]++;
					}
				}
			}
		});
		two_.setBounds(45, 60, 57, 15);
		panel_5.add(two_);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(300, 0, 150, 261);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 150, 142);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel three_1 = new JLabel("New label");
		three_1.setBounds(45, 60, 57, 15);
		panel_6.add(three_1);
		
		/* a[ran[0]] 이런식으로
		 * 앞에서 서버에서 가져온 답 배열을 
		 * 랜덤으로 라벨에 String 값을 넣어줍니다!
		 */
		one_1.setText(info[ran[0]]);
		two_.setText(info[ran[1]]);
		three_1.setText(info[ran[2]]);
		Identify_Middle e1 = new Identify_Middle();
		
		JButton identify_Middle = new JButton("\uC815\uB2F5 \uD655\uC778");
		identify_Middle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((o[1]+o[2]+o[0])==3){
					JOptionPane.showMessageDialog(null, "정답입니다!!");
					e1.setVisible(true);
					e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else
					JOptionPane.showMessageDialog(null, "다시 문제를 풀어보세요!");
			}
		});
		identify_Middle.setBounds(41, 228, 97, 23);
		panel_3.add(identify_Middle);
		
		/* 마찬가지로 q[ran[0]] 이런식으로
		 * 앞에서 서버에서 가져온 답 배열을 
		 * 랜덤으로 라벨에 String 값을 넣어줍니다!
		 * 여기에 있는 ran_1의 배열은 무시해주세요. 코드 고치면 ran_1랜덤으로 돌리는 코드는
		 * 지워야합니당!!
		 */
		one.setText(info[ran[ran_1[0]]+o1]);
		two.setText(info[ran[ran_1[1]]+o1]);
		three.setText(info[ran[ran_1[2]]+o1]);
	}
}
