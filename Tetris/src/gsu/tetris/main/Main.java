package gsu.tetris.main;
import gsu.tetris.control.GameControl;
import gsu.tetris.control.PlayerControl;
import gsu.tetris.dto.GameDto;
import gsu.tetris.service.GameService;
import gsu.tetris.ui.FrameGame;
import gsu.tetris.ui.PanelGame;

/**
 * @author Zhanpeng Gong
 *	Main method to start program
 */
public class Main {
	
	public static void main(String[]args){
		//Create game data source
		GameDto dto  = new GameDto();
		
		//Create game panel
		PanelGame panel = new PanelGame(dto);
		
		//Create game logic field
		GameService service = new GameService(dto);
		
		//Create game control and link panel to logic
 		GameControl gameControl = new GameControl(panel,service, dto);
 		
 		//Create player control and link to controller
		PlayerControl control = new PlayerControl(gameControl, dto);

		//Install player control
		panel.setGameControl(control);
		
		//Create game window and install panel
		new FrameGame(panel);
		
	}

}
