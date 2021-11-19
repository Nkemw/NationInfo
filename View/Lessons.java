package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Lessons {

	private final static int WIDTH = 840;
	private final static int HEIGHT = 500;

	private JFrame frame;
	private JTable tbCtris;


	/**
	 * Create the application.
	 */
	public Lessons() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public void run() {
		System.out.println("Launch the View Section.");
		try {
			Lessons window = new Lessons();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Terminate the View Section.");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lessions");
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Main Page Objects
		View.PnMain pnMain = new View.PnMain();
		View.PnSetup pnSetup = new View.PnSetup();
		JButton setup_Button = setupButton();

		//put the components in Jframe
		frame.getContentPane().add(pnMain);
		frame.getContentPane().add(pnSetup);
		frame.getContentPane().add(setup_Button);
		
		JLayeredPane jlp = frame.getLayeredPane();
		
		jlp.add(pnMain, JLayeredPane.DEFAULT_LAYER);
		jlp.add(setup_Button, JLayeredPane.PALETTE_LAYER);
		jlp.add(pnSetup, JLayeredPane.MODAL_LAYER);
		
		pnMain.setVisible(true);
		
		setup_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnSetup.setVisible(true);
			}
		});
		
	}

	private JButton setupButton() {
		//Setup Button
		JButton setup_Button = new JButton("S");
		setup_Button.setForeground(Color.BLACK);
//		setup_Button.setIcon(new ImageIcon("./Images/btStup2.PNG"));
		setup_Button.setBorderPainted(false);
		setup_Button.setBounds(740, 10, 60, 60);
		setup_Button.setVisible(true);

		return setup_Button;
	}

}
