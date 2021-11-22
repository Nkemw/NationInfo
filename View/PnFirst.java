package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//첫화면을 보여주는 패널 클래스
public class PnFirst extends JPanel {
	JButton searchPanel_Button = new JButton("");
	JButton gamePanel_Button = new JButton("");

	public PnFirst() {
		setBounds(0, 0, 824, 461);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
		
		//메인 타이틀 텍스트
		JLabel main_Title_label = new JLabel("");
		main_Title_label.setIcon(new ImageIcon("./images/Pnfirst_Title.PNG"));
		main_Title_label.setFont(new Font("Arial Black", Font.PLAIN, 19));
		main_Title_label.setBounds(262, 39, 300, 90);
		add(main_Title_label);
		
	
		//국가검색 진입 텍스트
		JLabel countrysearch_Label = new JLabel("");
		countrysearch_Label.setIcon(new ImageIcon("./images/CountrySearch_label.png"));
		countrysearch_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrysearch_Label.setBounds(120, 370, 126, 20);
		add(countrysearch_Label);
		
		//국가게임 진입 텍스트
		JLabel countrygame_Label = new JLabel("");
		countrygame_Label.setIcon(new ImageIcon("./images/CountryGame_label.png"));
		countrygame_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrygame_Label.setBounds(588, 370, 126, 20);
		add(countrygame_Label);
		
		//pnFirst패널에 있는 버튼 생성 -> 이거는 옮기는게 나을듯
				
				searchPanel_Button.setIcon(new ImageIcon("./images/green_Earth.png"));
				searchPanel_Button.setBounds(100, 240, 150, 130);
				searchPanel_Button.setBorderPainted(false);
				add(searchPanel_Button);
				
				//pnFirst패널에 있는 버튼 생성 -> 이거는 옮기는게 나을듯
				
				gamePanel_Button.setIcon(new ImageIcon("./images/blue_Earth.png"));
				gamePanel_Button.setBounds(574, 240, 150, 130);
				gamePanel_Button.setBorderPainted(false);
				add(gamePanel_Button);
		
		
		
		
	}


}
