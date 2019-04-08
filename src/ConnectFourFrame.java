import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConnectFourFrame extends JFrame {

    public static final int WIDTH = 825;
    public static final int HEIGHT = 725;

    public ConnectFourFrame() {
        setTitle("Connect Four");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        Board board = new Board();
        root.add(board, BorderLayout.CENTER);


        root.add(new ButtonsBar(board).getButtons(), BorderLayout.NORTH);

        setContentPane(root);
    }
}
