
import java.util.Random;
import javax.swing.ImageIcon;

public class AlienShip extends Ship {

    private boolean movingRight = true;

    // Four different enemy images
    private static final String[] ALIEN_IMAGES = {
        "tiefighter.png",
        "tiebomber.png",
        "stardestroyer.png",
        "superstardestoryer.png"
    };

    private static final Random RANDOM = new Random();

    // Default constructor
    public AlienShip() {
        super();
    }

    public AlienShip(int x, int y) {
     super(x, y, 60, 60,
        new ImageIcon(ALIEN_IMAGES[RANDOM.nextInt(ALIEN_IMAGES.length)]));
}

    // Constructor that allows a specific image
    public AlienShip(int x, int y, ImageIcon image, int width, int height) {
        super(x, y, width, height, image);
}

    // Checks if a missile hits this alien
    public boolean hit(PlayerMissile sm) {
        if ((sm.getX() + sm.getWidth() > super.getX()
                && sm.getX() < super.getX() + super.getWidth())
                && (sm.getY() + sm.getHeight() > super.getY()
                && sm.getY() < super.getY() + super.getHeight())) {

            return true;
        }

        return false;
    }

    // Getter
    public boolean isMovingRight() {
        return movingRight;
    }

    // Setter
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
}
