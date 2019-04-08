import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {

    private final int rows = 6;
    private final int cols = 7;
    private final int space = 25;
    private JPanel board = new JPanel(new GridLayout(rows, cols, space, space));
    private final int margin = 50;
    private final int pieceSize = 75;


    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(margin, margin, ConnectFourFrame.WIDTH - (2 * margin), ConnectFourFrame.HEIGHT - (2 * margin));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Piece piece = new Piece(graphics, pieceSize, getPieceXPosition(j), getPieceYPosition(i));
                board.add(piece);
            }
        }
    }

    private int getPieceXPosition(int col) {
        return margin + space + (col * (pieceSize + space));
    }

    private int getPieceYPosition(int row) {
        return margin + space + (row * (pieceSize + space));
    }
}
