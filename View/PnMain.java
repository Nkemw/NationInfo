package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//매인 패널 클래스
public class PnMain extends JPanel {

	public PnMain() {
		//기본값 설정
		setBounds(0, 0, 836, 472);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
		
		//메인 검색 패널 객체생성
		PnSearch_main pnSearch_main = new PnSearch_main();
//		PnSearch_result pnSearch_result = new PnSearch_result();
		
		//첫화면 패널 생성
		//게임 패널 생성
		PnFirst pnFirst = new PnFirst();
		PnGame pnGame = new PnGame();
		
		//메인패널에 객체를 생성한 패널들 추가
		this.add(pnFirst);
		this.add(pnSearch_main);
		this.add(pnGame);
//		this.add(pnSearch_result);
		
		//초기 visible 설정 첫 화면만 보이도록
		pnFirst.setVisible(true);
		pnSearch_main.setVisible(false);
		pnGame.setVisible(false);
//		pnSearch_result.setVisible(false);
		
		
		//pnFirst패널에 있는 버튼 생성 -> 이거는 옮기는게 나을듯
		JButton searchPanel_Button = new JButton("");
		searchPanel_Button.setIcon(new ImageIcon("View/images/green_Earth.png"));
		searchPanel_Button.setBounds(100, 240, 150, 130);
		searchPanel_Button.setBorderPainted(false);
		pnFirst.add(searchPanel_Button);
		
		//pnFirst패널에 있는 버튼 생성 -> 이거는 옮기는게 나을듯
		JButton gamePanel_Button = new JButton("");
		gamePanel_Button.setIcon(new ImageIcon("View/images/blue_Earth.png"));
		gamePanel_Button.setBounds(574, 240, 150, 130);
		gamePanel_Button.setBorderPainted(false);
		pnFirst.add(gamePanel_Button);
		
		//pnFirst패널에 있는 버튼리스너, pnSearch에 접근하는 버튼
		searchPanel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnSearch_main.setVisible(true);
			}
		});
		
		//pnFirst패널에 있는 버튼리스너, pnGame에 접근하는 버튼
		gamePanel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnGame.setVisible(true);
			}
		});
	}


}
