import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Write a description of class Runing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Running 
{
    private boolean isRunning;
    private BufferedImage screen = null;
    private BufferedImage[] imgAray;
    private JFrame frame = null;
    private Timer time;
    private Ball ball;
	private Point[] locations;
    
    private ScreenCap screenCap;
    private Slicer slicer;
    private Block block;
    
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Running()
    {
    	ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            	}
        	};
        	time = new Timer(1000 / 10 /* frame rate */, al);
        	time.start();
    }
    public void Init()
    {
        isRunning = true;
   
        screenCap = new ScreenCap();
        slicer = new Slicer();
	    
        try
        {
         screen = screenCap.capScreen();
         
         frame = new JFrame("Screen Window");
         frame.setUndecorated(true);
         
         ball = new Ball(screenSize.height, screenSize.width);
         block = new Block();

         
        } catch (Exception e) {
			e.printStackTrace();
        }
        
        block.populateLocations();
        locations = block.getLocationPoint();
        imgAray = block.getImgAray();

        update();
        
    }
    

	private int index = 0;

    public void update()
    {
//        while(isRunning == true)
//        {
    	
    	ball.phisics();
    	for(int i = imgAray.length; i >= 0; i--)
    	{
    			index++;
              frame.add(new Component(){ 
                 @Override
                 public void paint(Graphics g) {
                     super.paint(g);
                     g.drawImage(imgAray[index], (int) locations[index].getX() , (int) locations[index].getY(), imgAray[index].getWidth(), imgAray[index].getHeight(), this);
//                     g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getImage().getHeight() / 4, ball.getImage().getWidth() /4 , this);

                 }
              }); 
             if (index == 15)
             {
            	 index = 0;
             }
              
    	}

    	
    	
    	// gets the current screens resolution
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        
        // makes the window Full Screen
        gs.setFullScreenWindow(frame);
        frame.validate();

            
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
    public BufferedImage[] getImgArray()
    {
    	return imgAray;
    }
}
