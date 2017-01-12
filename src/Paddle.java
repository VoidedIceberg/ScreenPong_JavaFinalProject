import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Paddle extends JComponent{

    private int dx;
    
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private BufferedImage  paddleImg;
	

	private int locX = 1;
	private int locY = 1;
	
    public Paddle() {

		try {
		paddleImg = ImageIO.read(new File("images/paddle.png"));
		} catch (IOException e) {
		}
		
        resetState();
    }

    
	public void move(Frame f) {
		f.addKeyListener(new KeyListener() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	int key = e.getKeyCode();

	            if (key == KeyEvent.VK_LEFT) {
	                dx = -1;
	            }

	            if (key == KeyEvent.VK_RIGHT) {
	                dx = 1;
	            }
	        	}
			@Override
			public void keyReleased(KeyEvent b) {	
				int key = b.getKeyCode();

		        if (key == KeyEvent.VK_LEFT) {
		            dx = 0;
		        }

		        if (key == KeyEvent.VK_RIGHT) {
		            dx = 0;
		        }
			}
			@Override
			public void keyTyped(KeyEvent arg0) {				}	        


	    });
       locX += dx * 25;
       
       
        if (locX >= screenSize.getWidth() - paddleImg.getWidth()) {
        	locX = (int) (screenSize.getWidth() - paddleImg.getWidth());
        }
		this.setBounds(locX, locY, paddleImg.getWidth(), paddleImg.getHeight());
    }
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -10;
            System.out.println("test");
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 10;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    private void resetState() {

        locX = 500;
        locY = 980;
        
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