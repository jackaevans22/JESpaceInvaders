
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


	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		key =-1; 
		screen = '1';
		player = new PlayerShip(400, 500, 100, 100);
		sMissiles = new ArrayList<PlayerMissile>();

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
    sMissiles.add(new PlayerMissile(x, player.getY(), 50, 50));
}

public void drawSM(Graphics g2d) {

    for (PlayerMissile sm : sMissiles) {

        g2d.drawImage(sm.getPic().getImage(),
            sm.getX(), sm.getY(),
            sm.getWidth(), sm.getHeight(), this);

    }
}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
    if (screen == '1') {
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


	
	
	

	
}
