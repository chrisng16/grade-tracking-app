import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                MainFrame main = new MainFrame();
                main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                main.setSize(500,500);
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }
}
