package View;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class PnGame extends JPanel {

	
	//이건아직
	public PnGame() {
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JLabel gameLabel = new JLabel("국가 수도 게임");
		gameLabel.setBounds(165, 72, 501, 123);
		gameLabel.setIcon(new ImageIcon("./images/gameLable.png"));
		gameLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		add(gameLabel);
		
		JButton gameStart_Button = new JButton("Game Start");
		gameStart_Button.setBounds(300, 281, 208, 66);
		gameStart_Button.setFont(new Font("굴림", Font.PLAIN, 20));
		add(gameStart_Button);
		
		
		JPanel Game_panel = new JPanel();
		Game_panel.setBounds(0, 0, 824, 461);
		add(Game_panel);
		Game_panel.setLayout(null);
		Game_panel.setVisible(false);
		JLabel question_label = new JLabel("Contry");
		question_label.setFont(new Font("궁서체", Font.PLAIN, 17));
		question_label.setBorder(new TitledBorder(new LineBorder(Color.black,3)));
		question_label.setBounds(158, 26, 468, 70);
		Game_panel.add(question_label);
		
		JLabel question_static_label = new JLabel("위 국가의 수도는 무었일까요 ?");
		question_static_label.setFont(new Font("돋움체", Font.PLAIN, 30));
		question_static_label.setBounds(168, 106, 443, 52);
		Game_panel.add(question_static_label);
		
		JButton answer1_button = new JButton("New button");
		answer1_button.setBounds(54, 289, 161, 65);
		Game_panel.add(answer1_button);
		
		JButton answer2_button = new JButton("New button");
		answer2_button.setBounds(332, 289, 161, 65);
		Game_panel.add(answer2_button);
		
		JButton answer3_button = new JButton("New button");
		answer3_button.setBounds(604, 289, 161, 65);
		Game_panel.add(answer3_button);
		
		JButton next_button = new JButton("다음문제");
		next_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		next_button.setBounds(639, 390, 126, 42);
		Game_panel.add(next_button);
		
		JLabel correct_label = new JLabel("정답입니다!!");
		correct_label.setFont(new Font("바탕", Font.PLAIN, 24));
		correct_label.setBounds(339, 189, 154, 59);
		correct_label.setVisible(false);
		Game_panel.add(correct_label);
		
		JLabel wrong_label = new JLabel("오답입니다ㅜㅜ");
		wrong_label.setFont(new Font("바탕", Font.PLAIN, 24));
		wrong_label.setBounds(339, 189, 154, 59);
		wrong_label.setVisible(false);
		Game_panel.add(wrong_label);
		
		JLabel life_text = new JLabel("남은 기회");
		life_text.setBounds(54, 200, 68, 42);
		Game_panel.add(life_text);
		
		JLabel life_label = new JLabel("5");
		life_label.setBounds(118, 214, 34, 15);
		Game_panel.add(life_label);
		
		gameStart_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//초기화면 setVisible false
				gameLabel.setVisible(false);
				gameStart_Button.setVisible(false);
				
				Game_panel.setVisible(true);
			}
		});
		
		//다음 버튼을 누를때 0이아니면 게임을 계속하고 0이되면 종료창이 나오도록 
		
				
	}
}