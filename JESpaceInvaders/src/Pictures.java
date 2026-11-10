
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pictures {

public Image image;
public int x ,y, width, height, dx, dy;
public boolean moveUp, moveRight;

public Pictures(String imagePath, int x, int y, int width, int height, int dx, int dy) {

this.x = x;
this.y = y;
this.width = width;
this.height = height;
this.dx = dx;
this.dy = dy;
this.image = new ImageIcon(imagePath).getImage();
moveUp = true;
moveRight = true;

}

public void move() {
        if (moveUp) {
            y-=dy;
        }
        else{
            y+=dy;
        }
        
        if (moveRight) {
            x+=dx;
        }
        else {
            x-=dx;
        }

        if(x<0) {
            x=0;
            setMoveright();
        }

        else if (x>1200-width) {
            x=1200-width;
            setMoveright();
        }

        if(y<0) {
            y=0;
            setMoveup();
        }

        else if (y>760-height) {
            y=760-height;
            setMoveup();
        }

        }

        public void setMoveup() {
            moveUp=!moveUp;
        }
        
        public void setMoveright() {
            moveRight=!moveRight;
        }









}
