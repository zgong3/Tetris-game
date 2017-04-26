package gsu.tetris.ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayoutCount extends Layout {
	
	private static final Image[] SHAPE;
	static{
		
		SHAPE = new Image[7];
		for(int i = 0; i<SHAPE.length; i++){
			SHAPE[i] = new ImageIcon("graphics/game/"+i+".png").getImage();
		}
		
	}
	
	public LayoutCount(int x, int y, int w, int h){
		super(x,y,w,h);
		
		
		
	}
	public void paint(Graphics g){
		this.createWindow(g);

		int space = 35;
		for(int i = 0; i < SHAPE.length; i++){
		g.drawImage(SHAPE[i], this.x+26, this.y+space,null);
		this.drawNumber(this.x+160, this.y+space-20 , this.dto.getCount()[i], g);
		space += 80;
		}
		
		
		
	}

}
