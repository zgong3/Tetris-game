package gsu.tetris.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayoutLevel extends Layout {
	private static final Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	
	public LayoutLevel(int x, int y, int w, int h){
		super(x,y,w,h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(LEVEL, this.x+34, this.y+16,null);
		
		if(this.dto.getLevel()<10)
		this.drawNumber(55, 65 , this.dto.getLevel(), g);
		else
			this.drawNumber(45, 65 , this.dto.getLevel(), g);
	}
	
	
	
}
