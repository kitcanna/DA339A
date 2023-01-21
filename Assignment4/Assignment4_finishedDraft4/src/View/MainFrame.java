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

public class MainFrame extends JFrame {
    private JFrame frame;
    private Controller controller;
    private MainPanel mainpanel;

    public MainFrame(Controller controller) {
        this.controller = controller;

        frame = new JFrame("Battleship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 700);
        frame.setLocation(300,300);
        frame.setVisible(true);

        mainpanel = new MainPanel(controller);
        frame.add(mainpanel);
    }

    public void reset() {
       mainpanel.reset();
    }

    public void messagePane(String message) {
        JOptionPane.showMessageDialog(this,message);
    }

    public String dialogPane(String message) {
        return JOptionPane.showInputDialog(this,message);
    }

    public void setGameEvents(String text) {
        mainpanel.setGameEvents(text);
    }
    public void setHighscore(String text) {
        mainpanel.setHighscore(text);
    }
    public void shoot(int shots) {
        mainpanel.shoot(shots);
    }
    public void setName(String text) {
        mainpanel.setName(text);
    }

}
