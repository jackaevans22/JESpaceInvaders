import javax.swing.*;

public class Missile {

    private int x, y, dx, dy, width, height;
    private ImageIcon pic;

    public Missile()
    {
        x=0;
        y=0;
        dx=0;
        dy=0;
        width=0;
        height=0;
        pic = new ImageIcon();
    }

    public Missile(int xV, int yV, int w, int h, ImageIcon p) {
        x=xV;
        y=yV;
        pic=p;
        dx=0;
        dy=0;
        width=w;
        height=h;
    }
public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

}
