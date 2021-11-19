package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PnSearch_result extends JPanel {

	public PnSearch_result() {
		initialize();
	}
	
	private void initialize() {
		setBounds(0, 0, 824, 451);
		setLayout(null);
		
		JPanel Button_Panel = new JPanel();
		Button_Panel.setBounds(40, 61, 130, 49);
		add(Button_Panel);
		Button_Panel.setLayout(null);
		
		
		JPanel Country_Imformation_Button_Panel = new JPanel();
		Country_Imformation_Button_Panel.setBounds(40, 112, 130, 315);
		Country_Imformation_Button_Panel.setVisible(true);
		add(Country_Imformation_Button_Panel);
		Country_Imformation_Button_Panel.setLayout(null);
		
		JButton a_major_city_Button = new JButton("a_major_city");
		a_major_city_Button.setBounds(0, 270, 130, 45);
		Country_Imformation_Button_Panel.add(a_major_city_Button);
		
		JButton at_a_look_Button = new JButton("at a look");
		at_a_look_Button.setBounds(0, 22, 130, 45);
		Country_Imformation_Button_Panel.add(at_a_look_Button);
		
		JButton country_Button = new JButton("Country");
		country_Button.setBounds(0, 73, 130, 45);
		Country_Imformation_Button_Panel.add(country_Button);
		
		JButton capital_Button = new JButton("Capital");
		capital_Button.setBounds(0, 123, 130, 45);
		Country_Imformation_Button_Panel.add(capital_Button);
		
		JButton climate_Button = new JButton("Climate");
		climate_Button.setBounds(0, 173, 130, 45);
		Country_Imformation_Button_Panel.add(climate_Button);
		
		JButton location_Button = new JButton("Location");
		location_Button.setBounds(0, 222, 130, 45);
		Country_Imformation_Button_Panel.add(location_Button);
		
		JPanel Travel_Imformation_Button_Panel = new JPanel();
		Travel_Imformation_Button_Panel.setBounds(40, 112, 130, 315);
		Travel_Imformation_Button_Panel.setVisible(false);
		add(Travel_Imformation_Button_Panel);
		Travel_Imformation_Button_Panel.setLayout(null);
		
		JButton a_tourist_spot_Button = new JButton("a_tourist_spot");
		a_tourist_spot_Button.setBounds(0, 22, 130, 45);
		Travel_Imformation_Button_Panel.add(a_tourist_spot_Button);
		
		JButton conversation_Button = new JButton("Basic conversation");
		conversation_Button.setBounds(0, 73, 130, 45);
		Travel_Imformation_Button_Panel.add(conversation_Button);
		
		JButton culture_Button = new JButton("Culture");
		culture_Button.setBounds(0, 123, 130, 45);
		Travel_Imformation_Button_Panel.add(culture_Button);
		
		JPanel Imformation_Panel = new JPanel();
		Imformation_Panel.setBounds(182, 112, 600, 315);
		add(Imformation_Panel);
		Imformation_Panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(581, 0, 17, 315);
		Imformation_Panel.add(scrollBar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 577, 315);
		Imformation_Panel.add(textArea);
		
		JTextField textField = new JTextField();
		textField.setBounds(240, 60, 424, 42);
		add(textField);
		textField.setColumns(10);
		
		JButton search_Button = new JButton("Search");
		search_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		search_Button.setBounds(670, 60, 54, 42);
		add(search_Button);
		
		JButton set_ContryImformation_Button = new JButton("ContryImpormation");
		set_ContryImformation_Button.setText("<HTML>Contry<br>Imformation</HTML>");
		set_ContryImformation_Button.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		set_ContryImformation_Button.setBounds(0, 0, 60, 50);
		set_ContryImformation_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		Button_Panel.add(set_ContryImformation_Button);
		set_ContryImformation_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Country_Imformation_Button_Panel.setVisible(true);
				Travel_Imformation_Button_Panel.setVisible(false);
				
			}
		});
		
		JButton set_TravelImformation_Button = new JButton("New button");
		set_TravelImformation_Button.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		set_TravelImformation_Button.setText("<HTML>Travel<br>Imformation</HTML>");
		set_TravelImformation_Button.setBounds(70, 0, 60, 50);
		set_TravelImformation_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		Button_Panel.add(set_TravelImformation_Button);
		set_TravelImformation_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Country_Imformation_Button_Panel.setVisible(false);
				Travel_Imformation_Button_Panel.setVisible(true);
			}
		});
	}
	
	
}