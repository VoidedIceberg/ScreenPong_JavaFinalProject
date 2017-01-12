import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Paddle {

    private int dx;
    
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage  paddleImg;
	

	private int locX = 1;
	private int locY = 1;
	
    public Paddle() {

		try {
		paddleImg = ImageIO.read(new File("images/paddle.png"));
		} catch (IOException e) {
		}

        resetState();
    }

	public void move() {

        locX += dx;

        if (locX <= 0) {
            locX = 0;
        }
        
        if (locX >= screenSize.getWidth() - paddleImg.getWidth()) {
        	locX = (int) (screenSize.getWidth() - paddleImg.getWidth());
        }
    }

    private void resetState() {

        locX = 500;
        locY = 820;
        
    }

    public BufferedImage getPaddleImg() {
		return paddleImg;
	}

	public void setPaddleImg(BufferedImage paddleImg) {
		this.paddleImg = paddleImg;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}
}