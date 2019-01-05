import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Game extends JPanel {

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    int ballSize = 30;

    private void moveBall() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > getWidth() - ballSize)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > getHeight() - ballSize)
            ya = -1;

        x = x + xa;
        y = y + ya;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x,y,ballSize,ballSize);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            game.moveBall();
            game.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                    System.out.print(e);
            }
        }

    }
}
