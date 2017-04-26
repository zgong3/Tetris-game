package gsu.tetris.ui;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import gsu.tetris.entity.Tetromino;

public class LayoutGame extends Layout {
	private static final Image TET = new ImageIcon("graphics/game/rect.png").getImage();
	
	private static final int TET_SIZE =32 ;
	
	public LayoutGame(int x, int y, int w, int h){
		super(x,y,w,h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		Tetromino act = this.dto.getGameTet();
		if(act != null){
		Point[]points = act.getTetPoints();
		//get shape type code (0-6)
		int ShapeCode = this.dto.getGameTet().getshapeCode();
		//print shape image
		for(int i = 0; i<points.length;i++){
			drawTetByPoint(points[i].x, points[i].y, ShapeCode, g);
		
		}
		//print game map
		boolean[][] map = this.dto.getGameMap();
		for(int x = 0; x<map.length; x++){
			for(int y = 0; y<map[x].length; y++){
				if(map[x][y])
					drawTetByPoint(x, y, 7, g);
					
				
			}
			
		}
		}
	}
	
	private void drawTetByPoint(int x, int y, int imgIdx, Graphics g){
		
		g.drawImage(TET, 
				this.x+x * TET_SIZE+Frame, 
				this.y+y * TET_SIZE+Frame, 
				this.x+x * TET_SIZE+TET_SIZE+Frame, 
				this.y+y * TET_SIZE+TET_SIZE+Frame,
				(imgIdx+1)*TET_SIZE, 0, (imgIdx+1)*TET_SIZE + TET_SIZE, TET_SIZE, null);
	}
	
}
