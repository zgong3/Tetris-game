package gsu.tetris.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import gsu.tetris.dto.GameDto;

/**
 * @author Zhanpeng Gong
 *	Player control class
 */
public class PlayerControl extends KeyAdapter{

	//Access to data transfer object and game control
	private GameDto dto;
	private GameControl control;
	
	
	/**
	 * Constructor
	 * @param control
	 * @param dto
	 */
	public PlayerControl(GameControl control, GameDto dto) {
		this.control = control;
		this.dto = dto;

	}


	/**
	 * Key press action event 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	if(dto.isGameOn()){
		//Match keys to each action method
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			this.control.keyUp();
			
			break;
		case KeyEvent.VK_DOWN:
			this.control.keyDown();
			
			break;
		case KeyEvent.VK_LEFT:
			this.control.keyLeft();
			
			break;
		case KeyEvent.VK_RIGHT:
			this.control.keyRight();
			
			break;
			
		case KeyEvent.VK_K:
			this.control.keyCheat();
			
			break;
		default:
			break;
		
		}
	}else if(dto.isGameOver()){
		//If the game is over, show game over message and exit program
		JOptionPane.showMessageDialog(null, "GAME OVER");
		System.exit(0);
	}
	else
		//If the game has not start when button is pressed, notify user
		JOptionPane.showMessageDialog(null, "You have not started the game yet.");
	
	}

}
