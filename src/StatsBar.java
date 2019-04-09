import javax.swing.*;
import java.awt.*;

public class StatsBar {

    private JPanel statsBar = new JPanel(new BorderLayout());
    private JLabel redScore;
    private JLabel blackScore;
    private JLabel turnLabel;

    public StatsBar() {
        blackScore  = new JLabel("0");
        createRedStats();
        createTurnIndicator();
        createBlackStats();
    }

    private void createRedStats() {
        JPanel redStats = new JPanel();
        JLabel redLabel = new JLabel("Red: ");
        redLabel.setForeground(Color.RED);
        redScore  = new JLabel("0");
        redScore.setForeground(Color.RED);
        redStats.add(redLabel);
        redStats.add(redScore);
        statsBar.add(redStats, BorderLayout.WEST);
    }

    private void createBlackStats() {
        JPanel blackStats = new JPanel();
        JLabel blackLabel = new JLabel("Black: ");
        blackScore = new JLabel("0");
        blackStats.add(blackLabel);
        blackStats.add(blackScore);
        statsBar.add(blackStats, BorderLayout.EAST);
    }

    private void createTurnIndicator() {
        turnLabel = new JLabel("Black Turn");
        turnLabel.setSize(ConnectFourFrame.WIDTH, ConnectFourFrame.HEIGHT);
        turnLabel.setHorizontalAlignment(JLabel.CENTER);
        statsBar.add(turnLabel, BorderLayout.CENTER);
    }

    public JPanel getStatsBar() {
        return statsBar;
    }

    public JLabel getRedScore() {
        return redScore;
    }

    public JLabel getBlackScore() {
        return blackScore;
    }

    public JLabel getTurnLabel() {
        return turnLabel;
    }

    public void incrementRedScore() {
        redScore.setText(String.valueOf(Integer.parseInt(redScore.getText()) + 1));
    }

    public void incrementBlackScore() {
        blackScore.setText(String.valueOf(Integer.parseInt(blackScore.getText()) + 1));
    }

    public void changePlayer() {
        if (turnLabel.getForeground() == Color.RED) {
            turnLabel.setText("Black Turn");
            turnLabel.setForeground(Color.BLACK);
        }
        else {
            turnLabel.setText("Red Turn");
            turnLabel.setForeground(Color.RED);
        }
    }
}
