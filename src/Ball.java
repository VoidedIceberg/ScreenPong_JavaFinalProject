import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends JComponent
	{
		boolean phisicsEnabled = false;
		int ballSpeed;
		BufferedImage  ballImg;
		

		private int locX = 0;
		private int locY = 0;
		private int screenHight;
		private int screenWidth;
		
		public Ball(int screenX, int screenY)
		{
			screenHight = screenX;
			screenWidth = screenY;
			
			try {
			ballImg = ImageIO.read(new File("images/BallImage.png"));
			} catch (IOException e) {
			}
		}
		
		public boolean phisicsEnabled()
	{
		return false;
	}
	public void phisics()
	{
		if (locX <= screenHight)
		{
			locX = locX + 1;
		}
		if (locY <= screenWidth)
		{
			locY = locY - 1;
		}
		
	}
	public boolean isTouching()
	{
		
		return false;
	}
	public void destroy()
	{
		
		
	}
	public void add(Frame frame)
	{
		
		
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
	
}
