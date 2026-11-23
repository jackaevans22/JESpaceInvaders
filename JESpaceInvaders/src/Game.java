
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 


public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key; 
    private char screen;
	private PlayerShip player;
	private ArrayList<PlayerMissile> sMissiles;
	private ArrayList<AlienShip> aliens;
	private ArrayList<AlienMissile> aMissiles;
	private boolean moveRight;
	int fireCounter = 0;
	

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		key =-1; 
		screen = '1';
		player = new PlayerShip(400, 650, 100, 100);
		sMissiles = new ArrayList<PlayerMissile>();
		aliens = setAlien1();
		aMissiles = new ArrayList<AlienMissile>();
		moveRight = true;
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	public void screen(Graphics g2d) {
				switch(screen){
					case 'S' :
						
					break;
					case '1' :
					g2d.drawImage(player.getPic().getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
					
					
					 for(int i = 0; i < aliens.size(); i++) {
						g2d.drawImage(aliens.get(i).getPic().getImage(),
            				aliens.get(i).getX(),aliens.get(i).getY(),aliens.get(i).getWidth(),aliens.get(i).getHeight(), this);
						}


					break;
                    case '2' :
                    
                    break;
                    case '3' :
                    
                    break;
					case 'B' :
                    
                    break;
					case 'W' :
							
					break;
					case 'L' :
						
				
				}
			}

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		screen(g2d);
		drawSM(g2d);
		drawAM(g2d);
		for (int i = 0; i < sMissiles.size(); i++) {
    	sMissiles.get(i).move();
	}
		removeOffscreenMissiles();
		moveAliens();
		if(checkAliens()) {
    		screen = 'L';
		}
	
		/*Chatgpt generated code that would control how fast the aliens fire
		prompt: "how do I change the aliens firing rate"*/
		fireCounter++;
		
		if(fireCounter >= 50) {
    		getAlienMissile(g2d);
    		fireCounter = 0;
		}//lower value = fires more often 100~1/2 second
		
		
		
		
		
		
		twoDgraph.drawImage(back, null, 0, 0);
	}

	



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}



	@Override
	public void mouseMoved(MouseEvent m) {
	   int newX = m.getX() - player.getWidth() / 2;

    newX = Math.max(0, newX);
    newX = Math.min(getWidth() - player.getWidth(), newX);

    player.setX(newX);
	}



	//@Override
	public void mouseClicked(MouseEvent e) {
	
   
	}

public void playerMissile(int x) {
    sMissiles.add(new PlayerMissile(player.getX()-15, player.getY(), 125, 50));
}

public void drawSM(Graphics g2d) {

    for (PlayerMissile sm : sMissiles) {

        g2d.drawImage(sm.getPic().getImage(),
            sm.getX(), sm.getY(),
            sm.getWidth(), sm.getHeight(), this);

    }
}




public void removeOffscreenMissiles() {
    for (int i = sMissiles.size() - 1; i >= 0; i--) {
        if (sMissiles.get(i).getY() + sMissiles.get(i).getHeight() < 0) {
            sMissiles.remove(i);
        }
    }
}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
    if ((screen == '1'|| screen == '2'|| screen == '3'|| screen == '4')) {
        if (arg0.getButton() == MouseEvent.BUTTON1) {

            playerMissile(player.getX() + player.getWidth() / 2 - 25);

        }
    }
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*public ArrayList<AlienShip> setAlien() {
      ArrayList<AlienShip> temp = new ArrayList<AlienShip>();
     int x = 0;
      int y = 100;
     for(int i=0; i<2; i++) {
          for(int j=0; j<7; j++) {
              temp.add(new AlienShip(x, y, "tiefighter.png"));
              x += 100;
          }
         y += 50;
         x = 0;
     }
	}
temp.add(new AlienShip(700, 500, "tiefighter.png"));
temp.add(new AlienShip(700, 500, "tiefighter.png"));*/


public ArrayList<AlienShip> setAlien1() {

    ArrayList<AlienShip> temp = new ArrayList<AlienShip>();

    int x = 100;
    int y = 100;

	//back two rows of 7
    for(int i=0; i<2; i++) {
        for(int j=0; j<7; j++) {

            temp.add(new AlienShip(x, y,
                new ImageIcon("tiefighter.png"), 60, 60));

            x += 100;
        }

        y += 75;
        x = 100;
    }

	//front row of 5
	x=175;
    for(int j=0; j<5; j++) {
        temp.add(new AlienShip(x, y,
            new ImageIcon("tiefighter.png"), 60, 60));

        x += 100;
    }


    return temp;
}


public void changeDyAlien(int dy)
{
    for(AlienShip a:aliens) {
        a.setDy(dy);     
    }  }

public boolean checkAlienWall() {
    for(AlienShip a:aliens) {
    if(a.getX()+a.getWidth()>= getWidth() || a.getX()<0) {  
        moveRight=!moveRight;
		a.setY(a.getY() + a.getDy());
        return true;   }}
    return false;
}

public boolean checkAliens() {
    for (AlienShip a:aliens) {
        if (a.getY()>=player.getY()) {
            return true; }}
   return false;}

public void moveAliens() {
    if(checkAlienWall()) {
            changeDyAlien(10);  }
		for(AlienShip a:aliens) {
            a.setY(a.getY() + a.getDy());
            a.setDy(0);
        }
       for(AlienShip a:aliens) {
            if(moveRight) {
                a.setDx(1);}
            else {
                a.setDx(-1);}
				a.setX(a.getX() + a.getDx());}
				
    }





	public void getAlienMissile(Graphics g2d) {
    if (aliens.isEmpty()) {
        return;
    }

    int randAlien = (int)(Math.random()*aliens.size());

    aMissiles.add(new AlienMissile(
        aliens.get(randAlien).getX() + aliens.get(randAlien).getWidth()/2,
        aliens.get(randAlien).getY() + aliens.get(randAlien).getHeight(),
        10, 50, new ImageIcon("tielaser.png")
    ));

    //SoundManager.playPreloadedClip("fire");
}
public void drawAM(Graphics g2d) {
    for(AlienMissile am:aMissiles) {
        g2d.drawImage(am.getPic().getImage(),
            am.getX(), am.getY(),
            am.getWidth(), am.getHeight(), this);

        am.setDy(2);
        am.move();
    }
}


}
