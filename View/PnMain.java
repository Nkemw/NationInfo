package View;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * 화면 전환 담당
 */

public class PnMain extends JPanel {
	//JPanel 객체
	private ArrayList<JPanel> jpanels = new ArrayList<JPanel>();
	private PnFirst pnFirst;
	private PnSearch_main pnSearch_main;

	//JButton 객체

	public PnMain() {
		// TODO Auto-generated constructor stub

		setBounds(0, 0, 836, 472);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
		
		pnSearch_main = new View.PnSearch_main();
		pnFirst = new PnFirst();
		jpanels.add(pnSearch_main);
		jpanels.add(pnFirst);
//		PnSearch_result pnSearch_result = new PnSearch_result();
//		PnGame pnGame = new PnGame();
		
		//PnFirst 패널 활성화
		this.add(pnFirst);
		this.add(pnSearch_main);
		activatePanel(pnFirst);

//		this.add(pnGame);
//		this.add(pnSearch_result);
//		pnGame.setVisible(false);
//		pnSearch_result.setVisible(false);


		JButton searchPanel_Button = new JButton("");
//		searchPanel_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\green_Earth.png"));
		searchPanel_Button.setBounds(100, 240, 150, 130);
		searchPanel_Button.setBorderPainted(false);
		searchPanel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnSearch_main.setVisible(true);
			}
		});

		pnFirst.add(searchPanel_Button);
		
//		JButton gamePanel_Button = new JButton("");
////		gamePanel_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\blue_Earth.png"));
//		gamePanel_Button.setBounds(574, 240, 150, 130);
//		gamePanel_Button.setBorderPainted(false);
//		pnFirst.add(gamePanel_Button);
		
		
		

		
//		gamePanel_Button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				pnFirst.setVisible(false);
//				pnGame.setVisible(true);
//			}
//		});
	}

	// 특정 패널만 setVisible 시키는 메소드
	private void activatePanel(JPanel target) {
		for (JPanel penal : jpanels) {
			if (penal == target) {
				penal.setVisible(true);
			}
			else {
				penal.setVisible(false);
			}
		}
	}
}
