import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class AddSubjectFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2711660143195357917L;
	private MainFrame main;
	private JTextField textObject;
	private JTextField txtMidtermPercent;
	private JTextField txtQuizPercent;
	private JTextField txtFinalPercent;
	
	public AddSubjectFrame(MainFrame m) {
		super("Add Subject");
		
		main = m;
		getContentPane().setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 1, 382, 42);
		getContentPane().add(titlePanel);
		titlePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEnterTheSubject = new JLabel("Enter the subject you want to add");
		lblEnterTheSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterTheSubject.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblEnterTheSubject);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 382, 42);
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
		
		JPanel percentageInputPanel = new JPanel();
		percentageInputPanel.setBounds(0, 85, 382, 87);
		getContentPane().add(percentageInputPanel);
		percentageInputPanel.setLayout(null);
		
		JLabel lblPercentage = new JLabel("Percentage:");
		lblPercentage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPercentage.setBounds(12, 0, 76, 24);
		percentageInputPanel.add(lblPercentage);
		
		JLabel lblQuizzes = new JLabel("Quizzes:");
		lblQuizzes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuizzes.setBounds(100, 2, 76, 24);
		percentageInputPanel.add(lblQuizzes);
		
		JLabel lblMidterms = new JLabel("Midterms:");
		lblMidterms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMidterms.setBounds(100, 28, 76, 24);
		percentageInputPanel.add(lblMidterms);
		
		JLabel lblFinal = new JLabel("Final:");
		lblFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinal.setBounds(100, 54, 76, 24);
		percentageInputPanel.add(lblFinal);
		
		txtMidtermPercent = new JTextField();
		txtMidtermPercent.setBounds(163, 29, 116, 22);
		percentageInputPanel.add(txtMidtermPercent);
		txtMidtermPercent.setColumns(10);
		
		txtQuizPercent = new JTextField();
		txtQuizPercent.setBounds(163, 2, 116, 22);
		percentageInputPanel.add(txtQuizPercent);
		txtQuizPercent.setColumns(10);
		
		txtFinalPercent = new JTextField();
		txtFinalPercent.setBounds(163, 56, 116, 22);
		percentageInputPanel.add(txtFinalPercent);
		txtFinalPercent.setColumns(10);
		
		btnSubmit.addActionListener(this);
		textObject.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Tracking manage = main.getTrack();
		try {
			String objectName = StringUtils.capitalize(textObject.getText());
			int quizPercent = Integer.parseInt(txtQuizPercent.getText());
			int midtermPercent = Integer.parseInt(txtMidtermPercent.getText());
			int finalPercent = Integer.parseInt(txtFinalPercent.getText());
			
	
			if (quizPercent+midtermPercent+finalPercent != 100)
				JOptionPane.showMessageDialog(null, "The input percentages do NOT add up to 100%. Please try again...");
			else {
				if (!manage.isInSubjectNameArray(objectName)) {
					String report = manage.addSubject(new Subject(objectName,quizPercent,midtermPercent,finalPercent));
					main.getTextReport().setText(report);
					setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, objectName+" is already on the list.","Error",JOptionPane.ERROR_MESSAGE);	
			}
		} catch (Exception event) {
			JOptionPane.showMessageDialog(null, "Invalid input! Please try again...");
		}
	}
}
