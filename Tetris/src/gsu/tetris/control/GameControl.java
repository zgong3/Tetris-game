package gsu.tetris.control;


import gsu.tetris.dto.GameDto;
import gsu.tetris.service.GameService;
import gsu.tetris.ui.PanelGame;

/**
 * @author Zhanpeng Gong
 *	Receive user key event, control game action command and change display
 */
public class GameControl {
	
	

	//Access to game panel, service and data transfer object class
	private static PanelGame panelGame;
	private static GameService service;
	private static GameDto DTO;
	
	//Create main game thread
	private static Thread gameThread;
	
	
	/**
	 * Constructor
	 * @param panelGame
	 * @param service
	 * @param DTO
	 */
	public GameControl(PanelGame panelGame, GameService service, GameDto DTO) {
	
	GameControl.panelGame = panelGame;
	GameControl.service = service;
	GameControl.DTO = DTO;
	}



	/**
	 * Up key command
	 */
	public void keyUp() {
		GameControl.service.keyUp();
		GameControl.panelGame.repaint();
		
	}

	
	/**
	 * Down key command
	 */
	public void keyDown() {
		
		GameService.keyDown();
		GameControl.panelGame.repaint();
		
		
	}

	/**
	 * Left key command
	 */
	public void keyLeft() {
		GameControl.service.keyLeft();
		GameControl.panelGame.repaint();
		
	}

	/**
	 * Right key command
	 */
	public void keyRight() {
		GameControl.service.keyRight();
		GameControl.panelGame.repaint();
		
	}
	
	
	/**
	 * Cheat key command
	 */
	public void keyCheat() {
		GameControl.service.cheat();
		GameControl.panelGame.repaint();
		
	}


	
	/**
	 * Start game thread
	 */
	public static void start() {
		service.startThread();
		panelGame.repaint();
		//Create thread object
		gameThread = new Thread(){
			@Override
			public void run(){

				//Loop to move shapes down continually until game over
				while(!DTO.isGameOver()){
					int speed = DTO.getLevel();
					try {
						//Increase fall speed base on level of difficulty
						switch(speed){
						case 0:
							Thread.sleep(800);
							break;
						case 1:
							Thread.sleep(750);
							break;
						case 2:
							Thread.sleep(700);
							break;
						case 3:
							Thread.sleep(650);
							break;
						case 4:
							Thread.sleep(600);
							break;
						case 5:
							Thread.sleep(550);
							break;
						case 6:
							Thread.sleep(500);
							break;
						case 7:
							Thread.sleep(450);
							break;
						case 8:
							Thread.sleep(400);
							break;
						case 9:
							Thread.sleep(350);
							break;
						default:
							Thread.sleep(300);
							break;
						
						}
			
						
						
					GameService.keyDown();
					panelGame.repaint();
					
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		};
		gameThread.start();
	}
	
	
	

}
