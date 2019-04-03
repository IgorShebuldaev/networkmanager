import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm {
    public final int WIDTH = 600;
    public final int HEIGHT = 800;

    public void createForm() {
        JFrame frame = new JFrame("Simple NetWorkManager");
        JScrollPane jScrollPane = new JScrollPane();

        creatMenuBar(frame);
        createTabbedPane(frame, jScrollPane);

        frame.setSize(HEIGHT, WIDTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to exit NTM?",
                        "Confirm Exit", JOptionPane.YES_NO_OPTION);

                if(x == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }else{
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    // Private section

    private void creatMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("NTM");

        menuBar.add(menu);

        menu.add(new JMenuItem("Settings"));
        menu.addSeparator();

        menu.add(new JMenuItem("Hide NTM"));
        menu.addSeparator();

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }




    private JScrollPane createTableUsage(JScrollPane jScrollPane) {

        String[] columnNames = {
                "Apps",
                "Hosts",
                "Traffic Type",
        };

        Object[][] data = {
                {null, null, null },
                {null, null, null },
                {null, null, null },
        };

        return new JScrollPane(new JTable(data, columnNames));
    }

    private JScrollPane createTableThings(JScrollPane jScrollPane) {

        String[] columnNames = {
                "Device",
                "Info",
                "First Seen",
        };

        Object[][] data = {
                {null, null, null },
                {null, null, null },
                {null, null, null },
        };

        return new JScrollPane(new JTable(data, columnNames));
    }

    private void createTabbedPane(JFrame frame, JScrollPane jScrollPane){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Graph",  makeTextPanel("void"));
        tabbedPane.addTab("Usage", createTableUsage(jScrollPane));
        tabbedPane.addTab("Things", createTableThings(jScrollPane));

        frame.add(tabbedPane);

    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.add(filler);
        return panel;
    }

}