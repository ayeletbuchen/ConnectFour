import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {

    private final int winningNumber = 4;
    private final int rows = 6;
    private final int cols = 7;
    private final int space = 25;
    private JPanel board = new JPanel();
    private final int margin = 50;
    private final Color defaultColor = Color.lightGray;
    private final int pieceSize = 75;
    private Piece[][] pieces = new Piece[rows][cols];
    private boolean black = true;
    private boolean firstPaint = true;


    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(margin, margin, ConnectFourFrame.WIDTH - (2 * margin), ConnectFourFrame.HEIGHT - (int) (3.5 * margin));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstPaint) {
                    pieces[i][j] = new Piece(defaultColor, getPieceXPosition(j), getPieceYPosition(i));
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

    public int getMargin() {
        return margin;
    }

    public int getSpace() {
        return space;
    }

    public int getPieceSize() {
        return pieceSize;
    }

    public void columnSelected(int col) {
        if (pieces[0][col].getColor() != defaultColor) {
            return;
        }

        int row = findRow(col);
        changePieceColor(pieces[row][col]);
        Color player = pieces[row][col].getColor();

        black = !black;
        firstPaint = false;
        repaint(pieces[row][col].getXPosition(), pieces[row][col].getYPosition(), pieceSize, pieceSize);
        if (isGameOver(player, row, col)) {
            System.out.println((player == Color.BLACK ? "Black" : "Red") + " wins!");
            // TODO turn above statement into dialgoe box and make users unable to continue here
        }
    }

    private int findRow(int col) {
        int row = 0;
        for (int i = 0; i < rows && pieces[i][col].getColor() == defaultColor; i++) {
            row = i;
        }

        return row;
    }

    private void changePieceColor(Piece piece) {
        if (black) {
            piece.setColor(Color.BLACK);
        }
        else {
            piece.setColor(Color.RED);
        }
    }

    private boolean isGameOver(Color player, int row, int col) {
        if (isVerticalWin(player, row, col)
                || isHorizontalWin(player, row, col)
                || isDownwardDiagonalWin(player, row, col)
                || isUpwardDiagonalWin(player, row, col)) {
            return true;
        }
        return false;
    }

    private boolean isVerticalWin(Color player, int row, int col) {
        if (row > 2) {
            return false;
        }

        int matchingPieces = 1;
        for (int i = row + 1; i <= rows && pieces[i][col].getColor() == player; i++) {
            matchingPieces++;
            if (matchingPieces == winningNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean isHorizontalWin(Color player, int row, int col) {
        int matchingPieces = 1;
        for (int i = col - 1; i >= 0 && pieces[row][i].getColor() == player; i--) {
            matchingPieces++;
        }

        for (int i = col + 1; i < cols && pieces[row][i].getColor() == player; i++) {
            matchingPieces++;
        }

        if (matchingPieces >= winningNumber) {
            return true;
        }
        return false;
    }

    private boolean isDownwardDiagonalWin(Color player, int row, int col) {
        int matchingPieces = 1;
        for (int i = row + 1, j = col + 1; i < rows && j < cols && pieces[i][j].getColor() == player; i++, j++) {
            matchingPieces++;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 && pieces[i][j].getColor() == player; i--, j--) {
            matchingPieces++;
        }

        if (matchingPieces >= winningNumber) {
            return true;
        }

        return false;
    }

    private boolean isUpwardDiagonalWin(Color player, int row, int col) {
        int matchingPieces = 1;

        for (int i = row - 1, j = col + 1; i >= 0 && j < cols && pieces[i][j].getColor() == player; i--, j++) {
            matchingPieces++;
        }

        for (int i = row + 1, j = col - 1; i < rows && j >= 0 && pieces[i][j].getColor() == player; i++, j--) {
            matchingPieces++;
        }

        if (matchingPieces >= winningNumber) {
            return true;
        }

        return false;
    }
}
