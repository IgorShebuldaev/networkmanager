import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class MainForm {
    public final int WIDTH = 600;
    public final int HEIGHT = 800;

    public void createForm() {
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        creatMenuBar(frame);
        createTable(frame);

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

    private void createTable(JFrame frame) {
        String[] columnNames = {
                "First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"
        };

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        frame.add(new JScrollPane(new JTable(data, columnNames)));
    }
}