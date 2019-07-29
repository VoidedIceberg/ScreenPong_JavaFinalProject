import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This is the main loop of the application that handels the screen updates
 * 
 * @author Troy Mullenberg  
 */
public class Running extends JPanel
{
    private BufferedImage screen = null;
    private BufferedImage[] imgAray;
    private JFrame frame = null;
    private Timer time;
    private Ball ball;
    private Slicer slicer;
    private ScreenCap screenCap;
    private JPanel panel;
    private Paddle paddle;
    private Block[] blockAray;

    // sets the frame rate of the game
    public Running()
    {
        Init();
    	ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    update();
            	}
        	};
        	time = new Timer(1000 / 30 /* frame rat*/, al);
        	time.start();
    }

    public void Init()
    {   
        screenCap = new ScreenCap();
        slicer = new Slicer();

        try
        {
         screen = screenCap.capScreen();
	     imgAray = slicer.slice(screen);
         frame = new JFrame("Screen Window");
         frame.setUndecorated(true);
         
         ball = new Ball();
        } catch (Exception e) {
			e.printStackTrace();
        }
        blockAray = new Block[imgAray.length];
        
        for (int i = 0; i <= imgAray.length - 1; i++)
        {
        	blockAray[i] = new Block(i, imgAray[i], imgAray);
        }
        paddle = new Paddle();
        
        update();
    }

    public void update()
    {
    	ball.phisics();

    		panel = new JPanel(){
    			 @Override
                 public void paintComponent(Graphics g) {
                     super.paintComponent(g);
                 	for(int i = 0; i <= 7; i++)
                	{
                 		if (blockAray[i].getDestroyed() == false)
                 		{
                 		 g.drawImage(blockAray[i].getImg(), blockAray[i].getLocationPoint().x, blockAray[i].getLocationPoint().y, blockAray[i].getImg().getWidth(),blockAray[i].getImg().getHeight(), this);
                 		}
                	}
                 	for (int i = 8; i <= 15; i++)
                 	{
                 		g.drawImage(blockAray[i].getImg(), blockAray[i].getLocationPoint().x, blockAray[i].getLocationPoint().y, blockAray[i].getImg().getWidth(),blockAray[i].getImg().getHeight(), this);
                 	}
                    g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getImage().getWidth() / 8, ball.getImage().getHeight() /8 , this);
             		g.drawImage(paddle.getPaddleImg(), paddle.getLocX(), paddle.getLocY(), paddle.getPaddleImg().getWidth(),paddle.getPaddleImg().getHeight(), this);
                 }
    		};     
        frame.add(panel);
    		// gets the current screens resolution
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        
        // makes the window Full Screen
       gs.setFullScreenWindow(frame);
       
        frame.validate();
        paddle.move(frame);
        checkCollision();
        win();
    }


    public void win()
    {
    	int j = 0;
       for(int i = 0; i <= 7; i++)
       {
    	   if (blockAray[i].getDestroyed() == true)
    	   {
    		   j++;
    	   }
    	   if(j == blockAray.length)
    	   {
    		   end();
    	   }
       }

    }
    private void checkCollision() {
    	for (int i = 0; i <= imgAray.length - 1; i++)
    	{
        if ((ball.getBounds()).intersects(blockAray[i].getBounds()))
        {
        	if (blockAray[i].getDestroyed() == false)
        	{
        	ball.setDirectionX(-(ball.getDirectionX()));
        	ball.setDirectionY(-(ball.getDirectionY()));
        	}
        	blockAray[i].setDestroyed(true);
        }      
    	}
    	
    	if (ball.getBounds().intersects(paddle.getBounds()))
    	{
       	// ball.setDirectionX(-(ball.getDirectionX()));
        	ball.setDirectionY(-(ball.getDirectionY()));
    	}
    }
    public void end()
    {
    	time.stop();
    	frame.dispose();
    	
    }
	public BufferedImage[] getImgAray() {
		return imgAray;
	}
}

