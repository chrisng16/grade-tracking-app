import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class AddScoreFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 964092506285051735L;
	private MainFrame main;
	private JTextField textField;
	private ButtonGroup bgroup;
	private JComboBox<String> comboBox;
	private JRadioButton rdbtnQuiz;
	private JRadioButton rdbtnMidterm;
	private JRadioButton rdbtnFinal;
	
	public AddScoreFrame(MainFrame m) {
		super("Add Score");
		setResizable(false);
		getContentPane().setLayout(null);
		main = m;
		// Get subject name array to build JComboBox later
		String[] subjectNames = main.getTrack().getSubjectNames();
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 230, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject.setBounds(12, 13, 86, 24);
		panel.add(lblSubject);
		
		comboBox = new JComboBox<String>(subjectNames);
		comboBox.setBounds(89, 16, 105, 22);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Type", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 73, 101, 119);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnQuiz = new JRadioButton("Quiz");
		rdbtnQuiz.setBounds(8, 23, 85, 25);
		panel_1.add(rdbtnQuiz);
		
		rdbtnMidterm = new JRadioButton("Midterm");
		rdbtnMidterm.setBounds(8, 53, 85, 25);
		panel_1.add(rdbtnMidterm);
		
		rdbtnFinal = new JRadioButton("Final");
		rdbtnFinal.setBounds(8, 83, 85, 25);
		panel_1.add(rdbtnFinal);
		
		bgroup = new ButtonGroup();
		bgroup.add(rdbtnQuiz);
		bgroup.add(rdbtnMidterm);
		bgroup.add(rdbtnFinal);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblScore.setBounds(125, 101, 56, 25);
		getContentPane().add(lblScore);
		
		textField = new JTextField();
		textField.setBounds(168, 102, 74, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(125, 139, 97, 25);
		getContentPane().add(btnSubmit);	
		
		btnSubmit.addActionListener(this);
		textField.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String subjectName=comboBox.getSelectedItem().toString();
		
		String type = "";
		if (rdbtnQuiz.isSelected())
			type="Quiz";
		else if (rdbtnMidterm.isSelected())
			type="Midterm";
		else if (rdbtnFinal.isSelected())
			type="Final";
		try {
			int score = Integer.parseInt(textField.getText());
			
			String report=main.getTrack().addScore(subjectName, type, score);
			if (report == "Error")
				JOptionPane.showMessageDialog(null, "Error: No type was choosen. Please select one type...", "Error", JOptionPane.ERROR_MESSAGE);
			else {	
				main.getTextReport().setText(report);
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Your score must be an integer. Please try again...");
		}
	}
}
