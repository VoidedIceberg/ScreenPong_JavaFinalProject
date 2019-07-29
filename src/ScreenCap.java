import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;


/**
 * Write a description of class ScreenCap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenCap
{
    public BufferedImage capScreen() throws AWTException
    {
        Robot robot = new Robot();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        return robot.createScreenCapture(new Rectangle(new Dimension(width, height)));
    }
}
