package gsu.tetris.dto;

import gsu.tetris.entity.Tetromino;

/**
 * @author Zhanpeng Gong
 *	Data transfer object class
 */
public class GameDto {
	
	private boolean[][] gameMap;
	
	private Tetromino tetromino;
	
	private int next;
	
	private int level;
	
	private int currentScore;
	
	private int currentLine;
	
	private int difficulty;
	
	private boolean gameOn;
	
	private boolean gameOver;
	
	
	
	public int[] count = new int[7];
	
	
	
	public GameDto(){
		dtoInit();
		
	}
	
	
	//Data initialization
	public void dtoInit(){
		this.gameMap = new boolean[10][18];
		
	}
	
	

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public Tetromino getGameTet() {
		return tetromino;
	}

	public void setGameTet(Tetromino gameAct) {
		this.tetromino = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCurrentScore() {
		
		//Increase score gain based on current level
		switch(level){
		case 0:
			currentScore = currentLine*10;
			break;
		case 1:
			currentScore = currentLine*12;
			break;
		case 2:
			currentScore = currentLine*15;
			break;
		case 3:
			currentScore = currentLine*19;
			break;
		case 4:
			currentScore = currentLine*23;
			break;
		case 5:
			currentScore = currentLine*29;
			break;
		case 6:
			currentScore = currentLine*36;
			break;
		case 7:
			currentScore = currentLine*44;
			break;
		case 8:
			currentScore = currentLine*53;
			break;
		case 9:
			currentScore = currentLine*63;
			break;
		default:
			currentScore = currentLine*75;
			break;
		
		}
		
		return currentScore;
	}
	


	public int getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(int currentLine) {
		this.currentLine = currentLine;
	}


	public int[] getCount() {
		return count;
	}


	public boolean isGameOn() {
		return gameOn;
	}


	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}


	public boolean isGameOver() {
		return gameOver;
	}


	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	

}
