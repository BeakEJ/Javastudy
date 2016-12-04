import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Identify_A extends JFrame {

	private JPanel contentPane;
	private Image img;
	private JLabel ImgBox;

	/**
	 * Launch the application.
	 */
	public static void min(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identify_A frame = new Identify_A();
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
	public Identify_A() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Middle aaa= new Middle();
		
		JButton id = new JButton("\uC644\uB8CC");
		id.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aaa.setVisible(true);
				aaa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		id.setBounds(325, 228, 97, 23);
		contentPane.add(id);
		
		//컴파일시 이미지 서버에서 불러와 주세요
		JLabel lb = new JLabel("");
		//그 이미지 쓰는 부분입니다.
		lb.setIcon(new ImageIcon("별.jpg"));
		lb.setBounds(0, 0, 434, 261);
		contentPane.add(lb);
		
		
	}

}
