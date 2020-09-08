import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame implements ActionListener {
	
    private static final long serialVersionUID = -2124245560246536286L;
    private JButton btnAddSubject;
    private JButton btnAddScore;
    private JButton btnReport;
    private Managing manage;
    private AddSubjectFrame addSubject;
    private AddScoreFrame addScore;
    private ReportOptionFrame reportOption;
    private JTextArea textReport;
    
    public MainFrame(){
    	super("Grade Tracking");
    	manage = new Managing();
    	setBounds(0,0,500,500);
        getContentPane().setLayout(null);   
    	
        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        titlePanel.setBounds(12, 0, 458, 45);
        getContentPane().add(titlePanel);
        titlePanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel title = new JLabel("Grade Tracking App");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.PLAIN, 22));
        titlePanel.add(title);
        
        JPanel funcPanel = new JPanel();
        funcPanel.setBounds(297, 58, 185, 395);
        getContentPane().add(funcPanel);
        funcPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        btnAddSubject = new JButton("Add Subject");
        funcPanel.add(btnAddSubject);
        
        btnAddScore = new JButton("Add Score");
        funcPanel.add(btnAddScore);
        
        btnReport = new JButton("Report");
        funcPanel.add(btnReport);
        
        JScrollPane ReportPanel = new JScrollPane();
        ReportPanel.setViewportBorder(new TitledBorder(null, "Report", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        ReportPanel.setBounds(0, 58, 298, 395);
        getContentPane().add(ReportPanel);
        
        textReport = new JTextArea();
        textReport.setLineWrap(true);
        textReport.setEditable(false);
        textReport.setWrapStyleWord(true);
        ReportPanel.setViewportView(textReport);
        
        btnAddSubject.addActionListener(this);
        btnAddScore.addActionListener(this);
        btnReport.addActionListener(this);

    }

	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==btnAddSubject) {
    		addSubject = new AddSubjectFrame(this);
            addSubject.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addSubject.setLocationRelativeTo(null);
            addSubject.setSize(400,220);
    		addSubject.setVisible(true);
    	}
    	else if (e.getSource()==btnAddScore) {
    		addScore = new AddScoreFrame(this);
            addScore.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            addScore.setLocationRelativeTo(null);
            addScore.setSize(260,240);
    		addScore.setVisible(true);
    	}
    	else if (e.getSource()==btnReport) {
    		reportOption = new ReportOptionFrame(this);
    		reportOption.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    		reportOption.setLocationRelativeTo(null);
    		reportOption.setSize(400,95);
    		reportOption.setResizable(false);
    		reportOption.setVisible(true);
    	}
    }
    public JTextArea getTextReport() {
    	return this.textReport;
    }
    public Managing manage() {
    	return this.manage;
    }
}