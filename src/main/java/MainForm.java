import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainForm {
    public final int WIDTH = 600;
    public final int HEIGHT = 800;

    JTable jTableUsage = createTableUsage();
    JTable jTableThings = createTableThings();

    public void createForm() {
        JFrame frame = new JFrame("Simple NetWorkManager");;

        creatMenuBar(frame);
        createTabbedPane(frame);

        frame.setSize(HEIGHT, WIDTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        try{
            setUpTableData();
        } catch (InterruptedException e){
            System.out.print("Ops!");
        }



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

        String[][] data = {
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

        String[][] data = {
                {null, null, null },
                {null, null, null },
                {null, null, null },
        };

        return (new JTable(data, columnNames));
    }

    private void setUpTableData() throws InterruptedException{
        TableModel tableModel = jTableUsage.getModel();

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                tableModel.setValueAt(list.get(i), i, j);
            }
        }
        jTableUsage.setModel(tableModel);

    }

    private void createTabbedPane(JFrame frame){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Graph",  makeTextPanel("void"));
        tabbedPane.addTab("Usage", new JScrollPane(jTableUsage));
        tabbedPane.addTab("Things", new JScrollPane(jTableThings));

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