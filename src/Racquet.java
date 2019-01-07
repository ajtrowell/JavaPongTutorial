import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    int x = 0;
    int xa = 0;
    int racquetWidth = 60;
    int racquetHeight = 10;
    private Game game;

    public Racquet(Game game) {
        this.game = game;
    }

    void move() {
        if (x + xa > 0 && x + xa < game.getWidth()- racquetWidth)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, 330, racquetWidth, racquetHeight);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }

}
