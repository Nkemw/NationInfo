package View;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnGame extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnGame() {
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JButton btGameMenu = new JButton(new ImageIcon("./Images/gamemenu.PNG"));
		btGameMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btGameMenu.setBounds(660, 10, 59, 57);
		add(btGameMenu);
		
		JButton btGameSlct = new JButton("\uAC8C\uC784");
		btGameSlct.setBounds(593, 403, 219, 48);
		add(btGameSlct);
		
		JPanel pnIcons = new JPanel();
		pnIcons.setBounds(12, 403, 569, 48);
		add(pnIcons);
		
	}

}