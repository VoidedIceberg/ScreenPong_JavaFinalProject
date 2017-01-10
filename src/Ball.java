import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends JComponent
	{
	
		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		boolean phisicsEnabled = false;
		int ballSpeed;
		BufferedImage  ballImg;
		

		private int locX = 1;
		private int locY = 1;
		private int speed = 5;
		private int directionX = 1;
		private int directionY = 1;

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
