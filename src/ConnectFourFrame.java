import javax.swing.*;

public class ConnectFourFrame extends JFrame {

    public static final int WIDTH = 825;
    public static final int HEIGHT = 800;
    private int margin;

    public ConnectFourFrame() {
        setTitle("Connect Four");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(null);

        Board board = createBoard();
        StatsBar statsBar = new StatsBar();
        JPanel statsPanel = createStatsBar(statsBar);
        JPanel buttonsBar = createButtonsBar(board, statsBar);

        root.add(board);
        root.add(buttonsBar);
        root.add(statsPanel);

        setContentPane(root);
    }

    private Board createBoard() {
        Board board = new Board();
        int margin = board.getMargin();
        this.margin = margin;
        board.setLocation(0, margin);
        board.setSize(WIDTH - margin, HEIGHT -  margin);
        return board;
    }

    private JPanel createButtonsBar(Board board, StatsBar statsBar) {
        JPanel buttonsBar = new ButtonsBar(board, statsBar).getButtons();
        buttonsBar.setSize(WIDTH - (3 * margin), margin);
        int space = board.getSpace();
        buttonsBar.setLocation(3 * space, space);
        return buttonsBar;
    }

    private JPanel createStatsBar(StatsBar statsBar) {
        JPanel statsPanel = statsBar.getStatsBar();
        statsPanel.setSize(WIDTH - (2 * margin), margin);
        statsPanel.setLocation(margin , HEIGHT - (int) (1.5 * margin));
        return statsPanel;
    }
}
