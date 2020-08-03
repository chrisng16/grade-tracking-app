import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                MainFrame main = new MainFrame();
                main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                main.setSize(500,500);
                main.setLocationRelativeTo(null);
                main.setVisible(true);
                
                main.addWindowListener(new WindowAdapter() {
                	public void windowClosing(WindowEvent e) {
                		CloseFrame close = new CloseFrame(main);
                		close.setSize(455,105);
                		close.setLocationRelativeTo(null);
                		close.setVisible(true);
                	}
                });
            }

        });
    }
}
