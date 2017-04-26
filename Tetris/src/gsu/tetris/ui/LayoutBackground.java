package gsu.tetris.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class LayoutBackground extends Layout {
	// Import image file directory then add to list
	File dir =  new File("graphics/background");
	File[] files = dir.listFiles();
	public static List<Image> IMAGE_LIST;
	

	public LayoutBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		
		//Get each image from list
		IMAGE_LIST = new ArrayList<Image>();
		for(File file: files){
			IMAGE_LIST.add(new ImageIcon(file.getPath()).getImage());
		}
		//Display background images, repeat every 10 level
		int ImageIdx = this.dto.getLevel() % IMAGE_LIST.size();
		g.drawImage(IMAGE_LIST.get(ImageIdx),0,0,1220,770,null);

	}

}
