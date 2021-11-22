package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;


public class ViewFrame extends JFrame {

	public final static int WIDTH = 840;
	public final static int HEIGHT = 500;
	public final static String TITLE = "Nation Data Search Program";

	private Setup setup;
	
	/**
	 * Create the application.
	 */
	public ViewFrame() {
		setup = new Setup();
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public void launch() {
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle(TITLE);
		setBounds(0, 0, WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		PnMain pnMain = new PnMain();
		
		PnSetup setup_pane = setup.getSetupPane();
		JButton setup_Button = setup.getSetupButton();
		setup_Button.setBounds(741, 10, 40, 40);
		
		//UI에 추가
		getContentPane().add(pnMain);
		getContentPane().add(setup_pane);
		getContentPane().add(setup_Button);

		//UI 요소 계층화 : 설정 버튼 및 설정창은 최상단에 위치
		JLayeredPane jlp = getLayeredPane();
		jlp.add(pnMain, JLayeredPane.DEFAULT_LAYER);
		jlp.add(setup_Button, JLayeredPane.PALETTE_LAYER); //�ٸ�â�� �����ص� ������ư�� ���̵��� ���̾ƿ� ����
		jlp.add(setup_pane, JLayeredPane.MODAL_LAYER);


		setup_Button.setVisible(true);
		pnMain.setVisible(true);

	}
}
