import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JComponent;
import javax.tools.DocumentationTool.Location;

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
	public class Block extends JComponent
	{
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int screenHight;
	private int screenWidth;
	private int indexNum;
	private int rows;
	private int cols;
	
	private BufferedImage[] imgAray;;


	private Point[] location;
	private boolean[] hasBeenHit;
	
    private Slicer slicer;
    private ScreenCap screenCap;
    private BufferedImage screen;

	public Block() 
	{
		screenHight= screenSize.height;
		screenWidth  = screenSize.width;
		

		slicer = new Slicer();
		screenCap = new ScreenCap();
			
        try {
			screen = screenCap.capScreen();
	        imgAray = slicer.slice(screen);

		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}
        
		rows = slicer.getRows();
		cols = slicer.getCols();
		
		location = new Point[imgAray.length];
		for(int i = 0; i < location.length; i++) {
		    location[i] = new Point();
		}
		
        indexNum = 0;
	}
	
	private int preWidth = 0;
	private int preHight = 0;
	
	public void populateLocations()
	{
		System.out.println("testing");

		
		for (int i = 0; i <=  imgAray.length -1; i++ )
		{
			if (i != rows)
			{
				location[i].setLocation( preWidth, preHight );
				preWidth = preWidth + imgAray[0].getWidth();
			}
			if ( i % 4 == 0 && i != 0)
			{
				preHight =  preHight + imgAray[0].getHeight();
			    location[i].setLocation( 0, preHight );
			}
		}

		
	}
	public Point[] getLocationPoint() {
		return location;
	}
	public BufferedImage[] getImgAray() {
		return imgAray;
	}
	
	
	
}
