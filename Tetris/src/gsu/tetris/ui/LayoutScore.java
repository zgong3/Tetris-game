package gsu.tetris.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayoutScore extends Layout {
	
	private static final Image SCORE = new ImageIcon("graphics/string/score.png").getImage();
	
	private static final Image LINES = new ImageIcon("graphics/string/lines.png").getImage();
	
	private static final Image BAR = new ImageIcon("graphics/other/bar.png").getImage();
	
	private static final Image AUTHOR = new ImageIcon("graphics/string/myname.png").getImage();
	
	//TODO
	private static final int LEVELUP = 20;
	
	public LayoutScore(int x, int y, int w, int h){
		super(x,y,w,h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		
		//draw current score word
		g.drawImage(SCORE, this.x+34, this.y+26,null);
		
		//draw current score number
		this.drawNumber(190, 30 , this.dto.getCurrentScore(), g);
		
		//draw lines word
		g.drawImage(LINES, this.x+28, this.y+96,null);

		//draw line number
		this.drawNumber(190, 100 , this.dto.getCurrentLine(), g);
		
		//draw experience bar
		int rmline = this.dto.getCurrentLine();
		this.drawBar((double)(rmline % LEVELUP), (double)LEVELUP, g);
		
		//draw author name
		g.drawImage(AUTHOR, this.x+30, this.y+230,null);
	
		
	}
private void drawBar(double value, double maxValue, Graphics g){
		
		//draw experience bar
		g.setColor(Color.blue);
		g.fillRect(this.x + 40, this.y +170, 250, 40);
		
		g.drawImage(BAR, this.x+45, this.y+175,null);

		

		int progress = (int)((value/maxValue) * 236) ;
		g.setColor(Color.blue);
		g.fillRect(this.x + 47, this.y +177, progress, 26);
		}
}
