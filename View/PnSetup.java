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

public class PnSetup extends JPanel {

	JComboBox language_Combobox;
	JLabel language_Label;
	JComboBox fontsize_Combobox;
	JLabel fontsize_Label;
	JButton gotomain_Button;
	JLabel gotomain_Label;
	
	public PnSetup() {
		// TODO Auto-generated constructor stub
		setVisible(false);
		setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JComboBox language_Combobox = new JComboBox();
		language_Combobox.setBounds(260, 50, 480, 35);
		add(language_Combobox);
		
		JLabel language_Label = new JLabel("Language");
		language_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		language_Label.setBounds(140, 50, 90, 35);
		add(language_Label);
		
		JComboBox fontsize_Combobox = new JComboBox();
		fontsize_Combobox.setBounds(260, 130, 480, 35);
		add(fontsize_Combobox);
		
		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);
		add(fontsize_Label);
		
		JButton gotomain_Button = new JButton("");
		gotomain_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\home_icon.jpg"));
		gotomain_Button.setBounds(70, 380, 45, 45);
		add(gotomain_Button);
		
		JLabel gotomain_Label = new JLabel("    Close");
		gotomain_Label.setBounds(64, 436, 68, 15);
		add(gotomain_Label);
		
		gotomain_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfclose();
				//�����гΰ� �������� �κ�
			}
		});
	}
	
	private void selfclose() {
		this.setVisible(false);
	}

}