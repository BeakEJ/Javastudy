import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Study_m extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Study_m() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 128, 262);
		panel.add(panel_1);
		
		JLabel label = new JLabel((String) null);
		label.setBounds(0, 0, 128, 262);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(128, 0, 188, 196);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setBounds(0, 0, 188, 196);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(128, 196, 188, 66);
		panel.add(panel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(5, 23, 105, 21);
		panel_3.add(textField);
		
		JButton button = new JButton("\uD655\uC778");
		button.setBounds(118, 16, 66, 34);
		panel_3.add(button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(316, 0, 118, 262);
		panel.add(panel_4);
		
		JLabel label_2 = new JLabel(" ");
		label_2.setBounds(0, 0, 118, 262);
		panel_4.add(label_2);
		
		JButton button_2 = new JButton("\uB2E4\uC74C\uC73C\uB85C");
		button_2.setBounds(12, 229, 97, 23);
		panel_4.add(button_2);

	}
}
