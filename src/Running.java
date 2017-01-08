import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel panel;
    
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Running()
    {
    	ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            	}
        	};
        	time = new Timer(1000 / 30 /* frame rate */, al);
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
//    	for(int i = imgAray.length; i >= 0; i--)
//    	{
    		panel = new JPanel(){
                 @Override
                 public void paint(Graphics g) {
                     super.paint(g);
                     g.drawImage(imgAray[0], (int) locations[0].getX() , (int) locations[0].getY(), imgAray[0].getWidth(), imgAray[0].getHeight(), this);
                     g.drawImage(imgAray[1], (int) locations[1].getX() , (int) locations[1].getY(), imgAray[1].getWidth(), imgAray[1].getHeight(), this);
                     g.drawImage(imgAray[2], (int) locations[2].getX() , (int) locations[2].getY(), imgAray[2].getWidth(), imgAray[2].getHeight(), this);
                     g.drawImage(imgAray[3], (int) locations[3].getX() , (int) locations[3].getY(), imgAray[3].getWidth(), imgAray[3].getHeight(), this);
                     g.drawImage(imgAray[4], (int) locations[4].getX() , (int) locations[4].getY(), imgAray[4].getWidth(), imgAray[4].getHeight(), this);
                     g.drawImage(imgAray[5], (int) locations[5].getX() , (int) locations[5].getY(), imgAray[5].getWidth(), imgAray[5].getHeight(), this);
                     g.drawImage(imgAray[6], (int) locations[6].getX() , (int) locations[6].getY(), imgAray[6].getWidth(), imgAray[6].getHeight(), this);
                     g.drawImage(imgAray[7], (int) locations[7].getX() , (int) locations[7].getY(), imgAray[7].getWidth(), imgAray[7].getHeight(), this);
                     g.drawImage(imgAray[8], (int) locations[8].getX() , (int) locations[8].getY(), imgAray[8].getWidth(), imgAray[8].getHeight(), this);
                     g.drawImage(imgAray[9], (int) locations[9].getX() , (int) locations[9].getY(), imgAray[9].getWidth(), imgAray[9].getHeight(), this);
                     g.drawImage(imgAray[10], (int) locations[10].getX() , (int) locations[10].getY(), imgAray[10].getWidth(), imgAray[10].getHeight(), this);
                     g.drawImage(imgAray[11], (int) locations[11].getX() , (int) locations[11].getY(), imgAray[11].getWidth(), imgAray[11].getHeight(), this);
                     g.drawImage(imgAray[12], (int) locations[12].getX() , (int) locations[12].getY(), imgAray[12].getWidth(), imgAray[12].getHeight(), this);
                     g.drawImage(imgAray[13], (int) locations[13].getX() , (int) locations[13].getY(), imgAray[13].getWidth(), imgAray[13].getHeight(), this);
                     g.drawImage(imgAray[14], (int) locations[14].getX() , (int) locations[14].getY(), imgAray[14].getWidth(), imgAray[14].getHeight(), this);
                     g.drawImage(imgAray[15], (int) locations[15].getX() , (int) locations[15].getY(), imgAray[15].getWidth(), imgAray[15].getHeight(), this);

                     g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getImage().getHeight() / 4, ball.getImage().getWidth() /4 , this);
                     ball.setLocX(ball.getX() + 1);
                     ball.setLocY(ball.getY() + 1);
                 }
    		};

//             if (index == 15)
//             {
//            	 index = 0;
//             }
//             else{index++;}
//              
//    	}
    	
        frame.add(panel);

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
