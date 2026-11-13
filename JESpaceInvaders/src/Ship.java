import javax.swing.ImageIcon;

public class Ship {
    private int x;
private int y;
private int width;
private int height;
private int dx;
private int score;
public ImageIcon pic;


    public Ship() {
    x = 0;
    y = 0;
    width = 0;
    height = 0;
    score = 0;
    pic = new ImageIcon();

    }

public Ship(int xpos, int ypos, int w, int h, ImageIcon p){
    x = xpos;
    y = ypos;
    width = w;
    height = h;
    pic=p;
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

public int getDx() {
    return dx;
}

public void setDx(int dx) {
    this.dx = dx;
}

public int getScore() {
    return score;
}

public void setScore(int score) {
    this.score = score;
}

public ImageIcon getPic() {
    return pic;
}

public void setPic(ImageIcon pic) {
    this.pic = pic;
}

public void moveBasket() {
    if(x<0) {
        x=0;
    }

    if(x>=1000-getWidth()) {
        x=1000-getWidth();
    }
}



}
