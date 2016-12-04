import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Final extends JFrame {

	private JPanel contentPane;
	private static int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final frame = new Final();
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
	public Final() {
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
		
		
		count = (new Final_c()).r();
		System.out.println(count);
		this.getContentPane().removeAll();
		
		if(count<19){
			this.getContentPane().removeAll();
			this.setContentPane(new Final_mm().getContentPane());
			getContentPane().revalidate();
			getContentPane().repaint();
			
		}
		else{
			getContentPane().invalidate();
			getContentPane().removeAll();
			System.out.println("Á¦¹ß ¹Ù²îÀÚ");
			setContentPane(new Final_ff().getContentPane());
			getContentPane().revalidate();
			getContentPane().repaint();
			//getContentPane().removeAll();
		}
	}
	public static int c(){
		return count;
	}

}
