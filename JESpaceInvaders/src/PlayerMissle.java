import javax.swing.*;

public class PlayerMissile extends Missile {

    public PlayerMissile()
    {
        super();
    }
    public PlayerMissile(int x, int y, int width, int height) {
        super(400, 700, 100, 100, new ImageIcon("redlaser.png"));
    }
}
