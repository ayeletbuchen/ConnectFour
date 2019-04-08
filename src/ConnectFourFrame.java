import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConnectFourFrame extends JFrame {

    public static final int WIDTH = 825;
    public static final int HEIGHT = 775;

    public ConnectFourFrame() {
        setTitle("Connect Four");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(null);

        Board board = new Board();
        board.setLocation(0, 50);
        board.setSize(WIDTH - 50, HEIGHT-  50);
        root.add(board);

        JPanel buttonsBar = new ButtonsBar(board).getButtons();
        buttonsBar.setSize(WIDTH - 150, 50);
        buttonsBar.setLocation(75, 25);
        root.add(buttonsBar);

        setContentPane(root);
    }
}
