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
    public BufferedImage capScreen() throws AWTException
    {
        Robot robot = new Robot();
        return robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }
}
