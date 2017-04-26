package gsu.tetris.config;

public class Config {
	
	private static GameConfig GAME_CONFIG;
	
	static{
		try {
			GAME_CONFIG = new GameConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static GameConfig getGameConfig(){
		return GAME_CONFIG;
		
	}

	
	
}
