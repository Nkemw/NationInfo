package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

//지도에서 대륙을 선택했을 때 보여주는 패널
public class PnContinent extends JPanel {

	ImageIcon africaImg = new ImageIcon("./Images/map/africa.PNG");
	ImageIcon asiaImg = new ImageIcon("./Images/map/asia.PNG");
	ImageIcon europeImg = new ImageIcon("./Images/map/europe.PNG");
	ImageIcon nAmericaImg = new ImageIcon("./Images/map/nAmerica.PNG");
	ImageIcon sAmericaImg = new ImageIcon("./Images/map/sAmerica.PNG");
	ImageIcon oceaniaImg = new ImageIcon("./Images/map/oceania.PNG");
	
	public ImageIcon currentImage;
	
	private JPanel continentPn;
	private JLabel continentLb;
	
	public PnContinent() {
		
		
		setLayout(null);
		
		JButton countriesMenuBt = new JButton("Countries");
		countriesMenuBt.setBounds(400, 33, 91, 31);
		add(countriesMenuBt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 74, 291, 341);
		add(scrollPane);
		// 스크롤패인 안 국가들 목록이 쫙 나오게!
		
		
		continentLb = new JLabel("");
		continentLb.setBounds(12, 10, 376, 431);
		add(continentLb);
		
		


	}
	
	public void selectCont(int choice) {
		
		
		switch (choice) {

		case 0: continentLb.setIcon(africaImg);
		break;
		case 1: continentLb.setIcon(asiaImg);
		break;
		case 2: continentLb.setIcon(europeImg);
		break;
		case 3: continentLb.setIcon(nAmericaImg);
		break;
		case 4: continentLb.setIcon(oceaniaImg);
		break;
		case 5: continentLb.setIcon(sAmericaImg);
		break;
		default:
			continentLb.setIcon(africaImg);
		break;
		}
		
		

	}
}