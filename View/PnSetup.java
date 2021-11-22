package View;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

//설정패널
public class PnSetup extends JPanel {

	JComboBox language_Combobox; //언어 선택 콤보박스
	JLabel language_Label; 
	JComboBox fontsize_Combobox; //폰트사이즈 콤보박스
	JLabel fontsize_Label;
	JButton gotomain_Button; //메인으로 돌아가는 버튼
	JLabel gotomain_Label;
	
	public PnSetup() {
		//기본설정
		setVisible(false);
		setBounds(0, 0, 824, 461);
		setLayout(null);
		
		//언어선택 콤보박스
		JComboBox language_Combobox = new JComboBox();
		language_Combobox.setBounds(260, 50, 480, 35);
		add(language_Combobox);
		
		JLabel language_Label = new JLabel("Language");
		language_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		language_Label.setBounds(140, 50, 90, 35);
		add(language_Label);
		
		//폰트사이즈 콤보박스
		JComboBox fontsize_Combobox = new JComboBox();
		fontsize_Combobox.setBounds(260, 130, 480, 35);
		add(fontsize_Combobox);
		
		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);
		add(fontsize_Label);
		
		//메인으로 돌아가는 버튼
		JButton gotomain_Button = new JButton("");
		gotomain_Button.setIcon(new ImageIcon("./images/home_icon.jpg"));
		gotomain_Button.setBounds(70, 380, 45, 45);
		add(gotomain_Button);
		
		JLabel gotomain_Label = new JLabel("    Close");
		gotomain_Label.setBounds(64, 436, 68, 15);
		add(gotomain_Label);
		
		//메인으로 돌아가는 버튼리스너
		gotomain_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfclose();
			}
		});
	}
	
	private void selfclose() {
		this.setVisible(false);
	}

}