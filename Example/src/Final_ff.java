import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Final_ff extends Final_level {
	private static int count;
	/**
	 * Create the panel.
	 */
	public Final_ff() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("\uBB38\uC81C \uBC88\uD638");
		label.setBounds(12, 10, 57, 15);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 28, 409, 177);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("\uBB38\uC81C \uB0B4\uC6A9");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 5, 409, 51);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("1. \uB0B4\uC6A9");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 66, 409, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("2. \uB0B4\uC6A9");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(0, 91, 409, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("3. \uB0B4\uC6A9");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 116, 409, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("4. \uB0B4\uC6A9");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 141, 409, 15);
		panel_1.add(label_5);
		
		JButton button = new JButton("1\uBC88");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button.setVisible(false);
			}
		});
		button.setBounds(44, 215, 69, 35);
		panel.add(button);
		
		JButton button_1 = new JButton("2\uBC88");
		button_1.setBounds(134, 215, 69, 35);
		panel.add(button_1);
		
		JButton button_2 = new JButton("3\uBC88");
		button_2.setBounds(226, 215, 69, 35);
		panel.add(button_2);
		
		JButton button_3 = new JButton("4\uBC88");
		button_3.setBounds(318, 215, 69, 35);
		panel.add(button_3);

	}

}
