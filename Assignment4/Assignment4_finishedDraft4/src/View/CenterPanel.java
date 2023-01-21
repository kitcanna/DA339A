/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Controller.Controller;
import java.awt.event.ActionListener;

public class CenterPanel extends JPanel {
    private JButton[][] buttons;
    private Controller controller;

    public CenterPanel(Controller controller) {
        this.controller = controller;
        buttons = new JButton[10][10];
        addButtons();
    }

    //Loops 10 x 10 buttons and adds actionlisteners to each one.
    private void addButtons() {
        GridLayout layout = new GridLayout(10, 10, 5, 5);
        ActionListener listener = new CenterPanel.ButtonActionListeners();
        setLayout(layout);
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                buttons[y][x] = new JButton(" ");
                add(buttons[y][x]);
                buttons[y][x].addActionListener(listener);
            }
        }
    }

    //Resets the board and enables all the buttons again.
    public void reset() {
        for(int y = 0; y < 10; y++) {
            for (int x = 0; x<10; x++) {
                buttons[y][x].setEnabled(true);
                buttons[y][x].setText(" ");
                buttons[y][x].setOpaque(false);
            }
        }
    }

    //When clicking a button, this method runs. It sends
    //the position to controller if the button is "valid".
    class ButtonActionListeners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();  //Sets the object clicked on, in "button"
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    if (buttons[y][x].equals(button)) {
                        buttons[y][x].setEnabled(false);
                        if(controller.fireAt(y, x)) {
                            buttons[y][x].setText("Hit!");
                            buttons[y][x].setBackground(Color.RED);
                            buttons[y][x].setOpaque(true);

                        }
                        break;
                    }
                }
            }
            controller.winCondition();
        }
    }
}
