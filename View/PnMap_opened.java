package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//지도 패널
public class PnMap_opened extends JPanel {
	private Image img;
	
	
	public PnMap_opened() {
		img = new ImageIcon("./Images/worldmap2.PNG").getImage();
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

