import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CloseFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = -8608126710833597159L;
	private MainFrame main;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnSaveExit;
	public CloseFrame(MainFrame m) {
		super("Warning");
		main = m;
		
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel lblYourDataIs = new JLabel("Your data is not saved. Would you like to continue to exit?");
		lblYourDataIs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblYourDataIs);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(75, 0, 97, 25);
		panel_1.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(316, 0, 97, 25);
		panel_1.add(btnCancel);
		
		btnSaveExit = new JButton("Save & Exit");
		btnSaveExit.setBounds(184, 0, 120, 25);
		panel_1.add(btnSaveExit);
		
		btnCancel.addActionListener(this);
		btnSaveExit.addActionListener(this);
		btnOk.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk) {
			dispose();
			main.dispose();
		}
		else if (e.getSource()==btnSaveExit) {
			main.getTrack().saveData();
			dispose();
			main.dispose();
		}
		else if (e.getSource()==btnCancel) {
			dispose();
			main.setVisible(true);
		}
	}
}
