import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Write a description of class Ball here.
 * 
 * @author T. Mullenberg 
 */
public class Ball extends JComponent
	{
		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ballSpeed;
		BufferedImage  ballImg;

		private int locX = (int) (screenSize.getWidth() / 2);
		private int locY = (int) (screenSize.getHeight() / 2 + 350);
		private int speed = 5;
		private int directionX = 1;
		private int directionY = 1;
		
		private Rectangle rect;
		
	public Ball()
	{	
		try {
			ballImg = ImageIO.read(new File("images/BallImage.png"));
		} catch (IOException e) { }
			rect = new Rectangle();
	}

	public void phisics()
	{
		if (locX > screenSize.getWidth() - (ballImg.getWidth() / 8) || locX <= 0)
		{
			directionX = -directionX;
		}
		if (locY > screenSize.getHeight() - (ballImg.getHeight() / 8) || locY <= 0)
		{
			directionY = -directionY;
		}
		locX = (speed *(directionX * 4)) + locX;
		locY = (speed *(directionY * 4)) + locY;

		rect.setBounds(locX, locY, ballImg.getWidth(), ballImg.getHeight());	
		this.setBounds(rect);
	}
	public boolean isTouching()
	{		
		return false;
	}

	public BufferedImage getImage()
	{
		return ballImg;
	}
	public int getX()
	{
		return this.locX;
	}
	public int getY()
	{
		return this.locY;
	}
	public void setLocX(int locX) {
		this.locX = locX;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public Rectangle getRect() {
		return rect;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
}
