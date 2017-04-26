package gsu.tetris.ui;

import java.awt.*;
import javax.swing.JFrame;

import gsu.tetris.config.Config;
import gsu.tetris.config.GameConfig;

/**
 * @author ASUS
 *	JFrame configuration
 */
public class FrameGame extends JFrame {
	

	public FrameGame(PanelGame panel){
		//get game config data
		GameConfig cfg = Config.getGameConfig();
		//set title
		this.setTitle(cfg.getTitle());
		//set default close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set window size
		this.setSize(cfg.getWidth(),cfg.getHeight());
		//lock window size
		this.setResizable(false);
		//get user screen size to display window at center
		Toolkit toolkit =  Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		//get approximate location and set position
		int x = screen.width/5;
		int y = screen.height/5;
		this.setLocation(x, y);
		//set default panel
		this.setContentPane(panel);
		//default window visible
		this.setVisible(true);
	}

}
