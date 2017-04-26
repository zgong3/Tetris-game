package gsu.tetris.entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhanpeng Gong
 *	Tetrominoes configuration
 */
public class Tetromino {
	
	private Point[] tetPoints;
	
	private int tetCode;
	
	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	//Initialize tetromino points
	private static List<Point[]>TET_CONFIG;
	static{
		TET_CONFIG = new ArrayList<Point[]>(7);
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0)});
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(4,1)});
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1)});
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(3,1),new Point(4,1)});
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(5,1)});
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(5,1)});
		TET_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1)});
	}
	
	public Tetromino(int shapeCode){
		
		this.init(shapeCode);	
		
		
	}
	
	public void init(int tetCode){
		this.tetCode = tetCode;
		Point[] points = TET_CONFIG.get(tetCode);
		tetPoints = new Point[points.length];
		for(int i = 0; i<points.length; i++){
			
			tetPoints[i] = new Point(points[i].x, points[i].y);
			
		}
		
	}

	public Point[] getTetPoints() {
		return tetPoints;
	}
	
	//Method to determine if the tetromino can be moved
	public boolean move(int moveX,int moveY, boolean[][] gameMap){
	//Movement command
	for(int i = 0; i<tetPoints.length;i++){
		int newX = tetPoints[i].x + moveX;
		int newY = tetPoints[i].y + moveY;
		if(isOffMap(newX, newY,gameMap)){
			return false;
		}
	}
	for(int i = 0; i<tetPoints.length;i++){
		tetPoints[i].x += moveX;
		tetPoints[i].y += moveY;
		
	}
	return true;
	
}
	
	/**
	 * Rotate tetromino clockwise
	 * equation: 
	 *	A.x = 0.y + 0.x - B.y
	 *	A.y = 0.y - 0.x + B.x
	 * 
	 */
	public void rotate(boolean[][] gameMap){
		if(this.tetCode == 4 ){
			return;
		}
		for(int i = 1; i < tetPoints.length; i++){
			int newX = tetPoints[0].y + tetPoints[0].x - tetPoints[i].y;
			int newY = tetPoints[0].y - tetPoints[0].x + tetPoints[i].x;
			
			//determine if the tetromino can be rotated
			if(this.isOffMap(newX, newY, gameMap)){
			return;
			}
			
		}
		for(int i = 1; i < tetPoints.length; i++){
			
			int newX = tetPoints[0].y + tetPoints[0].x - tetPoints[i].y;
			int newY = tetPoints[0].y - tetPoints[0].x + tetPoints[i].x;
			
			tetPoints[i].x = newX;
			tetPoints[i].y = newY;
		}
		
		
		
	}

	
	/** 
	 * Determine if is out of boundary
	 */
	private boolean isOffMap(int x, int y, boolean[][] gameMap){
		return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y];
		
	}
	public int getshapeCode(){
		return tetCode;
	}
	
}
