import javax.swing.*;

public class MainForm {
    public final int WIDTH = 600;
    public final int HEIGHT = 800;

    public void createForm() {
        JFrame frame = new JFrame("Main");
        JScrollPane jScrollPane = new JScrollPane();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        creatMenuBar(frame);
        createTabbedPane(frame, jScrollPane);

        frame.setSize(HEIGHT, WIDTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Private section

    private void creatMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        menuBar.add(menu);

        menu.add(new JMenuItem("Menu 1"));
        menu.addSeparator();

        menu.add(new JMenuItem("Menu 2"));
        menu.addSeparator();

        menu.add(new JMenuItem("Menu 3"));

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }


    private JScrollPane createTable(JScrollPane jScrollPane) {

        String[] columnNames = {
                "Apps",
                "Download Kb/s",
                "Upload Kb/s",
        };

        Object[][] data = {
                {"Telegram", null, null },
                {"Chrome", null, null },
                {"Discord", null, null },
        };

        return new JScrollPane(new JTable(data, columnNames));
    }

    private void createTabbedPane(JFrame frame, JScrollPane jScrollPane){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Graph", createTable(jScrollPane));
        tabbedPane.addTab("Network", makeTextPanel("void"));
        tabbedPane.addTab("Usage", null);

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