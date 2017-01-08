import java.awt.AWTException;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

/**
 * Write a description of class ScreenCap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenCap
{

//    public static void capScreenDisplay(JFrame frame) throws IOException, AWTException{ 
//        frame.setUndecorated(true);
//        
//        // Creates a new Robot (Robotics is also cool go 4818!)
//        Robot robot = new Robot();
//        
//        
//        // gets the screen cap from the robot buffers that image and adds it to the frame
//        frame.add(new Component(){ 
//            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//             
//             @Override
//             public void paint(Graphics g) {
//                 super.paint(g);
//                 g.drawImage(screenShot, 0, 0, getWidth(), getHeight(), this);
//             }
//        });
//        
//        // gets the current screens resolution
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice gs = ge.getDefaultScreenDevice();
//        
//        // makes the window Full Screen
//        gs.setFullScreenWindow(frame);
//        frame.validate();
//    }

    public BufferedImage capScreen() throws AWTException
    {
        Robot robot = new Robot();
        return robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }

}
