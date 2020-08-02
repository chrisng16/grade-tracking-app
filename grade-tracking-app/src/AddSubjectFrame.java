import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class AddSubjectFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2711660143195357917L;
	private MainFrame main;
	private JTextField textObject;
	
	public AddSubjectFrame(MainFrame m) {
		super("Add Subject");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		main = m;
		
		JPanel titlePanel = new JPanel();
		getContentPane().add(titlePanel);
		titlePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEnterTheSubject = new JLabel("Enter the subject you want to add");
		lblEnterTheSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterTheSubject.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblEnterTheSubject);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblSubject);
		
		textObject = new JTextField();
		panel_1.add(textObject);
		textObject.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		panel_1.add(btnSubmit);
		
		btnSubmit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		main.getTrack().addSubject(new Subject(textObject.getText()));
		
		setVisible(false);
	}
}
