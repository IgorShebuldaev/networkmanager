import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainForm {
    public final int WIDTH = 600;
    public final int HEIGHT = 800;

    JTable jTable = new JTable((TableModel) createTableUsage());

    public void createForm() {
        JFrame frame = new JFrame("Simple NetWorkManager");;

        creatMenuBar(frame);
        createTabbedPane(frame);

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

    private JTable createTableUsage() {

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

        return (new JTable(data, columnNames));
    }

    private JTable createTableThings() {

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

        return (new JTable(data, columnNames));
    }

    private void setUpTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[5];
            data[0] = list.get(i);
            data[1] = list.get(i);
            data[2] = list.get(i);
            //Thread.sleep(5000);

            tableModel.addRow(data);
        }
        jTable.setModel(tableModel);
    }

    private void createTabbedPane(JFrame frame){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Graph",  makeTextPanel("void"));
        tabbedPane.addTab("Usage", createTableUsage());
        tabbedPane.addTab("Things", createTableThings());

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