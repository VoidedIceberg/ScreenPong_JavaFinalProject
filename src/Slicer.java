import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Slicer
{	
	private int rows;
	private int cols;
	
 	public BufferedImage [] slice(BufferedImage image) throws  IOException, AWTException
	{
		System.out.println(Integer.toString(image.getWidth()) + "," + Integer.toString(image.getHeight()));
	    rows = 4; //You should decide the values for rows and cols variables
	    cols = 4;
	    int chunks = rows * cols;
	    int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
	    int chunkHeight = image.getHeight() / rows;
	    int count = 0;
	        
	    BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
	        
		for (int x = 0; x < rows; x++) 
		{
			 for (int y = 0; y < cols; y++) 
			 {
	             //Initialize the image array with image chunks
	             imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

	             // draws the image chunk
	             Graphics2D gr = imgs[count++].createGraphics();
	             gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
	             gr.dispose();
	         }
		}
			        
	    return imgs;
	}
  	public int getRows()
  	{
	  return rows;
  	}
  	public int getCols()
  	{
  		return cols;
  	}

}
