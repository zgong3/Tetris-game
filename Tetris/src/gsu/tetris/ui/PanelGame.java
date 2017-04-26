package gsu.tetris.ui;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import gsu.tetris.config.Config;
import gsu.tetris.config.GameConfig;
import gsu.tetris.config.LayoutConfig;
import gsu.tetris.control.GameControl;
import gsu.tetris.control.PlayerControl;
import gsu.tetris.dto.GameDto;

/**
 * @author ASUS
 *	Game panel configuration
 */
public class PanelGame extends JPanel{
	
	private GameDto dto;
	
	private JButton start;
	
	private static final ImageIcon START = new ImageIcon("graphics/other/startbutton.png");
	
	private List<Layout> layers =null;
	

	/**
	 * Constructor
	 */
	public PanelGame(GameDto dto){
		
		//Receive dto object
		this.dto = dto;
		
		this.setLayout(null);

		initialComponent();
		initialLayer();

	
	}
	
	
	/**
	 * Install player control
	 */
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	
	
	/**
	 * Start button configuration
	 */
	private void initialComponent(){
	
	
		//Config start button
		this.start = new JButton(START);
		start.setBounds(832, 40, 324, 85);
		this.add(start);
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GameControl.start();
				
			}
			
		});
		
		

	}

	/**
	 * Window layers configuration
	 */
	private void initialLayer(){
		try{
			//Get game config
			GameConfig cfg = Config.getGameConfig();
			//Get layout config
			List<LayoutConfig> LayersCfg = cfg.getConfigLayout();
			//Create window layers
			layers = new ArrayList<Layout>(LayersCfg.size());
			//Create all layers object
			for(LayoutConfig LayoutCfg : LayersCfg ){
				//get class object
				Class <?> cls = Class.forName(LayoutCfg.getClassName());
				//get constructor parameter
				Constructor<?> ctr = cls.getConstructor(int.class,int.class,int.class,int.class);
				//transfer constructor object
				Layout layer = (Layout)ctr.newInstance(
						LayoutCfg.getX(),LayoutCfg.getY(),LayoutCfg.getW(),LayoutCfg.getH());
				//set game data object
				layer.setDto(this.dto);
				layers.add(layer);
			
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		};
	
	

	/**
	 * Draw window frames 
	 */
@Override
public void paintComponent(Graphics g){
		//parent class transfer
		super.paintComponent(g);
		//display game window
		for(int i = 0;i<layers.size();i++){

			layers.get(i).paint(g);
			
		}
		//change focal point
		this.requestFocus();
}



}
