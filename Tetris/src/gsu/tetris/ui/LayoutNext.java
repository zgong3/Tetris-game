package gsu.tetris.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayoutNext extends Layout {
	
	private static final Image[] NEXT_ACT;
	
	static{
		
		NEXT_ACT = new Image[7];
		for(int i = 0; i<NEXT_ACT.length; i++){
			NEXT_ACT[i] = new ImageIcon("graphics/game/"+i+".png").getImage();
		}
		
	}
			

	
	
	public LayoutNext(int x, int y, int w, int h){
		super(x,y,w,h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		int type = this.dto.getNext();
		
			if(type == 4)
				g.drawImage(NEXT_ACT[type], this.x+65, this.y+40, null);
			else if(type == 0)
				g.drawImage(NEXT_ACT[type], this.x+33, this.y+50, null);
			else
				g.drawImage(NEXT_ACT[type], this.x+45, this.y+40, null);
		
		
		
		}
		
	}
	


