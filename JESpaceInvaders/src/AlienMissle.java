import javax.swing.*;

public class AlienMissile extends Missile {

    public AlienMissile()
    {
        super();
    }
    public AlienMissile(int x, int y, int width, int height) {
        super(400, 700, 100, 100, new ImageIcon("greenlaser.png"));
    }
}
