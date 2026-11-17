import javax.swing.*;

public class PlayerMissile extends Missile {

    public PlayerMissile()
    {
        super();
    }
    public PlayerMissile(int x, int y, int width, int height) {
        super(x, y, width, height, new ImageIcon("redlaser.png"));
        setDy(-10);
    }
    
}
