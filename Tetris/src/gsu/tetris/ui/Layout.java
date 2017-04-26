package gsu.tetris.ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import gsu.tetris.config.Config;
import gsu.tetris.config.GameConfig;
import gsu.tetris.dto.GameDto;


/**
 * @author ASUS
 *	Abstract class for displaying UI
 */
public abstract class Layout {
	//Size of frame corner
	protected static final int SIZE;
	//Width of frame
	protected static final int Frame = 7;
	static{
		//Get size value from XML file
		GameConfig cfg = Config.getGameConfig();
		SIZE = cfg.getSize();
		
	}
	//Get image from source
	private static Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	//Get image width and height
	private static int WIDTH = WINDOW.getWidth(null);
	private static int HEIGHT = WINDOW.getHeight(null);
	//Position x from upper left corner
	protected int x;
	//Position y from upper left corner
	protected int y;
	//Window WIDTH
	protected int w;
	//Window HEIGHT
	protected int h;
	
	//Access to game data
	protected  GameDto dto;
	
	//Level number image
	private static final Image NUMBER = new ImageIcon("graphics/string/levelnum.png").getImage();
	
	
	//Width and height of each number in the image
	private static final int NUMBER_WIDTH = 26;
	private static final int NUMBER_HEIGHT = 36;
	
	//Constructor
	protected Layout(int x, int y, int w, int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		
	}
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	
	/**
	 * Method to draw windows
	 * @param g drawing object
	 */
	protected void createWindow(Graphics g){
		//crop and display image for top left corner
		g.drawImage(WINDOW, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//crop and display image for up side
		g.drawImage(WINDOW, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WIDTH-SIZE, SIZE, null);
		//upper right corner
		g.drawImage(WINDOW, x+w-SIZE, y, x+w, y+SIZE, WIDTH-SIZE, 0, WIDTH, SIZE, null);
		//left side
		g.drawImage(WINDOW, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WIDTH-SIZE, null);
		//center
		g.drawImage(WINDOW, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WIDTH-SIZE, HEIGHT-SIZE, null);
		//right side
		g.drawImage(WINDOW, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WIDTH-SIZE, SIZE, WIDTH, HEIGHT-SIZE, null);
		//lower left corner
		g.drawImage(WINDOW, x, y+h-SIZE, x+SIZE, y+h, 0, HEIGHT-SIZE, SIZE, HEIGHT, null);
		//down side
		g.drawImage(WINDOW, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, HEIGHT-SIZE, WIDTH-SIZE, HEIGHT, null);
		//lower right corner
		g.drawImage(WINDOW, x+w-SIZE, y+h-SIZE, x+w, y+h, WIDTH-SIZE, HEIGHT-SIZE, WIDTH, HEIGHT, null);
			
		
	}

	//Abstract paint method
	protected abstract void paint(Graphics g);
	
		
		/**
		 * @param x position x from upper left corner
		 * @param y position y from upper left corner
		 * @param num numbers to be displayed
		 * @param g drawing object
		 */
		protected void drawNumber(int x, int y, int num, Graphics g){
			
			//convert number to be print into string
			String NumStr = Integer.toString(num);
			
			//for loop print number based on length and get each digit from string
			for(int i = 0; i < NumStr.length();i++){		
				int bit = NumStr.charAt(i) - '0';
				g.drawImage(NUMBER, 
						this.x + x + NUMBER_WIDTH * i, this.y + y, this.x + x 
						+ NUMBER_WIDTH * (i+1), this.y + y + NUMBER_HEIGHT, 
						bit * NUMBER_WIDTH, 0, (bit + 1) * NUMBER_WIDTH, NUMBER_HEIGHT, null);
				
			}
			
			
			
		}
	
}
