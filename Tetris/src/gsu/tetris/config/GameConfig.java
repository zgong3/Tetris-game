package gsu.tetris.config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author ASUS
 *	Reading config parameters from XML
 */
public class GameConfig {
	
	private String title;
	private int width;
	private int height;
	private int size;
	
	private List<LayoutConfig> ConfigLayout;
	
	public GameConfig() throws Exception{
		//Create XML reader
		SAXReader reader = new SAXReader();
		//Read XML file
		Document doc = reader.read("config/config.xml");
		//Get elements in XML file
		Element game = doc.getRootElement();
		//Config window parameters
		setWindowConfig(game.element("frame"));

		
		}
		private void setWindowConfig(Element frame){
			//get window width
			this.width = Integer.parseInt( frame.attributeValue("width"));
			//get window height
			this.height = Integer.parseInt( frame.attributeValue("height"));
			//get frame size
			this.size = Integer.parseInt( frame.attributeValue("size"));
			//get title
			this.title =  frame.attributeValue("title");
			//get window attribute
			@SuppressWarnings("unchecked")
			List<Element> layouts = frame.elements("Layout");
			ConfigLayout = new ArrayList<LayoutConfig>();
			for(Element Layout : layouts){
				//set attribute for each window
				LayoutConfig config = new LayoutConfig(
						Layout.attributeValue("class"),	
						Integer.parseInt(Layout.attributeValue("x")),
						Integer.parseInt(Layout.attributeValue("y")),
						Integer.parseInt(Layout.attributeValue("w")),
						Integer.parseInt(Layout.attributeValue("h"))
						);
		
				ConfigLayout.add(config);
		}
		
	}
		
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
		public int getSize() {
			return size;
		}
		public List<LayoutConfig> getConfigLayout() {
			return ConfigLayout;
		}	
		public String getTitle(){
			return title;
		}
		

}
