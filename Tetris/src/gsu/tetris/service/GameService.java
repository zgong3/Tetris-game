package gsu.tetris.service;

import java.awt.Point;
import java.util.Random;

import javax.swing.JOptionPane;

import gsu.tetris.dto.GameDto;
import gsu.tetris.entity.Tetromino;

/**
 * @author Zhanpeng Gong
 *	Service logic processing
 */
public class GameService{
	
	private static Random rand = new Random();
	private static GameDto dto;
	
	public GameService(GameDto dto){
		GameService.dto = dto;
	}
	
	public void keyUp() {
		dto.getGameTet().rotate(dto.getGameMap());
		
	}

	public static void keyDown() {
		//Determine whether cubes successfully moved
		if(dto.getGameTet().move(0, 1, dto.getGameMap())){
			return;
		}
			//get game map object
			boolean[][] map = dto.getGameMap();
			//get cube object
			Point[]act = dto.getGameTet().getTetPoints();
			//pile up cubes in the bottom
			for(int i = 0 ; i < act.length;i++){
				
				map[act[i].x][act[i].y] = true;
				
			}
			
			int exp = findLine();
			//Count score and level base on cleared lines
			levelUp(exp);

			//Insert a new shape
			dto.getGameTet().init(dto.getNext());
			switch(dto.getNext()){
			case 0: dto.count[0]++; 
				break;
			case 1: dto.count[1]++; 
				break;
			case 2: dto.count[2]++; 
				break;
			case 3: dto.count[3]++; 
				break;
			case 4: dto.count[4]++; 
				break;
			case 5: dto.count[5]++; 
				break;
			case 6: dto.count[6]++; 
				break;

		}	
			//Randomly select the tetromino to insert
			dto.setNext(rand.nextInt(7));
			
			//Check if the player has lost
			if(gameOver()){
				
			 dto.setGameOn(false);
			 dto.setGameOver(true);
						
			}
		
		
	}

	
	/**
	 * Determine is the game is over base on tetromino positions
	 */
	private static boolean gameOver() {
		//Get current game map
		Point[] actPoints = dto.getGameTet().getTetPoints();
		boolean[][] map = dto.getGameMap();
		for(int i = 0; i < actPoints.length; i++){
			if(map[actPoints[i].x][actPoints[i].y]){
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Level up every 20 line
	 */
	private static void levelUp(int exp) {
		int level = dto.getLevel();
		int line = dto.getCurrentLine();
		if(line % 20 + exp >= 20){
			
			level ++;
			dto.setLevel(level);

			
		}
		
		dto.setCurrentLine(line + exp);
	}
	

	/**
	 * Scan game map to fine line
	 */
	private static int findLine() {
		boolean [] [] map = dto.getGameMap();
		int exp = 0;
		for(int y = 0; y < 18; y++){
		
			if(canRemove(y,map)){
			
				removeLine(y, map);
				exp++;
				
			}
				
			}
		return exp;
		
	}
	

	/**
	 *Remove line
	 */
	private static void removeLine(int rowNumber, boolean[][] map) {
		for(int x = 0; x < 10; x++){
			for(int y = rowNumber; y > 0; y-- ){
				map[x][y] = map[x][y - 1];
			}
			
			map[x][0] = false;
		}
		
	}
	
	
	/**
	 * Check if the line can be deleted
	 */
	private static boolean canRemove(int y, boolean[][] map){
		
		for(int x = 0; x < 10; x++){
			if(!map[x][y]){
				return false;
			}
		}
		
		return true;
		
	}
	
	
	public void keyLeft() {

		dto.getGameTet().move(-1, 0,dto.getGameMap());
		
	}

	public void keyRight() {

		dto.getGameTet().move(1, 0,dto.getGameMap());
		
	}
	
	
	/**
	 * Increase score when K is pressed
	 */
	public void cheat(){
		
		int rmline = dto.getCurrentLine();
		int lv = dto.getLevel();
		rmline += 1;
		if(rmline % 20 == 0){
			lv += 1;
		}
		dto.setLevel(lv);
		dto.setCurrentLine(rmline);
		
	}
	

	/**
	 * Start thread, begin game
	 */
	public void startThread() {

		Tetromino act = new Tetromino(rand.nextInt(6));
		if(!dto.isGameOn()){
		dto.setGameTet(act);
		dto.setGameOn(true);
		}
		else
			JOptionPane.showMessageDialog(null, "The game has already started.");
	}
	
	

	
}
