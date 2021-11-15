package View;

import Controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame main_frame;
    private JPanel search_panel;
    
    private JButton button;

    private final int MAIN_WIDTH = 600;
    private final int MAIN_HEIGHT = 400;

    public View() {
        main_frame = new JFrame();
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //main_frame.setLayout(null);
        main_frame.setLayout(new FlowLayout());
        main_frame.setSize(MAIN_WIDTH, MAIN_HEIGHT);
        
        button = new JButton("test");
        main_frame.add(button);
        button.addActionListener(new ButtonListener());
    }

    public void run() {
        main_frame.setVisible(true);
    }

    public void setSearchView() {
        search_panel = new JPanel();
        search_panel.setBackground(Color.gray);

        search_panel.setBounds(0, 0, MAIN_WIDTH * 3/4, MAIN_HEIGHT);
        main_frame.add(search_panel);
    }
}