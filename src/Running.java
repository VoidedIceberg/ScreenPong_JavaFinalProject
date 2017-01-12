import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Write a description of class Runing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Running extends JPanel
{
    private boolean isRunning;
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
    
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // sets the frame rate of the game
    public Running()
    {
    	ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            	}
        	};
        	time = new Timer(1000 / 30 /* frame rat*/, al);
        	time.start();
    }

    //Initilizes all of my varibles and objects used
    public void Init()
    {
        isRunning = true;
   
        screenCap = new ScreenCap();
        slicer = new Slicer();
	    
        slicer = new Slicer();
		screenCap = new ScreenCap();
        
        try
        {
         screen = screenCap.capScreen();
	     imgAray = slicer.slice(screen);
         frame = new JFrame("Screen Window");
         frame.setUndecorated(true);
         
         ball = new Ball(screenSize.height, screenSize.width);

         
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
//                     super.paint(g);
                     super.paintComponent(g);
                     Graphics2D g2d = (Graphics2D) g.create();
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
        
        checkCollision();
            win();
    }


    public void win()
    {
    	int j = 0;
//        if (ball.getRect().getMaxY() > screenSize.getHeight()) {
//            end();
//        }
       for(int i = 0; i <= 7; i++)
       {
    	   if (blockAray[i].getDestroyed() == true)
    	   {
    		   j++;
    	   }
    	   if(j == 8)
    	   {
    		   end();
    	   }
       }

    }
    private void checkCollision() {

//        if (ball.getRect().getMaxY() < frame.getHeight()) {
//            end();
//        }
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

