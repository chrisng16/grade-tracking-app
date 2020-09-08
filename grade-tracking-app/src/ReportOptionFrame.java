import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ReportOptionFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6073456994621360254L;
	private JPanel contentPane;
	private MainFrame main;
	private JComboBox<String> comboBoxReportType;

	public ReportOptionFrame(MainFrame m) {
		super("Report Options");
		main = m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 90);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblChooseReportType = new JLabel("Choose report type: ");
		lblChooseReportType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblChooseReportType);
		
		String[] reportOptions = main.manage().getSubjectNames();
		
		comboBoxReportType = new JComboBox<String>(reportOptions);
		comboBoxReportType.addItem("ALL");
		contentPane.add(comboBoxReportType);
		
		JButton btnSubmit = new JButton("Submit");
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(this);;
	}
	
	public void actionPerformed(ActionEvent e) {
		String report = "";
		String reportType = comboBoxReportType.getSelectedItem().toString();
		try {
			report = main.manage().getReport(reportType);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		main.getTextReport().setText(report);
		this.dispose();
	}


}
