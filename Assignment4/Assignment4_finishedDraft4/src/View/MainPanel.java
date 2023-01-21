/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package View;

import Controller.Controller;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {
    private SouthPanel southPanel;
    private CenterPanel centerPanel;
    private RightPanel rightPanel;
    private Controller controller;

    public MainPanel(Controller controller) {
        this.controller = controller;
        setupPanel();
    }

    private void setupPanel() {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        Border border = this.getBorder();
        Border borderMargin = BorderFactory.createEmptyBorder(8,8,8,8);
        setBorder(new CompoundBorder(border, borderMargin));
        
        rightPanel = new RightPanel(controller);
        rightPanel.setPreferredSize(new Dimension(300, 505));
        add(rightPanel, BorderLayout.EAST);

        southPanel = new SouthPanel(controller);
        add(southPanel, BorderLayout.SOUTH);

        centerPanel = new CenterPanel(controller);
        centerPanel.setPreferredSize(new Dimension(600, 600));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Gameplay..."));
        add(centerPanel, BorderLayout.CENTER);
    }

    public void reset() {
       centerPanel.reset();
       rightPanel.reset();
    }
    public void shoot(int shots) {
        rightPanel.shoot(shots);
    }
    public void setName(String text) {
        rightPanel.setName(text);
    }
    public void setGameEvents(String text) {
        rightPanel.setGameEvents(text);
    }
    public void setHighscore(String text) {
        rightPanel.setHighscore(text);
    }
}
