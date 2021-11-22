package View;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.tools.javac.Main;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTable;

//프레임과 메인함수를 가지고 있는 클래스
public class Lessons {
	private JFrame frame;
	private PnSearch_main pnSearch_main; 
	private PnGame pnGame;
	private JTable tbCtris;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lessons window = new Lessons();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Lessons() {
		initialize();
	}
	private void initialize() {
		
		//프레임 생성 및 설정
		frame = new JFrame();
		frame.setTitle("Lessions");
		frame.setBounds(0, 0, 840, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//패널 객체생성
		pnSearch_main = new PnSearch_main(); 
		pnGame=new PnGame();
		PnFirst pnFirst = new PnFirst();
		PnSetup pnSetup = new PnSetup();
		
		
		//설정버튼
		JButton setup_Button = new JButton("");
		setup_Button.setForeground(Color.WHITE);
		setup_Button.setIcon(new ImageIcon("./Images/set_up_icon.png"));
		setup_Button.setBorderPainted(false);
		setup_Button.setBounds(720, 10, 40, 40);
		setup_Button.setVisible(true);
		
		
		JButton goFirst_Button=new JButton("");
		goFirst_Button.setForeground(Color.WHITE);
		goFirst_Button.setIcon(new ImageIcon("./Images/home_icon.jpg"));
		goFirst_Button.setBorderPainted(false);
		goFirst_Button.setBounds(770, 10, 40, 40);
		goFirst_Button.setVisible(true);
		
		
		frame.getContentPane().add(pnSetup);
		frame.getContentPane().add(pnFirst);
		frame.getContentPane().add(setup_Button);
		frame.getContentPane().add(goFirst_Button);
		frame.getContentPane().add(pnSearch_main);
		frame.getContentPane().add(pnGame);
		
		
		
		JLayeredPane jlp = frame.getLayeredPane();
		jlp.add(pnFirst, JLayeredPane.MODAL_LAYER);
		jlp.add(setup_Button, JLayeredPane.PALETTE_LAYER); 
		jlp.add(goFirst_Button, JLayeredPane.PALETTE_LAYER);
		jlp.add(pnSetup, JLayeredPane.MODAL_LAYER);
		
		
		pnFirst.setVisible(true);
		pnFirst.searchPanel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnGame.setVisible(false);
				pnSearch_main.setVisible(true);
			}
		});
		
		pnFirst.gamePanel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnSearch_main.setVisible(false);
				pnGame.setVisible(true);
			}
		});
		
		
		
		setup_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnSetup.setVisible(true);
			}
		});
		
		goFirst_Button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(true);
				
				frame.remove(pnSearch_main);
				pnSearch_main=new PnSearch_main();
				frame.getContentPane().add(pnSearch_main);
				frame.remove(pnGame);
				pnGame=new PnGame();
				frame.getContentPane().add(pnGame);
			}
			
		});
	}
}
