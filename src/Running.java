import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.CORBA.Bounds;

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
	private Point[] locations;
    private Slicer slicer;
    private ScreenCap screenCap;
    private Block block;
    private JPanel panel;
    
    private Block[] blockAray;
    
    private Rectangle rect1;
    private Rectangle rect2;
    
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
        	time = new Timer(1000 / 1 /* frame rat*/, al);
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
        
        update();
        
    }

    public void update()
    {
//        while(isRunning == true)
//        {
    	
    	ball.phisics();

    		panel = new JPanel(){
    			 @Override
                 public void paintComponent(Graphics g) {
//                     super.paint(g);
                     super.paintComponent(g);
                     Graphics2D g2d = (Graphics2D) g.create();
                 	for(int i = 0; i <= imgAray.length - 1; i++)
                	{
                 		g.drawImage(blockAray[i].getImg(), blockAray[i].getLocationPoint().x, blockAray[i].getLocationPoint().y, blockAray[i].getImg().getWidth(),blockAray[i].getImg().getHeight(), this);
                	}
                    g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getImage().getWidth() / 8, ball.getImage().getHeight() /8 , this);

                 }
    		};
        
        frame.add(panel);
        
 
    		// gets the current screens resolution
        	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        
        // makes the window Full Screen
        gs.setFullScreenWindow(frame);
        frame.validate();
        
        for(int i = 0; i <= imgAray.length - 1; i++){
        
        	rect1 = ball.getBounds();
        	rect2 = blockAray[i].getBounds();
        	
        	if (rect1.intersects(rect2))
        	{
        		System.out.println(i);
        		blockAray[i].setImg(blockAray[0].getImg());;
        	}
            
        }

    
            
            win();
//        }
    }
    public void win()
    {
         if (isRunning == true)
         {

            
         }
         else{
        	 isRunning = false;
        	 end();
         }
    }
    public void end()
    {
    	frame.dispose();
    }
	public BufferedImage[] getImgAray() {
		return imgAray;
	}
}
