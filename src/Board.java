import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {

    private final int rows = 6;
    private final int cols = 7;
    private final int space = 25;
    private JPanel board = new JPanel();
    private final int margin = 50;
    private final int pieceSize = 75;
    private Piece[][] pieces = new Piece[rows][cols];
    private boolean black = true;
    private boolean firstPaint = true;


    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(margin, margin, ConnectFourFrame.WIDTH - (2 * margin), ConnectFourFrame.HEIGHT - (3 * margin));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstPaint) {
                    pieces[i][j] = new Piece(getPieceXPosition(j), getPieceYPosition(i));
                }
                Piece piece = pieces[i][j];
                graphics.setColor(piece.getColor());
                graphics.fillOval(piece.getXPosition(), piece.getYPosition(), pieceSize, pieceSize);
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

    public int getColumns() {
        return cols;
    }

    public void columnSelected(int col) {
        if (pieces[0][col].getColor() != Color.GRAY) {
            return;
        }

        int row = 0;
        for (int i = 0; i < rows && pieces[i][col].getColor() == Color.GRAY; i++) {
            row = i;
        }

        Piece piece = pieces[row][col];

        if (black) {
            piece.setColor(Color.BLACK);
        }
        else {
            piece.setColor(Color.RED);
        }

        black = !black;
        firstPaint = false;

        repaint(piece.getXPosition(),piece.getYPosition(), pieceSize, pieceSize);
    }
}
