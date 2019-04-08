import javax.swing.*;
import java.awt.*;

public class Piece extends JComponent {

    private final int xPosition;
    private final int yPosition;
    private Color color;

    public Piece(Color color, int x, int y) {
        xPosition = x;
        yPosition = y;
        setColor(color);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }
}
