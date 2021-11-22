package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setup {
    private JButton setup_button;
    private PnSetup setup_pane;

    
    public Setup() {
        setup_pane = new PnSetup();
        setup_button = new JButton("");
        setup_button.setForeground(Color.WHITE);
        setup_button.setIcon(new ImageIcon("./images/set_up_icon.png"));
        setup_button.setBorderPainted(false);
        setup_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setup_pane.setVisible(true);
            }
        });
    }

    public PnSetup getSetupPane() {
        return setup_pane;
    }

    public JButton getSetupButton() {
        return setup_button;
    }
}
