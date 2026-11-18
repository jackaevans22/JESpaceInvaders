
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


	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		key =-1; 
		screen = '1';
		player = new PlayerShip(400, 650, 100, 100);
		sMissiles = new ArrayList<PlayerMissile>();
		aliens = new ArrayList<AlienShip>();
		aMissiles = new ArrayList<AlienMissile>();
		
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
					g2d.drawImage(player.getPic().getImage(), player.getX(), 
					player.getY(), player.getWidth(), player.getHeight(), this);
					

					
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
		for (int i = 0; i < sMissiles.size(); i++) {
    	sMissiles.get(i).move();
	}
		removeOffscreenMissiles();
		setAliens();
		drawAliens(g2d);
	
		
	
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


	/*AI helped me create different rows of alien ships Prompt:
	using the images and code I provided help me create an arraylist 
	for the alien ships, I want to have the first level be 3 rows of 
	tie fighter images, and with the first row having 5 and back 2 
	next rows having 7 */
	public void setAliens() {

    aliens.clear();

    
	 // Third row: 7 aliens
    for (int i = 0; i < 5; i++) {

        int x = 250 + (i * 100);
        int y = 260;

        aliens.add(new AlienShip(x, y,
            new ImageIcon("tiefighter.png"), 60, 60));
    }

    // Second row: 7 aliens
    for (int i = 0; i < 7; i++) {

        int x = 150 + (i * 100);
        int y = 180;

        aliens.add(new AlienShip(x, y,
            new ImageIcon("tiefighter.png"), 60, 60));
    }

   // First row: 5 aliens
    for (int i = 0; i < 7; i++) {

       

		int x = 150 + (i * 100);
        int y = 100;
        aliens.add(new AlienShip(x, y,
            new ImageIcon("tiefighter.png"), 60, 60));
    }
}
	
public void drawAliens(Graphics g2d) {

    for (AlienShip a : aliens) {

        g2d.drawImage(a.getPic().getImage(),
            a.getX(), a.getY(),
            a.getWidth(), a.getHeight(), this);

    }
}

























	
}

//template code from a brickbreaker game
/*

public ArrayList<Bricks> setBricks() {
      ArrayList<Bricks> temp = new ArrayList<Bricks>();
     int x = 0;
      int y = 100;
     for(int i=0; i<7; i++) {
          for(int j=0; j<10; j++) {
              temp.add(new Bricks(x, y, Color.GRAY));
              x += 100;
          }
         y += 50;
         x = 0;
     }
	 //temp.add(new Brick(700, 500, Color.BLACK))

	 // 2 bricks on the left
	temp.add(new Bricks(0, 50, Color.GRAY));
	temp.add(new Bricks(100, 50, Color.GRAY));

	// bricks in the middle
	temp.add(new Bricks(400, 50, Color.GRAY));
	temp.add(new Bricks(500, 50, Color.GRAY));
	

	// 2 bricks on the right
	temp.add(new Bricks(800, 50, Color.GRAY));
	temp.add(new Bricks(900, 50, Color.GRAY));
	//I used AI to get coordinates

     return temp;
 }


 
for(int i=0; i<brickList.size(); i++) {
			g2d.setColor(brickList.get(i).getC());
			g2d.fillRect(
				brickList.get(i).getX(),brickList.get(i).getY(),
				brickList.get(i).getWidth(), brickList.get(i).getHeight());

			//AI helped me draw a black outline
			g2d.setColor(Color.BLACK);
    		g2d.drawRect(
       			brickList.get(i).getX(),brickList.get(i).getY(),
				brickList.get(i).getWidth(),brickList.get(i).getHeight());
    
		} */
