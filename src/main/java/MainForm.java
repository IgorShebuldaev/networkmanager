import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainForm {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private JFrame frame = new JFrame("Simple NetWorkManager");
    private JTable jTableUsage = createTableApps();
    private JTable jTableThings = createTableDevices();

    public void createForm() {

        frame.setJMenuBar(creatMenuBar());
        frame.add(createTabbedPane());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setUpTableData();

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to exit?",
                        "Confirm Exit", JOptionPane.YES_NO_OPTION);

                if(x == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }else{
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    private JMenuBar creatMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("NTM");

        menuBar.add(menu);

        menu.add(new JMenuItem("Settings"));
        menu.addSeparator();

        menu.add(new JMenuItem("Hide NTM"));
        menu.addSeparator();

        menuBar.add(menu);
        return menuBar;
    }

    private JTabbedPane createTabbedPane(){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Graph",  makeTextPanel("void"));
        tabbedPane.addTab("Usage", new JScrollPane(jTableUsage));
        tabbedPane.addTab("Things", new JScrollPane(jTableThings));

        return tabbedPane;
    }

    private JLabel makeTextPanel(String text) {
        JLabel filler = new JLabel(text);

        filler.setHorizontalAlignment(JLabel.CENTER);

        return filler;
    }

    private JTable createTableApps() {

        String[] columnNames = {
                "Apps",
                "Hosts",
                "Traffic Type",
        };

        String[][] data = {
                {null, null, null },
                {null, null, null },
                {null, null, null },
        };

        return (new JTable(data, columnNames));
    }

    private JTable createTableDevices() {

        String[] columnNames = {
                "Device",
                "Info",
                "First Seen",
        };

        String[][] data = {
                {null, null, null },
                {null, null, null },
                {null, null, null },
        };

        return (new JTable(data, columnNames));
    }

    private void setUpTableData() {
        TableModel tableModel = jTableUsage.getModel();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            list.add(""+i);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                tableModel.setValueAt(list.get(i), i, j);
            }
        }
    }
}