import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
	public class Block extends JComponent
	{

	private int index;	
	
	
	private Point[] location;
	private BufferedImage img;
	private Point imgLocation;
	private BufferedImage[] imgAray;
	private Rectangle rect;
	private Boolean destroyed;

	public Block(int index, BufferedImage imgA, BufferedImage[] imgAray) 
	{		
		this.index = index;
		this.imgAray = imgAray;
		img = imgA;
		imgLocation = new Point();
		
		location = new Point[imgAray.length];
		for(int i = 0; i < location.length; i++) {
		    location[i] = new Point();
		}
		populateLocations();
		
		imgLocation = location[index];
		
		rect = new Rectangle();
		
		rect.setBounds(imgLocation.x, imgLocation.y, img.getWidth(), img.getHeight());
		
		this.setBounds(rect);
		destroyed = false;
	}
	


	private int preWidth = 0;
	private int preHight = 0;
	
	public void populateLocations()
	{
		for (int i = 0; i <= imgAray.length - 1; i++ )
		{
			if (i % 4 != 0 || i == 0)
			{
				location[i].setLocation( preWidth, preHight );
				preWidth = preWidth + img.getWidth();
			}
			else if ( i % 4 == 0 && i != 0)
			{
				preHight =  preHight + img.getHeight();
			    location[i].setLocation( 0, preHight );
				preWidth =  img.getWidth();

			}
		}

		
	}

	public Point getLocationPoint() {
		return imgLocation;
	}
	public void setLocation(Point[] location) {
		this.location = location;
	}

	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public void setImgLocation(Point imgLocation) {
		this.imgLocation = imgLocation;
	}

	public Rectangle getRect() {
		return rect;
	}

	public Boolean getDestroyed() {
		return destroyed;
	}

	public void setDestroyed(Boolean destroyed) {
		this.destroyed = destroyed;
	}

}
