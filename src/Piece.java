import javax.swing.*;
import java.awt.*;

public class Piece extends JComponent {

    private Graphics graphics;
    private final int xPosition;
    private final int yPosition;
    private final int size;
    private Color color;

    public Piece(Graphics graphics, int size, int x, int y) {
        this.size = size;
        xPosition = x;
        yPosition = y;
        this.graphics = graphics;
        setColor(Color.GRAY);
    }

    public void setColor(Color color) {
        this.color = color;
        graphics.setColor(color);
        graphics.fillOval(xPosition, yPosition, size, size);
    }
}
