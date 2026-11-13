import javax.swing.ImageIcon;

public class PlayerShip extends Ship {  
    public PlayerShip()
    {
        super();
    }
    public PlayerShip(int x, int y, int width, int height) {
        super(400, 700, 100, 100, new ImageIcon("xwing.png"));
    }
}
