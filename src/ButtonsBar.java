import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsBar extends JPanel{

    private JPanel buttons = new JPanel(
            new GridLayout(1, 0, 25, 0)
    );

    public ButtonsBar(Board board) {
        for (int i = 0; i < board.getColumns(); i++) {
            JButton button = new JButton(String.valueOf(i + 1));
            button.setPreferredSize(new Dimension(65, 50));

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    board.columnSelected(Integer.parseInt(button.getText()) - 1);
                }
            });
            buttons.add(button);
        }
    }

    public JPanel getButtons() {
        return buttons;
    }
}
